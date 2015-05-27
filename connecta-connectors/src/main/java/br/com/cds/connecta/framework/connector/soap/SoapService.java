package br.com.cds.connecta.framework.connector.soap;

import br.com.cds.connecta.framework.connector.soap.*;
import br.com.cds.connecta.framework.connector.soap.service.Operation;
import br.com.cds.connecta.framework.connector.soap.service.Parameters;
import br.com.cds.connecta.framework.connector.soap.service.Param;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
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
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author diego
 */
public class SoapService {
    
    
     public static String NAMESPACE = "%var";
    
    private static final XPathFactory xpathFactory = XPathFactory.newInstance();
    
    //Operation
    private static final String xpathOperations = "/definitions/binding[1]/operation/@name";
    //soapAction
    private static final String xpathSoapAction = "/definitions/binding[1]/operation[@name='%var']/operation/@soapAction";
    //private static final String xpathSoapAction = "/definitions/binding[1]/operation/operation/@soapAction";
    
    private static final String xpathTargetNamespace = "/definitions/@targetNamespace";
    
    //portType
    private static final String xpathInputMessage = "substring-after(/definitions/portType[1]/operation[@name='%var']/output/@message, ':')";
    private static final String xpathMessageInteface = "substring-after(/definitions/message[@name='%var']/part/@element, ':')";
    
    private static final String xpathElementColumns = "/definitions/types/schema/element[@name='%s']/complexType/sequence/element/@name";
    private static final String xpathElementType =    "/definitions/types/schema/element[@name='%s']/complexType/sequence/element/@type";
    
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

    public SoapService(String endpoint) {
        this.endpoint = endpoint;
        try {
            URL url = new URL(endpoint);
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url.openStream());
            
            XPathExpression findTargetNamespace = xpathFactory.newXPath().compile(xpathTargetNamespace);
            targetNamespace = (String) findTargetNamespace.evaluate(document, XPathConstants.STRING);
       
            System.out.println("---->>targetNamespace: " + targetNamespace);
            
        } catch (Exception e) {
        }
    }
    
    //ok
    public String getSoapAction(String operation) throws XPathExpressionException {
        
        XPathExpression findSoapAction = xpathFactory.newXPath().compile(xpathSoapAction.replace(NAMESPACE, operation));
         soapAction = (String) findSoapAction.evaluate(document, XPathConstants.STRING);
//       
//       System.out.println("SoapAction: " + xpathSoapAction);
//       System.out.println("xpathSoapAction: " + soapAction);
       
       return soapAction;
    }
    
    //ok
    public ArrayList getOperation() throws XPathExpressionException{
        
        XPathExpression findElements = xpathFactory.newXPath().compile(xpathOperations);
        NodeList list = (NodeList) findElements.evaluate(document, XPathConstants.NODESET);
        
        ArrayList<Operation> operations = new ArrayList<>();
        
        for (int i = 0; i < list.getLength(); i++) {
           Node item = list.item(i);
            
            Operation operation = new Operation();
            operation.setOperation(item.getNodeValue());
            
            System.out.println("xxMETODO: "+item.getNodeValue() );
            
            XPathExpression findElementColumns = xpathFactory.newXPath().compile(String.format(xpathElementColumns, item.getNodeValue()));
            XPathExpression findElementType = xpathFactory.newXPath().compile(String.format(xpathElementType, item.getNodeValue()));
            
            NodeList columnList = (NodeList) findElementColumns.evaluate(document, XPathConstants.NODESET);
            NodeList typeList = (NodeList) findElementType.evaluate(document, XPathConstants.NODESET);
            
           ArrayList<Param> params = new ArrayList<>();
            for (int j = 0; j < columnList.getLength(); j++) {
               Param param = new Param();
              
                Node column = columnList.item(j);
                Node type =   typeList.item(j);
                String typeParame = null;
                
                if(type != null){
                    typeParame = type.getNodeValue();
                    
                } else {
                    typeParame =  "null";
                }
                 param.setAttributes(column.getNodeValue());
                 param.setType(typeParame);
                
                 params.add(param);
                 System.out.println("-- ATTRIBUTO: "+column.getNodeValue() + " Parame --- "+  typeParame);
            }
            operation.setParams(params);
            operations.add(operation);
        }
        
        return operations;
    }
       
   
    public String ResponseXml(String operation, List<Parameters> parameters) throws SOAPException, IOException, XPathExpressionException {
        
          //Getting a SOAPConnection Object
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = soapConnectionFactory.createConnection();

            // Creating a message
            MessageFactory factory = MessageFactory.newInstance();
            SOAPMessage messageBody = factory.createMessage();
            SOAPPart soapPart = messageBody.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration(operation, targetNamespace);
System.out.println("######## operation: "+ operation  + " soapAction "+  this.getSoapAction(operation) );
            
            SOAPBody soapBody = envelope.getBody();

            QName bodyName = new QName(targetNamespace , operation);

            SOAPElement soapBodyElem = soapBody.addChildElement(bodyName);

            for (Parameters p : parameters) {
                System.out.println("Attributes: "+ p.getAttributes()  + " ----" +  p.getValue() );
                QName nCdServico = new QName(targetNamespace, p.getAttributes(), "ggg");
                SOAPElement soapBodyElem1 = soapBodyElem.addChildElement(nCdServico);
                soapBodyElem1.addTextNode(p.getValue());
            }
            
            MimeHeaders headers = messageBody.getMimeHeaders();
            headers.addHeader("SOAPAction", soapAction);

            messageBody.writeTo(System.out);
            System.out.println("\n");

            final SOAPMessage response = connection.call(messageBody, endpoint);
            
            final StringWriter sw = new StringWriter();

            
            
            try {
                TransformerFactory.newInstance().newTransformer().transform(
                    new DOMSource(response.getSOAPPart()),
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
    
    
    
    public String getTargetNamespace() {
        return targetNamespace;
    }

    public void setTargetNamespace(String targetNamespace) {
        this.targetNamespace = targetNamespace;
    }
    
//     public void getPortTypeMessage() throws XPathExpressionException{
//        XPathExpression xInputMessage = factory.newXPath().compile(xpathInputMessage.replace(NAMESPACE, "ListarSiglasTipoProposicao"));
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
