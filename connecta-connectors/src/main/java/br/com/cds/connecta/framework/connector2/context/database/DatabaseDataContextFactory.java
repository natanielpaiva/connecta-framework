package br.com.cds.connecta.framework.connector2.context.database;

import br.com.cds.connecta.framework.connector2.common.Base;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.pojo.MapTableDataProvider;
import org.apache.metamodel.pojo.PojoDataContext;
import org.apache.metamodel.pojo.TableDataProvider;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;
import org.apache.metamodel.util.SimpleTableDef;

/**
 *
 * @author diego
 */
public class DatabaseDataContextFactory extends Base implements ContextFactory {

    private final Logger logger = Logger.getLogger(DatabaseDataContextFactory.class);

//    private Class<? extends Driver> jdbcDriver;
    private String jdbcUrl;

    private String sql;
    private String table;
    private String user;
    private String password;
    
    private Table tableContext;
    
    private final String DEFAULT_SCHEMA_NAME = "DEFAULT_SCHEMA_NAME";
    private final String DEFAULT_TABLE_NAME = "DEFAULT_TABLE_NAME";

    /**
     *  
     * @param sql
     * @param connectorDriver
     * @param user
     * @param password
     */
    public DatabaseDataContextFactory(String sql, ConnectorDriver connectorDriver, String user, String password) {
        this.sql = sql;
        this.user = user;
        this.password = password;
//        this.jdbcDriver = connectorDriver.jdbcDriver();
        this.jdbcUrl = connectorDriver.jdbcUrl();

        dataContext = sqlCreateDataContext();
    }

    /**
     *
     * @param db
     * @param table
     * @param user
     * @param password
     */
    public DatabaseDataContextFactory(ConnectorDriver db, String table, String user, String password) {
        this.table = table;
        this.user = user;
        this.password = password;
//        this.jdbcDriver = db.jdbcDriver();
        this.jdbcUrl = db.jdbcUrl();

        dataContext = tableCreateDataContext();
    }

    /**
     *
     * @param db
     * @param user
     * @param password
     */
    public DatabaseDataContextFactory(ConnectorDriver db, String user, String password) {
        this.user = user;
        this.password = password;
        this.jdbcUrl = db.jdbcUrl();

        this.dataContext = tableCreateDataContext();
    }

    @Override
    public DataContext createDataContext() {
        return dataContext;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            logger.info("JDBC URL: " + jdbcUrl);
            conn = DriverManager.getConnection(jdbcUrl, user, password);
        } catch (SQLException ex) {
            // TODO Enviar Exception
            logger.error("Connection problem", ex);
        }

        return conn;
    }

    @Override
    public DataSet getResultAll() {
        Schema schema = discoverSchema();

        Table discoveredTable = discoverTable(schema);
        discoveredTable.getColumns(); // chamada pra reconhecer as colunas
        
        List<ConnectorColumn> listColumns = queryContext.getColumns();
        
        Query from = queryContext.build().from(discoveredTable);
        
        if (listColumns != null) {
            for (ConnectorColumn column : listColumns) {
                Column columnByName = discoveredTable.getColumnByName(column.getName());
                queryContext.build().select(columnByName);
            }

            return dataContext.executeQuery(from);
        } else {
            return dataContext.executeQuery(from.selectAll());
        }
    }

    private Schema discoverSchema() {
        if (queryContext == null || queryContext.getSchema() == null) {
            return dataContext.getDefaultSchema();
        } else {
            return dataContext.getSchemaByName(queryContext.getSchema());
        }
    }

    private Table discoverTable(Schema schema) {
        if (queryContext != null && queryContext.getTable() != null) {
            logger.info("QUERY CONTEXT AND TABLE NOT NULL: " + queryContext.getTable());
            tableContext = schema.getTableByName(queryContext.getTable());
        } else if (this.table != null) {
            logger.info("DATA CONTEXT TABLE NOT NULL: " + this.table);
            tableContext = schema.getTableByName(this.table);
        } else {
            logger.info("TABLE WAS NOT DEFINED. USING DEFAULT TABLE NAME: " + DEFAULT_TABLE_NAME);
            tableContext = schema.getTableByName(DEFAULT_TABLE_NAME);
        }

        return tableContext;
    }

    /**
     *  Lista as colunas de um context
     * @return
     */
    @Override
    public List<ConnectorColumn> getColumns() {

        List<ConnectorColumn> connectorColumns = new ArrayList<>();

        Schema schema = discoverSchema();
        Table discoverTable = discoverTable(schema);

        Column[] columns = discoverTable.getColumns();

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

    /**
     *  Retorna todos os Schemas do Banco
     * @return
     */
    @Override
    public String[] getSchemas() {
        Schema[] schemas = dataContext.getSchemas();
        String[] sc = new String[schemas.length];
        for (int i = 0; i < schemas.length; i++) {
            sc[i] = schemas[i].getName();
        }
        return sc;
    }

    @Override
    public String[] getTables() {
        Schema schema = discoverSchema();
        Table[] tables = schema.getTables();
        String[] tb = new String[tables.length];

        for (int i = 0; i < tables.length; i++) {
            tb[i] = tables[i].getName();
        }
        return tb;
    }

    @Override
    public Table getTable() {
        Schema schema = discoverSchema();
        if (queryContext == null || queryContext.getTable() == null) {
            if (table==null) {
                return discoverTable(schema);
            } else {
                return schema.getTableByName(table);
            }
        } else {
            return schema.getTableByName(queryContext.getTable());
        }

    }

    @Override
    public Column getColumn(String columnName) {
        return getTable().getColumnByName(columnName);
    }

    public DataContext sqlCreateDataContext() {
        DataContext dc = null;
        List<Map<String, ?>> rowset = new ArrayList<>();

        try {
            Statement statement = getConnection().createStatement();
            ResultSet rs = statement.executeQuery(this.sql);
            ResultSetMetaData metaData = rs.getMetaData();

            int count = metaData.getColumnCount();
            String columns[] = new String[count];

            for (int i = 1; i <= count; i++) {
                columns[i - 1] = metaData.getColumnLabel(i);
            }

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (String name : columns) {
                    row.put(name, rs.getObject(name));
                    System.out.println(name + " -------  " + rs.getObject(name));
                }
                System.out.println("\n");
                rowset.add(row);
            }

            TableDataProvider<?> provider = new MapTableDataProvider(
                    new SimpleTableDef(DEFAULT_TABLE_NAME, columns), rowset);
            dc = new PojoDataContext(DEFAULT_SCHEMA_NAME, provider);

        } catch (SQLException ex) {
            logger.error(ex.getMessage(), ex);
        }

        return dc;
    }
    
    public DataContext tableCreateDataContext() {
        dataContext = DataContextFactory.createJdbcDataContext(getConnection());
        return dataContext;
    }

}
