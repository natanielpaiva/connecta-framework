
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
 *         &lt;element name="pathSrc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pathDest" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flagACL" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "pathSrc",
    "pathDest",
    "flagACL",
    "sessionID"
})
@XmlRootElement(name = "copyItem")
public class CopyItem {

    @XmlElement(required = true)
    protected String pathSrc;
    @XmlElement(required = true)
    protected String pathDest;
    protected int flagACL;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Obtém o valor da propriedade pathSrc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathSrc() {
        return pathSrc;
    }

    /**
     * Define o valor da propriedade pathSrc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathSrc(String value) {
        this.pathSrc = value;
    }

    /**
     * Obtém o valor da propriedade pathDest.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathDest() {
        return pathDest;
    }

    /**
     * Define o valor da propriedade pathDest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathDest(String value) {
        this.pathDest = value;
    }

    /**
     * Obtém o valor da propriedade flagACL.
     * 
     */
    public int getFlagACL() {
        return flagACL;
    }

    /**
     * Define o valor da propriedade flagACL.
     * 
     */
    public void setFlagACL(int value) {
        this.flagACL = value;
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
