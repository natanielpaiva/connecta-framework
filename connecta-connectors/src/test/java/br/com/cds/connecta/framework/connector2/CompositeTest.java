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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.metamodel.query.JoinType;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author diego
 */
@Ignore
public class CompositeTest {

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
    public void allResultCsvWithDataBase() throws SQLException {
        long start = System.currentTimeMillis();

        ContextFactory contextStringCsv = contextStringCsv();
        ContextFactory contextDataBaseSql = contextDataBaseSqlUsuario();

        ContextFactory compositeContext = new CompositeDataContextFactory(
                contextStringCsv, "email", "csv", 
                JoinType.INNER, 
                contextDataBaseSql, "email", "banco");

        QueryBuilder query = new QueryBuilder();

        Request request = new Request(compositeContext, query);
        List<Map<String, Object>> all = client.getAll(request);

        assertThat(all, hasSize(greaterThan(0)));

        PrintResult.printMap(all);

        long elapsed = System.currentTimeMillis() - start;
        System.out.println(String.format("TOTAL TIME: %sms", elapsed));
    }

    @Test
    public void columnsCsvWithDataBase() throws SQLException {
        long start = System.currentTimeMillis();

        ContextFactory contextStringCsv = contextStringCsv();
        ContextFactory contextDataBaseSql = contextDataBaseSqlUsuario();

        ContextFactory compositeContext = new CompositeDataContextFactory(
                contextStringCsv, "email", "csv", 
                JoinType.INNER, 
                contextDataBaseSql, "email", "banco");

        QueryBuilder query = new QueryBuilder();

        Request request = new Request(compositeContext, query);

        List<ConnectorColumn> columns = client.getColumns(request);
        PrintResult.printColumns(columns);

        assertThat(columns.get(0).getName(), hasToString("csv.funcionario"));
        assertThat(columns.get(0).getLabel(), hasToString("csv.funcionario"));
        //assertThat(columns.get(0).getType(), hasToString("INTEGER"));

        assertThat(columns.get(1).getName(), hasToString("csv.nome"));
        assertThat(columns.get(1).getLabel(), hasToString("csv.nome"));
        //assertThat(columns.get(1).getType(), hasToString("STRING"));

        assertThat(columns.get(2).getName(), hasToString("csv.id_atividade"));
        assertThat(columns.get(2).getLabel(), hasToString("csv.id_atividade"));
        //assertThat(columns.get(2).getType(), hasToString("INTEGER"));

        assertThat(columns.get(3).getName(), hasToString("csv.email"));
        assertThat(columns.get(3).getLabel(), hasToString("csv.email"));
        //assertThat(columns.get(3).getType(), hasToString("STRING"));

        assertThat(columns.get(4).getName(), hasToString("banco.id_usuario"));
        assertThat(columns.get(4).getLabel(), hasToString("banco.id_usuario"));
        //assertThat(columns.get(4).getType(), hasToString("VARCHAR"));

        assertThat(columns.get(5).getName(), hasToString("banco.nome"));
        assertThat(columns.get(5).getLabel(), hasToString("banco.nome"));
        //assertThat(columns.get(5).getType(), hasToString("VARCHAR"));

        assertThat(columns.get(6).getName(), hasToString("banco.cpf"));
        assertThat(columns.get(6).getLabel(), hasToString("banco.cpf"));
        //assertThat(columns.get(6).getType(), hasToString("CHAR"));

        assertThat(columns.get(7).getName(), hasToString("banco.senha"));
        assertThat(columns.get(7).getLabel(), hasToString("banco.senha"));
        //assertThat(columns.get(7).getType(), hasToString("VARCHAR"));

        assertThat(columns.get(8).getName(), hasToString("banco.email"));
        assertThat(columns.get(8).getLabel(), hasToString("banco.email"));
        //assertThat(columns.get(8).getType(), hasToString("VARCHAR"));

        assertThat(columns.get(9).getName(), hasToString("banco.ativo"));
        assertThat(columns.get(9).getLabel(), hasToString("banco.ativo"));
        //assertThat(columns.get(9).getType(), hasToString("CHAR"));

        assertThat(columns.get(10).getName(), hasToString("banco.login"));
        assertThat(columns.get(10).getLabel(), hasToString("banco.login"));
        //assertThat(columns.get(10).getType(), hasToString("VARCHAR"));

        long elapsed = System.currentTimeMillis() - start;
        System.out.println(String.format("\n TOTAL TIME: %sms", elapsed));
    }

