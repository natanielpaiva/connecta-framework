
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Part of a record list response, RecordListEntry includes
 * 						the Record and any computed properties, like geocode
 * 						distance or snippets.
 * 
 * <p>Classe Java de RecordListEntry complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RecordListEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Record" type="{http://www.endeca.com/MDEX/conversation/3/0}Record"/>
 *         &lt;element name="ComputedProperties" type="{http://www.endeca.com/MDEX/conversation/3/0}ComputedProperties"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordListEntry", propOrder = {
    "record",
    "computedProperties"
})
public class RecordListEntry {

    @XmlElement(name = "Record", required = true)
    protected Record record;
    @XmlElement(name = "ComputedProperties", required = true)
    protected ComputedProperties computedProperties;

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
     * Obt\u00e9m o valor da propriedade computedProperties.
     * 
     * @return
     *     possible object is
     *     {@link ComputedProperties }
     *     
     */
    public ComputedProperties getComputedProperties() {
        return computedProperties;
    }

    /**
     * Define o valor da propriedade computedProperties.
     * 
     * @param value
     *     allowed object is
     *     {@link ComputedProperties }
     *     
     */
    public void setComputedProperties(ComputedProperties value) {
        this.computedProperties = value;
    }

}
