
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
 *         &lt;element name="createIfNotExists" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="createIntermediateDirs" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "createIfNotExists",
    "createIntermediateDirs",
    "sessionID"
})
@XmlRootElement(name = "createFolder")
public class CreateFolder {

    @XmlElement(required = true)
    protected String path;
    protected boolean createIfNotExists;
    protected boolean createIntermediateDirs;
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
     * Obtém o valor da propriedade createIfNotExists.
     * 
     */
    public boolean isCreateIfNotExists() {
        return createIfNotExists;
    }

    /**
     * Define o valor da propriedade createIfNotExists.
     * 
     */
    public void setCreateIfNotExists(boolean value) {
        this.createIfNotExists = value;
    }

    /**
     * Obtém o valor da propriedade createIntermediateDirs.
     * 
     */
    public boolean isCreateIntermediateDirs() {
        return createIntermediateDirs;
    }

    /**
     * Define o valor da propriedade createIntermediateDirs.
     * 
     */
    public void setCreateIntermediateDirs(boolean value) {
        this.createIntermediateDirs = value;
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
