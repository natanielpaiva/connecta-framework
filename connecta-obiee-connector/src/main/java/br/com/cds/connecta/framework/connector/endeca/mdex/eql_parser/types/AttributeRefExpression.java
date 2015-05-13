
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de AttributeRefExpression complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="AttributeRefExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase">
 *       &lt;sequence>
 *         &lt;element name="statementQualifier" type="{http://www.endeca.com/MDEX/eql_parser/types}StatementQualifier" minOccurs="0"/>
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
@XmlType(name = "AttributeRefExpression", propOrder = {
    "statementQualifier"
})
public class AttributeRefExpression
    extends ExpressionBase
{

    protected StatementQualifier statementQualifier;
    @XmlAttribute(name = "attributeKey", required = true)
    protected String attributeKey;

    /**
     * Obt\u00e9m o valor da propriedade statementQualifier.
     * 
     * @return
     *     possible object is
     *     {@link StatementQualifier }
     *     
     */
    public StatementQualifier getStatementQualifier() {
        return statementQualifier;
    }

    /**
     * Define o valor da propriedade statementQualifier.
     * 
     * @param value
     *     allowed object is
     *     {@link StatementQualifier }
     *     
     */
    public void setStatementQualifier(StatementQualifier value) {
        this.statementQualifier = value;
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
