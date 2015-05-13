
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
 *         &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mask" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resolveLinks" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="options" type="{urn://oracle.bi.webservices/v6}GetSubItemsParams"/>
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
    "path",
    "mask",
    "resolveLinks",
    "options",
    "sessionID"
})
@XmlRootElement(name = "getSubItems")
public class GetSubItems {

    @XmlElement(required = true)
    protected String path;
    @XmlElement(required = true)
    protected String mask;
    protected boolean resolveLinks;
    @XmlElement(required = true, nillable = true)
    protected GetSubItemsParams options;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Obtém o valor da propriedade path.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * Define o valor da propriedade path.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Obtém o valor da propriedade mask.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMask() {
        return mask;
    }

    /**
     * Define o valor da propriedade mask.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMask(String value) {
        this.mask = value;
    }

    /**
     * Obtém o valor da propriedade resolveLinks.
     * 
     */
    public boolean isResolveLinks() {
        return resolveLinks;
    }

    /**
     * Define o valor da propriedade resolveLinks.
     * 
     */
    public void setResolveLinks(boolean value) {
        this.resolveLinks = value;
    }

    /**
     * Obtém o valor da propriedade options.
     * 
     * @return
     *     possible object is
     *     {@link GetSubItemsParams }
     *     
     */
    public GetSubItemsParams getOptions() {
        return options;
    }

    /**
     * Define o valor da propriedade options.
     * 
     * @param value
     *     allowed object is
     *     {@link GetSubItemsParams }
     *     
     */
    public void setOptions(GetSubItemsParams value) {
        this.options = value;
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
