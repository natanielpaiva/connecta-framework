package br.com.cds.connecta.framework.connector2.context.database;

import br.com.cds.connecta.framework.connector2.common.Base;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.DatabaseContextFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;

/**
 *
 * @author diego
 */
public class DatabaseDataContextFactory extends Base implements ContextFactory, DatabaseContextFactory {

    private String jdbcDrive;
    private String jdbcUrl;

    private Connection connection;

    private Drive drive;

    private String table;
    private String user;
    private String password;

    public DatabaseDataContextFactory(Drive db, String table, String user, String password) {
        this.table = table;
        this.user = user;
        this.password = password;
        this.jdbcDrive = db.jdbcDrive();
        this.jdbcUrl = db.jdbcUrl();

        dataContext = createDataContext();
    }

    public DatabaseDataContextFactory(Drive db, String user, String password) {
        this.user = user;
        this.password = password;
        this.jdbcDrive = db.jdbcDrive();
        this.jdbcUrl = db.jdbcUrl();
        this.dataContext = createDataContext();
    }

    @Override
    public DataContext createDataContext() {

        if (dataContext == null) {
            try {
                System.out.println(jdbcDrive);
                Class.forName(jdbcDrive);
            } catch (ClassNotFoundException ex) {
                System.out.println("jdbcDrive nao encontrado");
                Logger.getLogger(DatabaseDataContextFactory.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                connection = DriverManager.getConnection(jdbcUrl, user, password);
                System.out.println(jdbcUrl);
            } catch (SQLException ex) {
                System.out.println("problema com a conexão");
                Logger.getLogger(DatabaseDataContextFactory.class.getName()).log(Level.SEVERE, null, ex);
            }

            dataContext = DataContextFactory.createJdbcDataContext(connection);
        }

        return dataContext;
    }

    @Override
    public DataSet getResultAll() {
        Schema schema = discoverSchema();

        Table table = discoverTable(schema);

        String[] requiredColumns = queryContext.getColumns();

        Query from = queryContext.getQuery().from(table);

        if (requiredColumns != null) {

            for (String requiredColumn : requiredColumns) {
                Column columnByName = table.getColumnByName(requiredColumn);
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
        Table table = null;

        if (queryContext != null && queryContext.getTable() != null) {
            table = schema.getTableByName(queryContext.getTable());
        } else if (this.table != null) {
            table = schema.getTableByName(this.table);
        } else {
            System.out.println("tabela nao definida");
            return table;
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

    //   Schema tables
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

}
