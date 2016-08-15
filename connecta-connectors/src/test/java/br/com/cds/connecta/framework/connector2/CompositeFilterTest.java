package br.com.cds.connecta.framework.connector2;

import static br.com.cds.connecta.framework.connector2.TestUtil.getFile;
import br.com.cds.connecta.framework.connector2.common.CompositeJoin;
import br.com.cds.connecta.framework.connector2.context.composite.CompositeDataContextFactory;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.context.file.FileDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.csv.CSVDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.json.JsonDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.xml.XMLDataContextFactory;
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
import org.apache.metamodel.query.JoinType;
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
import static org.hamcrest.Matchers.startsWith;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author diego
 */
@Ignore
public class CompositeFilterTest {

    private final FusionClient client = new FusionClient();

    private final Logger logger = Logger.getLogger(CompositeTest.class);

//    @Test
//    public void joinTwoContext() {
//
//        ContextFactory contextStringCsv = contextCsv();
//        ContextFactory contextFileJson = contextFileJson();
//        ContextFactory contextXml = contextXml();
//        
//        List<CompositeJoin> list = new ArrayList<>();
//        list.add(new CompositeJoin(contextStringCsv, "idCargo", "csv", JoinType.LEFT));
//        list.add(new CompositeJoin(contextFileJson, "idCargo", "json", JoinType.LEFT));
//        list.add(new CompositeJoin(contextXml, "csv.departamento", "join", JoinType.LEFT));
//        
//        //CompositeDataContextFactory compositeDataContextFactory = new CompositeDataContextFactory(list);
//        
//        QueryBuilder queryContext = new QueryBuilder();
//        Request request = new Request(compositeDataContextFactory, queryContext);
//        List<Map<String, Object>> all = client.getAll(request);
//        PrintResult.printMap(all);
//    }
    
    
    @Test
    public void listPossibleValuesForFilterWithoutPreviousFiltersCSVWithJson() {

        ContextFactory contextStringCsv = contextCsv();
        ContextFactory contextFileJson = contextFileJson();
        //ContextFactory contextXml = contextXml();
        ContextFactory compositeContext = new CompositeDataContextFactory(
                contextStringCsv, "idCargo", "csv",
                JoinType.INNER,
                contextFileJson, "idCargo", "json");

        QueryBuilder queryContext = new QueryBuilder();
        Request request = new Request(compositeContext, queryContext);
        List<Object> all = client.possibleValuesFor(request, compositeContext.getColumn("csv.nome"));

        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.size(), is(7));
        for (Object possibleValue : all) {
            logger.info("VALUE: " + possibleValue);
            assertThat((String) possibleValue, anyOf(
                    is("Diego"),
                    is("Natan"),
                    is("Vinicius"),
                    is("Anais"),
                    is("Rizia"),
                    is("Eduardo"),
                    is("Cleto")
            ));
        }
    }

    @Test
    public void listPossibleValuesForFilterWithPreviousFiltersCSVWithJson() {

        ContextFactory contextCsv = contextCsv();
        ContextFactory contexJson = contextFileJson();

        ContextFactory compositeContext = new CompositeDataContextFactory(
                contextCsv, "idCargo", "csv",
                JoinType.INNER,
                contexJson, "idCargo", "json");

        QueryBuilder queryContext = new QueryBuilder();
        queryContext.addFilter(compositeContext.getColumn("json.ativo"), QueryFilterOperator.NOT_EQUAL, new QueryFilterValue("N"));

        Column column = compositeContext.getColumn("csv.nome");

        Request request = new Request(compositeContext, queryContext);

        List<Object> possibleValuesFor = client.possibleValuesFor(request, column);

        assertThat(possibleValuesFor, hasSize(greaterThan(0)));
        assertThat(possibleValuesFor.size(), is(4));
        for (Object possibleValue : possibleValuesFor) {
            logger.info("VALUE: " + possibleValue);
            assertThat((String) possibleValue, anyOf(
                    is("Natan"),
                    is("Vinicius"),
                    is("Anais"),
                    is("Rizia")
            ));
        }
    }

    private ContextFactory contextCsv() {
        File csvFile = getFile("test/data/csv/csv_funcionario.csv");
        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(csvFile);
        return new FileDataContextFactory(csvDataContextFactory);
    }

    private ContextFactory contextXml() {
        File xlsFile = getFile("test/data/xml/xml_departamento.xml");
        XMLDataContextFactory xmlDataContextFactory = new XMLDataContextFactory(
                xlsFile,
                "/departamentos/departamento",
                new String[]{
                    "/departamentos/departamento@id",
                    "/departamentos/departamento/nome"
                });

                FileDataContextFactory fileDataContextFactory = new FileDataContextFactory(xmlDataContextFactory);
        
        List<ConnectorColumn> columns = fileDataContextFactory.getColumns();
        PrintResult.printColumns(columns);

        QueryBuilder query = new QueryBuilder();

        Request request = new Request(fileDataContextFactory, query);
        List<Map<String, Object>> all = client.getAll(request);
        PrintResult.printMap(all);
        return new FileDataContextFactory(xmlDataContextFactory);
    }

    
    private ContextFactory contextFileJson() {
        File jsonFile = getFile("test/data/json/json_cargos.json");
        JsonDataContextFactory jsonDataContextFactory = new JsonDataContextFactory(jsonFile);

        FileDataContextFactory fileDataContextFactory = new FileDataContextFactory(jsonDataContextFactory);

        List<ConnectorColumn> columns = fileDataContextFactory.getColumns();
        PrintResult.printColumns(columns);

        QueryBuilder query = new QueryBuilder();

        Request request = new Request(fileDataContextFactory, query);
        List<Map<String, Object>> all = client.getAll(request);
        PrintResult.printMap(all);
        return new FileDataContextFactory(jsonDataContextFactory);
    }

    @Test
    public void filterOneColumnCsv() {

        ContextFactory compositeContext = new CompositeDataContextFactory(
                contextCsv(), "idCargo", "csv",
                JoinType.INNER,
                contextFileJson(), "idCargo", "json");

        testOneColumnFilterEqual(compositeContext, "csv.nome", "Diego");
        testOneColumnFilterNotEqual(compositeContext, "json.idCargo", 1);
        testOneColumnFilterGreaterThan(compositeContext, "json.salario", 5000);
        testOneColumnFilterLessThan(compositeContext, "json.salario", 5000);
        testOneColumnFilterGreaterThanOrEqualTo(compositeContext, "json.salario", 5000);
        testOneColumnFilterLessThanOrEqualTo(compositeContext, "json.salario", 5000);
        testOneColumnFilterBetween(compositeContext, "json.salario", 3000, 5000);
        testOneColumnFilterIn(compositeContext, "csv.idFuncionario", new Integer[]{1, 5});
        testOneColumnFilterContains(compositeContext, "json.cargo", "Programador");
        testOneColumnFilterStartsWith(compositeContext, "csv.nome", "D");
        testOneColumnFilterEndsWith(compositeContext, "csv.nome", "o");
    }

    private void testOneColumnFilterEqual(ContextFactory contextFactory, String columnName, String value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.EQUAL, new QueryFilterValue(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat((String) map.get(columnName), is(value));
        }
    }
    
    @Test
    public void filterTwoColumnsCSV() {
        String column1 = "json.ativo";
        String column2 = "json.salario";
        String value1 = "S";
        int value2 = 5000;

        ContextFactory compositeContext = new CompositeDataContextFactory(
                contextCsv(), "idCargo", "csv",
                JoinType.INNER,
                contextFileJson(), "idCargo", "json");

        List<Map<String, Object>> all;

        all = getResultTwoColumnsFilter(compositeContext,
                column1, QueryFilterOperator.EQUAL, new QueryFilterValue(value1),
                column2, QueryFilterOperator.EQUAL, new QueryFilterValue(value2));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(column1));
            assertThat((String) map.get(column1), is(value1));
            assertThat(map, hasKey(column2));
            assertThat((int) map.get(column2), is(value2));
        }
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

    private void testOneColumnFilterNotEqual(ContextFactory contextFactory, String columnName, int value) {
        List<Map<String, Object>> all = getResultOneColumnFilter(contextFactory, columnName, QueryFilterOperator.NOT_EQUAL, new QueryFilterValue(value));

        for (Map<String, Object> map : all) {
            assertThat(map, hasKey(columnName));
            assertThat((int) map.get(columnName), not(is(value)));
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

}

