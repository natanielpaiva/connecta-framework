package br.com.cds.connecta.framework.connector2.context.solr;

import br.com.cds.connecta.framework.connector.solr.Solr;
import br.com.cds.connecta.framework.connector.util.PrintResult;
import br.com.cds.connecta.framework.connector2.common.Base;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.pojo.ArrayTableDataProvider;
import org.apache.metamodel.pojo.PojoDataContext;
import org.apache.metamodel.pojo.TableDataProvider;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.ColumnType;
import org.apache.metamodel.schema.Table;
import org.apache.metamodel.util.SimpleTableDef;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.LukeRequest;
import org.apache.solr.client.solrj.response.LukeResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Ignore;

/**
 *
 * @author diego
 */
@Ignore
public class SolrDataContextFactoty extends Base implements ContextFactory {

    private final Logger logger = Logger.getLogger(SolrDataContextFactoty.class.getName());

    private String address;
    private String sorlQuery;
    private int facet;

    public SolrDataContextFactoty(String address, String sorlQuery, int facet) {
        this.address = address;
        this.sorlQuery = sorlQuery;
        this.facet = facet;

        createContext();
    }

    public SolrDataContextFactoty(String address) {
        this.address = address;
    }

    @Override
    public DataSet getResultAll() {
        Table table = getTable();
        table.getColumns(); // chamada pra reconhecer as colunas

        List<ConnectorColumn> listColumns = queryContext.getColumns();

        Query from = queryContext.build().from(table);

        if (listColumns != null  &&
                from.getSelectClause().getItems().isEmpty()) {
            for (ConnectorColumn column : listColumns) {
                Column columnByName = table.getColumnByName(column.getName());
                if (columnByName != null) {
                    queryContext.build().select(columnByName);
                } else {
                    logger.log(Level.WARNING,
                            ">>---------> ATENÇÃO A COLUNA " + column.getName() + " NÃO FOI ENCONTRADA");
                }
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

    public Column getColumn(String columnName) {
        return getTable().getColumnByName(columnName);
    }

    @Override
    public String[] getSchemas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getTables() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public final void createContext() {
        SolrServer solr = new HttpSolrServer(address);

        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery(sorlQuery);
        solrQuery.setRows(facet);

        QueryResponse response = null;
        try {
            response = solr.query(solrQuery);
        } catch (SolrServerException ex) {
            Logger.getLogger(SolrDataContextFactoty.class.getName()).log(Level.SEVERE, null, ex);
        }

        SolrDocumentList data = response.getResults();

        List<Map<String, Object>> result = new ArrayList<>();

        for (SolrDocument document : data) {
            Map<String, Object> object = new HashMap<>();
            for (Map.Entry<String, Object> row : document) {
                object.put(row.getKey(), row.getValue());

            }
            result.add(object);
        }
        PrintResult printResult = new PrintResult();
        printResult.print(result);

        List<Object[]> table = new ArrayList<>();
        Set<String> columnsNames = result.get(0).keySet();
        Collection<Object> types = result.get(0).values();

        ColumnType[] columnTypes = new ColumnType[types.size()];
        int i = 0;
        for (Object type : types) {
            String value = type.getClass().getSimpleName();

            if (value.equals("Integer") || value.equals("Long")) {
                columnTypes[i] = ColumnType.INTEGER;
            } else if (value.equals("Date")) {
                columnTypes[i] = ColumnType.DATE;
            } else if (value.equals("ArrayList")) {
                columnTypes[i] = ColumnType.STRING;
            } else {
                columnTypes[i] = ColumnType.VARCHAR;
            }
            i++;
        }

        for (Map<String, Object> result1 : result) {
            Object[] obj = new Object[columnsNames.size()];

            String value = "";
            int j = 0;
            for (String column : columnsNames) {
                obj[j] = result1.get(column);
                j++;
            }
            table.add(obj);
            System.out.println(value);
        }
        String[] columnsTable;
        columnsTable = (String[]) columnsNames.toArray(new String[columnsNames.size()]);

        SimpleTableDef std = new SimpleTableDef("DEFAULT_TABLE_NAME", columnsTable, columnTypes);

        TableDataProvider<?> tableDataProvider = new ArrayTableDataProvider(std, table);
        dataContext = new PojoDataContext("DEFAULT_SCHEMA_NAME", tableDataProvider);

    }

    public List<String> getConditionsSolr() {
        SolrServer solr = new HttpSolrServer(this.address);

        ArrayList<String> conditions = new ArrayList<>();

        LukeRequest lukeRequest = new LukeRequest();
        lukeRequest.setNumTerms(0);
        LukeResponse lukeResponse;

        try {
            lukeResponse = lukeRequest.process(solr);

            List<LukeResponse.FieldInfo> sorted = new ArrayList<>(lukeResponse.getFieldInfo().values());

            for (LukeResponse.FieldInfo infoEntry : sorted) {
                conditions.add(infoEntry.getName());
            }

            Collections.sort(conditions);

        } catch (SolrServerException | IOException ex) {
            Logger.getLogger(Solr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conditions;
    }

}
