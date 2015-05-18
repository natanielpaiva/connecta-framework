
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A set of properties computed during a query for a particular record.
 * 
 * <p>Classe Java de ComputedProperties complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ComputedProperties">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSnippets" type="{http://www.endeca.com/MDEX/conversation/3/0}SearchSnippets" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RelevanceRank" type="{http://www.endeca.com/MDEX/conversation/3/0}RelevanceRank" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComputedProperties", propOrder = {
    "searchSnippets",
    "relevanceRank"
})
public class ComputedProperties {

    @XmlElement(name = "SearchSnippets")
    protected List<SearchSnippets> searchSnippets;
    @XmlElement(name = "RelevanceRank")
    protected RelevanceRank relevanceRank;

    /**
     * Gets the value of the searchSnippets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchSnippets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchSnippets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchSnippets }
     * 
     * 
     */
    public List<SearchSnippets> getSearchSnippets() {
        if (searchSnippets == null) {
            searchSnippets = new ArrayList<SearchSnippets>();
        }
        return this.searchSnippets;
    }

    /**
     * Obt\u00e9m o valor da propriedade relevanceRank.
     * 
     * @return
     *     possible object is
     *     {@link RelevanceRank }
     *     
     */
    public RelevanceRank getRelevanceRank() {
        return relevanceRank;
    }

    /**
     * Define o valor da propriedade relevanceRank.
     * 
     * @param value
     *     allowed object is
     *     {@link RelevanceRank }
     *     
     */
    public void setRelevanceRank(RelevanceRank value) {
        this.relevanceRank = value;
    }

}
