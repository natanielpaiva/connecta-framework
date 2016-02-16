
package br.com.cds.connecta.framework.connector2.test;

import br.com.cds.connecta.framework.connector2.FusionClient;
import br.com.cds.connecta.framework.connector2.Request;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.common.QueryContext;
import br.com.cds.connecta.framework.connector2.context.file.FileDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.csv.CSVDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.excel.XlsDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.json.JsonDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.xml.XMLDataContextFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


/**
 *
 * @author diego
 */
public class FileTest {
    
    public static final String TESTFOLDER = "/testdata/";
    
    public static void main(String args[]) throws URISyntaxException, MalformedURLException{
        PrintResult printResult = new PrintResult();
        FusionClient fusionClient = new FusionClient();
         FileTest fileTest = new FileTest();
        
//        String csv = "funcionario,nome,departamento\n"
//                + "1,Diego,1\n"
//                + "2,Natan,1\n"
//                + "3,Vinicius,2\n"
//                + "4,Diego,1\n"
//                + "5,Natan,1\n"
//                + "6,Vinicius,2\n"
//                + "7,Diego,1\n"
//                + "8,Natan,1\n"
//                + "9,Vinicius,2\n"
//                + "10,Diego,1\n"
//                + "11,Natan,1\n"
//                + "12,Vinicius,2";
        
        File csvFile = fileTest.getFile(TESTFOLDER + "csvdata.csv");
        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(csvFile);
        //CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(csv);
        
        FileDataContextFactory fileDataContextFactory = new FileDataContextFactory(csvDataContextFactory);
        
        Request requestCsv = new Request(fileDataContextFactory, 
                                        new QueryContext()
                                                .setColumns(new String[]{"nome"}));
        printResult.printMap2(fusionClient.getAll(requestCsv));
        
        printResult.printColumns(fusionClient.getColumns(requestCsv));
        
        
        ///------------------
       
        File xlmFile = fileTest.getFile(TESTFOLDER + "xmldata.xml");
        
        XMLDataContextFactory xmlDataContextFactory = new XMLDataContextFactory(
                xlmFile,
                "/departamentos/departamento",
                new String[]{
                    "/departamentos/departamento@id",
                    "/departamentos/departamento/nome",
                    "/departamentos/departamento/analise"
                } );
        
          
        FileDataContextFactory contextFactory = new FileDataContextFactory(xmlDataContextFactory);
        
        QueryContext xmlQuery = new QueryContext();
        
       Request requestXml = new Request(contextFactory, xmlQuery.setColumns(new String[]{"/nome","@id"}).setPagination(1, 3));
       printResult.printMap2(fusionClient.getAll(requestXml));
       printResult.printColumns(fusionClient.getColumns(requestXml));
       
       //--------------------------
       
       File xlsFile = fileTest.getFile(TESTFOLDER + "xlsdata.xls");
       
        XlsDataContextFactory xlsDataContextFactory = new XlsDataContextFactory(xlsFile);
       
        FileDataContextFactory xlsContext = new FileDataContextFactory(xlsDataContextFactory);
        
        QueryContext xlsQuery = new QueryContext();
        Request xlsRequest = new Request(xlsContext, xlsQuery.setPagination(1, 10).setColumns(new String[]{"Sales", "Row ID", "Quantity", "Profit", "Postal Code", "Ship Mode", "Customer ID", "Order Date" }));
        printResult.printMap2(fusionClient.getAll(xlsRequest));
       
        //--------------------------------------------
        File file = fileTest.getFile(TESTFOLDER + "jsondata.json");
        //URL url = new URL("http://www.mocky.io/v2/569fcc27270000d94efb71cb");
        FileDataContextFactory jsonDataContextFactory = new FileDataContextFactory(new JsonDataContextFactory(file));
        
        QueryContext jsonQuery = new QueryContext();
        Request jsonRequest = new Request(jsonDataContextFactory, jsonQuery);
        printResult.printMap2(fusionClient.getAll(jsonRequest));
        
        
    }

    
    
    
    private File getFile(String filename) throws URISyntaxException {
        File file = new File(getClass().getResource(filename).toURI());

        return file;
    }
    
}
