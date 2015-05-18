
package br.com.cds.connecta.framework.connector.obiee;

import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="recursive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="permissions" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="timestamps" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="useMtom" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "recursive",
    "permissions",
    "timestamps",
    "useMtom",
    "sessionID"
})
@XmlRootElement(name = "copyItem2")
public class CopyItem2 {

    @XmlElement(required = true)
    protected List<String> path;
    protected boolean recursive;
    protected boolean permissions;
    protected boolean timestamps;
    @XmlElement(defaultValue = "false")
    protected boolean useMtom;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Gets the value of the path property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the path property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPath().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPath() {
        if (path == null) {
            path = new ArrayList<String>();
        }
        return this.path;
    }

    /**
     * Obtém o valor da propriedade recursive.
     * 
     */
    public boolean isRecursive() {
        return recursive;
    }

    /**
     * Define o valor da propriedade recursive.
     * 
     */
    public void setRecursive(boolean value) {
        this.recursive = value;
    }

    /**
     * Obtém o valor da propriedade permissions.
     * 
     */
    public boolean isPermissions() {
        return permissions;
    }

    /**
     * Define o valor da propriedade permissions.
     * 
     */
    public void setPermissions(boolean value) {
        this.permissions = value;
    }

    /**
     * Obtém o valor da propriedade timestamps.
     * 
     */
    public boolean isTimestamps() {
        return timestamps;
    }

    /**
     * Define o valor da propriedade timestamps.
     * 
     */
    public void setTimestamps(boolean value) {
        this.timestamps = value;
    }

    /**
     * Obtém o valor da propriedade useMtom.
     * 
     */
    public boolean isUseMtom() {
        return useMtom;
    }

    /**
     * Define o valor da propriedade useMtom.
     * 
     */
    public void setUseMtom(boolean value) {
        this.useMtom = value;
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
