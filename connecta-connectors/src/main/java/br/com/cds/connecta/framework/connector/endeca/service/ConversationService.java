package br.com.cds.connecta.framework.connector.endeca.service;

import br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3.ConversationPort;
import br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3.Fault;
import br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0.Assignment;
import br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0.ContentElement;
import br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0.EQL;
import br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0.EQLConfig;
import br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0.Record;
import br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0.Request;
import br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0.ResultRecords;
import br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0.Results;
import br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0.State;
import br.com.cds.connecta.framework.connector.endeca.service.bean.Attribute;
import br.com.cds.connecta.framework.connector.endeca.service.bean.Row;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * ConversationService is a class that call, conversation webservice from endeca
 * server, and search data from a specific domain
 *
 * In the ConversationService constructor must be set a domain for searchs, to
 * view all domains vide class {@link ManageService}
 *
 * this service can be found at the following url
 * http://0.0.0.0:7001/endeca-server/ws/conversation/myDomain?wsdl
 *
 * @author jhonatas
 *
 */
public class ConversationService {

    private ConversationPort portService;

    /**
     * @param dataDomain domainName to compose the wsdl url
     * @param wsdlLocation localização do wsdl
     *
     * http://0.0.0.0:7001/endeca-server/ws/conversation/myDomain?wsdl
     */
    public ConversationService(String dataDomain, String wsdlLocation) {
        portService = EndecaServiceFactory.getConversationService(dataDomain, wsdlLocation);
    }

    /**
     * vide doc {@link #getData(String[], Operation[], String, Grouping)}
     *
     * @param columns
     * @param operation
     * @return List<Row>
     * @throws ServiceFault
     */
    public List<Row> getData(List<String> columns, List<Operation> operation) throws ServiceFault {
        return this.getData(columns, operation, null, null, null, null);
    }

    public List<Row> getData(List<String> columns, Grouping group, String columnTop, OperationTop top) throws ServiceFault {
        return this.getData(columns, null, null, group, columnTop, top);
    }

    /**
     * vide doc {@link #getData(String[], Operation[], String, Grouping)}
     *
     * @param columns
     * @param operation
     * @param columnGroup
     * @param group
     * @return List<Row>
     * @throws ServiceFault
     */
    public List<Row> getData(List<String> columns, List<Operation> operation,
            String columnGroup, Grouping group) throws ServiceFault {
        return this.getData(columns, operation, columnGroup, group, null, null);
    }

    /**
     * @param columns String's array, columns must be in same order of operation
     * array
     * @param operation array of operation type {@link Operation}, operations
     * are in the desired order is similar to the columns
     * @param columnGroup
     * @param group the value is a grouping type {@link Grouping}
     * @param columnTop
     * @param top
     * @return List<Row>
     *
     * @throws ServiceFault if it happens any error on webservice, it will throw
     * a ServiceFault Exception
     */
    public List<Row> getData(List<String> columns, List<Operation> operation,
            String columnGroup, Grouping group,
            String columnTop, OperationTop top) throws ServiceFault {

        if (operation != null && columns.size() < operation.size()) {
            throw new ServiceFault("columns and operation array must be the"
                    + " same number of parameteres");
        }

        List<Row> rows = new ArrayList<Row>();

        Request request = new Request();
        request.setLanguage("en");
        request.getState().add(new State());

        EQLConfig eqlConfig = new EQLConfig();
        eqlConfig.setId(UUID.randomUUID().toString());

        String eqlAux = this.getDefaultEQL(columns, operation, columnGroup,
                group, columnTop, top);

        eqlConfig.setEQLQueryString(eqlAux);

        request.getContentElementConfig().add(eqlConfig);

        Results results = null;

        try {
            results = portService.request(request);
        } catch (Fault e) {
            throw new ServiceFault(e.getMessage(), e);
        }

        List<ContentElement> eqls = results.getContentElement();

        for (ContentElement el : eqls) {
            EQL eql = (EQL) el;
            List<ResultRecords> records = eql.getResultRecords();

            //has a break, because only can exist one in the webservice response
            for (ResultRecords result : records) {
                rows = this.getRecords(result);
                break;
            }

        }

        return rows;
    }

