package br.com.cds.connecta.framework.connector2;

import static br.com.cds.connecta.framework.connector2.TestUtil.*;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.QueryBuilder;
import br.com.cds.connecta.framework.connector2.context.database.DatabaseDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.database.ConnectorDriver;
import br.com.cds.connecta.framework.connector2.context.database.mysql.MySQLDriver;
import br.com.cds.connecta.framework.connector2.context.database.oracle.OracleDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author diego
 */
@Ignore
public class DatabaseTest {

    private static final String DEFAULT_TABLE_NAME = "DEFAULT_TABLE_NAME";
    private static final String DEFAULT_SCHEMA_NAME = "DEFAULT_SCHEMA_NAME";

    private static final String MYSQL_HOST = "192.168.33.10";
    private static final String MYSQL_PORT = "3306";
    private static final String MYSQL_DB = "memorando";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASS = "root";

    private static final String ORACLE_HOST = "192.168.3.14";
    private static final String ORACLE_PORT = "1521";
    private static final String ORACLE_SID = "cdsdev";
    private static final String ORACLE_USER = "presenter2";
    private static final String ORACLE_PASS = "cds312";

    private final FusionClient client = new FusionClient();

    private final Logger logger = Logger.getLogger(DatabaseTest.class);

    /**
     * Testa execução de consulta SQL
     */
    @Test
    public void manualQueryMySQL() {
        String sql = getTestResourceAsString("test/sql/mysql.sql");

        ConnectorDriver driver = new MySQLDriver(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);

        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, MYSQL_USER, MYSQL_PASS);
        QueryBuilder query = new QueryBuilder();

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
    public void manualQueryMySQLWithListColumns() {
        String sql = getTestResourceAsString("test/sql/mysql.sql");

        ConnectorDriver driver = new MySQLDriver(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);

        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, MYSQL_USER, MYSQL_PASS);

        List<ConnectorColumn> connectorColumns = new ArrayList<>();

        ConnectorColumn column1 = new ConnectorColumn();
        column1.setId(Long.valueOf(1));
        column1.setName("cod");
        column1.setLabel("código");
        column1.setType("VARCHAR");

        ConnectorColumn column2 = new ConnectorColumn();
        column2.setId(Long.valueOf(1));
        column2.setName("Tipo");
        column2.setLabel("Tipo Memorando");
        column2.setType("VARCHAR");

        connectorColumns.add(column1);
        connectorColumns.add(column2);

        QueryBuilder query = new QueryBuilder().setColumns(connectorColumns);

        Request request = new Request(contextFactory, query);

        List<Map<String, Object>> all = client.getAll(request);

        assertThat(all.get(0).size(), is(2));

        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("Tipo Memorando"));
        assertThat(all.get(0), hasKey("código"));
    }

    /**
     * Verifica quando se passa uma consulta sql retona a tabela Default
     */
    @Test
    public void manualQueryMySQLReturnTableDefault() {
        String sql = getTestResourceAsString("test/sql/mysql.sql");

        ConnectorDriver driver = new MySQLDriver(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);

        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, MYSQL_USER, MYSQL_PASS);
        String[] tables = contextFactory.getTables();

        assertThat(tables.length, is(1));
        assertThat(DEFAULT_TABLE_NAME, hasToString(tables[0]));
    }

    @Test
    public void manualQueryMySQLReturnSchemaDefault() {
        String sql = getTestResourceAsString("test/sql/mysql.sql");

        ConnectorDriver driver = new MySQLDriver(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);

        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, MYSQL_USER, MYSQL_PASS);
        String[] schemas = contextFactory.getSchemas();

        assertThat(schemas.length, is(2));
        assertThat("information_schema", hasToString(schemas[0]));
        assertThat(DEFAULT_SCHEMA_NAME, hasToString(schemas[1]));
    }

    /**
     * Verifica a lista de columns de uma consulta mysql
     */
    @Test
    public void manualQueryMySQLReturnColumns() {
        String sql = getTestResourceAsString("test/sql/mysql.sql");

        ConnectorDriver driver = new MySQLDriver(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);

        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, MYSQL_USER, MYSQL_PASS);
        List<ConnectorColumn> columns = contextFactory.getColumns();

        assertThat(columns.get(0).getName(), hasToString("cod"));
        assertThat(columns.get(0).getLabel(), hasToString("cod"));
        assertThat(columns.get(0).getFormula(), hasToString("cod"));
        assertThat(columns.get(0).getType(), hasToString("VARCHAR"));
    }
