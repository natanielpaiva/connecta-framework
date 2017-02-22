package br.com.cds.connecta.framework.connector2.context.wso2;

import br.com.cds.connecta.framework.connector2.common.Base;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.context.http.Header;
import br.com.cds.connecta.framework.connector2.context.http.HttpDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.http.HttpResponse;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.pojo.MapTableDataProvider;
import org.apache.metamodel.pojo.PojoDataContext;
import org.apache.metamodel.pojo.TableDataProvider;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.ColumnType;
import org.apache.metamodel.schema.ColumnTypeImpl;
import org.apache.metamodel.schema.MutableColumn;
import org.apache.metamodel.schema.MutableTable;
import org.apache.metamodel.schema.Table;
import org.apache.metamodel.util.SimpleTableDef;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.HttpMethod;

/**
 *
 * @author diego
 */
public class Wso2DataContextFactory extends Base implements ContextFactory {

    private String user;
    private String password;
    private String url;
    private String table;
    private Date from, to;
    private String search;

    final private String TABLE_PATH = "tables/";
    final private String SEARCH_PATH = "search/";

    public Wso2DataContextFactory(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public Wso2DataContextFactory(String user, String password, String url, String table) {
        this.user = user;
        this.password = password;
        this.url = url;
        this.table = table;
        this.dataContext = createRangeContext();
    }

    public Wso2DataContextFactory(String user, String password, String url, String table, Date from, Date to) {
        this.user = user;
        this.password = password;
        this.url = url;
        this.table = table;
        this.from = from;
        this.to = to;
        this.dataContext = createRangeContext();
    }

    public Wso2DataContextFactory(String user, String password, String url, String table, String search) {
        this.user = user;
        this.password = password;
        this.url = url;
        this.table = table;
        this.search = search;
        this.dataContext = createQueryContext();
    }

    public Wso2DataContextFactory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataSet getResultAll() {
        Table table = getTable();
        table.getColumns(); // chamada pra reconhecer as colunas

        List<ConnectorColumn> listColumns = queryContext.getColumns();

        Query from = queryContext.build().from(table);

        if (listColumns != null && from.getSelectClause().getItems().isEmpty()) {
            for (ConnectorColumn column : listColumns) {
                Column columnByName = table.getColumnByName(column.getName());
                queryContext.build().select(columnByName);
            }
            return dataContext.executeQuery(from);
        } else if (!from.getSelectClause().getItems().isEmpty()) {
            return dataContext.executeQuery(from);
        } else {
            return dataContext.executeQuery(from.selectAll());
        }
    }

    @Override
    public List<ConnectorColumn> getColumns() {
        List<ConnectorColumn> connectorColumns = new ArrayList<>();

        Table table = dataContext.getDefaultSchema().getTable(0);
        Column[] columns = table.getColumns();

        for (Column column : columns) {
            ConnectorColumn cc = new ConnectorColumn();
            cc.setName(column.getName());
            cc.setType(column.getType().getName());
            cc.setFormula(column.getName());
            cc.setLabel(column.getName());

            connectorColumns.add(cc);
        }
        return connectorColumns;

    }

    @Override
    public Table getTable() {
        return dataContext.getDefaultSchema().getTable(0);
    }

    @Override
    public Column getColumn(String columnName) {
        return getTable().getColumnByName(columnName);
    }

    @Override
    public String[] getSchemas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getTables() {

        HttpDataContextFactory httpContext = new HttpDataContextFactory();
        HttpResponse executeHttp = httpContext.executeHttp(url + TABLE_PATH, HttpMethod.GET, headerAuthorization(), "");

        List<String> tables = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(executeHttp.getBody());
            for (int i = 0; i < jsonArray.length(); i++) {
                tables.add(jsonArray.get(i).toString());
            }
        } catch (JSONException ex) {
            Logger.getLogger(Wso2DataContextFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tables.toArray(new String[tables.size()]);
    }

    private List<Header> headerAuthorization() {

        String credentials = user + ":" + password;
        String encoding = Base64.getEncoder().encodeToString(credentials.getBytes());

        Header header1 = new Header();
        header1.setKey("Authorization");
        header1.setValue("Basic " + encoding);

        Header header2 = new Header();
        header2.setKey("Content-Type");
        header2.setValue("application/json");
        
        Header header3 = new Header();
        header3.setKey("Accept-Charset");
        header3.setValue("UTF-8");

        List<Header> headers = new ArrayList<>();
        headers.add(header1);
        headers.add(header2);
        headers.add(header3);
        return headers;
    }


    private JSONArray getData(String url, HttpMethod verb, List<Header> headers, String body) {
        HttpDataContextFactory httpContext = new HttpDataContextFactory();
        HttpResponse tableResult = httpContext.executeHttp(url, verb, headers, body);
        JSONArray result = null;
        try {
            result = new JSONArray(tableResult.getBody());
        } catch (JSONException ex) {
            Logger.getLogger(Wso2DataContextFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private JSONObject getDataColomns() {
        HttpDataContextFactory httpContext = new HttpDataContextFactory();
        HttpResponse tableColumns = httpContext.executeHttp(url + "tables/" + table + "/schema/", HttpMethod.GET, headerAuthorization(), "");
        JSONObject columnsArray = null;
        JSONObject jsonObject = null;
        try {
            columnsArray = new JSONObject(tableColumns.getBody());
            jsonObject = columnsArray.getJSONObject("columns");
        } catch (JSONException ex) {
            Logger.getLogger(Wso2DataContextFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonObject;
    }

    private MutableTable buildMutableTable() {
        JSONObject jsonColumns = getDataColomns();
        JSONArray names = jsonColumns.names();

        MutableTable mutableTable = new MutableTable("DEFAULT_TABLE_NAME");
        for (int i = 0; i < names.length(); i++) {
            try {
                JSONObject jsonObject = (JSONObject) jsonColumns.get(names.getString(i));
                MutableColumn mutableColumn = new MutableColumn();
                mutableColumn.setTable(mutableTable);
                mutableColumn.setName(names.getString(i));
                mutableColumn.setType(ColumnTypeImpl.valueOf(jsonObject.getString("type")));
                mutableTable.addColumn(mutableColumn);
            } catch (JSONException ex) {
                Logger.getLogger(Wso2DataContextFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        MutableColumn mutableColumn = new MutableColumn();
        mutableColumn.setTable(mutableTable);
        mutableColumn.setName("timestamp");
        mutableColumn.setType(ColumnType.TIMESTAMP);
        mutableTable.addColumn(mutableColumn);

        return mutableTable;
    }

    private PojoDataContext buildRowset(JSONArray tableArray, MutableTable mutableTable) {

        List<Map<String, ?>> rowset = new ArrayList<>();
        try {
            for (int i = 0; i < tableArray.length(); i++) {
                Map<String, Object> row = new HashMap<>();
                JSONObject jsonObject1;
                jsonObject1 = tableArray.getJSONObject(i).getJSONObject("values");
                String string = tableArray.getJSONObject(i).getString("timestamp");
                jsonObject1.put("timestamp", string);
                Column[] columns = mutableTable.getColumns();
                for (Column column : columns) {
                    row.put(column.getName(), jsonObject1.getString(column.getName()));
                }
                rowset.add(row);
            }
        } catch (JSONException ex) {
            Logger.getLogger(Wso2DataContextFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

        TableDataProvider<?> provider = new MapTableDataProvider(
                new SimpleTableDef(mutableTable), rowset);
        return new PojoDataContext("DEFAULT_SCHEMA_NAME", provider);
    }

    private DataContext createRangeContext() {

        String path = url + TABLE_PATH + table;
        if (from != null) {
            path += "/" + from.getTime();
            if (to != null) {
                path += "/" + to.getTime();
            }
        }
        //JSONArray dataTable = getDataRange(url + "tables/" + table + "/" + from.getTime() + "/" + to.getTime());
        JSONArray dataTable = getData(path, HttpMethod.GET, headerAuthorization(), "");
        MutableTable buildMutableTable = buildMutableTable();
        return buildRowset(dataTable, buildMutableTable);
    }

    private DataContext createQueryContext() {
        if(search == null){
            search = "";
        }
        String body = " {\n \"tableName\":\"" + table + "\",\n \"query\":\"" + search + "\",\n \"start\":0,\n \"count\":1000\n }";
        JSONArray dataTable = getData(url + SEARCH_PATH, HttpMethod.POST, headerAuthorization(), body);

        MutableTable buildMutableTable = buildMutableTable();
        return buildRowset(dataTable, buildMutableTable);
    }
}
