
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ElseClause complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ElseClause">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}Node">
 *       &lt;sequence>
 *         &lt;element name="consequent" type="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElseClause", propOrder = {
    "consequent"
})
public class ElseClause
    extends Node
{

    @XmlElement(required = true)
    protected ExpressionBase consequent;

    /**
     * Obt\u00e9m o valor da propriedade consequent.
     * 
     * @return
     *     possible object is
     *     {@link ExpressionBase }
     *     
     */
    public ExpressionBase getConsequent() {
        return consequent;
    }

    /**
     * Define o valor da propriedade consequent.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpressionBase }
     *     
     */
    public void setConsequent(ExpressionBase value) {
        this.consequent = value;
    }

}
