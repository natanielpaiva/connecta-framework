package br.com.cds.connecta.framework.connector2;

import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.common.QueryBuilder;
import br.com.cds.connecta.framework.connector2.context.database.DatabaseDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.database.mysql.MySQLDriver;
import br.com.cds.connecta.framework.connector2.context.database.oracle.OracleDriver;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.metamodel.query.OperatorType;
import org.apache.metamodel.schema.Column;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author diego
 */
@Ignore
public class DatabaseFilterTest {

    private final Logger logger = Logger.getLogger(DatabaseFilterTest.class);

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

    private final MySQLDriver mysqlDriver = new MySQLDriver(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);
    private final OracleDriver oracleDriver = new OracleDriver(ORACLE_HOST, ORACLE_PORT, ORACLE_SID);

    private final FusionClient client = new FusionClient();

    @Test
    public void listPossibleValuesForFilterWithoutPreviousFiltersTableMySQL() {
        String table = "tb_projeto";
        String columnName = "id_usuario_gerente";

        ContextFactory contextFactory = makeMySQLTableContextFactory(table);

        QueryBuilder queryContext = new QueryBuilder();

        Request request = new Request(contextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, contextFactory.getColumn(columnName));
        
        assertThat(all, hasSize(greaterThan(0)));

        for (Object possibleValue : all) {
            logger.info("VALUE: " + possibleValue);
            assertThat((String) possibleValue, anyOf(
                    is("91"),
                    is("99"),
                    is("224")
            ));
        }
    }

    @Test
    public void listPossibleValuesForFilterWithPreviousFiltersTableMySQL() {
        String table = "tb_projeto";
        String columnName = "cod_projeto_primavera";
        String value = "CDS.Comercial";
        String columnPossibleValuesName = "id_usuario_gerente";

        ContextFactory contextFactory = makeMySQLTableContextFactory(table);

        Column column = contextFactory.getColumn(columnName);

        QueryBuilder queryContext = new QueryBuilder()
                .addWhere(column, OperatorType.EQUALS_TO, value);

        Request request = new Request(contextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, contextFactory.getColumn(columnPossibleValuesName));

        assertThat(all, hasSize(greaterThan(0)));

        for (Object possibleValue : all) {
            assertThat((String) possibleValue, anyOf(is("91"), is("99")));
        }
    }

    @Test
    public void listPossibleValuesForFilterWithoutPreviousFiltersSQLMySQL() {
        String columnName = "tipo";

        ContextFactory contextFactory = makeMySQLSQLContextFactory();

        QueryBuilder queryContext = new QueryBuilder();

        Request request = new Request(contextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, contextFactory.getColumn(columnName));
        
        assertThat(all, hasSize(greaterThan(0)));

        for (Object possibleValue : all) {
            logger.info("VALUE: " + possibleValue);
            assertThat((String) possibleValue, anyOf(
                    is("Reembolso"),
                    is("Despesas"),
                    is("Despesa"),
                    is("Compra de Material")
            ));
        }
    }

    @Test
    public void listPossibleValuesForFilterWithPreviousFiltersSQLMySQL() {
        String columnName = "tipo";
        String value = "Reembolso";
        String columnPossibleValuesName = "projeto";

        ContextFactory contextFactory = makeMySQLSQLContextFactory();

        Column column = contextFactory.getColumn(columnName);

        QueryBuilder queryContext = new QueryBuilder()
                .addWhere(column, OperatorType.EQUALS_TO, value);

        Request request = new Request(contextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, contextFactory.getColumn(columnPossibleValuesName));
        
        assertThat(all, hasSize(greaterThan(0)));

        assertThat(all, containsInAnyOrder((Object) "NTC", (Object) "Prospecção Comercial"));
    }
    
