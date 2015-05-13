
package br.com.cds.connecta.framework.connector.obiee;

import br.com.cds.connecta.framework.connector.obiee.ErrorDetailsLevel;
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
 *         &lt;element name="paths" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="resolveLinks" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="errorMode" type="{urn://oracle.bi.webservices/v6}ErrorDetailsLevel"/>
 *         &lt;element name="returnOptions" type="{urn://oracle.bi.webservices/v6}ReadObjectsReturnOptions"/>
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
    "paths",
    "resolveLinks",
    "errorMode",
    "returnOptions",
    "sessionID"
})
@XmlRootElement(name = "readObjects")
public class ReadObjects {

    protected List<String> paths;
    protected boolean resolveLinks;
    @XmlElement(required = true)
    protected ErrorDetailsLevel errorMode;
    @XmlElement(required = true)
    protected ReadObjectsReturnOptions returnOptions;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Gets the value of the paths property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paths property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaths().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPaths() {
        if (paths == null) {
            paths = new ArrayList<String>();
        }
        return this.paths;
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
     * Obtém o valor da propriedade errorMode.
     * 
     * @return
     *     possible object is
     *     {@link ErrorDetailsLevel }
     *     
     */
    public ErrorDetailsLevel getErrorMode() {
        return errorMode;
    }

    /**
     * Define o valor da propriedade errorMode.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorDetailsLevel }
     *     
     */
    public void setErrorMode(ErrorDetailsLevel value) {
        this.errorMode = value;
    }

    /**
     * Obtém o valor da propriedade returnOptions.
     * 
     * @return
     *     possible object is
     *     {@link ReadObjectsReturnOptions }
     *     
     */
    public ReadObjectsReturnOptions getReturnOptions() {
        return returnOptions;
    }

    /**
     * Define o valor da propriedade returnOptions.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadObjectsReturnOptions }
     *     
     */
    public void setReturnOptions(ReadObjectsReturnOptions value) {
        this.returnOptions = value;
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
