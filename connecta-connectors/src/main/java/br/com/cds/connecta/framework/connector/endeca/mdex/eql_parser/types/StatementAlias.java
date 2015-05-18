
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de StatementAlias complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="StatementAlias">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}Node">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="aliasKey" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatementAlias")
public class StatementAlias
    extends Node
{

    @XmlAttribute(name = "aliasKey", required = true)
    protected String aliasKey;

    /**
     * Obt\u00e9m o valor da propriedade aliasKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasKey() {
        return aliasKey;
    }

    /**
     * Define o valor da propriedade aliasKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasKey(String value) {
        this.aliasKey = value;
    }

}
