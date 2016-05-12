package br.com.cds.connecta.framework.connector2;

import static br.com.cds.connecta.framework.connector2.TestUtil.getFile;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import br.com.cds.connecta.framework.connector2.context.file.FileDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.csv.CSVDataContextFactory;
import br.com.cds.connecta.framework.connector2.query.QueryFilterOperator;
import br.com.cds.connecta.framework.connector2.query.QueryFilterValue;
import br.com.cds.connecta.framework.connector2.query.QueryFilterValueBetween;
import java.io.File;
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
import org.junit.Test;

/**
 *
 * @author diego
 */
public class CsvFilterTest {

    private final Logger logger = Logger.getLogger(CsvFilterTest.class);

    private static final File csvCities = getFile("test/data/csv/csv_cities.csv");

    private final FusionClient client = new FusionClient();

    @Test
    public void listPossibleValuesForFilterWithoutPreviousFiltersCSV() {
        String columnName = "UF";

        ContextFactory contextFactory = makeCSVFileContextFactory();

        QueryBuilder queryContext = new QueryBuilder();

        Request request = new Request(contextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, contextFactory.getColumn(columnName));

        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.size(), is(26));

        for (Object possibleValue : all) {
            logger.info("VALUE: " + possibleValue);
            assertThat((String) possibleValue, anyOf(
                    is("PI"),
                    is("PE"),
                    is("RJ"),
                    is("TO"),
                    is("PB"),
                    is("RO"),
                    is("RN"),
                    is("RS"),
                    is("MG"),
                    is("PA"),
                    is("MA"),
                    is("DF"),
                    is("GO"),
                    is("SP"),
                    is("MT"),
                    is("MS"),
                    is("BA"),
                    is("SE"),
                    is("PR"),
                    is("ES"),
                    is("SC"),
                    is("AC"),
                    is("CE"),
                    is("AP"),
                    is("AM"),
                    is("AL")
            ));
        }
    }

    @Test
    public void listPossibleValuesForFilterWithPreviousFiltersCSV() {
        String columnName = "Regiao";
        ContextFactory contextFactory = makeCSVFileContextFactory();

        Column column = contextFactory.getColumn(columnName);

        QueryBuilder queryContext = new QueryBuilder()
                .addFilter(column, QueryFilterOperator.EQUAL, new QueryFilterValue("Nordeste"));

        Request request = new Request(contextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, contextFactory.getColumn("UF"));

        assertThat(all, hasSize(greaterThan(0)));

        for (Object possibleValue : all) {
            assertThat((String) possibleValue,
                    anyOf(
                            is("PI"),
                            is("PE"),
                            is("PB"),
                            is("BA"),
                            is("CE"),
                            is("AP"),
                            is("SE"),
                            is("MA"),
                            is("AL")
                    ));
        }
    }

    @Test
    public void filterOneColumnCsv() {

        testOneColumnFilterEqual(new FileDataContextFactory(new CSVDataContextFactory(csvCities)), "Regiao", "Norte");
        testOneColumnFilterNotEqual(new FileDataContextFactory(new CSVDataContextFactory(csvCities)), "Regiao", "Norte");
        testOneColumnFilterGreaterThan(new FileDataContextFactory(new CSVDataContextFactory(csvCities)), "vendas", 80);
        testOneColumnFilterLessThan(new FileDataContextFactory(new CSVDataContextFactory(csvCities)), "vendas", 9);
        testOneColumnFilterGreaterThanOrEqualTo(new FileDataContextFactory(new CSVDataContextFactory(csvCities)), "vendas", 80);
        testOneColumnFilterLessThanOrEqualTo(new FileDataContextFactory(new CSVDataContextFactory(csvCities)), "vendas", 9);
        testOneColumnFilterBetween(new FileDataContextFactory(new CSVDataContextFactory(csvCities)), "vendas", 2, 9);
        testOneColumnFilterIn(new FileDataContextFactory(new CSVDataContextFactory(csvCities)), "vendas", new Integer[]{2, 5});
        testOneColumnFilterContains(new FileDataContextFactory(new CSVDataContextFactory(csvCities)), "Cidade", "Aurora");
        testOneColumnFilterStartsWith(new FileDataContextFactory(new CSVDataContextFactory(csvCities)), "Regiao", "Nort");
        testOneColumnFilterEndsWith(new FileDataContextFactory(new CSVDataContextFactory(csvCities)), "UF", "I");
    }

    @Test
    public void filterTwoColumnsCSV() {
        String column1 = "Regiao";
        String column2 = "Cidade";
        String value1 = "Centro Oeste";
        String value2 = "Padre Bernardo";

        ContextFactory contextFactory = new FileDataContextFactory(new CSVDataContextFactory(csvCities));

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

    private FileDataContextFactory makeCSVFileContextFactory() {
        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(csvCities);
        return new FileDataContextFactory(csvDataContextFactory);
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
            assertThat(((Number) map.get(columnName)).intValue(), greaterThan(value));
        }
    }

    private void testOneColumnFilterLessThan(ContextFactory contextFactory, String columnName, int value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.LESS_THAN, new QueryFilterValue<Integer>(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat(((Number) map.get(columnName)).intValue(), lessThan(value));
        }
    }

    private void testOneColumnFilterGreaterThanOrEqualTo(ContextFactory contextFactory, String columnName, int value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.GREATER_THAN_EQUAL, new QueryFilterValue(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat(((Number) map.get(columnName)).intValue(), greaterThanOrEqualTo(value));
        }
    }

    private void testOneColumnFilterLessThanOrEqualTo(ContextFactory contextFactory, String columnName, int value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.LESS_THAN_EQUAL, new QueryFilterValue(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat(((Number) map.get(columnName)).intValue(), lessThanOrEqualTo(value));
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
            in.add(is(value));
        }

        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.IN, new QueryFilterValue(Arrays.asList(values)));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat(
                    (Object) map.get(columnName),
                    anyOf((Iterable<Matcher<Object>>) in)
            );
        }
    }

}
