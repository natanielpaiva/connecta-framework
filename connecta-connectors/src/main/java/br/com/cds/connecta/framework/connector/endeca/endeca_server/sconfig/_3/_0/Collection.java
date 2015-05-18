
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * An element representing a collection.
 * 
 * <p>Classe Java de collection complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="collection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="property" type="{http://www.endeca.com/endeca-server/sconfig/3/0}property" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="collectionKey" use="required" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" />
 *       &lt;attribute name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="uniquePropertyKey" use="required" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "collection", propOrder = {
    "description",
    "property"
})
@XmlSeeAlso({
    CollectionUpdate.class,
    CollectionRecord.class
})
public class Collection {

    protected String description;
    protected List<Property> property;
    @XmlAttribute(name = "collectionKey", required = true)
    protected String collectionKey;
    @XmlAttribute(name = "displayName")
    protected String displayName;
    @XmlAttribute(name = "uniquePropertyKey", required = true)
    protected String uniquePropertyKey;

    /**
     * Obt\u00e9m o valor da propriedade description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define o valor da propriedade description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the property property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Property }
     * 
     * 
     */
    public List<Property> getProperty() {
        if (property == null) {
            property = new ArrayList<Property>();
        }
        return this.property;
    }

    /**
     * Obt\u00e9m o valor da propriedade collectionKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionKey() {
        return collectionKey;
    }

    /**
     * Define o valor da propriedade collectionKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionKey(String value) {
        this.collectionKey = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade displayName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Define o valor da propriedade displayName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade uniquePropertyKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniquePropertyKey() {
        return uniquePropertyKey;
    }

    /**
     * Define o valor da propriedade uniquePropertyKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniquePropertyKey(String value) {
        this.uniquePropertyKey = value;
    }

}
