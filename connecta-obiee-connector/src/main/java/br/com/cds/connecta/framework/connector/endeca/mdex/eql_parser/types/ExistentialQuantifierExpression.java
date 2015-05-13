
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ExistentialQuantifierExpression complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ExistentialQuantifierExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase">
 *       &lt;sequence>
 *         &lt;element name="universe" type="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase"/>
 *         &lt;element name="predicate" type="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase"/>
 *       &lt;/sequence>
 *       &lt;attribute name="boundVariable" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExistentialQuantifierExpression", propOrder = {
    "universe",
    "predicate"
})
public class ExistentialQuantifierExpression
    extends ExpressionBase
{

    @XmlElement(required = true)
    protected ExpressionBase universe;
    @XmlElement(required = true)
    protected ExpressionBase predicate;
    @XmlAttribute(name = "boundVariable", required = true)
    protected String boundVariable;

    /**
     * Obt\u00e9m o valor da propriedade universe.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionBase }
     *     
     */
    public ExpressionBase getUniverse() {
        return universe;
    }

    /**
     * Define o valor da propriedade universe.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionBase }
     *     
     */
    public void setUniverse(ExpressionBase value) {
        this.universe = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade predicate.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionBase }
     *     
     */
    public ExpressionBase getPredicate() {
        return predicate;
    }

    /**
     * Define o valor da propriedade predicate.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionBase }
     *     
     */
    public void setPredicate(ExpressionBase value) {
        this.predicate = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade boundVariable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoundVariable() {
        return boundVariable;
    }

    /**
     * Define o valor da propriedade boundVariable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoundVariable(String value) {
        this.boundVariable = value;
    }

}
