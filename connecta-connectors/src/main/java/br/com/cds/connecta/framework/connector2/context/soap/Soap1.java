/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.connector2.context.soap;
import com.predic8.wsdl.Definitions;
import com.predic8.wsdl.Operation;
import com.predic8.wsdl.Part;
import com.predic8.wsdl.PortType;
import com.predic8.wsdl.WSDLParser;
import static com.sforce.soap.partner.FieldType.url;

import org.apache.commons.httpclient.methods.GetMethod;
//http://www.programcreek.com/java-api-examples/index.php?api=javax.xml.soap.SOAPConnection

//verificar metodo desse link
//http://alvinalexander.com/java/jwarehouse/axis2-1.3/modules/saaj/test/org/apache/axis2/saaj/SOAPConnectionTest.java.shtml


//http://wsdlbrowser.com/soapclient?wsdl_url=http%3A%2F%2Fws.cdyne.com%2Femailverify%2FEmailvernotestemail.asmx%3Fwsdl

//https://groups.google.com/forum/#!topic/soa-model/OKQBRoY9H8I


//http://membrane-soa.org/parse-wsdl-java-api.htm

//https://www.predic8.com/wsdl-reading.htm

//http://www.membrane-soa.org/soa-model-doc/1.2/manipulate-wsdl-java-api.htm

//http://www.programcreek.com/java-api-examples/index.php?api=javax.xml.soap.SOAPConnection
/**
 *
 * @author diego
 */
public class Soap1 {
    
    public static void main(String[] args) {
        
        GetMethod method = new GetMethod("http://www.camara.gov.br/SitCamaraWS/Proposicoes.asmx?WSDL");
        
    WSDLParser parser = new WSDLParser();

    Definitions defs = parser
        //.parse("http://ws.cdyne.com/emailverify/Emailvernotestemail.asmx?wsdl");
        .parse("http://www.camara.gov.br/SitCamaraWS/Proposicoes.asmx?WSDL");

    for (PortType pt : defs.getPortTypes()) {
      System.out.println("* " + pt.getName());
      for (Operation op : pt.getOperations()) {
        System.out.println(" -" + op.getName());
        for(Part  part :  op.getInput().getMessage().getParts()) {
        	System.out.println(part.getName() + " " + part.getElement());
        }
        for(Part  part :  op.getOutput().getMessage().getParts()) {
        	System.out.println(part.getName() + " " + part.getElement());
        }
      }
    }
  }
    
}
