package br.com.cds.connecta.framework.connector2.context.database.oracle;

import br.com.cds.connecta.framework.connector2.context.database.ConnectorDriver;

/**
 *
 * @author diego
 */
public class OracleDriver implements ConnectorDriver {

    private String host;
    private String port;
    private String database;

    public OracleDriver(String host, String port, String database) {
        this.host = host;
        this.port = port;
        this.database = database;
    }

    @Override
    public String jdbcUrl() {
//        String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + database;
        return "jdbc:oracle:thin:@"+host+":"+port+":"+database;
    }

}
