package br.com.cds.connecta.framework.connector2.test;

import br.com.cds.connecta.framework.connector2.FusionClient;
import br.com.cds.connecta.framework.connector2.Request;
import br.com.cds.connecta.framework.connector2.common.CompositeDataContextFactory;
import br.com.cds.connecta.framework.connector2.common.CompositeJoin;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.common.QueryContext;
import br.com.cds.connecta.framework.connector2.context.database.DatabaseDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.database.mysql.MySqlConnection;
import br.com.cds.connecta.framework.connector2.context.database.oracle.OracleConnection;
import br.com.cds.connecta.framework.connector2.context.file.FileDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.csv.CSVDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.json.JsonDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.xml.XMLDataContextFactory;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author diego
 */
public class CompositeContextTest {

    public static final String TESTFOLDER = "/testdata/";

    public static void main(String args[]) throws URISyntaxException {
       long start = System.currentTimeMillis(); 
       // long start = new Date().getTime();

        PrintResult printResult = new PrintResult();
        FusionClient fusionClient = new FusionClient();
        CompositeContextTest fileTest = new CompositeContextTest();

        File csvFile = fileTest.getFile(TESTFOLDER + "csvdata.csv");
        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(csvFile);
        //CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(csv);

        FileDataContextFactory csvDataContext = new FileDataContextFactory(csvDataContextFactory);

        Request requestCsv = new Request(csvDataContext,
                new QueryContext().setTable(TESTFOLDER));
        printResult.printMap2(fusionClient.getAll(requestCsv));

        //-------------------------
        File xlmFile = fileTest.getFile(TESTFOLDER + "xmldata.xml");

        XMLDataContextFactory xmlDataContextFactory = new XMLDataContextFactory(
                xlmFile,
                "/departamentos/departamento",
                new String[]{
                    "/departamentos/departamento@id",
                    "/departamentos/departamento/nome",
                    "/departamentos/departamento/analise"
                });

        FileDataContextFactory xmlContext = new FileDataContextFactory(xmlDataContextFactory);

        QueryContext xmlQuery = new QueryContext();

        Request requestXml = new Request(xmlContext, xmlQuery.setColumns(new String[]{"/nome", "@id"}).setPagination(1, 3));
        printResult.printMap2(fusionClient.getAll(requestXml));

        //---------------------------------------------------------------------
        
        
        
         //--------------------------------------------
        File jsonFile = fileTest.getFile(TESTFOLDER + "jsondata.json");
        //URL url = new URL("http://www.mocky.io/v2/569fcc27270000d94efb71cb");
        FileDataContextFactory jsonDataContextFactory = new FileDataContextFactory(new JsonDataContextFactory(jsonFile));
        
      
        
        //---------------------------------------
        
         DatabaseDataContextFactory oracleDatabase = new DatabaseDataContextFactory(
                new OracleConnection("192.168.1.185", "1521", "cdsdev"),"TB_ANALYSIS" ,"presenter2", "cds312");
         
       // ----------------------------------
        
         DatabaseDataContextFactory mySqlDatabase = new DatabaseDataContextFactory(
                new MySqlConnection("192.168.33.10", "3306", "memorando"),"tb_usuario" ,"root", "root");
         
        
        
        
        
        List<CompositeJoin> lista =  new ArrayList<>();
        lista.add(new CompositeJoin( csvDataContext,  "funcionario", jsonDataContextFactory,  "id"));
        lista.add(new CompositeJoin( csvDataContext, "departamento", xmlContext, "@id"));
        lista.add(new CompositeJoin( oracleDatabase, "PK_ANALYSIS", xmlContext, "/analise"));
        lista.add(new CompositeJoin( mySqlDatabase, "email", csvDataContext, "email"));
        
        CompositeDataContextFactory compositeContextTest = new CompositeDataContextFactory(lista);

        QueryContext queryContextComposite = new QueryContext();
        //queryContextComposite.setPagination(1, 4);

//        Collection<DataContext> delegates = null;
//        delegates.add(xmlContext.createDataContext());
//        delegates.add(csvDataContext.createDataContext());
        
        Request requestComposite = new Request(compositeContextTest, queryContextComposite);
        List<Map<String, Object>> all = fusionClient.getAll(requestComposite);
        long end = new Date().getTime();
        
        printResult.printMap2(all);
        
        long elapsed = System.currentTimeMillis() - start;
        System.out.println(String.format("TOTAL TIME: %sms", elapsed));
        
        
    }

    private File getFile(String filename) throws URISyntaxException {
        File file = new File(getClass().getResource(filename).toURI());

        return file;
    }
}
