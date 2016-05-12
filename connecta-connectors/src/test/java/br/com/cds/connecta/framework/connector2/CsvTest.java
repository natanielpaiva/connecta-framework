package br.com.cds.connecta.framework.connector2;

import static br.com.cds.connecta.framework.connector2.TestUtil.getFile;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import br.com.cds.connecta.framework.connector2.context.file.FileDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.csv.CSVDataContextFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
public class CsvTest {

    private final FusionClient client = new FusionClient();

    private final Logger logger = Logger.getLogger(CsvTest.class);

    private final String stringCsv = "id,name,gender,age\n"
            + "1,\"mike\",male,18\n"
            + "2,\"michael\",male,19\n"
            + "3,\"peter\",male,18\n"
            + "4,\"bob\",male,17\n"
            + "5,\"barbara, barb\",female,18\n"
            + "6,\"charlotte\",female,18\n"
            + "7,\"hillary\",female,20\n"
            + "8,\"vera\",female,17\n"
            + "9,\"carrie\",female,17";

    @Test
    public void columnsCsvFile() {
        File csvFile = getFile("test/data/csv/csv_cidades.csv");
        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(csvFile);
        FileDataContextFactory fileDataContextFactory = new FileDataContextFactory(csvDataContextFactory);

        List<ConnectorColumn> columns = fileDataContextFactory.getColumns();

        assertThat(columns.get(0).getName(), hasToString("Regiao"));
        assertThat(columns.get(0).getLabel(), hasToString("Regiao"));
        assertThat(columns.get(0).getFormula(), hasToString("Regiao"));

        assertThat(columns.get(1).getName(), hasToString("UF"));
        assertThat(columns.get(1).getLabel(), hasToString("UF"));
        assertThat(columns.get(1).getFormula(), hasToString("UF"));

        assertThat(columns.get(2).getName(), hasToString("Cidade"));
        assertThat(columns.get(2).getLabel(), hasToString("Cidade"));
        assertThat(columns.get(2).getFormula(), hasToString("Cidade"));

        assertThat(columns.get(3).getName(), hasToString("vendas"));
        assertThat(columns.get(3).getLabel(), hasToString("vendas"));
        assertThat(columns.get(3).getFormula(), hasToString("vendas"));

        assertThat(columns.get(4).getName(), hasToString("Flag"));
        assertThat(columns.get(4).getLabel(), hasToString("Flag"));
        assertThat(columns.get(4).getFormula(), hasToString("Flag"));

    }

    @Test
    public void allResultCsvFile() {
        File csvFile = getFile("test/data/csv/csv_cidades.csv");
        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(csvFile);
        FileDataContextFactory contextFactory = new FileDataContextFactory(csvDataContextFactory);

        QueryBuilder query = new QueryBuilder();
        Request request = new Request(contextFactory, query);

        List<Map<String, Object>> all = client.getAll(request);
        //PrintResult.printMap(all);
        assertThat(all, hasSize(greaterThan(0)));
    }