    /**
     * @param columns
     * @param operation
     * @param columnGroup
     * @param grouping
     */
    private String getDefaultEQL(List<String> columns, List<Operation> operation,
            String columnGroup, Grouping grouping,
            String columnTop, OperationTop top) {

        StringBuilder eql = new StringBuilder("RETURN result AS SELECT");

        for (int i = 0; i < columns.size(); i++) {
            String col = columns.get(i);
            //operation(column) as column
            String statement;
            if (operation != null) {
                statement = String.format(" %s(%s) as %s", operation.get(i).name(), col, col);
            } else {
                statement = String.format(" %s", col);
            }

            eql.append(statement);

            if (i != columns.size() - 1) {
                eql.append(", ");
            } else {
                eql.append(" ");
            }
        }

        if (columnGroup != null) {
            //GROUP BY column
            eql.append(String.format("%s %s", grouping.getValue(), columnGroup));
        } else {
            if (!grouping.equals(Grouping.ORDERBY)) {
                eql.append(Grouping.GROUP.getValue());
            } else {
                eql.append(grouping.getValue());
            }
        }

        if (top != null) {
            //if used order by, add only top function
            if (grouping.equals(Grouping.ORDERBY)) {
                eql.append(String.format(" %s DESC PAGE(0, %s)", columnTop, top.getNumber()));
            } else {
                eql.append(String.format(" ORDER BY %s DESC PAGE(0, %s)", columnTop, top.getNumber()));
            }
        }

        //eql = "RETURN result AS SELECT COUNT(Autor) AS Autor, SUM(Amigos) AS Amigos GROUP BY Origem";
        return eql.toString();
    }

    private List<Row> getRecords(ResultRecords result) {
        List<Row> rows = new ArrayList<Row>();

        for (Record record : result.getRecord()) {
            rows.add(new Row(this.getAttributes(record)));
        }

        return rows;
    }

    private List<Attribute> getAttributes(Record record) {
        List<Attribute> attrs = new ArrayList<Attribute>();

        for (Assignment attr : record.getAttribute()) {
            attrs.add(new Attribute(attr.getName(),
                    attr.getType(),
                    attr.getValue()));
        }

        return attrs;
    }

    /**
     * Grouping operation for search {@link ConversationService#getData}}
     *
     * @author jhonatas
     *
     */
    public enum Grouping {

        ORDERBY("ORDER BY"),
        GROUP("GROUP"),
        GROUPBY("GROUP BY");

        private String value = null;

        private Grouping(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    /**
     * Operation type for search {@link ConversationService#getData}
     *
     * @author jhonatas
     *
     */
    public enum Operation {

        AVG, SUM, COUNT
    }

    public enum OperationTop {

        TOP5(5),
        TOP10(10),
        TOP15(15),
        TOP20(20);

        private int number = 0;

        private OperationTop(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }

    public static void main(String... args) throws Exception {
        //ConversationService service = new ConversationService("COR_RJ", "http://172.16.0.246:7001/endeca-server/ws");
        ConversationService service = new ConversationService("cmsp001", "http://192.168.3.50:11001/endeca-server/ws/");
        String eqls = "RETURN result AS SELECT URL, QntFavorito, NomeExibicao, DataColeta, JobResultID, QntRetweet, Texto, PerfilUsuario ORDER BY URL DESC PAGE(0, 10)";
        //String eqls = "RETURN Top10 AS SELECT COUNT(Amigos) AS Amigos, AVG(Sentimento) AS Sentimento GROUP BY Autor ORDER BY Amigos DESC PAGE(0, 10)";

        Request request = new Request();
        request.setLanguage("en");
        request.getState().add(new State());

        EQLConfig eqlConfig = new EQLConfig();
        eqlConfig.setId(UUID.randomUUID().toString());

        eqlConfig.setEQLQueryString(eqls);

        request.getContentElementConfig().add(eqlConfig);

        Results results = service.portService.request(request);
        //System.out.println(JSONObject.fromObject(results));
    }
}
