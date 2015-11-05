package br.com.cds.connecta.framework.connector.solr;

import br.com.cds.connecta.framework.connector.util.ConnectorColumn;
import br.com.cds.connecta.framework.connector.util.PrintResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.LukeRequest;
import org.apache.solr.client.solrj.response.LukeResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

/**
 *
 * @author diego
 */
public class Solr {

    public List<ConnectorColumn> getColumns(String address) {
        HttpSolrClient solr = new HttpSolrClient(address);

        ArrayList<ConnectorColumn> columns = new ArrayList<>();

        LukeRequest lukeRequest = new LukeRequest();
        lukeRequest.setNumTerms(0);
        LukeResponse lukeResponse;

        try {
            lukeResponse = lukeRequest.process(solr);

            List<LukeResponse.FieldInfo> sorted = new ArrayList<LukeResponse.FieldInfo>(lukeResponse.getFieldInfo().values());

            for (LukeResponse.FieldInfo infoEntry : sorted) {

                ConnectorColumn column = new ConnectorColumn();

                column.setLabel(infoEntry.getName());
                column.setName(infoEntry.getName());
                column.setFormula(infoEntry.getName());
                column.setType(infoEntry.getType());

                columns.add(column);
            }

        } catch (SolrServerException ex) {
            Logger.getLogger(Solr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Solr.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columns;
    }

    public List<Map<String, Object>> searchSorl(String address, String query, int facet) throws SolrServerException, IOException {

        HttpSolrClient solr = new HttpSolrClient(address);

        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery(query);
        solrQuery.setRows(facet);

        QueryResponse response = solr.query(solrQuery);
        
        SolrDocumentList data = response.getResults();

        List<Map<String, Object>> result = new ArrayList<>();

        for (SolrDocument document : data) {
            Map<String, Object> object = new HashMap<>();
            for (Map.Entry<String, Object> row : document) {
                object.put(row.getKey(), row.getValue());
            }
            result.add(object);
        }
        PrintResult printResult = new PrintResult();
       //printResult.print(result);
        return result;

    }
    
     public static void main(String[] args) throws SolrServerException, IOException {
        Solr sorl = new Solr();
        sorl.searchSorl(
                "http://connecta.cds.com.br/solr/comercial",
                "((+JOBID:1201) AND (+SENTIMENT:neutral) AND (+FRIENDS:0))" , 50);
    }
}
