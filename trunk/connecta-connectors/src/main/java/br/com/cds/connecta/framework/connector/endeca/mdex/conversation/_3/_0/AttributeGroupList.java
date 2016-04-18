
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List of attribute groups selected by the current State and
 * 						their constituent attributes.  Note that a group is
 * 						included if and only if its GDR is in the State; it is
 * 						neither necessary nor sufficient for records with
 * 						assignments from the attribute to be in the State.
 * 
 * <p>Classe Java de AttributeGroupList complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="AttributeGroupList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElement">
 *       &lt;sequence>
 *         &lt;element name="GroupSummary" type="{http://www.endeca.com/MDEX/conversation/3/0}GroupSummary" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttributeGroupList", propOrder = {
    "groupSummary"
})
public class AttributeGroupList
    extends ContentElement
{

    @XmlElement(name = "GroupSummary")
    protected List<GroupSummary> groupSummary;

    /**
     * Gets the value of the groupSummary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groupSummary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroupSummary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GroupSummary }
     * 
     * 
     */
    public List<GroupSummary> getGroupSummary() {
        if (groupSummary == null) {
            groupSummary = new ArrayList<GroupSummary>();
        }
        return this.groupSummary;
    }

}
