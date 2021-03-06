
package br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2;
//package com.endeca.endeca_server.manage._2;
import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "manageFault", targetNamespace = "http://www.endeca.com/endeca-server/manage/2/0")
public class ManageFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2._0.ManageFault faultInfo;
    /**
     * 
     * @param message
     * @param faultInfo
     */
    public ManageFault(String message, br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2._0.ManageFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public ManageFault(String message, br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2._0.ManageFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.endeca.endeca_server.manage._2._0.ManageFault
     */
    public br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2._0.ManageFault getFaultInfo() {
        return faultInfo;
    }

}
