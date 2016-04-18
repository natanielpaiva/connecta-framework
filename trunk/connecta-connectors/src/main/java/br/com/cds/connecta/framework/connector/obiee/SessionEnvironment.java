
package br.com.cds.connecta.framework.connector.obiee;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SessionEnvironment complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SessionEnvironment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="homeDirectory" type="{urn://oracle.bi.webservices/v6}ItemInfo"/>
 *         &lt;element name="sharedDirectories" type="{urn://oracle.bi.webservices/v6}ItemInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SessionEnvironment", propOrder = {
    "userName",
    "homeDirectory",
    "sharedDirectories"
})
public class SessionEnvironment {

    @XmlElement(required = true)
    protected String userName;
    @XmlElement(required = true)
    protected ItemInfo homeDirectory;
    protected List<ItemInfo> sharedDirectories;

    /**
     * Obtém o valor da propriedade userName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Define o valor da propriedade userName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Obtém o valor da propriedade homeDirectory.
     * 
     * @return
     *     possible object is
     *     {@link ItemInfo }
     *     
     */
    public ItemInfo getHomeDirectory() {
        return homeDirectory;
    }

    /**
     * Define o valor da propriedade homeDirectory.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemInfo }
     *     
     */
    public void setHomeDirectory(ItemInfo value) {
        this.homeDirectory = value;
    }

    /**
     * Gets the value of the sharedDirectories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sharedDirectories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSharedDirectories().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemInfo }
     * 
     * 
     */
    public List<ItemInfo> getSharedDirectories() {
        if (sharedDirectories == null) {
            sharedDirectories = new ArrayList<ItemInfo>();
        }
        return this.sharedDirectories;
    }

}
