
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="filter" type="{urn://oracle.bi.webservices/v6}CatalogItemsFilter"/>
 *         &lt;element name="flag" type="{urn://oracle.bi.webservices/v6}ExportFlags"/>
 *         &lt;element name="exportSecurity" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "filter",
    "flag",
    "exportSecurity",
    "sessionID"
})
@XmlRootElement(name = "export")
public class Export {

    @XmlElement(required = true)
    protected String filename;
    @XmlElement(required = true)
    protected CatalogItemsFilter filter;
    @XmlElement(required = true)
    protected ExportFlags flag;
    @XmlElement(defaultValue = "true")
    protected boolean exportSecurity;
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
     * Obtém o valor da propriedade flag.
     * 
     * @return
     *     possible object is
     *     {@link ExportFlags }
     *     
     */
    public ExportFlags getFlag() {
        return flag;
    }

    /**
     * Define o valor da propriedade flag.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportFlags }
     *     
     */
    public void setFlag(ExportFlags value) {
        this.flag = value;
    }

    /**
     * Obtém o valor da propriedade exportSecurity.
     * 
     */
    public boolean isExportSecurity() {
        return exportSecurity;
    }

    /**
     * Define o valor da propriedade exportSecurity.
     * 
     */
    public void setExportSecurity(boolean value) {
        this.exportSecurity = value;
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
