
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The result data corresponding to an EQLConfig request.
 * 
 * <p>Classe Java de EQL complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="EQL">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElement">
 *       &lt;sequence>
 *         &lt;element name="ResultRecords" type="{http://www.endeca.com/MDEX/conversation/3/0}ResultRecords" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EQL", propOrder = {
    "resultRecords"
})
public class EQL
    extends ContentElement
{

    @XmlElement(name = "ResultRecords")
    protected List<ResultRecords> resultRecords;

    /**
     * Gets the value of the resultRecords property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resultRecords property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResultRecords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResultRecords }
     * 
     * 
     */
    public List<ResultRecords> getResultRecords() {
        if (resultRecords == null) {
            resultRecords = new ArrayList<ResultRecords>();
        }
        return this.resultRecords;
    }

}
