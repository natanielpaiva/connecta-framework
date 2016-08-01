package br.com.cds.connecta.framework.connector2;

import static br.com.cds.connecta.framework.connector2.TestUtil.getFile;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.context.file.FileDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.excel.ExcelDataContextFactory;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
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
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.startsWith;
import org.junit.Test;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
public class ExcelFiterText {

    private final Logger logger = Logger.getLogger(ExcelTest.class);
    private final FusionClient client = new FusionClient();

    private static final File formulaXlsx = getFile("test/data/excel/formulas.xlsx");
    private static final File formulaXls = getFile("test/data/excel/xls_formulas.xls");

    @Test
    public void listPossibleValuesForFilterWithoutPreviousFiltersXlsx() {
        String columnName = "Bar";

        ExcelDataContextFactory dataContext = new ExcelDataContextFactory(formulaXlsx);
        FileDataContextFactory fileDataContextFactory = new FileDataContextFactory(dataContext);

        QueryBuilder queryContext = new QueryBuilder();

        Request request = new Request(fileDataContextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, fileDataContextFactory.getColumn(columnName));

        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.size(), is(13));

        for (Object possibleValue : all) {
            logger.info("VALUE: " + possibleValue);
            assertThat((String) possibleValue, anyOf(
                    is("#DIV/0!"),
                    is("here are"),
                    is("baz"),
                    is("lorem"),
                    is("21"),
                    is("foo"),
                    is("ipsum"),
                    is("0"),
                    is("formulas:"),
                    is("bar"),
                    is("!\"#¤%&/()<>=?"),
                    is("some invalid"),
                    nullValue()
            ));
        }
    }

    @Test
    public void listPossibleValuesForFilterWithoutPreviousFiltersXls() {
        String columnName = "some mixed formula";

        ExcelDataContextFactory dataContext = new ExcelDataContextFactory(formulaXls);

        FileDataContextFactory fileDataContextFactory = new FileDataContextFactory(dataContext);

        QueryBuilder queryContext = new QueryBuilder();

        Request request = new Request(fileDataContextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, fileDataContextFactory.getColumn(columnName));

        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.size(), is(6));

        for (Object possibleValue : all) {
            logger.info("VALUE: " + possibleValue);
            assertThat((String) possibleValue, anyOf(
                    is("1"),
                    is("3"),
                    is("8"),
                    is("12"),
                    is("yes"),
                    is("no")
            ));
        }
    }

    @Test
    public void listPossibleValuesForFilterWithPreviousFiltersXlsx() {
        String value = "6";
        String columnCompared = "Foo";
        String columnPresentation = "Bar";
        ExcelDataContextFactory dataContext = new ExcelDataContextFactory(formulaXlsx);
        FileDataContextFactory contextFactory = new FileDataContextFactory(dataContext);

        Column column = contextFactory.getColumn(columnCompared);

        QueryBuilder queryContext = new QueryBuilder()
                .addFilter(column, QueryFilterOperator.LESS_THAN, new QueryFilterValue(value));

        Request request = new Request(contextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, contextFactory.getColumn(columnPresentation));

        assertThat(all, hasSize(greaterThan(0)));

        for (Object possibleValue : all) {
            assertThat((String) possibleValue,
                    anyOf(
                            is("lorem"),
                            is("21"),
                            is("foo"),
                            is("ipsum"),
                            is("bar")
                    ));
        }
    }

    @Test
    public void listPossibleValuesForFilterWithPreviousFiltersXls() {
        String value = "5";
        String columnCompared = "some number";
        String columnPresentation = "some mixed formula";
        ExcelDataContextFactory dataContext = new ExcelDataContextFactory(formulaXls);
        FileDataContextFactory contextFactory = new FileDataContextFactory(dataContext);

        Column column = contextFactory.getColumn(columnCompared);

        QueryBuilder queryContext = new QueryBuilder()
                .addFilter(column, QueryFilterOperator.GREATER_THAN_EQUAL, new QueryFilterValue(value));

        Request request = new Request(contextFactory, queryContext);

        List<Object> all = client.possibleValuesFor(request, contextFactory.getColumn(columnPresentation));

        assertThat(all, hasSize(greaterThan(0)));

        for (Object possibleValue : all) {
            assertThat((String) possibleValue,
                    anyOf(
                            is("yes"),
                            is("no")
                    ));
        }
    }

    @Test
    public void filterOneColumnXlsx() {
        testOneColumnFilterEqual(new FileDataContextFactory(new ExcelDataContextFactory(formulaXlsx)), "Foo", 2);
        testOneColumnFilterNotEqual(new FileDataContextFactory(new ExcelDataContextFactory(formulaXlsx)), "Bar", "lorem");
        testOneColumnFilterGreaterThan(new FileDataContextFactory(new ExcelDataContextFactory(formulaXlsx)), "Foo", 5);
        testOneColumnFilterLessThan(new FileDataContextFactory(new ExcelDataContextFactory(formulaXlsx)), "Foo", 12);
        testOneColumnFilterGreaterThanOrEqualTo(new FileDataContextFactory(new ExcelDataContextFactory(formulaXlsx)), "Foo", 10);
        testOneColumnFilterLessThanOrEqualTo(new FileDataContextFactory(new ExcelDataContextFactory(formulaXlsx)), "Foo", 9);
        testOneColumnFilterBetween(new FileDataContextFactory(new ExcelDataContextFactory(formulaXlsx)), "Foo", 5, 9);
        testOneColumnFilterIn(new FileDataContextFactory(new ExcelDataContextFactory(formulaXlsx)), "Foo", new Integer[]{8, 9, 1, 2});
        testOneColumnFilterContains(new FileDataContextFactory(new ExcelDataContextFactory(formulaXlsx)), "Bar", "e");
        testOneColumnFilterStartsWith(new FileDataContextFactory(new ExcelDataContextFactory(formulaXlsx)), "Bar", "ba");
        testOneColumnFilterEndsWith(new FileDataContextFactory(new ExcelDataContextFactory(formulaXlsx)), "Bar", "m");
    }

    @Test
    public void filterOneColumnXls() {
        testOneColumnFilterEqual(new FileDataContextFactory(new ExcelDataContextFactory(formulaXls)), "some mixed formula", "12");
        testOneColumnFilterNotEqual(new FileDataContextFactory(new ExcelDataContextFactory(formulaXls)), "some mixed formula", "no");
        testOneColumnFilterGreaterThan(new FileDataContextFactory(new ExcelDataContextFactory(formulaXls)), "some int only formula", 6);
        testOneColumnFilterLessThan(new FileDataContextFactory(new ExcelDataContextFactory(formulaXls)), "some int only formula", 6);
        testOneColumnFilterGreaterThanOrEqualTo(new FileDataContextFactory(new ExcelDataContextFactory(formulaXls)), "some int only formula", 6);
        testOneColumnFilterLessThanOrEqualTo(new FileDataContextFactory(new ExcelDataContextFactory(formulaXls)), "some int only formula", 6);
        testOneColumnFilterBetween(new FileDataContextFactory(new ExcelDataContextFactory(formulaXls)), "some int only formula", 5, 9);
        testOneColumnFilterIn(new FileDataContextFactory(new ExcelDataContextFactory(formulaXls)), "some mixed formula", new Object[]{"1", "3", "8", "12"});
        testOneColumnFilterContains(new FileDataContextFactory(new ExcelDataContextFactory(formulaXls)), "some mixed formula", "e");
        testOneColumnFilterStartsWith(new FileDataContextFactory(new ExcelDataContextFactory(formulaXls)), "some mixed formula", "y");
        testOneColumnFilterEndsWith(new FileDataContextFactory(new ExcelDataContextFactory(formulaXls)), "some mixed formula", "o");
    }

    @Test
    public void filterTwoColumnsCSV() {
        String column1 = "some mixed formula";
        String value1 = "yes";

        String column2 = "some int only formula";
        Object value2 = 5;

        ContextFactory contextFactory = new FileDataContextFactory(new ExcelDataContextFactory(formulaXls));

        List<Map<String, Object>> all;

        all = getResultTwoColumnsFilter(contextFactory,
                column1, QueryFilterOperator.EQUAL, new QueryFilterValue(value1),
                column2, QueryFilterOperator.EQUAL, new QueryFilterValue(value2));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(column1));
            assertThat((String) map.get(column1), is(value1));
            assertThat(map, hasKey(column2));
            assertThat((Integer) map.get(column2), is(value2));
        }
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

    private void testOneColumnFilterEqual(ContextFactory contextFactory, String columnName, int value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.EQUAL, new QueryFilterValue(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat((int) map.get(columnName), is(value));
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
        Collection<Matcher<? super Object>> in = new ArrayList<>(values.length);
        for (Object value : values) {
            in.add(is(value));
        }

        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.IN, new QueryFilterValue(Arrays.asList(values)));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat(
                    (Object) map.get(columnName),
                    anyOf((Iterable<Matcher<? super Object>>) in)
            );
        }
    }

}
