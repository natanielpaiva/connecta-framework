package br.com.cds.connecta.framework.connector2.context.database.oracle;

import br.com.cds.connecta.framework.connector2.context.database.Driver;

/**
 *
 * @author diego
 */
public class OracleConnection implements Driver {

    String host;
    String port;
    String database;

    public OracleConnection(String host, String port, String database) {
        this.host = host;
        this.port = port;
        this.database = database;
    }

    @Override
    public String jdbcUrl() {
        String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + database;
        System.out.println(url);
        return url;
    }

    @Override
    public String jdbcDrive() {
        return "oracle.jdbc.driver.OracleDriver";
    }

}
