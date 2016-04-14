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

    private String jdbcDrive;
    private String jdbcUrl;

    //private Connection connection;
    private Driver drive;
    private String sql;
    private String table;
    private String user;
    private String password;

    private String DEFAULT_SCHEMA_NAME = "DEFAULT_SCHEMA_NAME";
    private String DEFAULT_TABLE_NAME = "DEFAULT_TABLE_NAME";

    public DatabaseDataContextFactory(String sql, Driver db, String user, String password) {
        this.sql = sql;
        this.user = user;
        this.password = password;
        this.jdbcDrive = db.jdbcDrive();
        this.jdbcUrl = db.jdbcUrl();

        dataContext = sqlCreateDataContext();
    }

    public DatabaseDataContextFactory(Driver db, String table, String user, String password) {
        this.table = table;
        this.user = user;
        this.password = password;
        this.jdbcDrive = db.jdbcDrive();
        this.jdbcUrl = db.jdbcUrl();

        dataContext = tableCreateDataContext();
    }

    public DatabaseDataContextFactory(Driver db, String user, String password) {
        this.user = user;
        this.password = password;
        this.jdbcDrive = db.jdbcDrive();
        this.jdbcUrl = db.jdbcUrl();

        this.dataContext = tableCreateDataContext();
    }

    @Override
    public DataContext createDataContext() {
        return dataContext;
    }

    private DataContext tableCreateDataContext() {
        dataContext = DataContextFactory.createJdbcDataContext(getConnection());
        return dataContext;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            System.out.println(jdbcDrive);
            Class.forName(jdbcDrive);
            conn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println(jdbcUrl);
            logger.info("JDBC URL: " + jdbcUrl);
        } catch (SQLException | ClassNotFoundException ex) {
            logger.error("Connection problem", ex);
        }

        return conn;
    }

    @Override
    public DataSet getResultAll() {
        Schema schema = discoverSchema();

        Table table = discoverTable(schema);

        // String[] requiredColumns = queryContext.getColumns();
        List<ConnectorColumn> columns = queryContext.getColumns();

        Query from = queryContext.getQuery().from(table).select(table.getColumns());

        

        if (columns != null) {

            for (ConnectorColumn column : columns) {

                Column columnByName = table.getColumnByName(column.getName());
                queryContext.getQuery().select(columnByName);
            }

            //Schema defaultSchema = dataContext.getDefaultSchema();
            //dataContext.getSchemaByName(schema.getName());
            return dataContext.executeQuery(from);
        } else {

            return dataContext.executeQuery(from.selectAll());
        }

    }

    public Schema discoverSchema() {
        if (queryContext == null || queryContext.getSchema() == null) {
            return dataContext.getDefaultSchema();
        } else {
            return dataContext.getSchemaByName(queryContext.getSchema());
        }
    }

    public Table discoverTable(Schema schema) {
        Table table;

        if (queryContext != null && queryContext.getTable() != null) {
            logger.info("QUERY CONTEXT AND TABLE NOT NULL: " + queryContext.getTable());
            table = schema.getTableByName(queryContext.getTable());
        } else if (this.table != null) {
            logger.info("DATA CONTEXT TABLE NOT NULL: " + this.table);
            table = schema.getTableByName(this.table);
        } else {
            logger.info("DATA CONTEXT TABLE IS NULL PA CARALHO: " + DEFAULT_TABLE_NAME);
            table = schema.getTableByName(DEFAULT_TABLE_NAME);
            logger.info("Table was not defined");
        }

        return table;
    }

    @Override
    public List getColumns() {

        List<ConnectorColumn> connectorColumns = new ArrayList<>();

        Schema schema = discoverSchema();
        Table tableByName = schema.getTableByName(queryContext.getTable());

        //Table table = dataContext.getDefaultSchema().getTableByName(queryContext.getTable());
        Column[] columns = tableByName.getColumns();

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
            return schema.getTableByName(table);
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

}
