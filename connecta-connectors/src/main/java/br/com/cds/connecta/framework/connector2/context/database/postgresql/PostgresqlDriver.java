package br.com.cds.connecta.framework.connector2.context.database.postgresql;

import br.com.cds.connecta.framework.connector2.context.database.ConnectorDriver;

/**
 *
 * @author diego
 */
public class PostgresqlDriver implements ConnectorDriver {

    private String host;
    private String port;
    private String database;

    public PostgresqlDriver(String host, String port, String database) {
        this.host = host;
        this.port = port;
        this.database = database;
    }

    @Override
    public String jdbcUrl() {
        return "jdbc:postgresql://" + host + ":" + port + "/" + database;
    }

//    public void getConnection() {
//        
//        try {
//            Class.forName("org.postgresql.Driver");
//            try {
//                Connection connection = DriverManager
//                        .getConnection("jdbc:postgresql://localhost:5432/testdb",
//                                "postgres", "123");
//            } catch (SQLException ex) {
//                Logger.getLogger(PostgresqlConnection.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(PostgresqlConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
