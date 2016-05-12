package br.com.cds.connecta.framework.connector.util;

import br.com.cds.connecta.framework.connector.solr.Solr;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.solr.client.solrj.SolrServerException;

/**
 *
 * @author diego
 */
public class PrintResult {

    public static void main(String[] args) throws SolrServerException, IOException {
        Solr sorl = new Solr();
        sorl.searchSorl(
                "http://167.114.116.94:9002/solr/comercial",
                "((+JOBID:1201) AND (+SENTIMENT:neutral) AND (+FRIENDS:0))", 12);
    }

    public void print(List<Map<String, Object>> result) {
        System.out.println("\n");
        Set<String> columns = result.get(0).keySet();
        String parametros = "";

        for (int i = 0; i < columns.size(); i++) {
            parametros += "%-30s";
            System.out.print("+----------------------------");
        }

        System.out.println("\r");
        System.out.printf(parametros, columns.toArray());
        System.out.println("\r");;
        for (Map<String, Object> result1 : result) {

            String value = "";
            for (String column : columns) {
                String format = String.format("%.20s", "|" + result1.get(column));

                value += value.format("%-30s", format);
            }

            System.out.println(value);
        }
    }

}
