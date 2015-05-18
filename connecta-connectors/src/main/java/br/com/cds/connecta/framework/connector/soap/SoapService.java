package br.com.cds.connecta.framework.connector.soap;

import br.com.cds.connecta.framework.connector.soap.service.Operation;
import br.com.cds.connecta.framework.connector.soap.service.Parameters;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author diego
 */
public class SoapService {

    private static final XPathFactory factory = XPathFactory.newInstance();
    private static final String xpathElements = "/definitions/types/schema/element/@name";
    private static final String xpathElementColumns = "/definitions/types/schema/element[@name='%s']/complexType/sequence/element/@name";
    private static final String xpathElementType = "/definitions/types/schema/element[@name='%s']/complexType/sequence/element/@type";

    private static final String xpathOperations = "/definitions/binding[1]/operation/@name";

    public ArrayList<Operation> getMethods(String Url) throws MalformedURLException, ParserConfigurationException, SAXException, IOException, XPathExpressionException {

        URL url = new URL(Url);
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url.openStream());

        XPathExpression findOperations = factory.newXPath().compile(xpathOperations);
        NodeList list = (NodeList) findOperations.evaluate(document, XPathConstants.NODESET);

        ArrayList<Operation> operations = new ArrayList<>();
        for (int i = 0; i < list.getLength(); i++) {
            Node item = list.item(i);

            Operation operation = new Operation();
            operation.setMethod(item.getNodeValue());

            System.out.println("METODO: " + item.getNodeValue());

            XPathExpression findElementColumns = factory.newXPath().compile(String.format(xpathElementColumns, item.getNodeValue()));
            XPathExpression findElementType = factory.newXPath().compile(String.format(xpathElementType, item.getNodeValue()));

            NodeList columnList = (NodeList) findElementColumns.evaluate(document, XPathConstants.NODESET);
            NodeList typeList = (NodeList) findElementType.evaluate(document, XPathConstants.NODESET);

            ArrayList<Parameters> parameters = new ArrayList<>();
            for (int j = 0; j < columnList.getLength(); j++) {

                Parameters parameter = new Parameters();

                Node column = columnList.item(j);
                Node type = typeList.item(j);
                String typeParame = null;

                if (type != null) {
                    typeParame = type.getNodeValue();

                } else {
                    typeParame = "null";
                }

                parameter.setAttributes(column.getNodeValue());
                parameter.setType(typeParame);

                parameters.add(parameter);
                System.out.println("-- ATTRIBUTO: " + column.getNodeValue() + " Parame --- " + typeParame);
            }

            operation.setParams(parameters);
            operations.add(operation);
        }

        return operations;
    }
    
    
    public void executeOperation(){
        
        
        
    }
    
    

}