//---------------------------------------------

    /**
     * Testa execução de consulta de tabela
     */
    @Test
    public void tableMySQL() {
        String table = "tb_tipo_transporte";

        ConnectorDriver driver = new MySQLDriver(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);

        ContextFactory contextFactory = new DatabaseDataContextFactory(driver, table, MYSQL_USER, MYSQL_PASS);
        QueryBuilder query = new QueryBuilder();

        Request request = new Request(contextFactory, query);

        List<Map<String, Object>> all = client.getAll(request);

        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("id_tipo_transporte"));
        assertThat(all.get(0), hasKey("nome"));
        assertThat(all.get(0), hasKey("ativo"));

        //falta fazer a verificação dos valores
    }

    @Test
    public void tableMySQLWithListColumns() {
        String table = "tb_tipo_transporte";

        ConnectorDriver driver = new MySQLDriver(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);

        ContextFactory contextFactory = new DatabaseDataContextFactory(driver, table, MYSQL_USER, MYSQL_PASS);

        List<ConnectorColumn> connectorColumns = new ArrayList<>();

        ConnectorColumn column1 = new ConnectorColumn();
        column1.setId(Long.valueOf(1));
        column1.setName("id_tipo_transporte");
        column1.setLabel("ID Transporte");
        column1.setFormula("id_tipo_transporte");
        column1.setType("INTEGER");

        ConnectorColumn column2 = new ConnectorColumn();
        column2.setId(Long.valueOf(1));
        column2.setName("nome");
        column2.setLabel("Nome dos Tipos");
        column2.setFormula("nome");
        column2.setType("INTEGER");

        connectorColumns.add(column1);
        connectorColumns.add(column2);

        QueryBuilder query = new QueryBuilder().setColumns(connectorColumns);

        Request request = new Request(contextFactory, query);

        List<Map<String, Object>> all = client.getAll(request);

        assertThat(all.get(0).size(), is(2));

        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("ID Transporte"));
        assertThat(all.get(0), hasKey("Nome dos Tipos"));
    }

    /**
     * Verifica a lista de columns de uma consulta mysql
     */
    @Test
    public void tableMySQLReturnColumns() {
        String table = "tb_tipo_transporte";
        String sql = getTestResourceAsString("test/sql/mysql.sql");

        ConnectorDriver driver = new MySQLDriver(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);

        ContextFactory contextFactory = new DatabaseDataContextFactory(driver, table, MYSQL_USER, MYSQL_PASS);
        List<ConnectorColumn> columns = contextFactory.getColumns();

        assertThat(columns.get(0).getName(), hasToString("id_tipo_transporte"));
        assertThat(columns.get(0).getLabel(), hasToString("id_tipo_transporte"));
        assertThat(columns.get(0).getFormula(), hasToString("id_tipo_transporte"));

        assertThat(columns.get(1).getName(), hasToString("nome"));
        assertThat(columns.get(1).getLabel(), hasToString("nome"));
        assertThat(columns.get(1).getFormula(), hasToString("nome"));

        assertThat(columns.get(2).getName(), hasToString("ativo"));
        assertThat(columns.get(2).getLabel(), hasToString("ativo"));
        assertThat(columns.get(2).getFormula(), hasToString("ativo"));
    }

    /**
     * Lista todas as tabelas do banco
     */
    @Test
    public void listTablesMySQL() {
        ConnectorDriver driver = new MySQLDriver(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);

        ContextFactory contextFactory = new DatabaseDataContextFactory(driver, MYSQL_USER, MYSQL_PASS);
        String[] tables = contextFactory.getTables();
        assertThat(tables.length, is(37));
    }

    /**
     * Testa execução de consulta SQL
     */
    @Test
    public void manualQueryOracle() {
        String sql = getTestResourceAsString("test/sql/oracle.sql");

        ConnectorDriver driver = new OracleDriver(ORACLE_HOST, ORACLE_PORT, ORACLE_SID);

        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, ORACLE_USER, ORACLE_PASS);
        QueryBuilder query = new QueryBuilder();

        Request request = new Request(contextFactory, query);

        List<Map<String, Object>> all = client.getAll(request);

        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("PK_DATASOURCE"));
        assertThat(all.get(0), hasKey("NM_DATASOURCE"));
        assertThat(all.get(0), hasKey("DS_DATASOURCE"));
        assertThat(all.get(0), hasKey("TXT_USUARIO"));
        assertThat(all.get(0), hasKey("TXT_SENHA"));
        assertThat(all.get(0), hasKey("TP_DATASOURCE"));

    }

    @Test
    public void manualQueryOracleWithListColumns() {
        String sql = getTestResourceAsString("test/sql/oracle.sql");

        ConnectorDriver driver = new OracleDriver(ORACLE_HOST, ORACLE_PORT, ORACLE_SID);

        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, ORACLE_USER, ORACLE_PASS);
