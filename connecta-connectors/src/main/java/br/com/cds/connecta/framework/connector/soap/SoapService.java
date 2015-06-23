package br.com.cds.connecta.framework.connector.soap;

import br.com.cds.connecta.framework.connector.soap.service.Operation;
import br.com.cds.connecta.framework.connector.soap.service.Parameters;
import br.com.cds.connecta.framework.connector.soap.service.Param;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.query.SelectItem;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Table;
import org.apache.metamodel.util.InMemoryResource;
import org.apache.metamodel.util.Resource;
import org.apache.metamodel.xml.XmlSaxDataContext;
import org.apache.metamodel.xml.XmlSaxTableDef;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author diego
 */
public class SoapService {

    public static String VAR = "%var";

    private static final XPathFactory xpathFactory = XPathFactory.newInstance();

    //Operation
    private static final String xpathOperations = "/definitions/binding[1]/operation/@name";
    //soapAction
    private static final String xpathSoapAction = "/definitions/binding[1]/operation[@name='%var']/operation/@soapAction";
    //private static final String xpathSoapAction = "/definitions/binding[1]/operation/operation/@soapAction";

    private static final String xpathTargetNamespace = "/definitions/@targetNamespace";

    //portType
    private static final String xpathOutputMessage = "substring-after(/definitions/portType[1]/operation[@name='%var']/output/@message, ':')";
    //private static final String xpathInputMessage = "substring-after(/definitions/portType[1]/operation[@name='%var']/output/@message, ':')";
    private static final String xpathNameSpace = "substring-after(/definitions/message[@name='%var']/part/@element, ':' )";

    //ComplexType define o tipo de retorno caso seja um array de elementos
    private static final String xpathComplexType = "string(/definitions/types/schema/complexType[@name='%var']/sequence/element/@type)";

    private static final String xpathMessageInteface = "substring-after(/definitions/message[@name='%var']/part/@element, ':')";

    private static final String xpathElementName = "/definitions/types/schema/element[@name='%s']/complexType/sequence/element/@name";
    private static final String xpathElementType = "/definitions/types/schema/element[@name='%s']/complexType/sequence/element/@type";

    //aqui deverão ser descritos os tipos de dados suportados pelo serviço em questão
    private String types;

    //aqui devem ser especificados os padrões de entrada e saída de dados dos web services
    private String message;

    //aqui devem ser descritos os agrupamentos lógicos das operações. São as operações executadas pelo web service
    private String portType;

    //aqui devem ser apresentados os protocolos de comunicação que os web services utilizam
    private String binding;

    //região que permite a especificação das assinaturas dos métodos disponibilizados
    private String operation;

    //elemento padrão de todos os documentos WSDL. Permite efetuar descrições sobre schemas e namespaces
    private String definitions;

    //Caminho de acesso no wsdl
    private String targetNamespace;

    //header do cabecalho 
    private String soapAction;

    private String endpoint;

    private Document document;

    private DOMSource domSource;

    private static final Logger logger = Logger.getLogger(SoapService.class.getName());

