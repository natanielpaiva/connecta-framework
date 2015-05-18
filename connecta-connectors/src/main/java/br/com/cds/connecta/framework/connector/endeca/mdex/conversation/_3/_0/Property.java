
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Pertinent information about an attribute including its
 * 						key, display name and other options.  The PDR (and DDR, if
 * 						present) is included for clients that prefer to read
 * 						descriptor records directly; note that records do not have
 * 						a fixed schema.
 * 
 * <p>Classe Java de Property complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Property">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PropertyRecord" type="{http://www.endeca.com/MDEX/conversation/3/0}Record"/>
 *         &lt;element name="DimensionRecord" type="{http://www.endeca.com/MDEX/conversation/3/0}Record" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Key" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Dimension" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="DisplayName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Refinable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Property", propOrder = {
    "propertyRecord",
    "dimensionRecord"
})
public class Property {

    @XmlElement(name = "PropertyRecord", required = true)
    protected Record propertyRecord;
    @XmlElement(name = "DimensionRecord")
    protected Record dimensionRecord;
    @XmlAttribute(name = "Key", required = true)
    protected String key;
    @XmlAttribute(name = "Type", required = true)
    protected String type;
    @XmlAttribute(name = "Dimension", required = true)
    protected boolean dimension;
    @XmlAttribute(name = "DisplayName", required = true)
    protected String displayName;
    @XmlAttribute(name = "Refinable", required = true)
    protected boolean refinable;

    /**
     * Obt\u00e9m o valor da propriedade propertyRecord.
     * 
     * @return
     *     possible object is
     *     {@link Record }
     *     
     */
    public Record getPropertyRecord() {
        return propertyRecord;
    }

    /**
     * Define o valor da propriedade propertyRecord.
     * 
     * @param value
     *     allowed object is
     *     {@link Record }
     *     
     */
    public void setPropertyRecord(Record value) {
        this.propertyRecord = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade dimensionRecord.
     * 
     * @return
     *     possible object is
     *     {@link Record }
     *     
     */
    public Record getDimensionRecord() {
        return dimensionRecord;
    }

    /**
     * Define o valor da propriedade dimensionRecord.
     * 
     * @param value
     *     allowed object is
     *     {@link Record }
     *     
     */
    public void setDimensionRecord(Record value) {
        this.dimensionRecord = value;
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
     * Obt\u00e9m o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade dimension.
     * 
     */
    public boolean isDimension() {
        return dimension;
    }

    /**
     * Define o valor da propriedade dimension.
     * 
     */
    public void setDimension(boolean value) {
        this.dimension = value;
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
     * Obt\u00e9m o valor da propriedade refinable.
     * 
     */
    public boolean isRefinable() {
        return refinable;
    }

    /**
     * Define o valor da propriedade refinable.
     * 
     */
    public void setRefinable(boolean value) {
        this.refinable = value;
    }

}
