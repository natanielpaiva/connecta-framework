package br.com.cds.connecta.framework.connector2.context.soap;

import br.com.cds.connecta.framework.connector2.common.Base;
import br.com.cds.connecta.framework.connector2.common.ConnectorColumn;
import br.com.cds.connecta.framework.connector2.common.ContextFactory;
import com.ibm.wsdl.util.xml.DOM2Writer;
import com.predic8.policy.Policy;
import com.predic8.schema.Attribute;
import com.predic8.schema.ComplexType;
import com.predic8.schema.Element;
import com.predic8.schema.Field;
import com.predic8.schema.Schema;
import static com.predic8.schema.Schema.STRING;
import com.predic8.schema.SchemaComponent;
import com.predic8.schema.Sequence;
import com.predic8.schema.TypeDefinition;
import com.predic8.schema.Unique;
import com.predic8.wsdl.AbstractSOAPBinding;
import com.predic8.wsdl.Binding;
import com.predic8.wsdl.BindingOperation;
import com.predic8.wsdl.Definitions;
import com.predic8.wsdl.Fault;
import com.predic8.wsdl.Import;
import com.predic8.wsdl.Input;
import com.predic8.wsdl.Message;
import com.predic8.wsdl.Operation;
import com.predic8.wsdl.Part;
import com.predic8.wsdl.Port;
import com.predic8.wsdl.PortType;
import com.predic8.wsdl.Service;
import com.predic8.wsdl.Types;
import com.predic8.wsdl.WSDLParser;
import com.predic8.wstool.creator.RequestCreator;
import com.predic8.wstool.creator.SOARequestCreator;
import groovy.xml.MarkupBuilder;
import groovy.xml.QName;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Table;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author diego
 */
public class SoapContextFactory extends Base implements ContextFactory {

    private String url;

    private Definitions defs;

    WSDLParser parser = new WSDLParser();

    private static final XPathFactory xpathFactory = XPathFactory.newInstance();

    public SoapContextFactory(String url) {
        this.url = url;
        defs = parser.parse(url);
    }

    public DataContext createDataContext() {
        return dataContext;
    }

