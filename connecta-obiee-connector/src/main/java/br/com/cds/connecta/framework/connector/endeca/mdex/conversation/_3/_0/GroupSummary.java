
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de GroupSummary complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="GroupSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Record" type="{http://www.endeca.com/MDEX/conversation/3/0}Record"/>
 *         &lt;element name="GroupMembers" type="{http://www.endeca.com/MDEX/conversation/3/0}GroupMembers"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Key" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="Cardinality" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupSummary", propOrder = {
    "record",
    "groupMembers"
})
public class GroupSummary {

    @XmlElement(name = "Record", required = true)
    protected Record record;
    @XmlElement(name = "GroupMembers", required = true)
    protected GroupMembers groupMembers;
    @XmlAttribute(name = "Key")
    protected String key;
    @XmlAttribute(name = "Cardinality")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger cardinality;

    /**
     * Obt\u00e9m o valor da propriedade record.
     * 
     * @return
     *     possible object is
     *     {@link Record }
     *     
     */
    public Record getRecord() {
        return record;
    }

    /**
     * Define o valor da propriedade record.
     * 
     * @param value
     *     allowed object is
     *     {@link Record }
     *     
     */
    public void setRecord(Record value) {
        this.record = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade groupMembers.
     * 
     * @return
     *     possible object is
     *     {@link GroupMembers }
     *     
     */
    public GroupMembers getGroupMembers() {
        return groupMembers;
    }

    /**
     * Define o valor da propriedade groupMembers.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupMembers }
     *     
     */
    public void setGroupMembers(GroupMembers value) {
        this.groupMembers = value;
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
     * Obt\u00e9m o valor da propriedade cardinality.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCardinality() {
        return cardinality;
    }

    /**
     * Define o valor da propriedade cardinality.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCardinality(BigInteger value) {
        this.cardinality = value;
    }

}
