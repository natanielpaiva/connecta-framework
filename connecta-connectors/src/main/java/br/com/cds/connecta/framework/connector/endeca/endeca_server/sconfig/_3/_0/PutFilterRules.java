
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

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
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outerTransactionId" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" minOccurs="0"/>
 *         &lt;element name="language" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" minOccurs="0"/>
 *         &lt;element name="filterRule" type="{http://www.endeca.com/endeca-server/sconfig/3/0}filterRule" maxOccurs="unbounded" minOccurs="0"/>
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
    "outerTransactionId",
    "language",
    "filterRule"
})
@XmlRootElement(name = "putFilterRules")
public class PutFilterRules {

    protected String outerTransactionId;
    @XmlElement(defaultValue = "en")
    protected String language;
    protected List<FilterRule> filterRule;

    /**
     * Obt\u00e9m o valor da propriedade outerTransactionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOuterTransactionId() {
        return outerTransactionId;
    }

    /**
     * Define o valor da propriedade outerTransactionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOuterTransactionId(String value) {
        this.outerTransactionId = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade language.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Define o valor da propriedade language.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the filterRule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filterRule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilterRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FilterRule }
     * 
     * 
     */
    public List<FilterRule> getFilterRule() {
        if (filterRule == null) {
            filterRule = new ArrayList<FilterRule>();
        }
        return this.filterRule;
    }

}
