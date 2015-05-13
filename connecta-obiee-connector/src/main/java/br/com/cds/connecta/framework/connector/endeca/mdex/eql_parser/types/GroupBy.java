
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de GroupBy complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="GroupBy">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}GroupingKeyBase">
 *       &lt;sequence>
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
@XmlType(name = "GroupBy")
public class GroupBy
    extends GroupingKeyBase
{

    @XmlAttribute(name = "attributeKey", required = true)
    protected String attributeKey;

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