    @Override
    public DataSet getResultAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConnectorColumn> getColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Table getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Column getColumn(String columnName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Lista as operações do Soap
     *
     * @return
     */
    public SoapOperation getOperationsSoap() {
        SoapOperation operation = new SoapOperation();

        for (Operation op : defs.getPortTypes().get(0).getOperations()) {
            System.out.println(" Operation " + op.getName());
            operation.setOperation(op.getName());

            ArrayList<Parameters> paramters = getParamters(op.getName());
            operation.setParams(paramters);
        }
        return operation;
    }

    private String getActionOperation(String operation) {
//        Binding bnd = defs.getBindings().get(0);
//            out("  Binding Name: " + bnd.getName());
//            out("  Binding Type: " + bnd.getPortType().getName());
//            out("  Binding Protocol: " + bnd.getBinding().getProtocol());
//            out("  Binding Operations: ");
//            for (BindingOperation bop : bnd.getOperations()) {
//                out("    Operation Name: " + bop.getName());
//                if (bnd.getBinding() instanceof AbstractSOAPBinding) {
//                    out("    Operation SoapAction: " + bop.getOperation().getSoapAction());
//                    out("    SOAP Body Use: " + bop.getInput().getBindingElements().get(0).getUse());
//                }
//            }
//            out("");

        BindingOperation op = defs.getBindings().get(0).getOperation(operation);
        out("    Operation Name: " + op.getName());
        out("    Operation Soap Action: " + op.getOperation().getSoapAction());
        out("");
        return op.getOperation().getSoapAction();

    }

    public String createHeadPath(String operation) {

        PortType get = defs.getPortTypes().get(0);
        out(get.getOperation(operation).getName());
        String localName = get.getOperation(operation).getOutput().getMessage().getParts().get(0).getElementPN().getLocalName();
        out(localName);

        String attribute = getParamters(localName).get(0).getAttribute();

        return "/" + localName + "/" + attribute;

    }

    public ArrayList<Parameters> getParamters(String operation) {
        String xpathValue = "/complexType/sequence/element/@name";
        String xpathType = "/complexType/sequence/element/@type";

        ArrayList<Parameters> params = new ArrayList<>();

        for (Schema schema : defs.getSchemas()) {
            Element element = schema.getElement(operation);
            String xml = element.getEmbeddedType().getAsString();

            InputSource source = new InputSource(new StringReader(xml));

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = null;
            Document document = null;
            NodeList listValue = null;
            NodeList listType = null;

            try {
                db = dbf.newDocumentBuilder();
                document = db.parse(source);

                listValue = (NodeList) xpathFactory.newXPath().compile(xpathValue).evaluate(document, XPathConstants.NODESET);
                listType = (NodeList) xpathFactory.newXPath().compile(xpathType).evaluate(document, XPathConstants.NODESET);
            } catch (SAXException | IOException | ParserConfigurationException | XPathExpressionException ex) {
                Logger.getLogger(SoapContextFactory.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int i = 0; i < listValue.getLength(); i++) {
                Parameters param = new Parameters();
                param.setAttribute(listValue.item(i).getNodeValue());
                param.setType(listType.item(i).getNodeValue().replace("\"", "").split(":")[1]);
                out(" Atributo " + listValue.item(i).getNodeValue() + " Tipe: " + listType.item(i).getNodeValue().replace("\"", "").split(":")[1]);
                params.add(param);
            }
        }
        return params;
    }

    public void sendSoap(String operation, ArrayList<Parameters> parameters) {
        try {
            //Criando Connection SOAP
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            //String url = "http://ws.cdyne.com/emailverify/Emailvernotestemail.asmx";
            SOAPMessage createSOAPRequest = createSOAPRequest(operation, parameters);

            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest, this.url);

            // Process the SOAP Response
            SOAPPart soapPart = soapResponse.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            Node firstChild = envelope.getBody().getFirstChild().getFirstChild();

            StringWriter sw = new StringWriter();
            try {
                Transformer t = TransformerFactory.newInstance().newTransformer();
                t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                t.transform(new DOMSource(firstChild), new StreamResult(sw));
            } catch (TransformerException te) {
                System.out.println("nodeToString Transformer Exception");
            }
            out("ddddddddd" + sw.toString());

            String xml = converterSOAPMessage(soapResponse);

            String path = createHeadPath(operation);

            applyHeadPath(xml, path);

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
        }
    }

    private void applyHeadPath(String xml, String path) throws XPathExpressionException {
        String xpathHead = "/Envelope/Body" + path + "/text()";
        out(xpathHead);
        InputSource source = new InputSource(new StringReader(xml));

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        Document document = null;

        try {
            db = dbf.newDocumentBuilder();
            document = db.parse(source);
            //String evaluate = xpathFactory.newXPath().compile(xpathHead).evaluate(document, XPathConstants.NODESET).toString();
            Object evaluate = xpathFactory.newXPath().compile(xpathHead).evaluate(document, XPathConstants.STRING);
            out(evaluate.toString());

        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(SoapContextFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private SOAPMessage createSOAPRequest(String operation, ArrayList<Parameters> parameters) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = defs.getTargetNamespace();

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("cds", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement(operation, "cds");

        for (Parameters p : parameters) {
            out("   Attributes: " + p.getAttribute() + " = Value: " + p.getValue());
            soapBodyElem.addChildElement(p.getAttribute(), "cds").addTextNode(p.getValue());
        }

//        soapBodyElem.addChildElement("email", "example").addTextNode("mutantninja@gmail.com");
//        soapBodyElem.addChildElement("LicenseKey", "example").addTextNode("123");
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + operation);
        out("SOAPAction " + serverURI + operation);

        soapMessage.saveChanges();
        soapMessage.getSOAPPart().getContent();

        /* Print the request message */
        converterSOAPMessage(soapMessage);

        return soapMessage;

    }

    /**
     * Method used to print the SOAP Response
     */
    private String converterSOAPMessage(SOAPMessage soapResponse) throws Exception {
        String strResult = null;
        try {
            //soapResponse.getSOAPBody().getAttributes().getNamedItem("soap:Body");

            Source sourceContent = soapResponse.getSOAPPart().getContent();
            //StreamSource source = new StreamSource(new StringReader("<xml>blabla</xml>"));
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.transform(sourceContent, result);
            strResult = writer.toString();
            out("\n");
            out("Super resposta: " + strResult);
        } catch (Exception e) {
        }
        return strResult;
    }

//    public void applying(String xml) {
//        String xpathValue = "/complexType/sequence/element/@name";
//        String xpathType = "/complexType/sequence/element/@type";
//
//        InputSource source = new InputSource(new StringReader(xml));
//
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = null;
//        Document document = null;
//        NodeList listValue = null;
//        NodeList listType = null;
//
//        try {
//            db = dbf.newDocumentBuilder();
//            document = db.parse(source);
//
//            listValue = (NodeList) xpathFactory.newXPath().compile(xpathValue).evaluate(document, XPathConstants.NODESET);
//            listType = (NodeList) xpathFactory.newXPath().compile(xpathType).evaluate(document, XPathConstants.NODESET);
//        } catch (SAXException ex) {
//            Logger.getLogger(SoapContextFactory.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(SoapContextFactory.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParserConfigurationException ex) {
//            Logger.getLogger(SoapContextFactory.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (XPathExpressionException ex) {
//            Logger.getLogger(SoapContextFactory.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        for (int i = 0; i < listValue.getLength(); i++) {
//            out(listType.item(i).getNodeValue().replace("\"", "").split(":")[1]);
//            out(listValue.item(i).getNodeValue());
//            out(listValue.item(i).getTextContent());
//            out(listValue.item(i).getNamespaceURI());
//            out(listValue.item(i).getTextContent());
//            out(listValue.item(i).getPrefix());
//            out(listValue.item(i).toString());
//
//            out("\n");
//        }
//
//    }
    public void sss() {
        List<Import> imports = defs.getImports();
        out("import");
        for (Import aImport : imports) {
            out(aImport.getElementName().toString());
        }

        out("service");
        List<Service> localServices = defs.getLocalServices();
        for (Service localService : localServices) {
            out(localService.getName());
            List<Port> ports = localService.getPorts();
            for (Port port : ports) {
                out(port.getName());
            }
        }

        out(" \n");
        out("port");
        List<PortType> localPortTypes = defs.getLocalPortTypes();
        for (PortType localPortType : localPortTypes) {
            out(localPortType.getQName().toString());
            List<Operation> operations = localPortType.getOperations();
            for (Operation operation : operations) {
                out("---" + operation.toString());

                //out("-----" + operation.getInput().getMessage().getParts().get(0).getElement().getEmbeddedType().getAnnotation());
                out("\n");
            }
        }

        out("\n");
//        out("mensage");
//        List<Message> messages = defs.getMessages();
//        for (Message message : messages) {
//            out("message.toString() " + message.toString());
//            out("message.getNamespaceUri() " + message.getNamespaceUri());
//            out("message.getPrefix() " + message.getPrefix());
//            out("message.getName() " + message.getName());
//            List<Part> parts = message.getParts();
//            for (Part part : parts) {
//                out("part.getElement().getAsJson()");
//                out((part.getElement().getAsJson() != null) ? part.getElement().getAsJson() : "######################" );
//                Element element = part.getElement();
//                out("element.getName()" + element.getName());
//                out("element.getPrefix()" + element.getPrefix());
//                out("element.getPrefix()" + element.toString());
//                out("element.getPrefix()" + element.getBuildInTypeName());
//                out("element.getPrefix()" + element.getFixedValue());
//                out("element.getPrefix()" + element.getMaxOccurs());
//                out("element.getPrefix()" + element.getMinOccurs());
//                out("element.getPrefix()" + element.getForm());
//                out("element.getPrefix()" + element.getName());
//                out("element.getPrefix()" + element.getName());
//            }
//            out("--------------------");
//        }

        out("Bindings: ");
        for (Binding bnd : defs.getBindings()) {
            out("  Binding Name: " + bnd.getName());
            out("  Binding Type: " + bnd.getPortType().getName());
            out("  Binding Protocol: " + bnd.getBinding().getProtocol());
            if (bnd.getBinding() instanceof AbstractSOAPBinding) {
                out("  Style: " + (((AbstractSOAPBinding) bnd.getBinding()).getStyle()));
            }
            out("  Binding Operations: ");
            for (BindingOperation bop : bnd.getOperations()) {
                out("    Operation Name: " + bop.getName());
                if (bnd.getBinding() instanceof AbstractSOAPBinding) {
                    out("    Operation SoapAction: " + bop.getOperation().getSoapAction());
                    out("    SOAP Body Use: " + bop.getInput().getBindingElements().get(0).getUse());
                }
            }
            out("");
        }

        out("");
        out("Services: ");
        for (Service service : defs.getServices()) {
            out("  Service Name: " + service.getName());
            out("  Service Potrs: ");
            for (Port port : service.getPorts()) {
                out("    Port Name: " + port.getName());
                out("    Port Binding: " + port.getBinding().getName());
                out("    Port Address Location: " + port.getAddress().getLocation()
                        + "\n");
            }
        }
        out("");

        out("Messages: ");
        for (Message msg : defs.getMessages()) {
            out("  Message Name: " + msg.getName());
            out("  Message Parts: ");
            for (Part part : msg.getParts()) {
                out("    Part Name: " + part.getName());
                out("    Part Element: " + ((part.getElement() != null) ? part.getElement() : "not available!"));
                out("    Part Type: " + ((part.getType() != null) ? part.getType() : "not available!"));
                out("");
            }
        }
        out("");

        out("  Schema Elements: ");

//        List<Operation> operations = defs.getOperations();
//        for (Operation operation : operations) {
//            Message message = operation.getInput().getMessage();
//            List<Part> parts = message.getParts();
//            for (Part part : parts) {
//                Element element = part.getElement();
//                //out("** "  + element.getTypeQName("VerifyMXRecord").toString());
//                
//               
//                out(part.getElementPN().getLocalName());
//                out(part.getElementPN().getPrefix());
//                out(part.getElementPN().toString());
//                
//            }
//        }
        out("----paoisdu faiudf auhdfiaj hdflkjad hflkajdhfla-");

        for (Schema schema : defs.getSchemas()) {
            for (Element e : schema.getElements()) {
                out("----- Element Name: " + e.getName());
                out(e.getEmbeddedType().getAsString());

                e.getEmbeddedType();

                if (e.getType() != null) {
                    out("-------- Element Type Name: " + schema.getType(e.getType()).getName());
                    out("-------- Element minoccurs: " + e.getMinOccurs());
                    out("-------- Element maxoccurs: " + e.getMaxOccurs());
                }
                out("");
            }
        }

        out("");

//        List<Types> types = defs.getTypes();
//        for (Types type : types) {
//            List<Schema> allSchemas = type.getAllSchemas();
//            for (Schema allSchema : allSchemas) {
//                out("-- " + allSchema.getElementFormDefault());
//                List<Element> elements = allSchema.getElements();
//                for (Element element : elements) {
//                    out("---" + element.getName());
//                    out("---" + element.getPrefix());
//                    ComplexType newComplexType = element.newComplexType();
//                    SchemaComponent model = newComplexType.getModel();
//                    
//                }
//                out("\n");
//                
////                out(allSchema.getElement("VerifyEmail").toString());
////                out(allSchema.getElement("VerifyEmail").getEmbeddedType().getAllAttributes().toString());
////                out(allSchema.getElement("VerifyEmail").getAsJson());
////                TypeDefinition embeddedType = allSchema.getElement("VerifyEmail").getEmbeddedType();
////                List<Attribute> allAttributes = embeddedType.getAllAttributes();
////                for (Attribute allAttribute : allAttributes) {
////                    out(allAttribute.getName());
////                }
////                
////                List<ComplexType> complexTypes = allSchema.getComplexTypes();
////                for (ComplexType complexType : complexTypes) {
////                   out( complexType.toString());
////                }
//            }
//        }
    }

    private static void out(String str) {
        System.out.println(str);
    }

}
