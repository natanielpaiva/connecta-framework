
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The searchable properties and search interfaces available. 
 * 						Presented in a single alphabetically ordered list. This information is
 * 						independent of the state.
 * 
 * <p>Classe Java de AvailableSearchKeys complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="AvailableSearchKeys">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElement">
 *       &lt;sequence>
 *         &lt;element name="AvailableSearchKey" type="{http://www.endeca.com/MDEX/conversation/3/0}AvailableSearchKey" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AvailableSearchKeys", propOrder = {
    "availableSearchKey"
})
public class AvailableSearchKeys
    extends ContentElement
{

    @XmlElement(name = "AvailableSearchKey")
    protected List<AvailableSearchKey> availableSearchKey;

    /**
     * Gets the value of the availableSearchKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availableSearchKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailableSearchKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AvailableSearchKey }
     * 
     * 
     */
    public List<AvailableSearchKey> getAvailableSearchKey() {
        if (availableSearchKey == null) {
            availableSearchKey = new ArrayList<AvailableSearchKey>();
        }
        return this.availableSearchKey;
    }

}
