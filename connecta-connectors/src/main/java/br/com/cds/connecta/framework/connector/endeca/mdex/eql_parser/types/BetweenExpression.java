
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de BetweenExpression complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="BetweenExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase">
 *       &lt;sequence>
 *         &lt;element name="operand" type="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase"/>
 *         &lt;element name="lowerBoundNotStrict" type="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase"/>
 *         &lt;element name="upperBoundStrict" type="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BetweenExpression", propOrder = {
    "operand",
    "lowerBoundNotStrict",
    "upperBoundStrict"
})
public class BetweenExpression
    extends ExpressionBase
{

    @XmlElement(required = true)
    protected ExpressionBase operand;
    @XmlElement(required = true)
    protected ExpressionBase lowerBoundNotStrict;
    @XmlElement(required = true)
    protected ExpressionBase upperBoundStrict;

    /**
     * Obt\u00e9m o valor da propriedade operand.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionBase }
     *     
     */
    public ExpressionBase getOperand() {
        return operand;
    }

    /**
     * Define o valor da propriedade operand.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionBase }
     *     
     */
    public void setOperand(ExpressionBase value) {
        this.operand = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade lowerBoundNotStrict.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionBase }
     *     
     */
    public ExpressionBase getLowerBoundNotStrict() {
        return lowerBoundNotStrict;
    }

    /**
     * Define o valor da propriedade lowerBoundNotStrict.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionBase }
     *     
     */
    public void setLowerBoundNotStrict(ExpressionBase value) {
        this.lowerBoundNotStrict = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade upperBoundStrict.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionBase }
     *     
     */
    public ExpressionBase getUpperBoundStrict() {
        return upperBoundStrict;
    }

    /**
     * Define o valor da propriedade upperBoundStrict.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionBase }
     *     
     */
    public void setUpperBoundStrict(ExpressionBase value) {
        this.upperBoundStrict = value;
    }

}