    @Test
    public void csvWithListColumnsFile() {
        File csvFile = getFile("test/data/csv/csv_cidades.csv");
        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(csvFile);
        FileDataContextFactory contextFactory = new FileDataContextFactory(csvDataContextFactory);

        QueryBuilder query = new QueryBuilder();

        List<ConnectorColumn> connectorColumns = new ArrayList<>();

        ConnectorColumn column1 = new ConnectorColumn();
        column1.setId(Long.valueOf(1));
        column1.setName("Regiao");
        column1.setLabel("Região");
        column1.setType("VARCHAR");

        ConnectorColumn column2 = new ConnectorColumn();
        column2.setId(Long.valueOf(1));
        column2.setName("UF");
        column2.setLabel("Uf");
        column2.setType("VARCHAR");

        connectorColumns.add(column1);
        connectorColumns.add(column2);

        Request request = new Request(contextFactory, query.setColumns(connectorColumns));

        List<Map<String, Object>> all = client.getAll(request);

        assertThat(all.get(0).size(), is(2));
        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("Uf"));
        assertThat(all.get(0), hasKey("Região"));
    }

    @Test
    public void stringColumnsCSVString() {

        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(stringCsv);
        FileDataContextFactory contextFactory = new FileDataContextFactory(csvDataContextFactory);

        QueryBuilder query = new QueryBuilder();
        Request request = new Request(contextFactory, query);

        List<ConnectorColumn> columns = client.getColumns(request);

        assertThat(columns.get(0).getName(), hasToString("id"));
        assertThat(columns.get(0).getLabel(), hasToString("id"));
        assertThat(columns.get(0).getFormula(), hasToString("id"));
        assertThat(columns.get(0).getType(), hasToString("INTEGER"));

        assertThat(columns.get(1).getName(), hasToString("name"));
        assertThat(columns.get(1).getLabel(), hasToString("name"));
        assertThat(columns.get(1).getFormula(), hasToString("name"));
        assertThat(columns.get(1).getType(), hasToString("STRING"));

        assertThat(columns.get(2).getName(), hasToString("gender"));
        assertThat(columns.get(2).getLabel(), hasToString("gender"));
        assertThat(columns.get(2).getFormula(), hasToString("gender"));
        assertThat(columns.get(2).getType(), hasToString("STRING"));

        assertThat(columns.get(3).getName(), hasToString("age"));
        assertThat(columns.get(3).getLabel(), hasToString("age"));
        assertThat(columns.get(3).getFormula(), hasToString("age"));
        assertThat(columns.get(3).getType(), hasToString("INTEGER"));
    }

    @Test
    public void allResultCsvString() {
        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(stringCsv);
        FileDataContextFactory contextFactory = new FileDataContextFactory(csvDataContextFactory);

        QueryBuilder query = new QueryBuilder();

        Request request = new Request(contextFactory, query);

        List<Map<String, Object>> all = client.getAll(request);
        PrintResult.printMap(all);
        assertThat(all, hasSize(greaterThan(0)));
    }

    @Test
    public void csvWithListColumnsString() {
        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(stringCsv);
        FileDataContextFactory contextFactory = new FileDataContextFactory(csvDataContextFactory);

        QueryBuilder query = new QueryBuilder();

        List<ConnectorColumn> connectorColumns = new ArrayList<>();
        ConnectorColumn column1 = new ConnectorColumn();
        column1.setId(Long.valueOf(1));
        column1.setName("age");
        column1.setLabel("Age");
        column1.setFormula("age");
        column1.setType("STRING");

        ConnectorColumn column2 = new ConnectorColumn();
        column2.setId(Long.valueOf(1));
        column2.setName("name");
        column2.setLabel("Name");
        column2.setFormula("name");
        column2.setType("STRING");

        connectorColumns.add(column1);
        connectorColumns.add(column2);

        Request request = new Request(contextFactory, query.setColumns(connectorColumns));

        List<Map<String, Object>> all = client.getAll(request);

        PrintResult.printMap(all);
        assertThat(all.get(0).size(), is(2));
        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("Age"));
        assertThat(all.get(0), hasKey("Name"));
    }

    @Test
    public void allResultCsvSemicolonQuote() {

        File csvFile = getFile("test/data/csv/csv_semicolon_singlequote.csv");
        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(csvFile, ';', '\'');
        FileDataContextFactory contextFactory = new FileDataContextFactory(csvDataContextFactory);

        QueryBuilder query = new QueryBuilder();

        Request request = new Request(contextFactory, query);
        List<Map<String, Object>> all = client.getAll(request);

        PrintResult.printMap(all);
        assertThat(all.get(0).size(), is(4));
        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("id"));
        assertThat(all.get(0), hasKey("gender"));
        assertThat(all.get(0), hasKey("age"));
        assertThat(all.get(0), hasKey("name"));

    }
    
    
    @Test
    public void checksVariousTypes() {

        File csvFile = getFile("test/data/csv/csv_various_types.csv");
        CSVDataContextFactory csvDataContextFactory = new CSVDataContextFactory(csvFile, ',', '\"');
        FileDataContextFactory contextFactory = new FileDataContextFactory(csvDataContextFactory);

        QueryBuilder query = new QueryBuilder();

        Request request = new Request(contextFactory, query);
        List<ConnectorColumn> columns = client.getColumns(request);
        List<Map<String, Object>> all = client.getAll(request);

        PrintResult.printColumns(columns);
        
        assertThat(columns.get(0).getName(), hasToString("date"));
        assertThat(columns.get(0).getLabel(), hasToString("date"));
        assertThat(columns.get(0).getFormula(), hasToString("date"));
        assertThat(columns.get(0).getType(), hasToString("DATE"));
        
        assertThat(columns.get(1).getName(), hasToString("time"));
        assertThat(columns.get(1).getLabel(), hasToString("time"));
        assertThat(columns.get(1).getFormula(), hasToString("time"));
        assertThat(columns.get(1).getType(), hasToString("DATE"));
        
        
        assertThat(columns.get(2).getName(), hasToString("description"));
        assertThat(columns.get(2).getLabel(), hasToString("description"));
        assertThat(columns.get(2).getFormula(), hasToString("description"));
        assertThat(columns.get(2).getType(), hasToString("STRING"));
        
        
        assertThat(columns.get(3).getName(), hasToString("rating"));
        assertThat(columns.get(3).getLabel(), hasToString("rating"));
        assertThat(columns.get(3).getFormula(), hasToString("rating"));
        assertThat(columns.get(3).getType(), hasToString("DOUBLE"));
        
        
        assertThat(columns.get(4).getName(), hasToString("holiday"));
        assertThat(columns.get(4).getLabel(), hasToString("holiday"));
        assertThat(columns.get(4).getFormula(), hasToString("holiday"));
        assertThat(columns.get(4).getType(), hasToString("BOOLEAN"));
        

        
        
        PrintResult.printMap(all);
//        assertThat(all.get(0).size(), is(4));
//        assertThat(all, hasSize(greaterThan(0)));
//        assertThat(all.get(0), hasKey("id"));
//        assertThat(all.get(0), hasKey("gender"));
//        assertThat(all.get(0), hasKey("age"));
//        assertThat(all.get(0), hasKey("name"));

    }

}
