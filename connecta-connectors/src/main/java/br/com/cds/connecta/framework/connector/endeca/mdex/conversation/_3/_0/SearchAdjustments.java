
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Corresponds to a SearchAdujstmentConfig request.
 * 						Includes both suggested and auto-applied adjustments.
 * 
 * <p>Classe Java de SearchAdjustments complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SearchAdjustments">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElement">
 *       &lt;sequence>
 *         &lt;element name="AppliedAdjustment" type="{http://www.endeca.com/MDEX/conversation/3/0}AppliedSearchAdjustment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SuggestedAdjustment" type="{http://www.endeca.com/MDEX/conversation/3/0}SuggestedSearchAdjustment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchAdjustments", propOrder = {
    "appliedAdjustment",
    "suggestedAdjustment"
})
public class SearchAdjustments
    extends ContentElement
{

    @XmlElement(name = "AppliedAdjustment")
    protected List<AppliedSearchAdjustment> appliedAdjustment;
    @XmlElement(name = "SuggestedAdjustment")
    protected List<SuggestedSearchAdjustment> suggestedAdjustment;

    /**
     * Gets the value of the appliedAdjustment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appliedAdjustment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppliedAdjustment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppliedSearchAdjustment }
     * 
     * 
     */
    public List<AppliedSearchAdjustment> getAppliedAdjustment() {
        if (appliedAdjustment == null) {
            appliedAdjustment = new ArrayList<AppliedSearchAdjustment>();
        }
        return this.appliedAdjustment;
    }

    /**
     * Gets the value of the suggestedAdjustment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the suggestedAdjustment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSuggestedAdjustment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SuggestedSearchAdjustment }
     * 
     * 
     */
    public List<SuggestedSearchAdjustment> getSuggestedAdjustment() {
        if (suggestedAdjustment == null) {
            suggestedAdjustment = new ArrayList<SuggestedSearchAdjustment>();
        }
        return this.suggestedAdjustment;
    }

}
