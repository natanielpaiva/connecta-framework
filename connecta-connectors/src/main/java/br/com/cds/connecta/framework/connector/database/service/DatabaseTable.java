package br.com.cds.connecta.framework.connector.database.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author diego
 */
public class DatabaseTable {
    
    private static final Logger logger = Logger.getLogger(DatabaseTable.class);

    /**
     *
     * @param jdbcConnection
     * @param jdbcSchema
     * @param jdbcUser
     * @param jdbcPassword
     * @return
     * @throws SQLException
     */
    public List<IDatabaseTable> getTables(String jdbcConnection, String jdbcSchema,
            String jdbcUser, String jdbcPassword) throws SQLException {

        Connection con = null;

        try {
            logger.info(jdbcConnection+" | "+jdbcUser+" | "+jdbcPassword);
            con = DriverManager.getConnection(jdbcConnection, jdbcUser, jdbcPassword);

            DatabaseMetaData metadata = con.getMetaData();
            String[] types = {"TABLE", "VIEW"};

            //recuperando os metadados sobre as tabelas
            ResultSet rs = metadata.getTables(null, jdbcSchema, "%", types);

            List<IDatabaseTable> tables = new ArrayList<>();

            while (rs.next()) {

                String tableName = rs.getString("TABLE_NAME");
                String tableType = rs.getString("TABLE_TYPE");

                TableImpl table = new TableImpl(tableName);
                table.setSchema(jdbcSchema);
                table.setTableType(tableType);

                //recuperando os metadados da tabela
                String sql = "select * from ".concat(jdbcSchema.concat(".".concat(tableName)));

                try (Statement stm = con.createStatement();
                        ResultSet rsTable = stm.executeQuery(sql);) {

                    ResultSetMetaData rsmetadata = rsTable.getMetaData();

                    List<ColumnImp> columns = new ArrayList<ColumnImp>();

                    for (int i = 1; i <= rsmetadata.getColumnCount(); i++) {
                        ColumnImp column = new ColumnImp();
                        column.setName(rsmetadata.getColumnName(i));
                        column.setDataType(rsmetadata.getColumnTypeName(i));
                        column.setDataPrecision(rsmetadata.getPrecision(i));

                        //recuperando os dados das chaves estrangeiras
                        ResultSet rsColumns = metadata.getImportedKeys(null, jdbcSchema, tableName);

                        while (rsColumns.next()) {
                            String parentTableName = rsColumns.getString(3);
                            String columnImported = rsColumns.getString(4);

                            if (column.getName().equals(columnImported)) {
                                ForeignKeyColumnImpl fk = new ForeignKeyColumnImpl();
                                fk.setName(columnImported);
                                fk.setParentTableName(parentTableName);

                                column.setForeignKey(fk);
                                break;
                            }
                        }
                        rsColumns.close();

                        columns.add(column);
                    }
                    table.getColumns().addAll(columns);
                    tables.add(table);

                } catch (SQLException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
            rs.close();

            return tables;
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    private String getJDBCDriverName(String jdbcConnection) {

        HashMap<String, String> JDBCdrives = new HashMap<String, String>();
        JDBCdrives.put("oracle", "oracle.jdbc.driver.OracleDriver");
        JDBCdrives.put("postgres", "org.postgresql.Driver");

        for (String key : JDBCdrives.keySet()) {

            if (jdbcConnection.contains(key)) {
                return JDBCdrives.get(key);
            }
        }

        return null;
    }

    public List<Map<String, Object>> getSqlViewColumns(String sql, String JDBCConnection, String schema, String user, String password) throws Exception {
        List<String> out = new ArrayList<String>();

//        String sql = "SELECT * FROM (" + " SELECT * FROM PRESENTER2.TB_SOLR_ANALYSIS " + ") F";
//        String JDBCConnection = "jdbc:oracle:thin:@192.168.3.14:1521:cdsdev";
//        String JDBCUser = "presenter2";
//        String JDBCPassword = "cds312";
        //Abrindo a conexão com o banco de dados
        String JDBCDriver = getJDBCDriverName(JDBCConnection);
        Class.forName(JDBCDriver);
        Connection con = DriverManager.getConnection(JDBCConnection, user, password);

        //recuperando os dados da análise
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Map<String, Object>> Obj = new ArrayList<>();

        if (rs != null) {
            while (rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData();

                Map<String, Object> object = new HashMap<>(rsmd.getColumnCount());

                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String column = rsmd.getColumnLabel(i);
                    System.out.println();

                    object.put(column, rs.getObject(column));
                    System.out.println("**" + column + " --> " + rs.getString(column));

                }
                System.out.println("\n");
                Obj.add(object);

            }
            rs.close();
        }
        stm.close();
        con.close();

        return Obj;
    }

    public static void main(String args[]) throws SQLException {

        DatabaseTable database = new DatabaseTable();
        database.getTables("jdbc:oracle:thin:@192.168.3.14:1521:cdsbd", "PRESENTER_ANALYTICS", "portal", "cds312");
//       String[] columns = {"id", "name"};
//       database.getDados("ORACLE_SID", "192.168.3.14", "1521", "cdsdev", "portal", "cds312", columns);
    }

}
