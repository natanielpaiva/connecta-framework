
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SetEmptinessExpression complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SetEmptinessExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase">
 *       &lt;sequence>
 *         &lt;element name="operand" type="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase"/>
 *       &lt;/sequence>
 *       &lt;attribute name="isEmpty" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetEmptinessExpression", propOrder = {
    "operand"
})
public class SetEmptinessExpression
    extends ExpressionBase
{

    @XmlElement(required = true)
    protected ExpressionBase operand;
    @XmlAttribute(name = "isEmpty", required = true)
    protected boolean isEmpty;

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
     * Obt\u00e9m o valor da propriedade isEmpty.
     * 
     */
    public boolean isIsEmpty() {
        return isEmpty;
    }

    /**
     * Define o valor da propriedade isEmpty.
     * 
     */
    public void setIsEmpty(boolean value) {
        this.isEmpty = value;
    }

}