    @Test
    public void listPossibleValuesForFilterWithoutPreviousFiltersTableOracle() {
        String table = "TB_VIEWER";
        String columnName = "TP_VIEWER";

        ContextFactory contextFactory = makeOracleTableContextFactory(table);

        QueryBuilder builder = new QueryBuilder();

        Request request = new Request(contextFactory, builder);

        List<Object> all = client.possibleValuesFor(
                request,
                contextFactory.getColumn(columnName));
        
        assertThat(all, hasSize(greaterThan(0)));

        for (Object possibleValue : all) {
            logger.info("VALUE: " + possibleValue);
            assertThat((String) possibleValue, anyOf(
                    is("SINGLESOURCE"),
                    is("ANALYSIS")
            ));
        }
    }

    @Test
    public void listPossibleValuesForFilterWithPreviousFiltersTableOracle() {
        String table = "TB_DATASOURCE";
        String columnName = "TP_DATASOURCE";
        String value = "DATABASE";
        String columnPossibleValuesName = "TXT_USUARIO";

        ContextFactory contextFactory = makeOracleTableContextFactory(table);

        Column column = contextFactory.getColumn(columnName);

        QueryBuilder queryContext = new QueryBuilder()
                .addWhere(column, OperatorType.EQUALS_TO, value);

        Request request = new Request(contextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, contextFactory.getColumn(columnPossibleValuesName));
        
        assertThat(all, hasSize(greaterThan(0)));

        for (Object possibleValue : all) {
            assertThat((String) possibleValue, anyOf(
                is("PRESENTER2"),
                is("PRESENTER_ANALYTICS"),
                is("poc_caixa"),
                is("root")
            ));
        }
    }

    @Test
    public void listPossibleValuesForFilterWithoutPreviousFiltersSQLOracle() {
        String columnName = "TP";

        ContextFactory contextFactory = makeOracleSQLContextFactory();

        QueryBuilder queryContext = new QueryBuilder();

        Request request = new Request(contextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, contextFactory.getColumn(columnName));
        
        assertThat(all, hasSize(greaterThan(0)));

        for (Object possibleValue : all) {
            logger.info("VALUE: " + possibleValue);
            assertThat((String) possibleValue, anyOf(
                is("DATABASE"),
                is("WEBSERVICE"),
                is("HDFS")
            ));
        }
    }

    @Test
    public void listPossibleValuesForFilterWithPreviousFiltersSQLOracle() {
        String columnName = "TP";
        String value = "DATABASE";
        String columnPossibleValuesName = "QT";

        ContextFactory contextFactory = makeOracleSQLContextFactory();

        Column column = contextFactory.getColumn(columnName);

        QueryBuilder queryContext = new QueryBuilder()
                .addWhere(column, OperatorType.EQUALS_TO, value);

        Request request = new Request(contextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, contextFactory.getColumn(columnPossibleValuesName));
        
        assertThat(all, hasSize(greaterThan(0)));

        for (Object possibleValue : all) {
            logger.info("VALUE: " + possibleValue);
            assertThat((String) possibleValue, anyOf(
                is("4")
            ));
        }
    }

    @Test
    public void filterOneColumnDatabaseTableMySQL() {
        String table = "tb_projeto";
        String columnName = "cod_projeto_primavera";
        String value = "CDS.Comercial";

        ContextFactory contextFactory = makeMySQLTableContextFactory(table);

        testOneColumnFilter(contextFactory, columnName, value);
    }

    @Test
    public void filterTwoColumnsDatabaseTableMySQL() {
        String table = "tb_projeto";
        String column1 = "cod_projeto_primavera";
        String column2 = "id_usuario_gerente";
        String value1 = "CDS.Comercial";
        String value2 = "99";

        ContextFactory contextFactory = makeMySQLTableContextFactory(table);

        testTwoColumnsFilter(contextFactory, column1, value1, column2, value2);
    }

    @Test
    public void filterOneColumnDatabaseSQLMySQL() {
        String columnName = "tipo";
        String value = "Reembolso";

        ContextFactory contextFactory = makeMySQLSQLContextFactory();

        testOneColumnFilter(contextFactory, columnName, value);
    }

