
package br.com.cds.connecta.framework.connector2.test;

import br.com.cds.connecta.framework.connector.util.PrintResult;
import static br.com.cds.connecta.framework.connector2.test.CombinedAnalysis.TESTFOLDER;
import java.io.File;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.json.JsonDataContext;
import org.apache.metamodel.query.JoinType;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.query.SelectItem;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;
import org.apache.metamodel.xml.XmlSaxDataContext;
import org.apache.metamodel.xml.XmlSaxTableDef;

/**
 *
 * @author diego
 */
public class MassData {
    

     public static final String TESTFOLDER = "/testdata/";

    public static void main(String args[]) throws URISyntaxException {
        MassData analysis = new MassData();

        //CSV
        DataContext factoryCSV = analysis.factoryCSV();
        Table csvTable = factoryCSV.getDefaultSchema().getTables()[0];
         //String[] columnNames = csvTable.getColumnNames();
//         for (String columnName : columnNames) {
//             System.out.println(columnName);
//        }
         
        Column csvIdUsuario = csvTable.getColumnByName("ID");
        //Column csvFuncionario = csvTable.getColumnByName("funcionario");
        //Column csvEmpresa = csvTable.getColumnByName("empresa");
        //Column csvNome = csvTable.getColumnByName("nome");

        
        //Json
        DataContext factoryJSON = analysis.factoryJSON();
        Table jsonTable = factoryJSON.getDefaultSchema().getTables()[0];
        Column jsonId = jsonTable.getColumnByName("id");
        Column jsonSobrenome = jsonTable.getColumnByName("sobre_nome");
        //Column jsonNome = jsonTable.getColumnByName("nome");

       
        
        System.out.println("####################### Schema de Banco #######################");
        
        DataContext factoryDatabase = analysis.factoryDatabase();
       // Schema[] schemas = factoryDatabase.getSchemas();
//        for (Schema schema : schemas) {
//            System.err.println( schema.getName());
//        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        
        //Table databaseTables = factoryDatabase.getDefaultSchema().getTableByName("PRESENTER2");
        Table databaseTables = factoryDatabase.getSchemaByName("PRESENTER2").getTableByName("TB_ANALYSIS");
//        String[] DatabasecolumnNames = databaseTables.getColumnNames();
//        for (String databasecolumnName : DatabasecolumnNames) {
//            System.out.println(databasecolumnName);
//        }
        
        Column databaseIdAnalise = databaseTables.getColumnByName("PK_ANALYSIS");
//        Column databaseNomeAnalise = databaseTables.getColumnByName("NM_ANALYSIS");

//        Column[] columns = databaseTables.getColumns();
//        for (Column column : columns) {
//            System.out.println(column);
//        }

        //DataSet dataSet = factoryJson.query().from(tableJson).select(columnNames).execute();
        DataContext compositeDataContext = DataContextFactory.createCompositeDataContext(new DataContext[]{
            factoryJSON,
            factoryCSV,
            //factoryDatabase 15:42:12.860 [main] DEBUG o.a.metamodel.util.EqualsBuilder - append(true)
        });

        
        Query query1 = new Query();
        query1
                .from(csvTable, jsonTable, JoinType.LEFT, csvIdUsuario, jsonId)
                //.from(xmlTable, databaseTables, JoinType.LEFT, xmlIdAnalise, databaseIdAnalise)
                
                //.where(csvFuncionario, OperatorType.EQUALS_TO, jsonId)
                //.where(csvDepartamento, OperatorType.EQUALS_TO, xmlId)
                //.where(xmlIdEmpresa, OperatorType.EQUALS_TO, databaseIdEmpresa)
                .selectAll() //                .select(
                //                        databaseNomeEmpresa,
                //                        xmlNomeDepartamento,
                //                        xmlIdEmpresa,
                //                        csvNome,
                //                        jsonSobrenome
                //                )
                ;
        
        
        
        
        DataSet executeQuery = compositeDataContext.executeQuery(query1);

        List<Map<String, Object>> list = toList(executeQuery);

        PrintResult printResult = new PrintResult();
        printResult.print(list);
    }

    public static List<Map<String, Object>> toList(DataSet execute) throws IndexOutOfBoundsException {
        List<Map<String, Object>> list = new ArrayList<>();

        for (Row row : execute) {
            SelectItem[] selectItems = row.getSelectItems();
            Map<String, Object> object = new HashMap<>(selectItems.length);

            for (int i = 0; i < row.getValues().length; i++) {
                String key = selectItems[i].getColumn().getName();
                String value = row.getValue(i) == null ? "" : row.getValue(i).toString();
                object.put(key, value);
            }

            list.add(object);
        }
        return list;
    }

    public DataContext factoryCSV() throws URISyntaxException {
        File csv = getFile(TESTFOLDER + "cidades.csv");
        return DataContextFactory.createCsvDataContext(csv, ',', '\"');
    }

    public DataContext factoryJSON() throws URISyntaxException {
        File file = getFile(TESTFOLDER + "jsondata.json");
        JsonDataContext dataContext = new JsonDataContext(file);

        return dataContext;
    }

    private DataContext factoryXML() throws URISyntaxException {
        File file = getFile(TESTFOLDER + "xmldata.xml");

        DataContext dataContext = new XmlSaxDataContext(file,
                new XmlSaxTableDef("/departamentos/departamento", new String[]{
                    "/departamentos/departamento@id",
                    "/departamentos/departamento/nome",
                    "/departamentos/departamento/analise"

                })
        );

        return dataContext;
    }

    public DataContext factoryDatabase() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Class.forName("oracle.jdbc.pool.OracleDataSource");
            //Class.forName("oracle.jdbc.xa.client.OracleXADataSource");
        } catch (ClassNotFoundException ex) {
            System.out.println("nao foi dessa vez");
            Logger.getLogger(CombinedAnalysis.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;
        try {

//            connection = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@192.168.1.8:1521:cdsbd", "PRESENTER_ANALYTICS",
//                    "cds312");
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.1.185:1521:cdsdev", "presenter2",
                    "cds312");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        //Database database = new Database();
        //DataContext dados = database.getDados(TESTFOLDER, TESTFOLDER, TESTFOLDER, TESTFOLDER, TESTFOLDER, TESTFOLDER);
        DataContext dataContext = DataContextFactory.createJdbcDataContext(connection);
        return dataContext;
    }

    private File getFile(String filename) throws URISyntaxException {
        File file = new File(getClass().getResource(filename).toURI());

        return file;
    }
}
