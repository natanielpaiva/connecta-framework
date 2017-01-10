package br.com.cds.connecta.framework.connector2.context.database.orientdb;

import br.com.cds.connecta.framework.connector2.context.database.ConnectorDriver;

/**
 *
 * @author diego
 */
public class OrientdbDriver implements ConnectorDriver {

    private String host;
    private String port;
    private String database;

    public OrientdbDriver(String host, String port, String database) {
        this.host = host;
        this.port = port;
        this.database = database;
    }

    public OrientdbDriver(String host, String port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public String jdbcUrl() {
        return "jdbc:orient:remote:" + host + ":" + port+"/" + database;
    }

}