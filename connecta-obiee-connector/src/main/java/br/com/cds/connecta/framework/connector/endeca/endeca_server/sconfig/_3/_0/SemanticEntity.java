
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * An element representing a Semantic Entity and all its Semantic Attributes
 * 
 * <p>Classe Java de semanticEntity complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="semanticEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="definition" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attributes" type="{http://www.endeca.com/endeca-server/sconfig/3/0}semanticAttributes"/>
 *         &lt;element name="metrics" type="{http://www.endeca.com/endeca-server/sconfig/3/0}metrics"/>
 *         &lt;element name="groups" type="{http://www.endeca.com/endeca-server/sconfig/3/0}groups"/>
 *         &lt;element name="property" type="{http://www.endeca.com/endeca-server/sconfig/3/0}property" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="key" use="required" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" />
 *       &lt;attribute name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="isActive" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "semanticEntity", propOrder = {
    "definition",
    "description",
    "attributes",
    "metrics",
    "groups",
    "property"
})
@XmlSeeAlso({
    ValidatedSemanticEntity.class
})
public class SemanticEntity {

    @XmlElement(required = true)
    protected String definition;
    protected String description;
    @XmlElement(required = true)
    protected SemanticAttributes attributes;
    @XmlElement(required = true)
    protected Metrics metrics;
    @XmlElement(required = true)
    protected Groups groups;
    protected List<Property> property;
    @XmlAttribute(name = "key", required = true)
    protected String key;
    @XmlAttribute(name = "displayName")
    protected String displayName;
    @XmlAttribute(name = "isActive", required = true)
    protected boolean isActive;

    /**
     * Obt\u00e9m o valor da propriedade definition.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * Define o valor da propriedade definition.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefinition(String value) {
        this.definition = value;
    }

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
     * Obt\u00e9m o valor da propriedade attributes.
     * 
     * @return
     *     possible object is
     *     {@link SemanticAttributes }
     *     
     */
    public SemanticAttributes getAttributes() {
        return attributes;
    }

    /**
     * Define o valor da propriedade attributes.
     * 
     * @param value
     *     allowed object is
     *     {@link SemanticAttributes }
     *     
     */
    public void setAttributes(SemanticAttributes value) {
        this.attributes = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade metrics.
     * 
     * @return
     *     possible object is
     *     {@link Metrics }
     *     
     */
    public Metrics getMetrics() {
        return metrics;
    }

    /**
     * Define o valor da propriedade metrics.
     * 
     * @param value
     *     allowed object is
     *     {@link Metrics }
     *     
     */
    public void setMetrics(Metrics value) {
        this.metrics = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade groups.
     * 
     * @return
     *     possible object is
     *     {@link Groups }
     *     
     */
    public Groups getGroups() {
        return groups;
    }

    /**
     * Define o valor da propriedade groups.
     * 
     * @param value
     *     allowed object is
     *     {@link Groups }
     *     
     */
    public void setGroups(Groups value) {
        this.groups = value;
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
     * Obt\u00e9m o valor da propriedade key.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Define o valor da propriedade key.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
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
     * Obt\u00e9m o valor da propriedade isActive.
     * 
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * Define o valor da propriedade isActive.
     * 
     */
    public void setIsActive(boolean value) {
        this.isActive = value;
    }

}
