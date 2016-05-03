package br.com.cds.connecta.framework.connector2;

import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import br.com.cds.connecta.framework.connector2.context.database.DatabaseDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.database.mysql.MySQLDriver;
import br.com.cds.connecta.framework.connector2.context.database.oracle.OracleDriver;
import br.com.cds.connecta.framework.connector2.query.QueryFilterOperator;
import br.com.cds.connecta.framework.connector2.query.QueryFilterValue;
import br.com.cds.connecta.framework.connector2.query.QueryFilterValueBetween;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.metamodel.schema.Column;
import org.hamcrest.Matcher;
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

    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASS = "root";

    private static final String ORACLE_USER = "presenter2";
    private static final String ORACLE_PASS = "cds312";

    private final MySQLDriver mysqlDriver = new MySQLDriver("192.168.33.10", "3306", "memorando");
    private final OracleDriver oracleDriver = new OracleDriver("192.168.3.14", "1521", "cdsdev");

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
            assertThat((Number) possibleValue, anyOf(
                    is((Number) 91L),
                    is((Number) 99L),
                    is((Number) 224L)
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
                .addFilter(column, QueryFilterOperator.EQUAL, new QueryFilterValue(value));

        Request request = new Request(contextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, contextFactory.getColumn(columnPossibleValuesName));

        assertThat(all, hasSize(greaterThan(0)));

        for (Object possibleValue : all) {
            assertThat((Number)possibleValue, anyOf(is((Number)91L), is((Number)99L)));
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
                .addFilter(column, QueryFilterOperator.EQUAL, new QueryFilterValue(value));

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
                .addFilter(column, QueryFilterOperator.EQUAL, new QueryFilterValue(value));

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
                .addFilter(column, QueryFilterOperator.EQUAL, new QueryFilterValue(value));

        Request request = new Request(contextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, contextFactory.getColumn(columnPossibleValuesName));

        assertThat(all, hasSize(greaterThan(0)));

        for (Object possibleValue : all) {
            logger.info("VALUE: " + possibleValue);
            assertThat((BigDecimal) possibleValue, anyOf(
                is(new BigDecimal(3))
            ));
        }
    }

    @Test
    public void filterOneColumnDatabaseTableMySQL() {
        String table = "tb_projeto";

        ContextFactory contextFactory = makeMySQLTableContextFactory(table);

        testOneColumnFilterEqual(contextFactory, "cod_projeto_primavera", "CDS.Comercial");
        testOneColumnFilterNotEqual(contextFactory, "cod_projeto_primavera", "CDS.Comercial");
        testOneColumnFilterGreaterThan(contextFactory, "id_projeto", 100);
        testOneColumnFilterLessThan(contextFactory, "id_projeto", 100);
        testOneColumnFilterGreaterThanOrEqualTo(contextFactory, "id_projeto", 99);
        testOneColumnFilterLessThanOrEqualTo(contextFactory, "id_projeto", 99);
        testOneColumnFilterBetween(contextFactory, "id_projeto", 99, 240);
        testOneColumnFilterIn(contextFactory, "id_projeto", new Integer[]{99, 240});
        testOneColumnFilterContains(contextFactory, "cod_projeto_primavera", "S.Com");
        testOneColumnFilterStartsWith(contextFactory, "cod_projeto_primavera", "CDS");
        testOneColumnFilterEndsWith(contextFactory, "cod_projeto_primavera", "ercial");
    }

    @Test
    public void filterTwoColumnsDatabaseTableMySQL() {
        String table = "tb_projeto";
        String column1 = "cod_projeto_primavera";
        String column2 = "id_usuario_gerente";
        String value1 = "CDS.Comercial";
        int value2 = 99;

        ContextFactory contextFactory = makeMySQLTableContextFactory(table);

        List<Map<String, Object>> all;

        all = getResultTwoColumnsFilter(contextFactory,
                column1, QueryFilterOperator.EQUAL, new QueryFilterValue(value1),
                column2, QueryFilterOperator.EQUAL, new QueryFilterValue(value2));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(column1));
            assertThat((String) map.get(column1), is(value1));
            assertThat(map, hasKey(column2));
            assertThat(((Number)map.get(column2)).intValue(), is(value2));
        }
    }

    @Test
    public void filterOneColumnDatabaseSQLMySQL() {
        ContextFactory contextFactory = makeMySQLSQLContextFactory();

        testOneColumnFilterEqual(contextFactory, "tipo", "Reembolso");
        testOneColumnFilterNotEqual(contextFactory, "tipo", "Reembolso");
        testOneColumnFilterGreaterThan(contextFactory, "cod", 6650);
        testOneColumnFilterLessThan(contextFactory, "cod", 6650);
        testOneColumnFilterGreaterThanOrEqualTo(contextFactory, "cod", 6657);
        testOneColumnFilterLessThanOrEqualTo(contextFactory, "cod", 6657);
        testOneColumnFilterBetween(contextFactory, "cod", 6633, 6670);
        testOneColumnFilterIn(contextFactory, "tipo", new String[]{"Reembolso", "Despesas"});
        testOneColumnFilterContains(contextFactory, "tipo", "bol");
        testOneColumnFilterStartsWith(contextFactory, "tipo", "Reem");
        testOneColumnFilterEndsWith(contextFactory, "tipo", "bolso");
    }

    @Test
    public void filterTwoColumnsDatabaseSQLMySQL() {
        String column1 = "tipo";
        String value1 = "Reembolso";
        String column2 = "projeto";
        String value2 = "NTC";

        ContextFactory contextFactory = makeMySQLSQLContextFactory();

        List<Map<String, Object>> all;

        all = getResultTwoColumnsFilter(contextFactory,
                column1, QueryFilterOperator.EQUAL, new QueryFilterValue(value1),
                column2, QueryFilterOperator.EQUAL, new QueryFilterValue(value2));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(column1));
            assertThat((String) map.get(column1), is(value1));
            assertThat(map, hasKey(column2));
            assertThat((String) map.get(column2), is(value2));
        }
    }

    @Test
    public void filterOneColumnDatabaseTableOracle() {
        ContextFactory contextFactory = makeOracleTableContextFactory("TB_VIEWER");

        testOneColumnFilterEqual(contextFactory, "TP_VIEWER", "ANALYSIS");
        testOneColumnFilterNotEqual(contextFactory, "TP_VIEWER", "ANALYSIS");
        testOneColumnFilterGreaterThan(contextFactory, "PK_VIEWER", 700);
        testOneColumnFilterLessThan(contextFactory, "PK_VIEWER", 700);
        testOneColumnFilterGreaterThanOrEqualTo(contextFactory, "PK_VIEWER", 390);
        testOneColumnFilterLessThanOrEqualTo(contextFactory, "PK_VIEWER", 390);
        testOneColumnFilterBetween(contextFactory, "PK_VIEWER", 390, 700);
        testOneColumnFilterIn(contextFactory, "PK_VIEWER", new Integer[]{390, 554});
        testOneColumnFilterContains(contextFactory, "TP_VIEWER", "ALY");
        testOneColumnFilterStartsWith(contextFactory, "TP_VIEWER", "ANA");
        testOneColumnFilterEndsWith(contextFactory, "TP_VIEWER", "SIS");
    }

    @Test
    public void filterTwoColumnsDatabaseTableOracle() {
        String table = "TB_VIEWER";
        String column1 = "TP_VIEWER";
        String column2 = "NM_VIEWER";
        String value1 = "ANALYSIS";
        String value2 = "Total de homens";

        ContextFactory contextFactory = makeOracleTableContextFactory(table);

        List<Map<String, Object>> all;

        all = getResultTwoColumnsFilter(contextFactory,
                column1, QueryFilterOperator.EQUAL, new QueryFilterValue(value1),
                column2, QueryFilterOperator.EQUAL, new QueryFilterValue(value2));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(column1));
            assertThat((String) map.get(column1), is(value1));
            assertThat(map, hasKey(column2));
            assertThat((String) map.get(column2), is(value2));
        }
    }

    @Test
    public void filterOneColumnDatabaseSQLOracle() {
        ContextFactory contextFactory = makeOracleSQLContextFactory();

        testOneColumnFilterEqual(contextFactory, "TP", "DATABASE");
        testOneColumnFilterNotEqual(contextFactory, "TP", "DATABASE");
        testOneColumnFilterGreaterThan(contextFactory, "QT", 2);
        testOneColumnFilterLessThan(contextFactory, "QT", 2);
        testOneColumnFilterGreaterThanOrEqualTo(contextFactory, "QT", 2);
        testOneColumnFilterLessThanOrEqualTo(contextFactory, "QT", 2);
        testOneColumnFilterBetween(contextFactory, "QT", 1, 3);
        testOneColumnFilterIn(contextFactory, "TP", new String[]{"DATABASE", "WEBSERVICE"});
        testOneColumnFilterContains(contextFactory, "TP", "ABA");
        testOneColumnFilterStartsWith(contextFactory, "TP", "DATA");
        testOneColumnFilterEndsWith(contextFactory, "TP", "BASE");
    }

    @Test
    public void filterTwoColumnsDatabaseSQLOracle() {
        String column1 = "TP";
        String value1 = "DATABASE";
        String column2 = "QT";
        int value2 = 3;

        ContextFactory contextFactory = makeOracleSQLContextFactory();

        List<Map<String, Object>> all;

        all = getResultTwoColumnsFilter(contextFactory,
                column1, QueryFilterOperator.EQUAL, new QueryFilterValue(value1),
                column2, QueryFilterOperator.EQUAL, new QueryFilterValue(value2));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(column1));
            assertThat((String) map.get(column1), is(value1));
            assertThat(map, hasKey(column2));
            assertThat(((Number) map.get(column2)).intValue(), is(value2));
        }
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

    private List<Map<String, Object>> getResultOneColumnFilter(ContextFactory contextFactory, String columnName, QueryFilterOperator operator, QueryFilterValue value) {
        Column column = contextFactory.getColumn(columnName);
        QueryBuilder builder = new QueryBuilder()
                .addFilter(column, operator, value);
        Request request = new Request(contextFactory, builder);
        List<Map<String, Object>> all = client.getAll(request);
        PrintResult.printMap(all);
        assertThat(all, hasSize(greaterThan(0)));
        return all;
    }

    private List<Map<String, Object>> getResultTwoColumnsFilter(ContextFactory contextFactory, String column1, QueryFilterOperator operator1, QueryFilterValue value1, String column2, QueryFilterOperator operator2, QueryFilterValue value2) {
        QueryBuilder queryContext = new QueryBuilder()
                .addFilter(contextFactory.getColumn(column1),
                        operator1,
                        value1)
                .addFilter(contextFactory.getColumn(column2),
                        operator2,
                        value2);
        Request request = new Request(contextFactory, queryContext);
        List<Map<String, Object>> all = client.getAll(request);
        PrintResult.printMap(all);
        assertThat(all, hasSize(greaterThan(0)));
        return all;
    }

    private void testOneColumnFilterEqual(ContextFactory contextFactory, String columnName, String value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.EQUAL, new QueryFilterValue(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat((String) map.get(columnName), is(value));
        }
    }

    private void testOneColumnFilterContains(ContextFactory contextFactory, String columnName, String value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.CONTAINS, new QueryFilterValue(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat((String) map.get(columnName), containsString(value));
        }
    }

    private void testOneColumnFilterStartsWith(ContextFactory contextFactory, String columnName, String value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.STARTS_WITH, new QueryFilterValue(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat((String) map.get(columnName), startsWith(value));
        }
    }

    private void testOneColumnFilterEndsWith(ContextFactory contextFactory, String columnName, String value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.ENDS_WITH, new QueryFilterValue(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat((String) map.get(columnName), endsWith(value));
        }
    }

    private void testOneColumnFilterGreaterThan(ContextFactory contextFactory, String columnName, int value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.GREATER_THAN, new QueryFilterValue(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat(((Number)map.get(columnName)).intValue(), greaterThan(value));
        }
    }

    private void testOneColumnFilterLessThan(ContextFactory contextFactory, String columnName, int value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.LESS_THAN, new QueryFilterValue(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat(((Number)map.get(columnName)).intValue(), lessThan(value));
        }
    }

    private void testOneColumnFilterGreaterThanOrEqualTo(ContextFactory contextFactory, String columnName, int value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.GREATER_THAN_EQUAL, new QueryFilterValue(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat(((Number)map.get(columnName)).intValue(), greaterThanOrEqualTo(value));
        }
    }

    private void testOneColumnFilterLessThanOrEqualTo(ContextFactory contextFactory, String columnName, int value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.LESS_THAN_EQUAL, new QueryFilterValue(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat(((Number)map.get(columnName)).intValue(), lessThanOrEqualTo(value));
        }
    }

    private void testOneColumnFilterNotEqual(ContextFactory contextFactory, String columnName, String value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.NOT_EQUAL, new QueryFilterValue(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat((String) map.get(columnName), not(is(value)));
        }
    }
    
    private void testOneColumnFilterBetween(ContextFactory contextFactory, String columnName, int start, int end) {
        List<Map<String, Object>> all = getResultOneColumnFilter(
            contextFactory, columnName, QueryFilterOperator.BETWEEN,
            new QueryFilterValue(
                    new QueryFilterValueBetween(start, end)
            )
        );

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            int integer = Integer.parseInt(map.get(columnName).toString());
            assertThat(integer, allOf(
                greaterThanOrEqualTo(start), lessThanOrEqualTo(end)
            ));
        }
    }
    
    private void testOneColumnFilterIn(ContextFactory contextFactory, String columnName, Object[] values) {
        Collection<Matcher<Object>> in = new ArrayList<>(values.length);
        for (Object value : values) {
            in.add( is( value ) );
        }
        
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.IN, new QueryFilterValue(Arrays.asList(values)));
        
        for (Map<String, Object> map : all) {
            Object expected;
            if (map.get(columnName) instanceof Number) {
                expected = ((Number)map.get(columnName)).intValue();
            } else {
                expected = map.get(columnName);
            }
            
            assertThat(map, hasKey(columnName));
            assertThat(
                expected,
                anyOf( (Iterable<Matcher<Object>>) in)
            );
        }
    }

}
