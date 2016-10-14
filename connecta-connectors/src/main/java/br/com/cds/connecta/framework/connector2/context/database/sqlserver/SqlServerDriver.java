package br.com.cds.connecta.framework.connector2.context.database.sqlserver;

import br.com.cds.connecta.framework.connector2.context.database.ConnectorDriver;

/**
 *
 * @author diego
 */
public class SqlServerDriver implements ConnectorDriver {

    private String host;
    private String port;
    private String database;

    public SqlServerDriver(String host, String port, String database) {
        this.host = host;
        this.port = port;
        this.database = database;
    }

    @Override
    public String jdbcUrl() {
        return "jdbc:sqlserver://" + host + ":" + port + ";DatabaseName=" + database;
    }
}
