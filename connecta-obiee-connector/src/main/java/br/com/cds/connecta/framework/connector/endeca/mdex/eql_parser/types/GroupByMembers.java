
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de GroupByMembers complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="GroupByMembers">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}GroupingKeyBase">
 *       &lt;sequence>
 *         &lt;element name="preGroupingAttrKey" type="{http://www.endeca.com/MDEX/eql_parser/types}AttributeRefExpression"/>
 *       &lt;/sequence>
 *       &lt;attribute name="postGroupingAttrKey" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupByMembers", propOrder = {
    "preGroupingAttrKey"
})
public class GroupByMembers
    extends GroupingKeyBase
{

    @XmlElement(required = true)
    protected AttributeRefExpression preGroupingAttrKey;
    @XmlAttribute(name = "postGroupingAttrKey", required = true)
    protected String postGroupingAttrKey;

    /**
     * Obt\u00e9m o valor da propriedade preGroupingAttrKey.
     * 
     * @return
     *     possible object is
     *     {@link AttributeRefExpression }
     *     
     */
    public AttributeRefExpression getPreGroupingAttrKey() {
        return preGroupingAttrKey;
    }

    /**
     * Define o valor da propriedade preGroupingAttrKey.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeRefExpression }
     *     
     */
    public void setPreGroupingAttrKey(AttributeRefExpression value) {
        this.preGroupingAttrKey = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade postGroupingAttrKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostGroupingAttrKey() {
        return postGroupingAttrKey;
    }

    /**
     * Define o valor da propriedade postGroupingAttrKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostGroupingAttrKey(String value) {
        this.postGroupingAttrKey = value;
    }

}
