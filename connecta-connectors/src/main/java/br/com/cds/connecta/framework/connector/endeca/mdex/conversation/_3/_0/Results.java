
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * The Results type contains the components that were requested after the possibly
 * 						modified states were applied.  The applicable state is returned as well.
 * 
 * <p>Classe Java de Results complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Results">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="State" type="{http://www.endeca.com/MDEX/conversation/3/0}State" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.endeca.com/MDEX/conversation/3/0}ContentElement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Results", propOrder = {
    "state",
    "contentElement"
})
public class Results {

    @XmlElement(name = "State")
    protected List<State> state;
    @XmlElements({
        @XmlElement(name = "AttributeGroupList", type = AttributeGroupList.class),
        @XmlElement(name = "PropertyList", type = PropertyList.class),
        @XmlElement(name = "AvailableSearchKeys", type = AvailableSearchKeys.class),
        @XmlElement(name = "NavigationMenu", type = NavigationMenu.class),
        @XmlElement(name = "ValueSearch", type = ValueSearch.class),
        @XmlElement(name = "Breadcrumbs", type = Breadcrumbs.class),
        @XmlElement(name = "SearchAdjustments", type = SearchAdjustments.class),
        @XmlElement(name = "RecordList", type = RecordList.class),
        @XmlElement(name = "RecordDetails", type = RecordDetails.class),
        @XmlElement(name = "EQL", type = EQL.class),
        @XmlElement(name = "RecordCount", type = RecordCount.class)
    })
    protected List<ContentElement> contentElement;

    /**
     * Gets the value of the state property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the state property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link State }
     * 
     * 
     */
    public List<State> getState() {
        if (state == null) {
            state = new ArrayList<State>();
        }
        return this.state;
    }

    /**
     * Gets the value of the contentElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttributeGroupList }
     * {@link PropertyList }
     * {@link AvailableSearchKeys }
     * {@link NavigationMenu }
     * {@link ValueSearch }
     * {@link Breadcrumbs }
     * {@link SearchAdjustments }
     * {@link RecordList }
     * {@link RecordDetails }
     * {@link EQL }
     * {@link RecordCount }
     * 
     * 
     */
    public List<ContentElement> getContentElement() {
        if (contentElement == null) {
            contentElement = new ArrayList<ContentElement>();
        }
        return this.contentElement;
    }

}
