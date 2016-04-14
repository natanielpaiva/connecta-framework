package br.com.cds.connecta.framework.connector2;

import static br.com.cds.connecta.framework.connector2.TestUtil.*;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.QueryContext;
import br.com.cds.connecta.framework.connector2.context.database.DatabaseDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.database.Driver;
import br.com.cds.connecta.framework.connector2.context.database.mysql.MySqlConnection;
import br.com.cds.connecta.framework.connector2.context.database.oracle.OracleConnection;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.metamodel.schema.Table;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author diego
 */
public class DatabaseTest {
    
    private static final String MYSQL_HOST      = "192.168.33.10";
    private static final String MYSQL_PORT      = "3306";
    private static final String MYSQL_DB        = "memorando";
    private static final String MYSQL_USER      = "root";
    private static final String MYSQL_PASS      = "root";
    
    private static final String ORACLE_HOST     = "192.168.33.10";
    private static final String ORACLE_PORT     = "1521";
    private static final String ORACLE_SID      = "memorando";
    private static final String ORACLE_USER     = "root";
    private static final String ORACLE_PASS     = "root";
            
    private final FusionClient client = new FusionClient();
    
    private final Logger logger = Logger.getLogger(DatabaseTest.class);
    
    @Test
    public void manualQueryMySQL(){
        String sql = getTestResourceAsString("test/sql/mysql.sql");
        
        Driver driver = new MySqlConnection(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);
        
        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, MYSQL_USER, MYSQL_PASS);
        QueryContext query = new QueryContext();//.setPagination(1, 20)
        
        Request request = new Request(contextFactory, query);
        
        List<Map<String, Object>> all = client.getAll(request);
        
        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("Reprovação"));
        assertThat(all.get(0), hasKey("Atividade"));
        assertThat(all.get(0), hasKey("Transporte"));
        assertThat(all.get(0), hasKey("Hotel"));
        assertThat(all.get(0), hasKey("Observações"));
        assertThat(all.get(0), hasKey("Projeto"));
        assertThat(all.get(0), hasKey("Data"));
        assertThat(all.get(0), hasKey("Taxi"));
        assertThat(all.get(0), hasKey("Tipo"));
        assertThat(all.get(0), hasKey("Locação"));
        assertThat(all.get(0), hasKey("cod"));
        assertThat(all.get(0), hasKey("Cod TMP"));
        assertThat(all.get(0), hasKey("R"));
        assertThat(all.get(0), hasKey("cod2"));
        assertThat(all.get(0), hasKey("Assunto"));
    }
    
    @Test
    @Ignore
    public void manualQueryOracle(){
        String sql = getTestResourceAsString("test/sql/oracle.sql");
        
        Driver driver = new OracleConnection(ORACLE_HOST, ORACLE_PORT, ORACLE_SID);
        
        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, MYSQL_USER, MYSQL_PASS);
        QueryContext query = new QueryContext();//.setPagination(1, 20)
        
        Request request = new Request(contextFactory, query);
        
        List<Map<String, Object>> all = client.getAll(request);
        
        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("Reprovação"));
        assertThat(all.get(0), hasKey("Atividade"));
        assertThat(all.get(0), hasKey("Transporte"));
        assertThat(all.get(0), hasKey("Hotel"));
        assertThat(all.get(0), hasKey("Observações"));
        assertThat(all.get(0), hasKey("Projeto"));
        assertThat(all.get(0), hasKey("Data"));
        assertThat(all.get(0), hasKey("Taxi"));
        assertThat(all.get(0), hasKey("Tipo"));
        assertThat(all.get(0), hasKey("Locação"));
        assertThat(all.get(0), hasKey("cod"));
        assertThat(all.get(0), hasKey("Cod TMP"));
        assertThat(all.get(0), hasKey("R"));
        assertThat(all.get(0), hasKey("cod2"));
        assertThat(all.get(0), hasKey("Assunto"));
    }
    
    @Test
    public void tablesMySql(){
        String sql = getTestResourceAsString("test/sql/mysql.sql");
        
        Driver driver = new MySqlConnection(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);
        
        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, MYSQL_USER, MYSQL_PASS);
//        contextFactory.
        
        
    }
    @Test
    public void manualQueryPostgreSQL(){
        
    }
    
    @Test
    @Ignore
    public void columnsFromTableMySQL(){
        String sql = getTestResourceAsString("test/sql/mysql.sql");
        
        Driver driver = new MySqlConnection(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);
        
        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, MYSQL_USER, MYSQL_PASS);
        QueryContext query = new QueryContext();//.setPagination(1, 20)
        
        Request request = new Request(contextFactory, query);
        
        //List<ConnectorColumn> columns = client.getColumns(request);
        
    }
    
    @Test
    public void columnsFromTableOracle(){
        
    }
    
    @Test
    public void columnsFromTablePostgreSQL(){
        
    }
    
}
