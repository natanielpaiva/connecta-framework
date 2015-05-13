
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de filterRuleKey complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="filterRuleKey">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="filterRuleKey" use="required" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filterRuleKey")
public class FilterRuleKey {

    @XmlAttribute(name = "filterRuleKey", required = true)
    protected String filterRuleKey;

    /**
     * Obt\u00e9m o valor da propriedade filterRuleKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterRuleKey() {
        return filterRuleKey;
    }

    /**
     * Define o valor da propriedade filterRuleKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterRuleKey(String value) {
        this.filterRuleKey = value;
    }

}
