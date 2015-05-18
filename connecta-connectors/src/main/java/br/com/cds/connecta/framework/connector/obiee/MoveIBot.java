
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
 *         &lt;element name="fromPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="resolveLinks" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="allowOverwrite" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "fromPath",
    "toPath",
    "resolveLinks",
    "allowOverwrite",
    "sessionID"
})
@XmlRootElement(name = "moveIBot")
public class MoveIBot {

    @XmlElement(required = true)
    protected String fromPath;
    @XmlElement(required = true)
    protected String toPath;
    protected boolean resolveLinks;
    protected boolean allowOverwrite;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Obtém o valor da propriedade fromPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromPath() {
        return fromPath;
    }

    /**
     * Define o valor da propriedade fromPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromPath(String value) {
        this.fromPath = value;
    }

    /**
     * Obtém o valor da propriedade toPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToPath() {
        return toPath;
    }

    /**
     * Define o valor da propriedade toPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToPath(String value) {
        this.toPath = value;
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
     * Obtém o valor da propriedade allowOverwrite.
     * 
     */
    public boolean isAllowOverwrite() {
        return allowOverwrite;
    }

    /**
     * Define o valor da propriedade allowOverwrite.
     * 
     */
    public void setAllowOverwrite(boolean value) {
        this.allowOverwrite = value;
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
