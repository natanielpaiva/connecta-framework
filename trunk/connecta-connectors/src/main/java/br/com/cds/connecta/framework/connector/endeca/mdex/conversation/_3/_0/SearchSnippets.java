
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A list of search snippets associated with an attribute.  Most of the time this list
 * 						will only have one snippet in it, but in some cases will return more.  For example
 * 						the user searches for multiple terms and has the two terms match in the same attribute.
 * 
 * <p>Classe Java de SearchSnippets complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SearchSnippets">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchSnippet" type="{http://www.endeca.com/MDEX/conversation/3/0}SearchSnippet" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Key" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchSnippets", propOrder = {
    "searchSnippet"
})
public class SearchSnippets {

    @XmlElement(name = "SearchSnippet")
    protected List<SearchSnippet> searchSnippet;
    @XmlAttribute(name = "Key", required = true)
    protected String key;

    /**
     * Gets the value of the searchSnippet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchSnippet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchSnippet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchSnippet }
     * 
     * 
     */
    public List<SearchSnippet> getSearchSnippet() {
        if (searchSnippet == null) {
            searchSnippet = new ArrayList<SearchSnippet>();
        }
        return this.searchSnippet;
    }

    /**
     * Obt\u00e9m o valor da propriedade key.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Define o valor da propriedade key.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

}