    @Test
    public void filterTwoColumnsDatabaseSQLMySQL() {
        String columnName1 = "tipo";
        String value1 = "Reembolso";
        String columnName2 = "projeto";
        String value2 = "NTC";

        ContextFactory contextFactory = makeMySQLSQLContextFactory();
        
        testTwoColumnsFilter(contextFactory, columnName1, value1, columnName2, value2);
    }

    @Test
    public void filterOneColumnDatabaseTableOracle() {
        String table = "TB_VIEWER";
        String columnName = "TP_VIEWER";
        String value = "ANALYSIS";

        ContextFactory contextFactory = makeOracleTableContextFactory(table);

        testOneColumnFilter(contextFactory, columnName, value);
    }

    @Test
    public void filterTwoColumnsDatabaseTableOracle() {
        String table = "TB_VIEWER";
        String column1 = "TP_VIEWER";
        String column2 = "NM_VIEWER";
        String value1 = "ANALYSIS";
        String value2 = "Total de homens";

        ContextFactory contextFactory = makeOracleTableContextFactory(table);

        testTwoColumnsFilter(contextFactory, column1, value1, column2, value2);
    }

    @Test
    public void filterOneColumnDatabaseSQLOracle() {
        String columnName = "TP";
        String value = "DATABASE";

        ContextFactory contextFactory = makeOracleSQLContextFactory();

        testOneColumnFilter(contextFactory, columnName, value);
    }

    @Test
    public void filterTwoColumnsDatabaseSQLOracle() {
        String columnName1 = "TP";
        String value1 = "DATABASE";
        String columnName2 = "QT";
        String value2 = "4";

        ContextFactory contextFactory = makeOracleSQLContextFactory();
        
        testTwoColumnsFilter(contextFactory, columnName1, value1, columnName2, value2);
    }
    
    private DatabaseDataContextFactory makeMySQLTableContextFactory(String table) {
        return new DatabaseDataContextFactory(mysqlDriver, table, MYSQL_USER, MYSQL_PASS);
    }
    
    private DatabaseDataContextFactory makeMySQLSQLContextFactory() {
        return new DatabaseDataContextFactory(
                TestUtil.getTestResourceAsString("test/sql/mysql-filter.sql"),
                mysqlDriver, MYSQL_USER, MYSQL_PASS);
    }
    
    private DatabaseDataContextFactory makeOracleTableContextFactory(String table) {
        return new DatabaseDataContextFactory(oracleDriver, table, ORACLE_USER, ORACLE_PASS);
    }

    private DatabaseDataContextFactory makeOracleSQLContextFactory() {
        return new DatabaseDataContextFactory(
                TestUtil.getTestResourceAsString("test/sql/oracle-filter.sql"),
                oracleDriver, ORACLE_USER, ORACLE_PASS);
    }
    
    private void testOneColumnFilter(ContextFactory contextFactory, String columnName, String value) {
        Column column = contextFactory.getColumn(columnName);
        
        QueryBuilder queryContext = new QueryBuilder()
                .addWhere(column, OperatorType.EQUALS_TO, value);

        Request request = new Request(contextFactory, queryContext);

        List<Map<String, Object>> all = client.getAll(request);

        PrintResult.printMap(all);
        
        assertThat(all, hasSize(greaterThan(0)));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat((String) map.get(columnName), is(value));
        }
    }
    
    private void testTwoColumnsFilter(ContextFactory contextFactory, String column1, String value1, String column2, String value2) {
        QueryBuilder queryContext = new QueryBuilder()
            .addWhere(
                contextFactory.getColumn(column1),
                OperatorType.EQUALS_TO,
                value1)
            .addWhere(
                contextFactory.getColumn(column2),
                OperatorType.EQUALS_TO,
                value2);

        Request request = new Request(contextFactory, queryContext);

        List<Map<String, Object>> all = client.getAll(request);

        PrintResult.printMap(all);
        
        assertThat(all, hasSize(greaterThan(0)));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(column1));
            assertThat((String) map.get(column1), is(value1));
            assertThat(map, hasKey(column2));
            assertThat((String) map.get(column2), is(value2));
        }
    }
}
