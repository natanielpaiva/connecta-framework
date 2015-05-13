
package br.com.cds.connecta.framework.connector.obiee;

import br.com.cds.connecta.framework.connector.obiee.CatalogItemsFilter;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6b21 
 * Generated source version: 2.0
 * 
 */
@WebService(name = "ReplicationServiceSoap", targetNamespace = "urn://oracle.bi.webservices/v6")
public interface ReplicationServiceSoap {


    /**
     * 
     * @param sessionID
     * @param flag
     * @param exportSecurity
     * @param filename
     * @param filter
     */
    @WebMethod(action = "#export")
    @RequestWrapper(localName = "export", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.Export")
    @ResponseWrapper(localName = "exportResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.ExportResult")
    public void export(
        @WebParam(name = "filename", targetNamespace = "urn://oracle.bi.webservices/v6")
        String filename,
        @WebParam(name = "filter", targetNamespace = "urn://oracle.bi.webservices/v6")
        CatalogItemsFilter filter,
        @WebParam(name = "flag", targetNamespace = "urn://oracle.bi.webservices/v6")
        ExportFlags flag,
        @WebParam(name = "exportSecurity", targetNamespace = "urn://oracle.bi.webservices/v6")
        boolean exportSecurity,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * imports change log
     * 
     * @param updateReplicationLog
     * @param lastPurgedLog
     * @param pathMap
     * @param returnErrors
     * @param sessionID
     * @param flag
     * @param filename
     * @param filter
     * @return
     *     returns java.util.List<oracle.bi.web.soap.ImportError>
     */
    @WebMethod(operationName = "import", action = "#import")
    @WebResult(name = "error", targetNamespace = "urn://oracle.bi.webservices/v6")
    @RequestWrapper(localName = "import", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.Import")
    @ResponseWrapper(localName = "importResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.ImportResult")
    public List<ImportError> _import(
        @WebParam(name = "filename", targetNamespace = "urn://oracle.bi.webservices/v6")
        String filename,
        @WebParam(name = "flag", targetNamespace = "urn://oracle.bi.webservices/v6")
        ImportFlags flag,
        @WebParam(name = "lastPurgedLog", targetNamespace = "urn://oracle.bi.webservices/v6")
        XMLGregorianCalendar lastPurgedLog,
        @WebParam(name = "updateReplicationLog", targetNamespace = "urn://oracle.bi.webservices/v6")
        boolean updateReplicationLog,
        @WebParam(name = "returnErrors", targetNamespace = "urn://oracle.bi.webservices/v6")
        boolean returnErrors,
        @WebParam(name = "filter", targetNamespace = "urn://oracle.bi.webservices/v6")
        CatalogItemsFilter filter,
        @WebParam(name = "pathMap", targetNamespace = "urn://oracle.bi.webservices/v6")
        PathMap pathMap,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param sessionID
     * @param item
     * @param replicate
     */
    @WebMethod(action = "#markForReplication")
    @RequestWrapper(localName = "markForReplication", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.MarkForReplication")
    @ResponseWrapper(localName = "markForReplicationResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.MarkForReplicationResult")
    public void markForReplication(
        @WebParam(name = "item", targetNamespace = "urn://oracle.bi.webservices/v6")
        String item,
        @WebParam(name = "replicate", targetNamespace = "urn://oracle.bi.webservices/v6")
        boolean replicate,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

    /**
     * 
     * @param timestamp
     * @param sessionID
     * @param items
     */
    @WebMethod(action = "#purgeLog")
    @RequestWrapper(localName = "purgeLog", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.PurgeLog")
    @ResponseWrapper(localName = "purgeLogResult", targetNamespace = "urn://oracle.bi.webservices/v6", className = "oracle.bi.web.soap.PurgeLogResult")
    public void purgeLog(
        @WebParam(name = "items", targetNamespace = "urn://oracle.bi.webservices/v6")
        List<String> items,
        @WebParam(name = "timestamp", targetNamespace = "urn://oracle.bi.webservices/v6")
        XMLGregorianCalendar timestamp,
        @WebParam(name = "sessionID", targetNamespace = "urn://oracle.bi.webservices/v6")
        String sessionID);

}
