package br.com.cds.connecta.framework.connector2;

import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import br.com.cds.connecta.framework.connector2.context.database.DatabaseDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.database.ConnectorDriver;
import br.com.cds.connecta.framework.connector2.context.database.orientdb.OrientdbDriver;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Ignore;

/**
 *
 * @author diego
 */
@Ignore
public class DatabaseOrientDBTest {

    private static final String MYSQL_HOST = "167.114.116.94";
    private static final String MYSQL_PORT = "2424";
    private static final String MYSQL_DB = "GratefulDeadConcerts";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASS = "cds312";

    

    private final FusionClient client = new FusionClient();

    private final Logger logger = Logger.getLogger(DatabaseOrientDBTest.class);

    /**
     * Testa execução de consulta SQL
     */
    @Test
    public void manualQueryMySQL() throws SQLException {
        String sql = "SELECT FROM Colaborador";

        ConnectorDriver driver = new OrientdbDriver(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);

        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, MYSQL_USER, MYSQL_PASS);
        QueryBuilder query = new QueryBuilder();

        Request request = new Request(contextFactory, query);
        
        System.out.println("request");

        List<Map<String, Object>> all = client.getAll(request);
        PrintResult.printMap(all);
        
    }
}
