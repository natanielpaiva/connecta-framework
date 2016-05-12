package br.com.cds.connecta.framework.connector.csv;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.cds.connecta.framework.connector.util.ConnectorColumn;
import br.com.cds.connecta.framework.connector.util.PrintResult;

/**
 *
 * @author diego
 */
public class Csv {
	
	private static final Logger log = LoggerFactory.getLogger(Csv.class);
    
    private DataContext dataContext;
    
    public List<Map<String, Object>> getResult(String csv, char separator, char quote){
        
        InputStream stream = new ByteArrayInputStream(csv.getBytes(StandardCharsets.UTF_8));

        dataContext = DataContextFactory.createCsvDataContext(stream, separator, quote);
        Schema schema = dataContext.getDefaultSchema();

        Table[] tables = schema.getTables();
        Table table = tables[0];

        Column[] columns = table.getColumns();

        DataSet dataSet = dataContext.query().from(table).selectAll().execute();

        List<Map<String, Object>> obj = new ArrayList<>();
        
        for (Row row : dataSet) {
            Object[] values = row.getValues();

            Map<String, Object> object = new LinkedHashMap<>(columns.length);
            for (int i = 0; i < values.length; i++) {

                String value;
                try {
                	value = values[i].toString();
                } catch (NullPointerException e) {
                	log.error("error", e);
                    value = null;
                }

                object.put(columns[i].getName(), value);
                log.info("**" + columns[i].getName() + " --> " + value);
            }
            obj.add(object);

        }
        PrintResult printResult = new PrintResult();
        printResult.print(obj);
        
        return obj;
    }
    
    public List<Map<String, Object>> getResult(String csv, char separator, char quote, List<ConnectorColumn> connectorColumn){
        
        InputStream stream = new ByteArrayInputStream(csv.getBytes(StandardCharsets.UTF_8));

        dataContext = DataContextFactory.createCsvDataContext(stream, separator, quote);
        Schema schema = dataContext.getDefaultSchema();

        Table[] tables = schema.getTables();
        Table table = tables[0];
        
        String[] columns =  new String[connectorColumn.size()];
        
        for (int i = 0; i < connectorColumn.size(); i++) {
           columns[i] =  connectorColumn.get(i).getName();
        }

        DataSet dataSet = dataContext.query().from(table).select(columns).execute();
        
        List<Map<String, Object>> obj = new ArrayList<>();
        
        String regex = "\\d+,\\d+";
        Pattern pattern = Pattern.compile(regex);
        
        for (Row row : dataSet) {
            Object[] values = row.getValues();
            
            Map<String, Object> object = new LinkedHashMap<>(connectorColumn.size());
            for (int i = 0; i < values.length; i++) {

                String value;
                try {
                    value = values[i].toString();
                    
                	if(pattern.matcher(value).matches()){
                		value = value.replace(",", ".");
                	}
                } catch (NullPointerException e) {
                	log.error("error", e);
                    value = null;
                }

                object.put(connectorColumn.get(i).getLabel(), value);
                log.info("**" + connectorColumn.get(i).getLabel() + " --> " + value);

            }
            obj.add(object);

        }
        PrintResult printResult = new PrintResult();
        printResult.print(obj);
        
        return obj;
    }
    
}
