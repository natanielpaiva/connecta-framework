
package br.com.cds.connecta.framework.connector.obiee;

import br.com.cds.connecta.framework.connector.obiee.CatalogItemsFilter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flag" type="{urn://oracle.bi.webservices/v6}ImportFlags"/>
 *         &lt;element name="lastPurgedLog" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="updateReplicationLog" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="returnErrors" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="filter" type="{urn://oracle.bi.webservices/v6}CatalogItemsFilter"/>
 *         &lt;element name="pathMap" type="{urn://oracle.bi.webservices/v6}PathMap"/>
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "filename",
    "flag",
    "lastPurgedLog",
    "updateReplicationLog",
    "returnErrors",
    "filter",
    "pathMap",
    "sessionID"
})
@XmlRootElement(name = "import")
public class Import {

    @XmlElement(required = true)
    protected String filename;
    @XmlElement(required = true)
    protected ImportFlags flag;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastPurgedLog;
    protected boolean updateReplicationLog;
    protected boolean returnErrors;
    @XmlElement(required = true, nillable = true)
    protected CatalogItemsFilter filter;
    @XmlElement(required = true, nillable = true)
    protected PathMap pathMap;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Obtém o valor da propriedade filename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Define o valor da propriedade filename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilename(String value) {
        this.filename = value;
    }

    /**
     * Obtém o valor da propriedade flag.
     * 
     * @return
     *     possible object is
     *     {@link ImportFlags }
     *     
     */
    public ImportFlags getFlag() {
        return flag;
    }

    /**
     * Define o valor da propriedade flag.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportFlags }
     *     
     */
    public void setFlag(ImportFlags value) {
        this.flag = value;
    }

    /**
     * Obtém o valor da propriedade lastPurgedLog.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastPurgedLog() {
        return lastPurgedLog;
    }

    /**
     * Define o valor da propriedade lastPurgedLog.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastPurgedLog(XMLGregorianCalendar value) {
        this.lastPurgedLog = value;
    }

    /**
     * Obtém o valor da propriedade updateReplicationLog.
     * 
     */
    public boolean isUpdateReplicationLog() {
        return updateReplicationLog;
    }

    /**
     * Define o valor da propriedade updateReplicationLog.
     * 
     */
    public void setUpdateReplicationLog(boolean value) {
        this.updateReplicationLog = value;
    }

    /**
     * Obtém o valor da propriedade returnErrors.
     * 
     */
    public boolean isReturnErrors() {
        return returnErrors;
    }

    /**
     * Define o valor da propriedade returnErrors.
     * 
     */
    public void setReturnErrors(boolean value) {
        this.returnErrors = value;
    }

    /**
     * Obtém o valor da propriedade filter.
     * 
     * @return
     *     possible object is
     *     {@link CatalogItemsFilter }
     *     
     */
    public CatalogItemsFilter getFilter() {
        return filter;
    }

    /**
     * Define o valor da propriedade filter.
     * 
     * @param value
     *     allowed object is
     *     {@link CatalogItemsFilter }
     *     
     */
    public void setFilter(CatalogItemsFilter value) {
        this.filter = value;
    }

    /**
     * Obtém o valor da propriedade pathMap.
     * 
     * @return
     *     possible object is
     *     {@link PathMap }
     *     
     */
    public PathMap getPathMap() {
        return pathMap;
    }

    /**
     * Define o valor da propriedade pathMap.
     * 
     * @param value
     *     allowed object is
     *     {@link PathMap }
     *     
     */
    public void setPathMap(PathMap value) {
        this.pathMap = value;
    }

    /**
     * Obtém o valor da propriedade sessionID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionID() {
        return sessionID;
    }

    /**
     * Define o valor da propriedade sessionID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionID(String value) {
        this.sessionID = value;
    }

}
