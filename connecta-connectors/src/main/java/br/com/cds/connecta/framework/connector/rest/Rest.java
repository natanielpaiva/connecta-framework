package br.com.cds.connecta.framework.connector.rest;

import br.com.cds.connecta.framework.connector.util.ConnectorColumn;
import com.fasterxml.jackson.databind.JsonNode;
import com.jayway.jsonpath.JsonPath;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.json.JsonDataContext;
import org.apache.metamodel.util.UrlResource;
import org.apache.metamodel.schema.builder.SchemaBuilder;
import org.apache.metamodel.schema.builder.SimpleTableDefSchemaBuilder;
import org.apache.metamodel.util.InMemoryResource;
import org.apache.metamodel.util.Resource;
import org.apache.metamodel.util.SimpleTableDef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author diego
 */
public class Rest {

    private static final Logger log = LoggerFactory.getLogger(Rest.class);

    public Resource jsonResource(String json) {
        Resource resource = new InMemoryResource("json", json.getBytes(), 0);
        return resource;
    }

    public Resource jsonResource(URL json) {
        Resource resource = new UrlResource(json);
        return resource;
    }

    /**
     * Produz um resultado tabular
     * @param resource
     * @param columns
     * @return
     */
    public List<Map<String, Object>> factoryResultMetaModel(Resource resource, List<ConnectorColumn> columns) {

        String fields[] = new String[columns.size()];
        for (int i = 0; i < columns.size(); i++) {
                fields[i]= columns.get(i).getFormula();
            }
       
        
        final SimpleTableDef tableDef = new SimpleTableDef("mytable", fields);
        final SchemaBuilder schemaBuilder = new SimpleTableDefSchemaBuilder("myschema", tableDef);

        final JsonDataContext dataContext = new JsonDataContext(resource, schemaBuilder);


        final DataSet dataSet = dataContext.query().from("mytable").selectAll().execute();
        List<Map<String, Object>> Obj = new ArrayList<>();

        for (Row row : dataSet) {
            Object[] values = row.getValues();

            Map<String, Object> object = new HashMap<>(columns.size());
            for (int i = 0; i < values.length; i++) {

                String value;
                try {
                    value = values[i].toString();
                } catch (NullPointerException e) {
                    value = null;
                }

                object.put(columns.get(i).getLabel(), value);
                System.out.println("**" + columns.get(i).getLabel() + " --> " + value);
                
            }
            Obj.add(object);
        }
        return Obj;
    }

    /**
     * Extrair parte de um json
     * @param url
     * @param path
     * @return
     */
    public Object extractPartJson(String url, String path) {
        Object jsonPathResult = null;
        try {
            jsonPathResult = JsonPath.read(new URL(url), path);
            log.debug("Return" + jsonPathResult);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Rest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonPathResult;
    }

    /**
     * retorna o json
     *
     * @param url
     * @return
     */
    public Object getJson(String url) {
        RestTemplate restTemplate = new RestTemplate();
        log.debug("Endereco: " + url);
        Object quote = restTemplate.getForObject(url, JsonNode.class);
        log.debug("Resposta: " + quote.toString());
        return quote;
    }

    /**
     * retorna somente uma parte do json
     *
     * @param url
     * @param table
     * @return
     */
    public Object getPartJson(String url, String table) {
        Rest rest = new Rest();
        return rest.extractPartJson(url, table);
    }

    /**
     * Retona os dados no formato tabular aplicando o jsonPath da tabela refente
     * as colunas
     *
     * @param url
     * @param table
     * @param columns
     * @return
     */
    public List<Map<String, Object>> getResultTabular(String url, List<ConnectorColumn> columns, String table) {
        Rest rest = new Rest();
        Resource jsonResource = null;
        if (table != null) {
            Object partJson = rest.extractPartJson(url, table);
            jsonResource = rest.jsonResource(partJson.toString());
        } else {
            try {
                jsonResource = rest.jsonResource(new URL(url));
            } catch (MalformedURLException ex) {
                java.util.logging.Logger.getLogger(Rest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return rest.factoryResultMetaModel(jsonResource, columns);
    }

    /**
     * Retona os dados no formato tabular refetente as colunas
     *
     * @param url
     * @param columns
     * @return
     */
    public List<Map<String, Object>> getResult(String url, List<ConnectorColumn> columns) {
        try {
            Rest rest = new Rest();

            Resource jsonResource = rest.jsonResource(new URL(url));
            return rest.factoryResultMetaModel(jsonResource, columns);
        } catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(Rest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Retona os dados no formato tabular aplicando o jsonPath da tabela refente
     * as colunas
     *
     * @param url
     * @param table
     * @param columns
     * @return
     */
    public List<Map<String, Object>> getResult(String url, List<ConnectorColumn> columns, String table) {
        Rest rest = new Rest();
        Object partJson = rest.extractPartJson(url, table);
        Resource jsonResource = rest.jsonResource(partJson.toString());
        return rest.factoryResultMetaModel(jsonResource, columns);
    }
    
    
    
     public static void main(String args[]) throws IOException {
        Rest rest = new Rest();
        //ok
        rest.getPartJson("http://www.mocky.io/v2/55ba80a03b5df2e0082f1444", "$.store.book[*]");
        //rest.getPartJson("http://sabesp-api.herokuapp.com/", "[*].data[*]");

        
//        String[] columns = {"name","data.key" };
//        rest.getResult("http://sabesp-api.herokuapp.com/", columns, "[*]");
//        
        
        //ok
        //String[] columns = {"author", "category"};
        //rest.getResult("http://www.mocky.io/v2/55ba80a03b5df2e0082f1444", columns, "$.store.book[*]");

        //ok
//        String[] columns = {"store.book[0].author", "store.book[0].category"};
//        rest.getResult("http://www.mocky.io/v2/55ba80a03b5df2e0082f1444", columns);
//      ok        
//            String[] columns = {"name.first", "name.last",
//            "gender", "interests[0]", "interests[0].type", "interests[0].name"};
//        rest.getResult("http://www.mocky.io/v2/55ad27d2052573a60e262f4f", columns);
    }

     //
}
