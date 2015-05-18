
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de StatementSource complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="StatementSource">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}SourceBase">
 *       &lt;sequence>
 *         &lt;element name="filter" type="{http://www.endeca.com/MDEX/eql_parser/types}StateFilter" minOccurs="0"/>
 *         &lt;element name="alias" type="{http://www.endeca.com/MDEX/eql_parser/types}StatementAlias" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="statementKey" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatementSource", propOrder = {
    "filter",
    "alias"
})
public class StatementSource
    extends SourceBase
{

    protected StateFilter filter;
    protected StatementAlias alias;
    @XmlAttribute(name = "statementKey", required = true)
    protected String statementKey;

    /**
     * Obt\u00e9m o valor da propriedade filter.
     * 
     * @return
     *     possible object is
     *     {@link StateFilter }
     *     
     */
    public StateFilter getFilter() {
        return filter;
    }

    /**
     * Define o valor da propriedade filter.
     * 
     * @param value
     *     allowed object is
     *     {@link StateFilter }
     *     
     */
    public void setFilter(StateFilter value) {
        this.filter = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade alias.
     * 
     * @return
     *     possible object is
     *     {@link StatementAlias }
     *     
     */
    public StatementAlias getAlias() {
        return alias;
    }

    /**
     * Define o valor da propriedade alias.
     * 
     * @param value
     *     allowed object is
     *     {@link StatementAlias }
     *     
     */
    public void setAlias(StatementAlias value) {
        this.alias = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade statementKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatementKey() {
        return statementKey;
    }

    /**
     * Define o valor da propriedade statementKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatementKey(String value) {
        this.statementKey = value;
    }

}
