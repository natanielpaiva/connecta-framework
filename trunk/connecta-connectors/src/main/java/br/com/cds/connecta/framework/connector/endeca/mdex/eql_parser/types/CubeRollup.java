
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de CubeRollup complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CubeRollup">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}GroupSetBase">
 *       &lt;sequence>
 *         &lt;element name="groupingSetList" type="{http://www.endeca.com/MDEX/eql_parser/types}GroupingSet" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="cubeOrRollupName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CubeRollup", propOrder = {
    "groupingSetList"
})
public class CubeRollup
    extends GroupSetBase
{

    protected List<GroupingSet> groupingSetList;
    @XmlAttribute(name = "cubeOrRollupName", required = true)
    protected String cubeOrRollupName;

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
     * {@link GroupingSet }
     * 
     * 
     */
    public List<GroupingSet> getGroupingSetList() {
        if (groupingSetList == null) {
            groupingSetList = new ArrayList<GroupingSet>();
        }
        return this.groupingSetList;
    }

    /**
     * Obt\u00e9m o valor da propriedade cubeOrRollupName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCubeOrRollupName() {
        return cubeOrRollupName;
    }

    /**
     * Define o valor da propriedade cubeOrRollupName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCubeOrRollupName(String value) {
        this.cubeOrRollupName = value;
    }

}
