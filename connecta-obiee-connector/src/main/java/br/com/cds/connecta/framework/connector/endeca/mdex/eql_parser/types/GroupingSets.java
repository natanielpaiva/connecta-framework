
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de GroupingSets complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="GroupingSets">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}Node">
 *       &lt;sequence>
 *         &lt;element name="groupingSetList" type="{http://www.endeca.com/MDEX/eql_parser/types}GroupSetBase" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupingSets", propOrder = {
    "groupingSetList"
})
public class GroupingSets
    extends Node
{

    @XmlElement(required = true)
    protected List<GroupSetBase> groupingSetList;

    /**
     * Gets the value of the groupingSetList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groupingSetList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroupingSetList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GroupSetBase }
     * 
     * 
     */
    public List<GroupSetBase> getGroupingSetList() {
        if (groupingSetList == null) {
            groupingSetList = new ArrayList<GroupSetBase>();
        }
        return this.groupingSetList;
    }

}
