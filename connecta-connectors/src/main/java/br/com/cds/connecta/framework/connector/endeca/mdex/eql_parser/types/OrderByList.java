
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de OrderByList complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="OrderByList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}Node">
 *       &lt;sequence>
 *         &lt;element name="orderBys" type="{http://www.endeca.com/MDEX/eql_parser/types}OrderBy" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderByList", propOrder = {
    "orderBys"
})
public class OrderByList
    extends Node
{

    @XmlElement(required = true)
    protected List<OrderBy> orderBys;

    /**
     * Gets the value of the orderBys property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderBys property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderBys().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrderBy }
     * 
     * 
     */
    public List<OrderBy> getOrderBys() {
        if (orderBys == null) {
            orderBys = new ArrayList<OrderBy>();
        }
        return this.orderBys;
    }

}
