package br.com.cds.connecta.framework.connector2.context.database.mysql;

import br.com.cds.connecta.framework.connector2.context.database.Driver;

/**
 *
 * @author diego
 */
public class MySqlConnection implements Driver {

    String host;
    String port;
    String database;

    public MySqlConnection(String host, String port, String database ) {
        this.host = host;
        this.port = port;
        this.database = database;
    }
    
    public MySqlConnection(String host, String port) {
        this.host = host;
        this.port = port;
    }
    
    @Override
    public String jdbcUrl() {
        
        String url = null; 
          url = "jdbc:mysql://"+ host + ":" + port ;
        if(database != null){
            url += "/" + database;
        }
        return url;
    }

    @Override
    public String jdbcDrive() {
        return "com.mysql.jdbc.Driver";
    }

}
