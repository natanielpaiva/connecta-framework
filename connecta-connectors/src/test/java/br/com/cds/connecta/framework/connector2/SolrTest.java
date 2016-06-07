package br.com.cds.connecta.framework.connector2;

import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import br.com.cds.connecta.framework.connector2.context.solr.SolrDataContextFactoty;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasToString;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Diego Rego <diego.rego@cds.com.br>
 */

public class SolrTest {

    private final FusionClient client = new FusionClient();
    
    private final String address  = "http://167.114.116.94:7004/solr/comercial/";
   // private final String query = "((+JOBID:901) AND (+SENTIMENT:positive) AND (+FRIENDS:0))";
    private final String query = "SENTIMENT: positive, TYPE: photo, COLLECTOR_USERNAME: politica, NETWORK: FACEBOOK, SHARED: 10";
    private final int facet =  5;

    @Test
    @Ignore
    public void columnsSorl() {
        
        SolrDataContextFactoty solrDataContextFactoty = new SolrDataContextFactoty(address, query, facet);
        QueryBuilder query = new QueryBuilder();
        Request request = new Request(solrDataContextFactoty, query);

        List<ConnectorColumn> columns = client.getColumns(request);
        PrintResult.printColumns(columns);

        assertThat(columns.get(0).getName(), hasToString("SHARED"));
        assertThat(columns.get(0).getLabel(), hasToString("SHARED"));
        assertThat(columns.get(0).getFormula(), hasToString("SHARED"));
        assertThat(columns.get(0).getType(), hasToString("INTEGER"));

        assertThat(columns.get(1).getName(), hasToString("COLLECTOR_USERNAME"));
        assertThat(columns.get(1).getLabel(), hasToString("COLLECTOR_USERNAME"));
        assertThat(columns.get(1).getFormula(), hasToString("COLLECTOR_USERNAME"));
        assertThat(columns.get(1).getType(), hasToString("VARCHAR"));
        
        assertThat(columns.get(2).getName(), hasToString("ARCHIVED"));
        assertThat(columns.get(2).getLabel(), hasToString("ARCHIVED"));
        assertThat(columns.get(2).getFormula(), hasToString("ARCHIVED"));
        assertThat(columns.get(2).getType(), hasToString("INTEGER"));

    }

    @Test
    @Ignore
    public void allResultSolr() {
      SolrDataContextFactoty solrDataContextFactoty = new SolrDataContextFactoty(address, query, facet);
        QueryBuilder query = new QueryBuilder();
        Request request = new Request(solrDataContextFactoty, query);

        List<Map<String, Object>> all = client.getAll(request);
        assertThat(all, hasSize(greaterThan(0)));
    }
    
    @Test
    @Ignore
    public void conditionsSolr() {
      SolrDataContextFactoty solrDataContextFactoty = new SolrDataContextFactoty(address);
      solrDataContextFactoty.getConditionsSolr();

    }
}
