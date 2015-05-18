
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The result data corresponding to a BreadcrumbsConfig request. Breadcrumbs for refinement and search are 
 * 						presented separately.
 * 
 * <p>Classe Java de Breadcrumbs complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Breadcrumbs">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElement">
 *       &lt;sequence>
 *         &lt;element name="RefinementBreadcrumb" type="{http://www.endeca.com/MDEX/conversation/3/0}RefinementBreadcrumb" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SearchBreadcrumb" type="{http://www.endeca.com/MDEX/conversation/3/0}SearchBreadcrumb" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Breadcrumbs", propOrder = {
    "refinementBreadcrumb",
    "searchBreadcrumb"
})
public class Breadcrumbs
    extends ContentElement
{

    @XmlElement(name = "RefinementBreadcrumb")
    protected List<RefinementBreadcrumb> refinementBreadcrumb;
    @XmlElement(name = "SearchBreadcrumb")
    protected List<SearchBreadcrumb> searchBreadcrumb;

    /**
     * Gets the value of the refinementBreadcrumb property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refinementBreadcrumb property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefinementBreadcrumb().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefinementBreadcrumb }
     * 
     * 
     */
    public List<RefinementBreadcrumb> getRefinementBreadcrumb() {
        if (refinementBreadcrumb == null) {
            refinementBreadcrumb = new ArrayList<RefinementBreadcrumb>();
        }
        return this.refinementBreadcrumb;
    }

    /**
     * Gets the value of the searchBreadcrumb property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchBreadcrumb property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchBreadcrumb().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchBreadcrumb }
     * 
     * 
     */
    public List<SearchBreadcrumb> getSearchBreadcrumb() {
        if (searchBreadcrumb == null) {
            searchBreadcrumb = new ArrayList<SearchBreadcrumb>();
        }
        return this.searchBreadcrumb;
    }

}
