package br.com.cds.connecta.framework.connector2.context.http;

import br.com.cds.connecta.framework.connector2.common.Base;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Table;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author diego
 */
public class HttpDataContextFactory extends Base implements ContextFactory {

    public HttpResponse executeHttp(String url, HttpMethod verb, List<Header> headers, String body) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = null;
         List<Header> responseHeaders = new ArrayList<>();
        HttpResponse httpResponse = new HttpResponse();
        try {
            response = restTemplate.exchange(url, verb, factoryBodyHttp(headers, body), String.class);
            httpResponse.setBody(response.getBody());

           
            Set<Map.Entry<String, List<String>>> entrySet = response.getHeaders().entrySet();
            for (Iterator<Map.Entry<String, List<String>>> iterator1 = entrySet.iterator(); iterator1.hasNext();) {
                Map.Entry<String, List<String>> next = iterator1.next();
                Header header = new Header();
                header.setKey(next.getKey());
                header.setValue(next.getValue().toString());
                responseHeaders.add(header);
            }
            httpResponse.setHeaders(responseHeaders);
            httpResponse.setStatusCode(response.getStatusCode().name());

        } catch (HttpClientErrorException e) {
            System.out.println("--- " + e.getMessage());
            httpResponse.setBody(e.getMessage());
            
            Set<Map.Entry<String, List<String>>> entrySet = e.getResponseHeaders().entrySet();
            
            for (Iterator<Map.Entry<String, List<String>>> iterator1 = entrySet.iterator(); iterator1.hasNext();) {
                Map.Entry<String, List<String>> next = iterator1.next();
                Header header = new Header();
                header.setKey(next.getKey());
                header.setValue(next.getValue().toString());
                responseHeaders.add(header);
            }
            httpResponse.setHeaders(responseHeaders);
            httpResponse.setStatusCode( e.getStatusCode().toString());
        }

        return httpResponse;
    }

    private HttpEntity<String> factoryBodyHttp(List<Header> headers, String body) {

        HttpHeaders HttpHeader = new HttpHeaders();
        if (!headers.isEmpty()) {
            for (Header header : headers) {
                if(header.getKey() != null && header.getValue() != null)
                HttpHeader.set(header.getKey(), header.getValue());
            }
        }

        return new HttpEntity<>(body, HttpHeader);

    }

    @Override
    public DataSet getResultAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConnectorColumn> getColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Table getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Column getColumn(String columnName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getSchemas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getTables() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
