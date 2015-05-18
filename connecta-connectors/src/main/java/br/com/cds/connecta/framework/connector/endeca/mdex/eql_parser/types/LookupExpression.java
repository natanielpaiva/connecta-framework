
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de LookupExpression complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="LookupExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase">
 *       &lt;sequence>
 *         &lt;element name="lookupValues" type="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="targetStatementKey" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="targetAttributeKey" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LookupExpression", propOrder = {
    "lookupValues"
})
public class LookupExpression
    extends ExpressionBase
{

    protected List<ExpressionBase> lookupValues;
    @XmlAttribute(name = "targetStatementKey", required = true)
    protected String targetStatementKey;
    @XmlAttribute(name = "targetAttributeKey", required = true)
    protected String targetAttributeKey;

    /**
     * Gets the value of the lookupValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lookupValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLookupValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExpressionBase }
     * 
     * 
     */
    public List<ExpressionBase> getLookupValues() {
        if (lookupValues == null) {
            lookupValues = new ArrayList<ExpressionBase>();
        }
        return this.lookupValues;
    }

    /**
     * Obt\u00e9m o valor da propriedade targetStatementKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetStatementKey() {
        return targetStatementKey;
    }

    /**
     * Define o valor da propriedade targetStatementKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetStatementKey(String value) {
        this.targetStatementKey = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade targetAttributeKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetAttributeKey() {
        return targetAttributeKey;
    }

    /**
     * Define o valor da propriedade targetAttributeKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetAttributeKey(String value) {
        this.targetAttributeKey = value;
    }

}