    @Test
    public void filterColumnsCsvWithDataBase() throws SQLException {
        long start = System.currentTimeMillis();

        ContextFactory contextStringCsv = contextStringCsv();
        ContextFactory contextDataBaseSql = contextDataBaseSqlUsuario();

        ContextFactory compositeContext = new CompositeDataContextFactory(
                contextStringCsv, "email", "201", 
                JoinType.INNER,
                contextDataBaseSql, "email", "banco");
        QueryBuilder query = new QueryBuilder();

        List<ConnectorColumn> connectorColumns = new ArrayList<>();

        ConnectorColumn column1 = new ConnectorColumn();
        column1.setId(Long.valueOf(1));
        column1.setName("banco.id_usuario");
        column1.setLabel("ID-usuario");
        column1.setFormula("banco.id_usuario");
        column1.setType("VARCHAR");

        ConnectorColumn column2 = new ConnectorColumn();
        column2.setId(Long.valueOf(1));
        column2.setName("banco.nome");
        column2.setLabel("Nome no Banco");
        column2.setFormula("banco.nome");
        column2.setType("STRING");

        ConnectorColumn column3 = new ConnectorColumn();
        column3.setId(Long.valueOf(1));
        column3.setName("201.nome");
        column3.setLabel("Nome do CSV");
        column3.setFormula("201.nome");
        column3.setType("STRING");

        connectorColumns.add(column1);
        connectorColumns.add(column2);
        connectorColumns.add(column3);

        query.setColumns(connectorColumns);
        Request request = new Request(compositeContext, query);
        List<Map<String, Object>> all = client.getAll(request);

        PrintResult.printMap(all);

        assertThat(all.get(0).size(), is(3));
        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("ID-usuario"));
        assertThat(all.get(0), hasKey("Nome no Banco"));
        assertThat(all.get(0), hasKey("Nome do CSV"));

        long elapsed = System.currentTimeMillis() - start;
        System.out.println(String.format("\n TOTAL TIME: %sms", elapsed));

    }

    //------------------------------------------------------------
    @Test
    public void allResultXmlWithDataBase() {
        ContextFactory contextXml = contextXml();
        ContextFactory contextFileCsv = contextFileCsv();
        //ContextFactory contextFileJson = contextFileJson();

        ContextFactory compositeContext = new CompositeDataContextFactory(
                contextXml, "@id", "xml", 
                JoinType.INNER,
                contextFileCsv, "departamento", "csv");
//
//        ContextFactory compositeToJson = new CompositeDataContextFactory(
//                compositeContext, contextFileJson,
//                "csv.idCargo", "all", JoinType.INNER, "idCargo", "json");
        
        QueryBuilder query = new QueryBuilder();

        Request request = new Request(compositeContext, query);
        List<Map<String, Object>> all = client.getAll(request);

        assertThat(all, hasSize(greaterThan(0)));

        PrintResult.printMap(all);
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

        FileDataContextFactory fileDataContextFactory = new FileDataContextFactory(jsonDataContextFactory);

        List<ConnectorColumn> columns = fileDataContextFactory.getColumns();
        PrintResult.printColumns(columns);

        QueryBuilder query = new QueryBuilder();

        Request request = new Request(fileDataContextFactory, query);
        List<Map<String, Object>> all = client.getAll(request);
        PrintResult.printMap(all);
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
        return new DatabaseDataContextFactory(sql, driver, MYSQL_USER, MYSQL_PASS, true);
    }

    private ContextFactory contextStringCsv() {
        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(stringCsv);
        return new FileDataContextFactory(csvDataContextFactory);
    }

}
