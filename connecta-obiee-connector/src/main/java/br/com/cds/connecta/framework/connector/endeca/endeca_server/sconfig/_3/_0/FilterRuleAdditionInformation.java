
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de filterRuleAdditionInformation complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="filterRuleAdditionInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="numFilterRulesAdded" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="numFilterRulesReplaced" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filterRuleAdditionInformation")
public class FilterRuleAdditionInformation {

    @XmlAttribute(name = "numFilterRulesAdded")
    protected Integer numFilterRulesAdded;
    @XmlAttribute(name = "numFilterRulesReplaced")
    protected Integer numFilterRulesReplaced;

    /**
     * Obt\u00e9m o valor da propriedade numFilterRulesAdded.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumFilterRulesAdded() {
        return numFilterRulesAdded;
    }

    /**
     * Define o valor da propriedade numFilterRulesAdded.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumFilterRulesAdded(Integer value) {
        this.numFilterRulesAdded = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade numFilterRulesReplaced.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumFilterRulesReplaced() {
        return numFilterRulesReplaced;
    }

    /**
     * Define o valor da propriedade numFilterRulesReplaced.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumFilterRulesReplaced(Integer value) {
        this.numFilterRulesReplaced = value;
    }

}
