
package br.com.cds.connecta.framework.connector.obiee;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6b21 
 * Generated source version: 2.0
 * 
 */
@WebServiceClient(name = "SecurityService", targetNamespace = "urn://oracle.bi.webservices/v6", wsdlLocation = "http://bivm1:9704/analytics/saw.dll?WSDL")
public class SecurityService
    extends Service
{

    private final static URL SECURITYSERVICE_WSDL_LOCATION;
    private final static WebServiceException SECURITYSERVICE_EXCEPTION;
    private final static QName SECURITYSERVICE_QNAME = new QName("urn://oracle.bi.webservices/v6", "SecurityService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://bivm1:9704/analytics/saw.dll?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SECURITYSERVICE_WSDL_LOCATION = url;
        SECURITYSERVICE_EXCEPTION = e;
    }

    public SecurityService() {
        super(__getWsdlLocation(), SECURITYSERVICE_QNAME);
    }

    public SecurityService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns SecurityServiceSoap
     */
    @WebEndpoint(name = "SecurityServiceSoap")
    public SecurityServiceSoap getSecurityServiceSoap() {
        return super.getPort(new QName("urn://oracle.bi.webservices/v6", "SecurityServiceSoap"), SecurityServiceSoap.class);
    }

    private static URL __getWsdlLocation() {
        if (SECURITYSERVICE_EXCEPTION!= null) {
            throw SECURITYSERVICE_EXCEPTION;
        }
        return SECURITYSERVICE_WSDL_LOCATION;
    }

}
