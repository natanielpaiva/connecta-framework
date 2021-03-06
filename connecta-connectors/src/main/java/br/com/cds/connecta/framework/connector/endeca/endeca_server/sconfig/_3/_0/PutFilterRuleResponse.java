
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

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
 *         &lt;element name="filterRuleAdditionInformation" type="{http://www.endeca.com/endeca-server/sconfig/3/0}filterRuleAdditionInformation"/>
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
    "filterRuleAdditionInformation"
})
@XmlRootElement(name = "putFilterRuleResponse")
public class PutFilterRuleResponse {

    @XmlElement(required = true)
    protected FilterRuleAdditionInformation filterRuleAdditionInformation;

    /**
     * Obt\u00e9m o valor da propriedade filterRuleAdditionInformation.
     * 
     * @return
     *     possible object is
     *     {@link FilterRuleAdditionInformation }
     *     
     */
    public FilterRuleAdditionInformation getFilterRuleAdditionInformation() {
        return filterRuleAdditionInformation;
    }

    /**
     * Define o valor da propriedade filterRuleAdditionInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterRuleAdditionInformation }
     *     
     */
    public void setFilterRuleAdditionInformation(FilterRuleAdditionInformation value) {
        this.filterRuleAdditionInformation = value;
    }

}
