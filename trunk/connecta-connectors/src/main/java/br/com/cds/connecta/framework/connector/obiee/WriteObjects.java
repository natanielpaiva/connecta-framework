
package br.com.cds.connecta.framework.connector.obiee;

import br.com.cds.connecta.framework.connector.obiee.ErrorDetailsLevel;
import br.com.cds.connecta.framework.connector.obiee.CatalogObject;
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
 *         &lt;element name="catalogObjects" type="{urn://oracle.bi.webservices/v6}CatalogObject" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="allowOverwrite" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="createIntermediateDirs" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="errorMode" type="{urn://oracle.bi.webservices/v6}ErrorDetailsLevel"/>
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
    "catalogObjects",
    "allowOverwrite",
    "createIntermediateDirs",
    "errorMode",
    "sessionID"
})
@XmlRootElement(name = "writeObjects")
public class WriteObjects {

    protected List<CatalogObject> catalogObjects;
    protected boolean allowOverwrite;
    protected boolean createIntermediateDirs;
    @XmlElement(required = true)
    protected ErrorDetailsLevel errorMode;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Gets the value of the catalogObjects property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the catalogObjects property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCatalogObjects().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CatalogObject }
     * 
     * 
     */
    public List<CatalogObject> getCatalogObjects() {
        if (catalogObjects == null) {
            catalogObjects = new ArrayList<CatalogObject>();
        }
        return this.catalogObjects;
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