//        QueryContext query = new QueryContext();

        List<ConnectorColumn> connectorColumns = new ArrayList<>();

        ConnectorColumn column1 = new ConnectorColumn();
        column1.setId(Long.valueOf(1));
        column1.setName("PK_DATASOURCE");
        column1.setLabel("ID Datasouce");
        column1.setType("INT");

        ConnectorColumn column2 = new ConnectorColumn();
        column2.setId(Long.valueOf(1));
        column2.setName("NM_DATASOURCE");
        column2.setLabel("Name");
        column2.setType("INT");

        connectorColumns.add(column1);
        connectorColumns.add(column2);

        QueryBuilder query = new QueryBuilder().setColumns(connectorColumns);

        Request request = new Request(contextFactory, query);

        List<Map<String, Object>> all = client.getAll(request);

        assertThat(all.get(0).size(), is(2));

        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("ID Datasouce"));
        assertThat(all.get(0), hasKey("Name"));
    }

    /**
     * Verifica quando se passa uma consulta sql retona a tabela Default
     */
    @Test
    public void manualQueryOracleReturnTableDefault() {
        String sql = getTestResourceAsString("test/sql/oracle.sql");

        ConnectorDriver driver = new OracleDriver(ORACLE_HOST, ORACLE_PORT, ORACLE_SID);

        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, ORACLE_USER, ORACLE_PASS);
        String[] tables = contextFactory.getTables();

        assertThat(tables.length, is(1));
        assertThat(DEFAULT_TABLE_NAME, hasToString(tables[0]));
    }
//

    @Test
    public void manualQueryOracleReturnSchemaDefault() {
        String sql = getTestResourceAsString("test/sql/oracle.sql");
        ConnectorDriver driver = new OracleDriver(ORACLE_HOST, ORACLE_PORT, ORACLE_SID);
        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, ORACLE_USER, ORACLE_PASS);

        String[] schemas = contextFactory.getSchemas();

        assertThat(schemas.length, is(2));
        assertThat("information_schema", hasToString(schemas[0]));
        assertThat(DEFAULT_SCHEMA_NAME, hasToString(schemas[1]));
    }

    /**
     * Verifica a lista de columns de uma consulta mysql
     */
    @Test
    public void manualQueryOracleReturnColumns() {
        String sql = getTestResourceAsString("test/sql/oracle.sql");
        ConnectorDriver driver = new OracleDriver(ORACLE_HOST, ORACLE_PORT, ORACLE_SID);
        ContextFactory contextFactory = new DatabaseDataContextFactory(sql, driver, ORACLE_USER, ORACLE_PASS);

        List<ConnectorColumn> columns = contextFactory.getColumns();

        assertThat(columns.get(0).getName(), hasToString("PK_DATASOURCE"));
        assertThat(columns.get(0).getLabel(), hasToString("PK_DATASOURCE"));
        assertThat(columns.get(0).getFormula(), hasToString("PK_DATASOURCE"));
        assertThat(columns.get(0).getType(), hasToString("VARCHAR"));
    }
