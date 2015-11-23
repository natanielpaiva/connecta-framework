package br.com.cds.connecta.framework.connector.csv;

import br.com.cds.connecta.framework.connector.util.ConnectorColumn;
import br.com.cds.connecta.framework.connector.util.PrintResult;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.SelectItem;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;

/**
 *
 * @author diego
 */
public class Csv {
    
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

            Map<String, Object> object = new HashMap<>(columns.length);
            for (int i = 0; i < values.length; i++) {

                String value;
                try {
                    value = values[i].toString();
                } catch (NullPointerException e) {
                    value = null;
                }

                object.put(columns[i].getName(), value);
                System.out.println("**" + columns[i].getName() + " --> " + value);

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
        
        for (Row row : dataSet) {
            Object[] values = row.getValues();
            SelectItem[] selectItems = row.getSelectItems();
            
            Map<String, Object> object = new HashMap<>(connectorColumn.size());
            for (int i = 0; i < values.length; i++) {

                String value;
                try {
                    value = values[i].toString();
                } catch (NullPointerException e) {
                    value = null;
                }

                object.put(connectorColumn.get(i).getLabel(), value);
                System.out.println("**" + connectorColumn.get(i).getLabel() + " --> " + value);

            }
            obj.add(object);

        }
        PrintResult printResult = new PrintResult();
        printResult.print(obj);
        
        return obj;
    }
    
    
//    public static void main(String args[]) throws IOException {
//
//        List<ConnectorColumn> columnsColumn = new ArrayList<>();
//        ConnectorColumn connectorColumn1 = new ConnectorColumn();
//        ConnectorColumn connectorColumn2 = new ConnectorColumn();
//
//        connectorColumn1.setId((long) 14452);
//        connectorColumn1.setName("User Name");
//        connectorColumn1.setLabel("/Codigo");
//        connectorColumn1.setFormula("/soap:Envelope/soap:Body/CalcPrazoResponse/CalcPrazoResult/Servicos/cServico/Codigo");
//
//        columnsColumn.add(connectorColumn1);
//
//        connectorColumn2.setId((long) 14450);
//        connectorColumn2.setName("First Name");
//        connectorColumn2.setLabel("/PrazoEntrega");
//        connectorColumn2.setFormula("/soap:Envelope/soap:Body/CalcPrazoResponse/CalcPrazoResult/Servicos/cServico/PrazoEntrega");
//
//        columnsColumn.add(connectorColumn2);
//        
//        
//        String csv = "User Name,First Name,Last Name,Display Name,Job Title,Department,Office Number,Office Phone,Mobile Phone,Fax,Address,City,State or Province,ZIP or Postal Code,Country or Region\n"
//                + "chris@contoso.com,Chris,Green,Chris Green,IT Manager,Information Technology,123451,123-555-1211,123-555-6641,123-555-9821,1 Microsoft way,Redmond,Wa,98052,United States\n"
//                + "ben@contoso.com,Ben,Andrews,Ben Andrews,IT Manager,Information Technology,123452,123-555-1212,123-555-6642,123-555-9822,1 Microsoft way,Redmond,Wa,98052,United States\n"
//                + "david@contoso.com,David,Longmuir,David Longmuir,IT Manager,Information Technology,123453,123-555-1213,123-555-6643,123-555-9823,1 Microsoft way,Redmond,Wa,98052,United States\n"
//                + "cynthia@contoso.com,Cynthia,Carey,Cynthia Carey,IT Manager,Information Technology,123454,123-555-1214,123-555-6644,123-555-9824,1 Microsoft way,Redmond,Wa,98052,United States\n"
//                + "melissa@contoso.com,Melissa,MacBeth,Melissa MacBeth,IT Manager,Information Technology,123455,123-555-1215,123-555-6645,123-555-9825,1 Microsoft way,Redmond,Wa,98052,United States";
//
//        char separatorChar = ',';
//        char quoteChar = '"';
//        
//        
//        Csv vai = new Csv();
//        vai.getResult(csv, separatorChar, quoteChar , columnsColumn);
//       
//    }

}
