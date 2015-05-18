
package br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The health of a data domain on a particular node of the Endeca Server cluster.
 * 
 * <p>Classe Java de nodeDataDomainHealth complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="nodeDataDomainHealth">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataDomainName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="available" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="detail" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nodeDataDomainHealth", propOrder = {
    "dataDomainName",
    "available",
    "detail"
})
public class NodeDataDomainHealth {

    @XmlElement(required = true)
    protected String dataDomainName;
    protected boolean available;
    protected List<String> detail;

    /**
     * Obt\u00e9m o valor da propriedade dataDomainName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataDomainName() {
        return dataDomainName;
    }

    /**
     * Define o valor da propriedade dataDomainName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataDomainName(String value) {
        this.dataDomainName = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade available.
     * 
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Define o valor da propriedade available.
     * 
     */
    public void setAvailable(boolean value) {
        this.available = value;
    }

    /**
     * Gets the value of the detail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDetail() {
        if (detail == null) {
            detail = new ArrayList<String>();
        }
        return this.detail;
    }

}
