
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de CaseExpression complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CaseExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase">
 *       &lt;sequence>
 *         &lt;element name="clauses" type="{http://www.endeca.com/MDEX/eql_parser/types}CaseClause" maxOccurs="unbounded"/>
 *         &lt;element name="elseClause" type="{http://www.endeca.com/MDEX/eql_parser/types}ElseClause" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseExpression", propOrder = {
    "clauses",
    "elseClause"
})
public class CaseExpression
    extends ExpressionBase
{

    @XmlElement(required = true)
    protected List<CaseClause> clauses;
    protected ElseClause elseClause;

    /**
     * Gets the value of the clauses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clauses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClauses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseClause }
     * 
     * 
     */
    public List<CaseClause> getClauses() {
        if (clauses == null) {
            clauses = new ArrayList<CaseClause>();
        }
        return this.clauses;
    }

    /**
     * Obt\u00e9m o valor da propriedade elseClause.
     * 
     * @return
     *     possible object is
     *     {@link ElseClause }
     *     
     */
    public ElseClause getElseClause() {
        return elseClause;
    }

    /**
     * Define o valor da propriedade elseClause.
     * 
     * @param value
     *     allowed object is
     *     {@link ElseClause }
     *     
     */
    public void setElseClause(ElseClause value) {
        this.elseClause = value;
    }

}
