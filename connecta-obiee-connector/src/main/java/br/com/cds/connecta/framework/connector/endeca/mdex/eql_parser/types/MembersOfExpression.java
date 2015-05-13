
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de MembersOfExpression complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="MembersOfExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase">
 *       &lt;sequence>
 *         &lt;element name="preGroupingAttrKey" type="{http://www.endeca.com/MDEX/eql_parser/types}AttributeRefExpression"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MembersOfExpression", propOrder = {
    "preGroupingAttrKey"
})
public class MembersOfExpression
    extends ExpressionBase
{

    @XmlElement(required = true)
    protected AttributeRefExpression preGroupingAttrKey;

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

}
