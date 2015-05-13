
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
 *         &lt;element name="pageID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pageReportID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "pageID",
    "pageReportID",
    "sessionID"
})
@XmlRootElement(name = "getHtmlForReport")
public class GetHtmlForReport {

    @XmlElement(required = true)
    protected String pageID;
    @XmlElement(required = true)
    protected String pageReportID;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Obtém o valor da propriedade pageID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageID() {
        return pageID;
    }

    /**
     * Define o valor da propriedade pageID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageID(String value) {
        this.pageID = value;
    }

    /**
     * Obtém o valor da propriedade pageReportID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageReportID() {
        return pageReportID;
    }

    /**
     * Define o valor da propriedade pageReportID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageReportID(String value) {
        this.pageReportID = value;
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
