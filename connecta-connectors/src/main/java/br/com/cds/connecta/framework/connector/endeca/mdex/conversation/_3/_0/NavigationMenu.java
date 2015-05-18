
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A menu of NavigationMenuItems or NavigationMenuItemGroups.
 * 
 * <p>Classe Java de NavigationMenu complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="NavigationMenu">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElement">
 *       &lt;choice>
 *         &lt;element name="NavigationMenuItemGroup" type="{http://www.endeca.com/MDEX/conversation/3/0}NavigationMenuItemGroup" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NavigationMenuItem" type="{http://www.endeca.com/MDEX/conversation/3/0}NavigationMenuItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NavigationMenu", propOrder = {
    "navigationMenuItemGroup",
    "navigationMenuItem"
})
public class NavigationMenu
    extends ContentElement
{

    @XmlElement(name = "NavigationMenuItemGroup")
    protected List<NavigationMenuItemGroup> navigationMenuItemGroup;
    @XmlElement(name = "NavigationMenuItem")
    protected List<NavigationMenuItem> navigationMenuItem;

    /**
     * Gets the value of the navigationMenuItemGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the navigationMenuItemGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNavigationMenuItemGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NavigationMenuItemGroup }
     * 
     * 
     */
    public List<NavigationMenuItemGroup> getNavigationMenuItemGroup() {
        if (navigationMenuItemGroup == null) {
            navigationMenuItemGroup = new ArrayList<NavigationMenuItemGroup>();
        }
        return this.navigationMenuItemGroup;
    }

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

}
