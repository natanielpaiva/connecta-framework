
package br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.endeca.com/endeca-server/types/2/0}nonEmptyString"/>
 *         &lt;element name="ddProfileName" type="{http://www.endeca.com/endeca-server/types/2/0}nonEmptyString" minOccurs="0"/>
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
    "name",
    "ddProfileName"
})
@XmlRootElement(name = "updateDataDomain")
public class UpdateDataDomain {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(defaultValue = "default")
    protected String ddProfileName;

    /**
     * Obt\u00e9m o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade ddProfileName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDdProfileName() {
        return ddProfileName;
    }

    /**
     * Define o valor da propriedade ddProfileName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDdProfileName(String value) {
        this.ddProfileName = value;
    }

}
