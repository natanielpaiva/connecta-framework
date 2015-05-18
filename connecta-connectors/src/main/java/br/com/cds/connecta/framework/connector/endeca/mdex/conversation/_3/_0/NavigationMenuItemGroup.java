
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A group of NavigationMenuItems, collected by property group.
 * 
 * <p>Classe Java de NavigationMenuItemGroup complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="NavigationMenuItemGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NavigationMenuItem" type="{http://www.endeca.com/MDEX/conversation/3/0}NavigationMenuItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="HasRefineableProperties" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NavigationMenuItemGroup", propOrder = {
    "navigationMenuItem"
})
public class NavigationMenuItemGroup {

    @XmlElement(name = "NavigationMenuItem")
    protected List<NavigationMenuItem> navigationMenuItem;
    @XmlAttribute(name = "HasRefineableProperties")
    protected Boolean hasRefineableProperties;
    @XmlAttribute(name = "Name", required = true)
    protected String name;

    /**
     * Gets the value of the navigationMenuItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the navigationMenuItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNavigationMenuItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NavigationMenuItem }
     * 
     * 
     */
    public List<NavigationMenuItem> getNavigationMenuItem() {
        if (navigationMenuItem == null) {
            navigationMenuItem = new ArrayList<NavigationMenuItem>();
        }
        return this.navigationMenuItem;
    }

    /**
     * Obt\u00e9m o valor da propriedade hasRefineableProperties.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasRefineableProperties() {
        return hasRefineableProperties;
    }

    /**
     * Define o valor da propriedade hasRefineableProperties.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasRefineableProperties(Boolean value) {
        this.hasRefineableProperties = value;
    }

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

}
