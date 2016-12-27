package br.com.cds.connecta.framework.connector2;

import static br.com.cds.connecta.framework.connector2.TestUtil.getFile;
import br.com.cds.connecta.framework.connector2.context.composite.CompositeDataContextFactory;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.context.database.ConnectorDriver;
import br.com.cds.connecta.framework.connector2.context.database.DatabaseDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.database.mysql.MySQLDriver;
import br.com.cds.connecta.framework.connector2.context.file.FileDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.csv.CSVDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.json.JsonDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.xml.XMLDataContextFactory;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.metamodel.query.JoinType;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Classe incompleta
 * @author diego
 */
@Ignore
public class TypeColumnsTest {

    private final FusionClient client = new FusionClient();

    private final Logger logger = Logger.getLogger(CompositeTest.class);

    private static final String MYSQL_HOST = "192.168.33.10";
    private static final String MYSQL_PORT = "3306";
    private static final String MYSQL_DB = "memorando";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASS = "root";

    private final String stringCsv = "funcionario,nome,id_atividade,email\n"
            + "1,Diego,1,diego.lakatos@cds.com.br\n"
            + "2,Natan,1,nataniel.paiva@cds.com.br\n"
            + "3,Vinicius,2,vinicius.pires@cds.com.br\n"
            + "4,Anais,1,ana.oliveira@cds.com.br\n"
            + "5,Rizia,1,rizelda.santos@cds.com.br\n"
            + "6,Eduardo,2,eduardo.castro@cds.com.br\n"
            + "7,Carlos H,2,carlos.diaz@cds.com.br";

    @Test
    public void join(){
        ContextFactory contextFileJson = contextFileJson();
        ContextFactory contextFileCsv = contextFileCsv();
        
         ContextFactory compositeContext = new CompositeDataContextFactory(
                contextFileCsv, "idCargo", "csv",
                JoinType.INNER,
               contextFileJson , "idCargo", "json");
         
         QueryBuilder queryContext = new QueryBuilder();
        Request request = new Request(compositeContext, queryContext);
        List<Map<String, Object>> all = client.getAll(request);
        PrintResult.printMap(all);
        
    }
    
    //retornando somente String
    @Test
    public void typeColumnsJson(){
        ContextFactory contextFileJson = contextFileJson();
        List<ConnectorColumn> columns = contextFileJson.getColumns();
        PrintResult.printColumns(columns);
    }
    
    @Test
    public void typeColumnsFileCsv() {
        ContextFactory contextFileCsv = contextFileCsv();
        List<ConnectorColumn> columns = contextFileCsv.getColumns();
        PrintResult.printColumns(columns);
    }
    
    @Test
    public void typeColumnsCsvString() {
        ContextFactory contextStringCsv = contextStringCsv();
        List<ConnectorColumn> columns = contextStringCsv.getColumns();
        PrintResult.printColumns(columns);
    }
    
   @Test
    public void typeColumnsFileXml() {
        ContextFactory contextStringCsv = contextXml();
        List<ConnectorColumn> columns = contextStringCsv.getColumns();
        PrintResult.printColumns(columns);
    }
    
    private ContextFactory contextFileCsv() {
        File csvFile = getFile("test/data/csv/csv_funcionario.csv");
        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(csvFile);

        return new FileDataContextFactory(csvDataContextFactory);
    }

    private ContextFactory contextXml() {
        File xlsFile = getFile("test/data/xml/xml_departamento.xml");
        XMLDataContextFactory xmlDataContextFactory = new XMLDataContextFactory(
                xlsFile,
                "/departamentos/departamento",
                new String[]{
                    "/departamentos/departamento@id",
                    "/departamentos/departamento/nome"
                });

        return new FileDataContextFactory(xmlDataContextFactory);
    }

    private ContextFactory contextFileJson() {
        File jsonFile = getFile("test/data/json/json_cargos.json");
        JsonDataContextFactory jsonDataContextFactory = new JsonDataContextFactory(jsonFile);
        return new FileDataContextFactory(jsonDataContextFactory);
    }

    private ContextFactory contextDataBaseSqlAtividade() {
        String table = "tb_tipo_atividade";
        ConnectorDriver driver = new MySQLDriver(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);
        return new DatabaseDataContextFactory(driver, table, MYSQL_USER, MYSQL_PASS);
    }

    private ContextFactory contextDataBaseSqlUsuario() throws SQLException {
        String sql = "select * from tb_usuario";
        ConnectorDriver driver = new MySQLDriver(MYSQL_HOST, MYSQL_PORT, MYSQL_DB);
        return new DatabaseDataContextFactory(sql, driver, MYSQL_USER, MYSQL_PASS);
    }

    private ContextFactory contextStringCsv() {
        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(stringCsv);
        return new FileDataContextFactory(csvDataContextFactory);
    }
    
//    @Test
//    public void contextFileCsvd() {
//        File csvFile = getFile("test/data/csv/testeDeNovo.csv");
//        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(csvFile, ';', '\'');
//
//        FileDataContextFactory fileDataContextFactory = new FileDataContextFactory(csvDataContextFactory);
//        
//          QueryBuilder queryContext = new QueryBuilder();
//        Request request = new Request(fileDataContextFactory, queryContext);
//        
//        List<ConnectorColumn> columns = client.getColumns(request);
//        PrintResult.printColumns(columns);
//    }

}