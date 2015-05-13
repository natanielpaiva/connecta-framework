
package br.com.cds.connecta.framework.connector.obiee;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
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
 *         &lt;element name="archive" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="replacePath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="flagACL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="flagOverwrite" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "archive",
    "replacePath",
    "flagACL",
    "flagOverwrite",
    "sessionID"
})
@XmlRootElement(name = "pasteItem2")
public class PasteItem2 {

    @XmlElement(required = true)
    @XmlMimeType("application/obipsarchive")
    protected DataHandler archive;
    @XmlElement(required = true)
    protected String replacePath;
    protected int flagACL;
    protected int flagOverwrite;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Obtém o valor da propriedade archive.
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getArchive() {
        return archive;
    }

    /**
     * Define o valor da propriedade archive.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setArchive(DataHandler value) {
        this.archive = value;
    }

    /**
     * Obtém o valor da propriedade replacePath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplacePath() {
        return replacePath;
    }

    /**
     * Define o valor da propriedade replacePath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplacePath(String value) {
        this.replacePath = value;
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
     * Obtém o valor da propriedade flagOverwrite.
     * 
     */
    public int getFlagOverwrite() {
        return flagOverwrite;
    }

    /**
     * Define o valor da propriedade flagOverwrite.
     * 
     */
    public void setFlagOverwrite(int value) {
        this.flagOverwrite = value;
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
