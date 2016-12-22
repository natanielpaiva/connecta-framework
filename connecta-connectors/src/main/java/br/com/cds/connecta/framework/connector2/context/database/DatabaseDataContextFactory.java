package br.com.cds.connecta.framework.connector2.context.database;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
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
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;
import org.apache.metamodel.util.SimpleTableDef;

import com.google.common.io.Files;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import br.com.cds.connecta.framework.connector2.common.Base;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ConnectorTableColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 *
 * @author diego
 */
public class DatabaseDataContextFactory extends Base implements ContextFactory {

    private final String DEFAULT_SCHEMA_NAME = "DEFAULT_SCHEMA_NAME";
    private String DEFAULT_TABLE_NAME = "DEFAULT_TABLE_NAME";
    private final Logger logger = Logger.getLogger(DatabaseDataContextFactory.class);

    private final String jdbcUrl;

    private String sql;
    private String table;
    private final String user;
    private final String password;
    private Connection conn = null;
    private File tempFile = null;

    private Table tableContext;

    private boolean isCached;

    private DatabaseDataContextFactory(String sql, String table,
            String user, String password, ConnectorDriver connectorDriver) {
        this.sql = sql;
        this.table = table;
        this.user = user;
        this.password = password;
        this.jdbcUrl = connectorDriver.jdbcUrl();
    }

    /**
     *
     * @param sql
     * @param connectorDriver
     * @param user
     * @param password
     */
    public DatabaseDataContextFactory(String sql,
            ConnectorDriver connectorDriver,
            String user, String password, boolean... updatingCache) throws SQLException {
        this(sql, null, user, password, connectorDriver);
        sqlCreateDataContext(updatingCache);
    }

    /**
     *
     * @param db
     * @param table
     * @param user
     * @param password
     */
    public DatabaseDataContextFactory(ConnectorDriver db, String table, String user, String password) {
        this(null, table, user, password, db);
        tableCreateDataContext();
    }

    /**
     *
     * @param db
     * @param user
     * @param password
     */
    public DatabaseDataContextFactory(ConnectorDriver db, String user, String password) {
        this(null, null, user, password, db);
        tableCreateDataContext();
    }

    @Override
    public DataContext createDataContext() {
        return dataContext;
    }

