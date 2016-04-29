
package br.com.cds.connecta.framework.connector2.test;

import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.FusionClient;
import br.com.cds.connecta.framework.connector2.Request;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import br.com.cds.connecta.framework.connector2.context.database.DatabaseDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.database.mysql.MySQLDriver;
import br.com.cds.connecta.framework.connector2.context.database.oracle.OracleDriver;
import br.com.cds.connecta.framework.connector2.context.file.csv.CSVDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.xml.XMLDataContextFactory;
import java.io.File;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author diego
 */
public class TestNewConnector {

    public static final String TESTFOLDER = "/testdata/";

    public static void main(String args[]) throws URISyntaxException {
        TestNewConnector testNewConnector = new TestNewConnector();
        FusionClient fusionClient = new FusionClient();

        String csv = "funcionario,nome,departamento\n"
                + "1,Diego,1\n"
                + "2,Natan,1\n"
                + "3,Vinicius,2\n"
                + "4,Diego,1\n"
                + "5,Natan,1\n"
                + "6,Vinicius,2\n"
                + "7,Diego,1\n"
                + "8,Natan,1\n"
                + "9,Vinicius,2\n"
                + "10,Diego,1\n"
                + "11,Natan,1\n"
                + "12,Vinicius,2";
        
        String[] csvColumns = {"nome"}; 
        
        QueryBuilder query = new QueryBuilder();
        query.build().select("nome");
        //Request requestCsv = new Request(new CSVDataContextFactory(csv), query);

        
        
        //List<Map<String, Object>> all = fusionClient.getAll(requestCsv);
        //List<ConnectorColumn> columns = fusionClient.getColumns(requestCsv);
        
        
       PrintResult printResult = new PrintResult();
        //printResult.printMap2(all);
       //printResult.printColumns(columns);
        
        //Request  requestCsv2 = new Request(new CSVDataContextFactory(csv), new QueryContext(12, 3));
        

//----------------------------------------------------------------
        File file = testNewConnector.getFile(TESTFOLDER + "xmldata.xml");
        
        XMLDataContextFactory xmlDataContextFactory = new XMLDataContextFactory(file,
                "/departamentos/departamento",
                new String[]{
                    "/departamentos/departamento@id",
                    "/departamentos/departamento/nome",
                    "/departamentos/departamento/analise"

                } );
        
        //Request requestXml = new Request(xmlDataContextFactory);
        
       // List<Map<String, Object>> resultList2 = fusionClient.getAll(requestXml);
       // List<ConnectorColumn> columns1 = fusionClient.getColumns(requestXml);
       // printResult.printColumns(columns1);
        
       // printResult.printMap2(resultList2);
        
  //--------------------------------------------------------------
      
//
//        Request requestXml = new Request(new XMLDataContextFactory(file,
//                "/departamentos/departamento",
//                new String[]{
//                    "/departamentos/departamento@id",
//                    "/departamentos/departamento/nome",
//                    "/departamentos/departamento/analise"
//
//                } ), new QueryContext().getXMLColumnus());
//
//        List<Map<String, Object>> resultList2 = fusionClient.getResultList(requestXml);
//        printResult.print(resultList2);
        
    }

    private File getFile(String filename) throws URISyntaxException {
        File file = new File(getClass().getResource(filename).toURI());

        return file;
    }

}
