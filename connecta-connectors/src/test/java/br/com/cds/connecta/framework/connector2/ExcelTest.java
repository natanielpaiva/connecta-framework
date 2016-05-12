package br.com.cds.connecta.framework.connector2;

import static br.com.cds.connecta.framework.connector2.TestUtil.getFile;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import br.com.cds.connecta.framework.connector2.context.file.FileDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.excel.ExcelDataContextFactory;
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
public class ExcelTest {

    private final FusionClient client = new FusionClient();

    private final Logger logger = Logger.getLogger(ExcelTest.class);

    private static final File formulaXlsx = getFile("test/data/excel/formulas.xlsx");
    private static final File formulaXls = getFile("test/data/excel/xls_formulas.xls");

    @Test
    public void columnsExcelFormulaXlsx() {
        ExcelDataContextFactory dataContext = new ExcelDataContextFactory(formulaXlsx);

        FileDataContextFactory fileDataContextFactory = new FileDataContextFactory(dataContext);

        List<ConnectorColumn> columns = fileDataContextFactory.getColumns();

        PrintResult.printColumns(columns);
        assertThat(columns.get(0).getName(), hasToString("Foo"));
        assertThat(columns.get(0).getLabel(), hasToString("Foo"));
        assertThat(columns.get(0).getFormula(), hasToString("Foo"));
        assertThat(columns.get(0).getType(), hasToString("INTEGER"));

        assertThat(columns.get(1).getName(), hasToString("Bar"));
        assertThat(columns.get(1).getLabel(), hasToString("Bar"));
        assertThat(columns.get(1).getFormula(), hasToString("Bar"));
        assertThat(columns.get(1).getType(), hasToString("STRING"));
    }

    @Test
    public void columnsExcelFormulaXls() {

        ExcelDataContextFactory dataContext = new ExcelDataContextFactory(formulaXls);

        FileDataContextFactory fileDataContextFactory = new FileDataContextFactory(dataContext);
        List<ConnectorColumn> columns = fileDataContextFactory.getColumns();

        PrintResult.printColumns(columns);
        assertThat(columns.get(0).getName(), hasToString("some number"));
        assertThat(columns.get(0).getLabel(), hasToString("some number"));
        assertThat(columns.get(0).getFormula(), hasToString("some number"));
        assertThat(columns.get(0).getType(), hasToString("INTEGER"));

        assertThat(columns.get(1).getName(), hasToString("some mixed formula"));
        assertThat(columns.get(1).getLabel(), hasToString("some mixed formula"));
        assertThat(columns.get(1).getFormula(), hasToString("some mixed formula"));
        assertThat(columns.get(1).getType(), hasToString("STRING"));

        assertThat(columns.get(2).getName(), hasToString("some int only formula"));
        assertThat(columns.get(2).getLabel(), hasToString("some int only formula"));
        assertThat(columns.get(2).getFormula(), hasToString("some int only formula"));
        assertThat(columns.get(2).getType(), hasToString("INTEGER"));
    }

    @Test
    public void allResultExcelXlsx() {
        ExcelDataContextFactory dataContext = new ExcelDataContextFactory(formulaXlsx);
        FileDataContextFactory contextFactory = new FileDataContextFactory(dataContext);

        QueryBuilder query = new QueryBuilder();
        Request request = new Request(contextFactory, query);

        List<Map<String, Object>> all = client.getAll(request);
        PrintResult.printMap(all);
        assertThat(all, hasSize(greaterThan(0)));
    }

    @Test
    public void allResultExcelXls() {
        ExcelDataContextFactory dataContext = new ExcelDataContextFactory(formulaXls);
        FileDataContextFactory contextFactory = new FileDataContextFactory(dataContext);

        QueryBuilder query = new QueryBuilder();
        Request request = new Request(contextFactory, query);

        List<Map<String, Object>> all = client.getAll(request);
        assertThat(all, hasSize(greaterThan(0)));
    }

    @Test
    public void XlsWithListColumns() {
        ExcelDataContextFactory dataContext = new ExcelDataContextFactory(formulaXls);
        FileDataContextFactory contextFactory = new FileDataContextFactory(dataContext);

        QueryBuilder query = new QueryBuilder();

        List<ConnectorColumn> connectorColumns = new ArrayList<>();

        ConnectorColumn column1 = new ConnectorColumn();
        column1.setId(Long.valueOf(1));
        column1.setName("some int only formula");
        column1.setLabel("Int formula");
        column1.setFormula("some int only formula");
        column1.setType("INTEGER");

        ConnectorColumn column2 = new ConnectorColumn();
        column2.setId(Long.valueOf(1));
        column2.setName("some mixed formula");
        column2.setLabel("Mixed formula");
        column2.setFormula("some mixed formula");
        column2.setType("STRING");

        connectorColumns.add(column1);
        connectorColumns.add(column2);

        Request request = new Request(contextFactory, query.setColumns(connectorColumns));

        List<Map<String, Object>> all = client.getAll(request);

        assertThat(all.get(0).size(), is(2));
        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("Int formula"));
        assertThat(all.get(0), hasKey("Mixed formula"));
    }
    
    @Test
    public void XlsxWithListColumns() {
        ExcelDataContextFactory dataContext = new ExcelDataContextFactory(formulaXlsx);
        FileDataContextFactory contextFactory = new FileDataContextFactory(dataContext);

        QueryBuilder query = new QueryBuilder();

        List<ConnectorColumn> connectorColumns = new ArrayList<>();

        ConnectorColumn column1 = new ConnectorColumn();
        column1.setId(Long.valueOf(1));
        column1.setName("Bar");
        column1.setLabel("BAR");
        column1.setFormula("Bar");
        column1.setType("STRING");

        connectorColumns.add(column1);

        Request request = new Request(contextFactory, query.setColumns(connectorColumns));

        List<Map<String, Object>> all = client.getAll(request);
        PrintResult.printMap(all);
        assertThat(all.get(0).size(), is(1));
        assertThat(all, hasSize(greaterThan(0)));
        assertThat(all.get(0), hasKey("BAR"));
    }


}