    public Connection getConnection() {
        if (conn == null) {
            try {
                logger.info("JDBC URL: " + jdbcUrl);
                conn = DriverManager.getConnection(jdbcUrl, user, password);
            } catch (SQLException ex) {
                // TODO Enviar Exception
                logger.error("Connection problem", ex);
            }
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

        if (listColumns != null
                && from.getSelectClause().getItems().isEmpty()) {
            for (ConnectorColumn column : listColumns) {
                Column columnByName = discoveredTable.getColumnByName(column.getName());
                queryContext.build().select(columnByName);
            }

            return dataContext.executeQuery(from);
        } else if (!from.getSelectClause().getItems().isEmpty()) {
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
     * Lista as colunas de um context
     *
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
     * Retorna todos os Schemas do Banco
     *
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
            if (table == null) {
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
    
    public List getTablesColumns() {
        Schema discoverSchema = discoverSchema();

        Table[] tables = discoverSchema.getTables();

        List<ConnectorTableColumn> listConnectorTables = new ArrayList<>();

        for (Table tb : tables) {

            ConnectorTableColumn connectorTable = new ConnectorTableColumn();
            connectorTable.setTableName(tb.getName());

            List<ConnectorColumn> connectorColumns = new ArrayList<>();
            for (Column column : tb.getColumns()) {

                ConnectorColumn cc = new ConnectorColumn();
                cc.setName(column.getName());
                cc.setType(column.getType().getName());
                cc.setLabel(column.getName());

                connectorColumns.add(cc);
            }
            connectorTable.setConnectorColumn(connectorColumns);
            listConnectorTables.add(connectorTable);
        }

        return listConnectorTables;
    }
    

    /**
     * TODO Criar o PojoDataContext já com os tipos de dados detectados na
     * consulta
     *
     */
    private void sqlCreateDataContext(boolean... updatingCache) throws SQLException {
        List<Map<String, ?>> rowset = new ArrayList<>();
        byte[] resultsetBytes = null;
        String hash = createHashOfSQL();
        final Gson gson = new GsonBuilder()
        		.setExclusionStrategies(new LobExclusionStrategy())
        		.create();
        
        boolean isUpdating = updatingCache.length > 0 ? updatingCache[0] : false;

        try {

            if (hash != null) {
                resultsetBytes = getRedisResultSet(hash);
            }

            if (isUpdating
                    || resultsetBytes == null) {

                String uniqueName = generateUniqueFileName();

                tempFile = File.createTempFile(uniqueName, ".tmp");
                OutputStream out = new FileOutputStream(tempFile);
                JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));

                Statement statement = getConnection().createStatement();
                ResultSet rs = statement.executeQuery(this.sql);
                ResultSetMetaData metaData = rs.getMetaData();

                int count = metaData.getColumnCount();
                String columns[] = new String[count];

                MutableTable mutableTable = new MutableTable(DEFAULT_TABLE_NAME);
                for (int i = 1; i <= count; i++) {
                    columns[i - 1] = metaData.getColumnLabel(i);

                    MutableColumn mutableColumn = new MutableColumn();
                    mutableColumn.setTable(mutableTable);
                    mutableColumn.setName(metaData.getColumnLabel(i));
                    mutableColumn.setType(discoverTypeColumn(metaData.getColumnType(i)));

                    mutableTable.addColumn(mutableColumn);
                }

                writer.beginArray();
                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>();
                    for (Column column : mutableTable.getColumns()) {
                        row.put(column.getName(), rs.getObject(column.getName()));
                    }
                    rowset.add(row);
                    gson.toJson(row, new TypeToken<Object>() {
                    }.getType(), writer);
                }
                writer.endArray();
                writer.close();
                out.close();

                if(!rowset.isEmpty()) saveResultSetOnRedis(hash);
                montaDataContext(rowset, columns);
            } else {
            	setCached(true);
                logger.info("Get analysis from cache");
                JsonReader reader
                        = new JsonReader(new InputStreamReader(new ByteArrayInputStream(resultsetBytes), "UTF-8"));

                rowset = gson.fromJson(reader, new TypeToken<List<Map<String, ?>>>() {
                }.getType());
                String[] columns = getResultSetColumns(rowset);

                montaDataContext(rowset, columns);
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            deleteTempFile(tempFile);
            closeConnection();
        }
    }

    private void saveResultSetOnRedis(String hash) throws IOException {
        try {
            getJedisInstance().set(hash.getBytes(), Files.toByteArray(tempFile));
            setCached(true);
        } catch (JedisConnectionException ex) {
            logger.error(ex.getMessage());
        }
    }

    private byte[] getRedisResultSet(String hash) {
        byte[] resultSetStream = null;
        try {
            resultSetStream = getJedisInstance().get(hash.getBytes());
        } catch (JedisConnectionException ex) {
            logger.error(ex.getMessage());
        }
        return resultSetStream;
    }

    private void deleteTempFile(File tempFile) {
        if (tempFile != null) {
            tempFile.delete();
        }
    }

    private String createHashOfSQL() {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(this.sql.getBytes());

            return new String(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    private String[] getResultSetColumns(List<Map<String, ?>> rowset) {
        String columns[] = null;
        Map<String, Object> firstElement = null;
        if (rowset != null && !rowset.isEmpty()) {
            firstElement = (LinkedTreeMap<String, Object>) rowset.get(0);
            columns = new String[firstElement.size()];
            int i = 0;
            for (Map.Entry<String, Object> entry : firstElement.entrySet()) {
                columns[i] = entry.getKey();
                i++;
            }
        }
        return columns == null ? new String[]{} : columns;
    }

    private void montaDataContext(List<Map<String, ?>> rowset, String[] columns) {
        TableDataProvider<?> provider = new MapTableDataProvider(
                new SimpleTableDef(DEFAULT_TABLE_NAME, columns), rowset);
        dataContext = new PojoDataContext(DEFAULT_SCHEMA_NAME, provider);
    }

    private void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }

        getJedisInstance().close();
    }

    private DataContext tableCreateDataContext() {
        dataContext = DataContextFactory.createJdbcDataContext(getConnection());

        return dataContext;
    }

    private ColumnType discoverTypeColumn(int type) {
    	return ColumnTypeImpl.convertColumnType(type);
    }

    public boolean isCached() {
        return isCached;
    }

    public void setCached(boolean isCached) {
        this.isCached = isCached;
    }

    private String generateUniqueFileName() {
        String filename = "";
        long millis = System.currentTimeMillis();
        String datetime = new Date().toGMTString();
        datetime = datetime.replace(" ", "");
        datetime = datetime.replace(":", "");
        String rndchars = RandomStringUtils.randomAlphanumeric(16);
        filename = rndchars + "_" + datetime + "_" + millis;
        return filename;
    }

    

}
