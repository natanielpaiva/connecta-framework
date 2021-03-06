
package br.com.cds.connecta.framework.connector.obiee;

import br.com.cds.connecta.framework.connector.obiee.CatalogObject;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6b21 
 * Generated source version: 2.0
 * 
 */
@WebService(name = "IBotServiceSoap", targetNamespace = "urn://oracle.bi.webservices/v6")
public interface IBotServiceSoap {


    /**
     * 
     * @param sessionID
     * @param path
     */
    @WebMethod(action = "#executeIBotNow")
    @RequestWrapper(localName = "executeIBotNow", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.ExecuteIBotNow")
    @ResponseWrapper(localName = "executeIBotNowResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.ExecuteIBotNowResult")
    public void executeIBotNow(
        @WebParam(name = "path", targetNamespace = "urn://oracle.bi.webservices/v6")
        String path,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param sessionID
     * @param resolveLinks
     * @param path
     * @param allowOverwrite
     * @param obj
     * @return
     *     returns int
     */
    @WebMethod(action = "#writeIBot")
    @WebResult(name = "jobID", targetNamespace = "urn://oracle.bi.webservices/v6")
    @RequestWrapper(localName = "writeIBot", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.WriteIBot")
    @ResponseWrapper(localName = "writeIBotResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.WriteIBotResult")
    public int writeIBot(
        @WebParam(name = "obj", targetNamespace = "urn://oracle.bi.webservices/v6")
        CatalogObject obj,
        @WebParam(name = "path", targetNamespace = "urn://oracle.bi.webservices/v6")
        String path,
        @WebParam(name = "resolveLinks", targetNamespace = "urn://oracle.bi.webservices/v6")
        boolean resolveLinks,
        @WebParam(name = "allowOverwrite", targetNamespace = "urn://oracle.bi.webservices/v6")
        boolean allowOverwrite,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param toPath
     * @param sessionID
     * @param resolveLinks
     * @param allowOverwrite
     * @param fromPath
     */
    @WebMethod(action = "#moveIBot")
    @RequestWrapper(localName = "moveIBot", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.MoveIBot")
    @ResponseWrapper(localName = "moveIBotResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.MoveIBotResult")
    public void moveIBot(
        @WebParam(name = "fromPath", targetNamespace = "urn://oracle.bi.webservices/v6")
        String fromPath,
        @WebParam(name = "toPath", targetNamespace = "urn://oracle.bi.webservices/v6")
        String toPath,
        @WebParam(name = "resolveLinks", targetNamespace = "urn://oracle.bi.webservices/v6")
        boolean resolveLinks,
        @WebParam(name = "allowOverwrite", targetNamespace = "urn://oracle.bi.webservices/v6")
        boolean allowOverwrite,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param sessionID
     * @param customizationXml
     * @param path
     */
    @WebMethod(action = "#subscribe")
    @RequestWrapper(localName = "subscribe", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.Subscribe")
    @ResponseWrapper(localName = "subscribeResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.SubscribeResult")
    public void subscribe(
        @WebParam(name = "path", targetNamespace = "urn://oracle.bi.webservices/v6")
        String path,
        @WebParam(name = "customizationXml", targetNamespace = "urn://oracle.bi.webservices/v6")
        String customizationXml,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param sessionID
     * @param path
     */
    @WebMethod(action = "#unsubscribe")
    @RequestWrapper(localName = "unsubscribe", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.Unsubscribe")
    @ResponseWrapper(localName = "unsubscribeResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.UnsubscribeResult")
    public void unsubscribe(
        @WebParam(name = "path", targetNamespace = "urn://oracle.bi.webservices/v6")
        String path,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param sessionID
     * @param path
     */
    @WebMethod(action = "#deleteIBot")
    @RequestWrapper(localName = "deleteIBot", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.DeleteIBot")
    @ResponseWrapper(localName = "deleteIBotResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.DeleteIBotResult")
    public void deleteIBot(
        @WebParam(name = "path", targetNamespace = "urn://oracle.bi.webservices/v6")
        String path,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param body
     * @param sessionID
     * @param priority
     * @param subject
     * @param group
     * @param recipient
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "#sendMessage")
    @WebResult(name = "status", targetNamespace = "urn://oracle.bi.webservices/v6")
    @RequestWrapper(localName = "sendMessage", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.SendMessage")
    @ResponseWrapper(localName = "sendMessageResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.SendMessageResult")
    public String sendMessage(
        @WebParam(name = "recipient", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<String> recipient,
        @WebParam(name = "group", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<String> group,
        @WebParam(name = "subject", targetNamespace = "urn://oracle.bi.webservices/v6")
        String subject,
        @WebParam(name = "body", targetNamespace = "urn://oracle.bi.webservices/v6")
        String body,
        @WebParam(name = "priority", targetNamespace = "urn://oracle.bi.webservices/v6")
        String priority,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

}
