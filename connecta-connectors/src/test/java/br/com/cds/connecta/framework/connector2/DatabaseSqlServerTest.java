package br.com.cds.connecta.framework.connector2;

import static br.com.cds.connecta.framework.connector2.TestUtil.*;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import br.com.cds.connecta.framework.connector2.context.database.DatabaseDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.database.ConnectorDriver;
import br.com.cds.connecta.framework.connector2.context.database.sqlserver.SqlServerDriver;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Classe incompleta
 * @author diego
 */
@Ignore
public class DatabaseSqlServerTest {

    private static final String DEFAULT_TABLE_NAME = "DEFAULT_TABLE_NAME";
    private static final String DEFAULT_SCHEMA_NAME = "DEFAULT_SCHEMA_NAME";

    private static final String SQLSERVER_HOST = "192.168.56.101";
    private static final String SQLSERVER_PORT = "1433";
    private static final String SQLSERVER_DB = "diegorego";
    private static final String SQLSERVER_USER = "diego";
    private static final String SQLSERVER_PASS = "root";


    private final FusionClient client = new FusionClient();

    private final Logger logger = Logger.getLogger(DatabaseSqlServerTest.class);

    /**
     * Testa execução de consulta SQL
     */
    @Test
    public void manualQuerySqlServer() throws SQLException {
        String sql = getTestResourceAsString("test/sql/sqlserver.sql");
        ConnectorDriver driver = new SqlServerDriver(SQLSERVER_HOST, SQLSERVER_PORT, SQLSERVER_DB);

        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, SQLSERVER_USER, SQLSERVER_PASS, true);
        QueryBuilder query = new QueryBuilder();

        Request request = new Request(contextFactory, query);
        List<Map<String, Object>> all = client.getAll(request);
        PrintResult.printMap(all);

    }

    @Test
    public void manualQuerySqlServerWithListColumns() {
        ConnectorDriver driver = new SqlServerDriver(SQLSERVER_HOST, SQLSERVER_PORT, SQLSERVER_DB);
        DatabaseDataContextFactory contextFactory = new DatabaseDataContextFactory( driver, SQLSERVER_USER, SQLSERVER_PASS);
        List tablesColumns = contextFactory.getTablesColumns();
    }
    
    
    @Test
    public void tableSqlServer() {
       ConnectorDriver driver = new SqlServerDriver(SQLSERVER_HOST, SQLSERVER_PORT, SQLSERVER_DB);
        DatabaseDataContextFactory contextFactory = new DatabaseDataContextFactory( driver, "usuario", SQLSERVER_USER, SQLSERVER_PASS);
        QueryBuilder query = new QueryBuilder();
        Request request = new Request(contextFactory, query);
        List<Map<String, Object>> all = client.getAll(request);
        PrintResult.printMap(all);
    }
}
