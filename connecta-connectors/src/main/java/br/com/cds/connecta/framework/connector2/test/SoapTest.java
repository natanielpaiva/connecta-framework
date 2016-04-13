package br.com.cds.connecta.framework.connector2.test;

import br.com.cds.connecta.framework.connector2.context.soap.Parameters;
import br.com.cds.connecta.framework.connector2.context.soap.SoapContextFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;


/**
 *
 * @author diego
 */
public class SoapTest {
    public static void main(String args[]) throws ParserConfigurationException, XPathExpressionException, SAXException, IOException {
    
        SoapContextFactory soapContextFactory = new SoapContextFactory("http://ws.cdyne.com/emailverify/Emailvernotestemail.asmx?WSDL");
        //SoapContextFactory soapContextFactory = new SoapContextFactory("http://www.camara.gov.br/SitCamaraWS/Proposicoes.asmx?wsdl");
       // SoapContextFactory soapContextFactory = new SoapContextFactory("http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx?WSDL");
        //soapContextFactory.getOperationsSoap();
        //soapContextFactory.getParamters("VerifyMXRecord");
        //soapContextFactory.getParamters("ObterVotacaoProposicao");
        //soapContextFactory.getActionOperation("ObterVotacaoProposicao");
        //soapContextFactory.getActionOperation("VerifyMXRecord");
        
       // soapContextFactory.sss();

        
//         
        ArrayList<Parameters> parameters = new ArrayList<>();
        parameters.add(new Parameters("email", "mutantninja@gmail.com") );
        parameters.add(new Parameters("LicenseKey", "123"));
        
        soapContextFactory.sendSoap("VerifyEmail", parameters);
//        
        
        
        
        //String url = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx?WSDL";
        String operation = "CalcPrazo";
        ArrayList<Parameters> parametersCorreio = new ArrayList<>();
        parametersCorreio.add(new Parameters("nCdServico",  "41106"));
        parametersCorreio.add(new Parameters("sCepOrigem", "64002150"));
        parametersCorreio.add(new Parameters("sCepDestino", "72594235"));
        
        //soapContextFactory.sendSoap("CalcPrazo", parametersCorreio);
        //soapContextFactory.getOutOperation("CalcPrazo");
        
    }
}

//        List parameters = new ArrayList<>();
//        parameters.add(new Parameters("nCdServico", "41106", "s:string"));
//        parameters.add(new Parameters("sCepOrigem", "64002150", "s:string"));
//        parameters.add(new Parameters("sCepDestino", "72594235", "s:string"));