//---------------------------------------------

    /**
     * Testa execução de consulta de tabela
     */
    @Test
    public void TableOracle() {
        String table = "TB_DATASOURCE";
        ConnectorDriver driver = new OracleDriver(ORACLE_HOST, ORACLE_PORT, ORACLE_SID);
        ContextFactory contextFactory = new DatabaseDataContextFactory(driver, table, ORACLE_USER, ORACLE_PASS);

        QueryBuilder query = new QueryBuilder();

        Request request = new Request(contextFactory, query);

        List<Map<String, Object>> all = client.getAll(request);

        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("PK_DATASOURCE"));
        assertThat(all.get(0), hasKey("NM_DATASOURCE"));
        assertThat(all.get(0), hasKey("DS_DATASOURCE"));
        assertThat(all.get(0), hasKey("TXT_USUARIO"));
        assertThat(all.get(0), hasKey("TXT_SENHA"));
        assertThat(all.get(0), hasKey("TP_DATASOURCE"));

        //falta fazer a verificação dos valores
    }

    @Test
    public void tableOracleWithListColumns() {
        String table = "TB_DATASOURCE";
        ConnectorDriver driver = new OracleDriver(ORACLE_HOST, ORACLE_PORT, ORACLE_SID);
        ContextFactory contextFactory = new DatabaseDataContextFactory(driver, table, ORACLE_USER, ORACLE_PASS);

        List<ConnectorColumn> connectorColumns = new ArrayList<>();

        ConnectorColumn column1 = new ConnectorColumn();
        column1.setId(Long.valueOf(1));
        column1.setName("PK_DATASOURCE");
        column1.setLabel("PK_DATASOURCE");
        column1.setFormula("PK_DATASOURCE");
        column1.setType("INTEGER");

        ConnectorColumn column2 = new ConnectorColumn();
        column2.setId(Long.valueOf(1));
        column2.setName("NM_DATASOURCE");
        column2.setLabel("NM_DATASOURCE");
        column2.setFormula("NM_DATASOURCE");
        column2.setType("INTEGER");

        connectorColumns.add(column1);
        connectorColumns.add(column2);

        QueryBuilder query = new QueryBuilder().setColumns(connectorColumns);

        Request request = new Request(contextFactory, query);

        List<Map<String, Object>> all = client.getAll(request);

        assertThat(all.get(0).size(), is(2));

        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("PK_DATASOURCE"));
        assertThat(all.get(0), hasKey("NM_DATASOURCE"));

    }
//

    /**
     * Verifica a lista de columns de uma consulta Oracle
     */
    @Test
    public void tableOracleReturnColumns() {
        String table = "TB_DATASOURCE";
        ConnectorDriver driver = new OracleDriver(ORACLE_HOST, ORACLE_PORT, ORACLE_SID);
        ContextFactory contextFactory = new DatabaseDataContextFactory(driver, table, ORACLE_USER, ORACLE_PASS);

        List<ConnectorColumn> columns = contextFactory.getColumns();

        assertThat(columns.get(0).getName(), hasToString("PK_DATASOURCE"));
        assertThat(columns.get(0).getLabel(), hasToString("PK_DATASOURCE"));
        assertThat(columns.get(0).getFormula(), hasToString("PK_DATASOURCE"));

        assertThat(columns.get(1).getName(), hasToString("NM_DATASOURCE"));
        assertThat(columns.get(1).getLabel(), hasToString("NM_DATASOURCE"));
        assertThat(columns.get(1).getFormula(), hasToString("NM_DATASOURCE"));

        assertThat(columns.get(2).getName(), hasToString("DS_DATASOURCE"));
        assertThat(columns.get(2).getLabel(), hasToString("DS_DATASOURCE"));
        assertThat(columns.get(2).getFormula(), hasToString("DS_DATASOURCE"));
        
    }

    /**
     * Lista todas as tabelas do banco
     */
    @Test
    public void listTablesOracle() {
        ConnectorDriver driver = new OracleDriver(ORACLE_HOST, ORACLE_PORT, ORACLE_SID);
        ContextFactory contextFactory = new DatabaseDataContextFactory(driver, ORACLE_USER, ORACLE_PASS);

        String[] tables = contextFactory.getTables();
        assertThat(tables.length, is(greaterThan(70)));
    }

}
