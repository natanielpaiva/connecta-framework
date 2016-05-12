package br.com.cds.connecta.framework.connector2.context.database.mysql;

import br.com.cds.connecta.framework.connector2.context.database.ConnectorDriver;

/**
 *
 * @author diego
 */
public class MySQLDriver implements ConnectorDriver {

    private String host;
    private String port;
    private String database;

    public MySQLDriver(String host, String port, String database) {
        this.host = host;
        this.port = port;
        this.database = database;
    }

    public MySQLDriver(String host, String port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public String jdbcUrl() {
        String url = "jdbc:mysql://" + host + ":" + port;
        if (database != null) {
            url += "/" + database;
        }
        return url;
    }

}
