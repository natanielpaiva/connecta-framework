
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ComparisonExpression complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ComparisonExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase">
 *       &lt;sequence>
 *         &lt;element name="leftOperand" type="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase"/>
 *         &lt;element name="rightOperand" type="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase"/>
 *       &lt;/sequence>
 *       &lt;attribute name="comparison" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComparisonExpression", propOrder = {
    "leftOperand",
    "rightOperand"
})
public class ComparisonExpression
    extends ExpressionBase
{

    @XmlElement(required = true)
    protected ExpressionBase leftOperand;
    @XmlElement(required = true)
    protected ExpressionBase rightOperand;
    @XmlAttribute(name = "comparison", required = true)
    protected String comparison;

    /**
     * Obt\u00e9m o valor da propriedade leftOperand.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionBase }
     *     
     */
    public ExpressionBase getLeftOperand() {
        return leftOperand;
    }

    /**
     * Define o valor da propriedade leftOperand.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionBase }
     *     
     */
    public void setLeftOperand(ExpressionBase value) {
        this.leftOperand = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade rightOperand.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionBase }
     *     
     */
    public ExpressionBase getRightOperand() {
        return rightOperand;
    }

    /**
     * Define o valor da propriedade rightOperand.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionBase }
     *     
     */
    public void setRightOperand(ExpressionBase value) {
        this.rightOperand = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade comparison.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComparison() {
        return comparison;
    }

    /**
     * Define o valor da propriedade comparison.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComparison(String value) {
        this.comparison = value;
    }

}
