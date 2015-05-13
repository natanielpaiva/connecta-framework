
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * A substring from an assignment which gives context around a search term match.
 * 
 * <p>Classe Java de SearchSnippet complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SearchSnippet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element name="SnippetText" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString"/>
 *           &lt;element name="SnippetTerm" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchSnippet", propOrder = {
    "snippetTextOrSnippetTerm"
})
public class SearchSnippet {

    @XmlElementRefs({
        @XmlElementRef(name = "SnippetTerm", namespace = "http://www.endeca.com/MDEX/conversation/3/0", type = JAXBElement.class),
        @XmlElementRef(name = "SnippetText", namespace = "http://www.endeca.com/MDEX/conversation/3/0", type = JAXBElement.class)
    })
    protected List<JAXBElement<String>> snippetTextOrSnippetTerm;

    /**
     * Gets the value of the snippetTextOrSnippetTerm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the snippetTextOrSnippetTerm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSnippetTextOrSnippetTerm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getSnippetTextOrSnippetTerm() {
        if (snippetTextOrSnippetTerm == null) {
            snippetTextOrSnippetTerm = new ArrayList<JAXBElement<String>>();
        }
        return this.snippetTextOrSnippetTerm;
    }

}
