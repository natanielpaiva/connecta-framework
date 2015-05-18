
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Select complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Select">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}Node">
 *       &lt;sequence>
 *         &lt;element name="expression" type="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase"/>
 *       &lt;/sequence>
 *       &lt;attribute name="attributeKey" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Select", propOrder = {
    "expression"
})
public class Select
    extends Node
{

    @XmlElement(required = true)
    protected ExpressionBase expression;
    @XmlAttribute(name = "attributeKey", required = true)
    protected String attributeKey;

    /**
     * Obt\u00e9m o valor da propriedade expression.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionBase }
     *     
     */
    public ExpressionBase getExpression() {
        return expression;
    }

    /**
     * Define o valor da propriedade expression.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionBase }
     *     
     */
    public void setExpression(ExpressionBase value) {
        this.expression = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade attributeKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeKey() {
        return attributeKey;
    }

    /**
     * Define o valor da propriedade attributeKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeKey(String value) {
        this.attributeKey = value;
    }

}
