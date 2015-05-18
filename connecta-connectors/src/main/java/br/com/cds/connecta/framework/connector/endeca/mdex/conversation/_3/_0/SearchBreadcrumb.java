
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Details of search for a breadcrumb.
 * 
 * <p>Classe Java de SearchBreadcrumb complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SearchBreadcrumb">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TextSearchFilter" type="{http://www.endeca.com/MDEX/conversation/3/0}TextSearchFilter"/>
 *       &lt;/sequence>
 *       &lt;attribute name="DisplayName" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchBreadcrumb", propOrder = {
    "textSearchFilter"
})
public class SearchBreadcrumb {

    @XmlElement(name = "TextSearchFilter", required = true)
    protected TextSearchFilter textSearchFilter;
    @XmlAttribute(name = "DisplayName", required = true)
    protected String displayName;

    /**
     * Obt\u00e9m o valor da propriedade textSearchFilter.
     * 
     * @return
     *     possible object is
     *     {@link TextSearchFilter }
     *     
     */
    public TextSearchFilter getTextSearchFilter() {
        return textSearchFilter;
    }

    /**
     * Define o valor da propriedade textSearchFilter.
     * 
     * @param value
     *     allowed object is
     *     {@link TextSearchFilter }
     *     
     */
    public void setTextSearchFilter(TextSearchFilter value) {
        this.textSearchFilter = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade displayName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Define o valor da propriedade displayName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

}
