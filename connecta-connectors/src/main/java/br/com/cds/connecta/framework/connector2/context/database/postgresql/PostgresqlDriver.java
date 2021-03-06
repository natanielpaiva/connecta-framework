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
}
