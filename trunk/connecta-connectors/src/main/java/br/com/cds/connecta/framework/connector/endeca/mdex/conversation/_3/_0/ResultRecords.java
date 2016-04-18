
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * A block of records corresponding to a single EQL statement. It has the name given to it
 * 						in the EQL statement, and is annotated with the number of records returned.
 * 
 * <p>Classe Java de ResultRecords complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ResultRecords">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DimensionHierarchy" type="{http://www.endeca.com/MDEX/conversation/3/0}DimensionHierarchy"/>
 *         &lt;element name="AttributeMetadata" type="{http://www.endeca.com/MDEX/conversation/3/0}AttributeMetadata" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Record" type="{http://www.endeca.com/MDEX/conversation/3/0}Record" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Name" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="NumRecords" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultRecords", propOrder = {
    "dimensionHierarchy",
    "attributeMetadata",
    "record"
})
public class ResultRecords {

    @XmlElement(name = "DimensionHierarchy", required = true)
    protected DimensionHierarchy dimensionHierarchy;
    @XmlElement(name = "AttributeMetadata")
    protected List<AttributeMetadata> attributeMetadata;
    @XmlElement(name = "Record")
    protected List<Record> record;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "NumRecords", required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger numRecords;

    /**
     * Obt\u00e9m o valor da propriedade dimensionHierarchy.
     * 
     * @return
     *     possible object is
     *     {@link DimensionHierarchy }
     *     
     */
    public DimensionHierarchy getDimensionHierarchy() {
        return dimensionHierarchy;
    }

    /**
     * Define o valor da propriedade dimensionHierarchy.
     * 
     * @param value
     *     allowed object is
     *     {@link DimensionHierarchy }
     *     
     */
    public void setDimensionHierarchy(DimensionHierarchy value) {
        this.dimensionHierarchy = value;
    }

    /**
     * Gets the value of the attributeMetadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributeMetadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributeMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttributeMetadata }
     * 
     * 
     */
    public List<AttributeMetadata> getAttributeMetadata() {
        if (attributeMetadata == null) {
            attributeMetadata = new ArrayList<AttributeMetadata>();
        }
        return this.attributeMetadata;
    }

    /**
     * Gets the value of the record property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the record property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecord().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Record }
     * 
     * 
     */
    public List<Record> getRecord() {
        if (record == null) {
            record = new ArrayList<Record>();
        }
        return this.record;
    }

    /**
     * Obt\u00e9m o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade numRecords.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumRecords() {
        return numRecords;
    }

    /**
     * Define o valor da propriedade numRecords.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumRecords(BigInteger value) {
        this.numRecords = value;
    }

}