    public SoapService(String endpoint) {
        this.endpoint = endpoint;
        try {
            URL url = new URL(endpoint);
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url.openStream());

            XPathExpression findTargetNamespace = xpathFactory.newXPath().compile(xpathTargetNamespace);
            targetNamespace = (String) findTargetNamespace.evaluate(document, XPathConstants.STRING);

            System.out.println("---->>targetNamespace: " + targetNamespace);

        } catch (ParserConfigurationException | IOException | SAXException | XPathExpressionException e) {
        }
    }

    //ok
    public String getSoapAction(String operation) throws XPathExpressionException {

        XPathExpression findSoapAction = xpathFactory.newXPath().compile(xpathSoapAction.replace(VAR, operation));
        soapAction = (String) findSoapAction.evaluate(document, XPathConstants.STRING);

        return soapAction;
    }

    public void getElement(String nameSpaceMessage) throws XPathExpressionException {

        XPathExpression findElementColumns = xpathFactory.newXPath().compile(String.format(xpathElementName, nameSpaceMessage));
        XPathExpression findElementType = xpathFactory.newXPath().compile(String.format(xpathElementType, nameSpaceMessage));

        NodeList nameList = (NodeList) findElementColumns.evaluate(document, XPathConstants.NODESET);
        NodeList typeList = (NodeList) findElementType.evaluate(document, XPathConstants.NODESET);

        for (int i = 0; i < nameList.getLength(); i++) {
            String name = nameList.item(i).toString();
            String type[] = typeList.item(i).toString().replace("\"", "").split(":");

            System.out.println("**** Name: " + name);
            System.out.println("**** Type: " + type[1]);

            // String type[] = typeList.item(i).toString().split(":");
            if (type[1].equals("string")) {
                System.out.println("**** Name: " + name);
                logger.info("eee");
            } else {
                getComplexType(type[1]);

            }

        }
    }

    public void getComplexType(String nameSpaceMessage) throws XPathExpressionException {
        XPathExpression xComplexType = xpathFactory.newXPath().compile(xpathComplexType.replace(VAR, nameSpaceMessage));
        String complexType = (String) xComplexType.evaluate(document, XPathConstants.STRING);

        String[] splitComplexType = complexType.split(":");

        System.out.println("**ComplexType: " + splitComplexType[1]);
        getComplexType(splitComplexType[1]);

    }

    public void getOutputMessage(String operation) throws XPathExpressionException {
        XPathExpression xOutputMessage = xpathFactory.newXPath().compile(xpathOutputMessage.replace(VAR, operation));
        String outputMessage = (String) xOutputMessage.evaluate(document, XPathConstants.STRING);

        System.out.println("**OutPutMessage: " + outputMessage);

        XPathExpression xNameSpaceMessage = xpathFactory.newXPath().compile(xpathNameSpace.replace(VAR, outputMessage));
        String nameSpaceMessage = (String) xNameSpaceMessage.evaluate(document, XPathConstants.STRING);

        System.out.println("**nameSpaceMessage: " + nameSpaceMessage);

        getElement(nameSpaceMessage);
    }

    public ArrayList getOperation() throws XPathExpressionException {

        XPathExpression findElements = xpathFactory.newXPath().compile(xpathOperations);
        NodeList list = (NodeList) findElements.evaluate(document, XPathConstants.NODESET);

        ArrayList<Operation> operations = new ArrayList<>();

        for (int i = 0; i < list.getLength(); i++) {
            Node item = list.item(i);

            Operation operation = new Operation();
            operation.setOperation(item.getNodeValue());

            System.out.println("xxMETODO: " + item.getNodeValue());

            XPathExpression findElementColumns = xpathFactory.newXPath().compile(String.format(xpathElementName, item.getNodeValue()));
            XPathExpression findElementType = xpathFactory.newXPath().compile(String.format(xpathElementType, item.getNodeValue()));

            NodeList columnList = (NodeList) findElementColumns.evaluate(document, XPathConstants.NODESET);
            NodeList typeList = (NodeList) findElementType.evaluate(document, XPathConstants.NODESET);

            ArrayList<Param> params = new ArrayList<>();
            for (int j = 0; j < columnList.getLength(); j++) {
                Param param = new Param();

                Node column = columnList.item(j);
                Node type = typeList.item(j);
                String typeParame = null;

                if (type != null) {
                    typeParame = type.getNodeValue();

                } else {
                    typeParame = "null";
                }
                param.setAttributes(column.getNodeValue());
                param.setType(typeParame);

                params.add(param);
                System.out.println("-- ATTRIBUTO: " + column.getNodeValue() + " Parame --- " + typeParame);
            }
            operation.setParams(params);
            operations.add(operation);
        }

        return operations;
    }

    public String ResponseXml(String operation, List<Parameters> parameters) throws SOAPException, IOException, XPathExpressionException {
        DOMSource domSource = getDomSource(operation, parameters);

        final StringWriter sw = new StringWriter();
        try {
            TransformerFactory.newInstance().newTransformer().transform(domSource,
                    new StreamResult(sw));
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }

        // Now you have the XML as a String:
        System.out.println("************");

        System.out.println(sw.toString());
        System.out.println("**************");

        return sw.toString();
    }

    public DOMSource getDomSource(String operation1, List<Parameters> parameters) throws SOAPException, XPathExpressionException, IOException, UnsupportedOperationException {
        //Getting a SOAPConnection Object
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = soapConnectionFactory.createConnection();
        // Creating a message
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage messageBody = factory.createMessage();
        SOAPPart soapPart = messageBody.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(operation1, targetNamespace);
        System.out.println("######## operation: " + operation1 + " soapAction " + this.getSoapAction(operation1));
        SOAPBody soapBody = envelope.getBody();
        QName bodyName = new QName(targetNamespace, operation1);
        SOAPElement soapBodyElem = soapBody.addChildElement(bodyName);
        for (Parameters p : parameters) {
            System.out.println("Attributes: " + p.getAttributes() + " ----" + p.getValue());
            QName nCdServico = new QName(targetNamespace, p.getAttributes(), "ggg");
            SOAPElement soapBodyElem1 = soapBodyElem.addChildElement(nCdServico);
            soapBodyElem1.addTextNode(p.getValue());
        }
        MimeHeaders headers = messageBody.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);
        messageBody.writeTo(System.out);
        System.out.println("\n");
        final SOAPMessage response = connection.call(messageBody, endpoint);

        domSource = new DOMSource(response.getSOAPPart());
        return domSource;
    }

    public String getTargetNamespace() {
        return targetNamespace;
    }

    public void setTargetNamespace(String targetNamespace) {
        this.targetNamespace = targetNamespace;
    }

    public static void main(String... args) throws Exception {
        String url = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx?WSDL";
        List parameters = new ArrayList<>();

        String operation = "CalcPrazo";
        parameters.add(new Parameters("nCdServico", "41106"));
        parameters.add(new Parameters("sCepOrigem", "64002150"));
        parameters.add(new Parameters("sCepDestino", "72594235"));

        SoapService soap = new SoapService(url);
        String soapAction = soap.getSoapAction(operation);
        String targetNamespace1 = soap.getTargetNamespace();
        //soap.getOutputMessage(operation);
        //soap.ResponseXml(operation, parameters);

        String xPathTable = "/soap:Envelope/soap:Body/CalcPrazoResponse/CalcPrazoResult/Servicos";
         String[] xpathColumns= {
             "/soap:Envelope/soap:Body/CalcPrazoResponse/CalcPrazoResult/Servicos/cServico/Codigo",
             "/soap:Envelope/soap:Body/CalcPrazoResponse/CalcPrazoResult/Servicos/cServico/PrazoEntrega",
             "/soap:Envelope/soap:Body/CalcPrazoResponse/CalcPrazoResult/Servicos/cServico/EntregaDomiciliar"};
        soap.factoryResult(operation, parameters, xPathTable, xpathColumns);
        
        
//        String url = "http://www.camara.gov.br/SitCamaraWS/Proposicoes.asmx?WSDL";
//        List parameters = new ArrayList<>();
//
//        String operation = "ListarSituacoesProposicao";
//        
//
//        SoapService soap = new SoapService(url);
//        String soapAction = soap.getSoapAction(operation);
//        String targetNamespace1 = soap.getTargetNamespace();
//        //soap.getOutputMessage(operation);
//        //soap.ResponseXml(operation, parameters);
//
//        String xPathTable = "/soap:Envelope/soap:Body/ListarSituacoesProposicaoResponse/ListarSituacoesProposicaoResult/situacaoProposicao/situacaoProposicao";
//         String[] xpathColumns= {
//             "/soap:Envelope/soap:Body/ListarSituacoesProposicaoResponse/ListarSituacoesProposicaoResult/situacaoProposicao/situacaoProposicao@id",
//            "/soap:Envelope/soap:Body/ListarSituacoesProposicaoResponse/ListarSituacoesProposicaoResult/situacaoProposicao/situacaoProposicao@descricao"
//         };
//        soap.factoryResult(operation, parameters, xPathTable, xpathColumns);
        
    }

    public List<Map<String, Object>> factoryResult(String operation, List<Parameters> parameters, String xPathTable, String[] xpathColumns) throws Exception {

        String result = ResponseXml(operation, parameters);

//        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//        InputSource is = new InputSource();
//        is.setCharacterStream(new StringReader(result));
//
//        Document doc = db.parse(is);

        XmlSaxTableDef tableDef = new XmlSaxTableDef(
                xPathTable,
                xpathColumns);
        
        Resource resource = new InMemoryResource(null, result.getBytes(), 0);
        DataContext dc = new XmlSaxDataContext(resource, tableDef);


        String[] tableNames = dc.getDefaultSchema().getTableNames();
        
        for (String schemaName : tableNames) {
            System.out.println("----------------"+ schemaName);
        }
        
        //Table table = dc.getDefaultSchema().getTableByName("/situacaoProposicao");
        Table table = dc.getDefaultSchema().getTableByName(tableNames[0]);
        
        
  
        
//        for (Column Columns : table.getColumns()) {
//             logger.info(Columns.getName());
//        }

        Column[] columns = table.getColumns();
        
        String stringColumns = " ";
        for(Column row : columns){
           stringColumns += row.getName()+ " - ";
        }
        logger.log(Level.WARNING, "Columns: {0}", stringColumns);
        
        Query query = dc.query()
                .from(table)
                .select(columns)
                .toQuery();

        
        
        DataSet dataSet = dc.executeQuery(query);
        
        List<Map<String, Object>> Obj = new ArrayList<>();
        
        for (Row row : dataSet) {
            Object[] values = row.getValues();
            Map<String, Object> object = new HashMap<>(row.size());
            for (int i = 0; i < values.length; i++) {
                Object value = values[i];
                object.put(columns[i].getName(), value);
            }
            Obj.add(object);
        }
        
        return Obj;
        
//        for (Row row : dc.executeQuery(query)) {
//            
//            for (int i = 0; i < row.size(); i++) {
//                //logger.info(row.getValue(i).toString());
//                 System.out.println(row.getValue(i).toString());
//            }
//           
//        }
    }

//     public void getPortTypeMessage() throws XPathExpressionException{
//        XPathExpression xInputMessage = factory.newXPath().compile(xpathInputMessage.replace(VAR, "ListarSiglasTipoProposicao"));
//        String inputMessage = (String) xInputMessage.evaluate(document, XPathConstants.STRING);
//        
//         System.out.println("Primeiro parametro da resposta do xml --inputMessage: " + inputMessage);
//        
//        XPathExpression xMessageInteface = factory.newXPath().compile(xpathMessageInteface.replace(NAMESPACE, inputMessage));
//        String messageInteface = (String) xMessageInteface.evaluate(document, XPathConstants.STRING);
//      
//             System.out.println("messageInteface: " + messageInteface);
//            
//            System.out.println(xpathInputMessage.replace("%var", "CalcPrazo"));
//            System.out.println(xpathMessageInteface.replace(NAMESPACE, inputMessage));
//    }
}
