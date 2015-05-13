
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Sort type paralleling the structure of a MAX Sort element. Key is the property or dimension
 * 						value to sort by and Direction is an enumeration of "Ascending" or "Descending".
 * 
 * <p>Classe Java de Sort complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Sort">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Key" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="Direction" type="{http://www.endeca.com/MDEX/conversation/3/0}SortDirection" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Sort")
@XmlSeeAlso({
    SortControl.class
})
public class Sort {

    @XmlAttribute(name = "Key", required = true)
    protected String key;
    @XmlAttribute(name = "Direction")
    protected SortDirection direction;

    /**
     * Obt\u00e9m o valor da propriedade key.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Define o valor da propriedade key.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade direction.
     * 
     * @return
     *     possible object is
     *     {@link SortDirection }
     *     
     */
    public SortDirection getDirection() {
        return direction;
    }

    /**
     * Define o valor da propriedade direction.
     * 
     * @param value
     *     allowed object is
     *     {@link SortDirection }
     *     
     */
    public void setDirection(SortDirection value) {
        this.direction = value;
    }

}
