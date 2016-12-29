package br.com.cds.connecta.framework.connector2;

import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.PrintResult;
import br.com.cds.connecta.framework.connector2.context.file.FileDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.file.json.JsonDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.http.Header;
import br.com.cds.connecta.framework.connector2.context.http.HttpDataContextFactory;
import br.com.cds.connecta.framework.connector2.context.http.HttpResponse;
import br.com.cds.connecta.framework.connector2.query.QueryBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpMethod;

/**
 *
 * @author diego
 */
@Ignore
public class RestTest {

    private final FusionClient client = new FusionClient();

    @Test
    public void get() {
        final String url = "http://www.mocky.io/v2/580e3ad7120000d410078820";

        HttpDataContextFactory httpDataContext = new HttpDataContextFactory();
        List<Header> headers = new ArrayList<>();
        Header header = new Header();
        header.setKey("Content-Type");
        header.setValue("application/json");
        headers.add(header);

        HttpResponse executeHttp = httpDataContext.executeHttp(url, HttpMethod.GET, headers, null);

    }

    @Test
    public void enviando() {
        final String url = "http://www.mocky.io/v2/580e3ad7120000d410078820";

        HttpDataContextFactory httpDataContext = new HttpDataContextFactory();
        List<Header> headers = new ArrayList<>();
        Header header = new Header();
        header.setKey("Content-Type");
        header.setValue("application/json");
        headers.add(header);

        HttpResponse executeHttp = httpDataContext.executeHttp(url, HttpMethod.GET, headers, null);
        JsonDataContextFactory jsonDataContextFactory = new JsonDataContextFactory(executeHttp.getBody());
        FileDataContextFactory contextFactory = new FileDataContextFactory(jsonDataContextFactory);

       // List<ConnectorColumn> columns = contextFactory.getColumns();
        QueryBuilder query = new QueryBuilder();

        Request request = new Request(contextFactory, query);

        List<Map<String, Object>> all = client.getAll(request);
        PrintResult.printMap(all);

    }

    @Test
    public void enviandow() {
        final String url = "http://www.mocky.io/v2/580f5800120000da119e2ef3";

        HttpDataContextFactory httpDataContext = new HttpDataContextFactory();
        List<Header> headers = new ArrayList<>();
        Header header = new Header();
        header.setKey("Content-Type");
        header.setValue("application/json");
        headers.add(header);

        HttpResponse executeHttp = httpDataContext.executeHttp(url, HttpMethod.GET, headers, null);
        JsonDataContextFactory jsonDataContextFactory = new JsonDataContextFactory(executeHttp.getBody(), "markers[*]");
        FileDataContextFactory contextFactory = new FileDataContextFactory(jsonDataContextFactory);

        List<ConnectorColumn> columns = contextFactory.getColumns();
        PrintResult.printColumns(columns);

        List<ConnectorColumn> connectorColumns = new ArrayList<>();
        ConnectorColumn column1 = new ConnectorColumn();
        column1.setId(Long.valueOf(1));
        column1.setName("markerImage");
        column1.setLabel("markerImage");
        column1.setFormula("markerImage");
        column1.setType("VARCHAR");

        ConnectorColumn column2 = new ConnectorColumn();
        column2.setId(Long.valueOf(1));
        column2.setName("awayTeam");
        column2.setLabel("awayTeam");
        column2.setFormula("awayTeam");
        column2.setType("VARCHAR");

        connectorColumns.add(column1);
        connectorColumns.add(column2);
//        
        QueryBuilder query = new QueryBuilder().setColumns(connectorColumns);

        Request request = new Request(contextFactory, query);

        List<Map<String, Object>> all = client.getAll(request);
        PrintResult.printMap(all);

    }

}
