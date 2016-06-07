package br.com.cds.connecta.framework.connector2;

import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.context.file.FileDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.csv.CSVDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.solr.SolrDataContextFactoty;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import br.com.cds.connecta.framework.connector2.query.QueryFilterOperator;
import br.com.cds.connecta.framework.connector2.query.QueryFilterValue;
import br.com.cds.connecta.framework.connector2.query.QueryFilterValueBetween;
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
import static org.hamcrest.Matchers.hasToString;
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
public class SolrFilterTest {

    private final FusionClient client = new FusionClient();

    private final Logger logger = Logger.getLogger(CsvFilterTest.class);

    private final String address = "http://167.114.116.94:7004/solr/comercial/";
    // private final String query = "((+JOBID:901) AND (+SENTIMENT:positive) AND (+FRIENDS:0))";
    private final String query = "SENTIMENT: positive, TYPE: photo, COLLECTOR_USERNAME: politica, NETWORK: FACEBOOK, SHARED: 10";
    private final int facet = 10;

    @Test
    public void listPossibleValuesForFilterWithoutPreviousFiltersSolr() {

        String columnName = "COLLECTOR_USERNAME";

        SolrDataContextFactoty solrDataContextFactoty = new SolrDataContextFactoty(address, query, facet);
        QueryBuilder query = new QueryBuilder();
        Request request = new Request(solrDataContextFactoty, query);

        List<Object> all = client.possibleValuesFor(request, solrDataContextFactoty.getColumn(columnName));

        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.size(), is(5));

        for (Object possibleValue : all) {
            logger.info("VALUE: " + possibleValue);
            assertThat((String) possibleValue, anyOf(
                    is("politica"),
                    is("caixa"),
                    is("CDS"),
                    is("loteria"),
                    is("copbh")
            ));
        }
    }
    
    @Test
    public void listPossibleValuesForFilterWithPreviousFiltersCSV() {
        String columnName = "SENTIMENT";
        SolrDataContextFactoty solrDataContextFactoty = new SolrDataContextFactoty(address, query, facet);

        Column column = solrDataContextFactoty.getColumn(columnName);

        QueryBuilder queryContext = new QueryBuilder()
                .addFilter(column, QueryFilterOperator.EQUAL, new QueryFilterValue("neutral"));

        Request request = new Request(solrDataContextFactoty, queryContext);

        List<Object> all = client.possibleValuesFor(request, solrDataContextFactoty.getColumn("COLLECTOR_USERNAME"));

        assertThat(all, hasSize(greaterThan(0)));

        for (Object possibleValue : all) {
             logger.info("VALUE: " + possibleValue);
            assertThat((String) possibleValue,
                    anyOf(
                            is("caixa"),
                            is("CDS")
                    ));
        }
    }
    
    @Test
    public void filterOneColumnCsv() {

       // testOneColumnFilterEqual(new SolrDataContextFactoty(address, query, facet), "SENTIMENT", "positive");
       // testOneColumnFilterNotEqual(new SolrDataContextFactoty(address, query, facet), "SENTIMENT", "negative");
      //  testOneColumnFilterGreaterThan(new SolrDataContextFactoty(address, query, facet), "JOBRESULTID", 78938);
      //  testOneColumnFilterLessThan(new SolrDataContextFactoty(address, query, facet), "JOBRESULTID", 78938);
      //  testOneColumnFilterGreaterThanOrEqualTo(new SolrDataContextFactoty(address, query, facet), "JOBRESULTID", 78938);
        testOneColumnFilterLessThanOrEqualTo(new SolrDataContextFactoty(address, query, facet), "JOBRESULTID", 78938);
//        testOneColumnFilterBetween(new SolrDataContextFactoty(address, query, facet), "vendas", 2, 9);
//        testOneColumnFilterIn(new SolrDataContextFactoty(address, query, facet), "vendas", new Integer[]{2, 5});
//        testOneColumnFilterContains(new SolrDataContextFactoty(address, query, facet), "Cidade", "Aurora");
//        testOneColumnFilterStartsWith(new SolrDataContextFactoty(address, query, facet), "Regiao", "Nort");
//        testOneColumnFilterEndsWith(new SolrDataContextFactoty(address, query, facet), "UF", "I");
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
