/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.connector.database.service;

import br.com.cds.connecta.framework.connector.database.Database;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author diego
 */
public class DatabaseTable {
    
    /**
     *
     * @param JDBCConnection
     * @param JDBCSchema
     * @param JDBCUser
     * @param JDBCPassword
     * @return
     * @throws SQLException
     */
    
    public List<IDatabaseTable> getTables(String JDBCConnection, String JDBCSchema,
            String JDBCUser, String JDBCPassword) throws SQLException {

        Connection con = null;

        try {
            String JDBCDriver = getJDBCDriverName(JDBCConnection);
            //String JDBCDriver = "oracle.jdbc.driver.OracleDriver";

            Class.forName(JDBCDriver);
            con = DriverManager.getConnection(JDBCConnection, JDBCUser, JDBCPassword);

            DatabaseMetaData metadata = con.getMetaData();
            String[] types = {"TABLE", "VIEW"};

            //recuperando os metadados sobre as tabelas
            ResultSet rs = metadata.getTables(null, JDBCSchema, "%", types);

            List<IDatabaseTable> tables = new ArrayList<IDatabaseTable>();

            while (rs.next()) {

                try {
                    String tableName = rs.getString("TABLE_NAME");
                    String tableType = rs.getString("TABLE_TYPE");

                    TableImpl table = new TableImpl(tableName);
                    table.setSchema(JDBCSchema);
                    table.setTableType(tableType);

                    //recuperando os metadados da tabela
                    String sql = "select * from ".concat(JDBCSchema.concat(".".concat(tableName)));
                    Statement stm = con.createStatement();

                    ResultSet rsTable = stm.executeQuery(sql);
                    ResultSetMetaData rsmetadata = rsTable.getMetaData();

                    List<ColumnImp> columns = new ArrayList<ColumnImp>();

                    for (int i = 1; i <= rsmetadata.getColumnCount(); i++) {
                        ColumnImp column = new ColumnImp();
                        column.setName(rsmetadata.getColumnName(i));
                        column.setDataType(rsmetadata.getColumnTypeName(i));
                        column.setDataPrecision(rsmetadata.getPrecision(i));

                        //recuperando os dados das chaves estrangeiras
                        ResultSet rsColumns = metadata.getImportedKeys(null, JDBCSchema, tableName);

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

                    rsTable.close();
                } catch (SQLException e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }

            rs.close();

            return tables;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }
    
    
    
    private String getJDBCDriverName(String jdbcConnection) {

        HashMap<String, String> JDBCdrives = new HashMap<String,String>();
        JDBCdrives.put("oracle", "oracle.jdbc.driver.OracleDriver");
        JDBCdrives.put("postgres", "org.postgresql.Driver");
        
        for (String key : JDBCdrives.keySet()) {

            if (jdbcConnection.contains(key)) {
                return JDBCdrives.get(key);
            }
        }

        return null;
    }
    
    
     public static void main(String args[]) throws SQLException  {
         
         
       DatabaseTable database = new DatabaseTable();
       database.getTables("jdbc:oracle:thin:@192.168.3.14:1521:cdsbd", "PRESENTER_ANALYTICS", "portal", "cds312");
//       String[] columns = {"id", "name"};
//       database.getDados("ORACLE_SID", "192.168.3.14", "1521", "cdsdev", "portal", "cds312", columns);
   }
    
}
