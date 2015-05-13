
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="column" type="{urn://oracle.bi.webservices/v6}SAColumn"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "column"
})
@XmlRootElement(name = "describeColumnResult")
public class DescribeColumnResult {

    @XmlElement(required = true)
    protected SAColumn column;

    /**
     * Obtém o valor da propriedade column.
     * 
     * @return
     *     possible object is
     *     {@link SAColumn }
     *     
     */
    public SAColumn getColumn() {
        return column;
    }

    /**
     * Define o valor da propriedade column.
     * 
     * @param value
     *     allowed object is
     *     {@link SAColumn }
     *     
     */
    public void setColumn(SAColumn value) {
        this.column = value;
    }

}
