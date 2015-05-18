
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Direction complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Direction">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}Node">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="isAscending" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Direction")
public class Direction
    extends Node
{

    @XmlAttribute(name = "isAscending", required = true)
    protected boolean isAscending;

    /**
     * Obt\u00e9m o valor da propriedade isAscending.
     * 
     */
    public boolean isIsAscending() {
        return isAscending;
    }

    /**
     * Define o valor da propriedade isAscending.
     * 
     */
    public void setIsAscending(boolean value) {
        this.isAscending = value;
    }

}
