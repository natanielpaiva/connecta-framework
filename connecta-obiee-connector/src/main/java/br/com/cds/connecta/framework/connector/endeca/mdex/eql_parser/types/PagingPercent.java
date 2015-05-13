
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de PagingPercent complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="PagingPercent">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}PageBase">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="offset" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="limit" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PagingPercent")
public class PagingPercent
    extends PageBase
{

    @XmlAttribute(name = "offset", required = true)
    protected double offset;
    @XmlAttribute(name = "limit", required = true)
    protected double limit;

    /**
     * Obt\u00e9m o valor da propriedade offset.
     * 
     */
    public double getOffset() {
        return offset;
    }

    /**
     * Define o valor da propriedade offset.
     * 
     */
    public void setOffset(double value) {
        this.offset = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade limit.
     * 
     */
    public double getLimit() {
        return limit;
    }

    /**
     * Define o valor da propriedade limit.
     * 
     */
    public void setLimit(double value) {
        this.limit = value;
    }

}
