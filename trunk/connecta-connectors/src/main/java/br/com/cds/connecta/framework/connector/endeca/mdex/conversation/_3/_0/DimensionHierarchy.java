
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A collection of paths from dimensions of interest.
 * 
 * <p>Classe Java de DimensionHierarchy complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="DimensionHierarchy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DimensionValueWithPath" type="{http://www.endeca.com/MDEX/conversation/3/0}DimensionValueWithPath" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DimensionHierarchy", propOrder = {
    "dimensionValueWithPath"
})
public class DimensionHierarchy {

    @XmlElement(name = "DimensionValueWithPath")
    protected List<DimensionValueWithPath> dimensionValueWithPath;

    /**
     * Gets the value of the dimensionValueWithPath property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dimensionValueWithPath property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDimensionValueWithPath().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DimensionValueWithPath }
     * 
     * 
     */
    public List<DimensionValueWithPath> getDimensionValueWithPath() {
        if (dimensionValueWithPath == null) {
            dimensionValueWithPath = new ArrayList<DimensionValueWithPath>();
        }
        return this.dimensionValueWithPath;
    }

}
