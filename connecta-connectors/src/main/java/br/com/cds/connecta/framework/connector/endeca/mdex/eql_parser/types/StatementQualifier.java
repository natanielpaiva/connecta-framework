
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de StatementQualifier complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="StatementQualifier">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}Node">
 *       &lt;sequence>
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
@XmlType(name = "StatementQualifier")
public class StatementQualifier
    extends Node
{

    @XmlAttribute(name = "statementKey", required = true)
    protected String statementKey;

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
