
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An applied search adjustment used for AutoCorrect. The
 * 						TextSearchFilter is the original query, the AdjustedTerms
 * 						are the corrected terms.
 * 
 * <p>Classe Java de AppliedSearchAdjustment complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="AppliedSearchAdjustment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TextSearchFilter" type="{http://www.endeca.com/MDEX/conversation/3/0}TextSearchFilter"/>
 *         &lt;element name="AdjustedTerms" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppliedSearchAdjustment", propOrder = {
    "textSearchFilter",
    "adjustedTerms"
})
public class AppliedSearchAdjustment {

    @XmlElement(name = "TextSearchFilter", required = true)
    protected TextSearchFilter textSearchFilter;
    @XmlElement(name = "AdjustedTerms", required = true)
    protected String adjustedTerms;

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
     * Obt\u00e9m o valor da propriedade adjustedTerms.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdjustedTerms() {
        return adjustedTerms;
    }

    /**
     * Define o valor da propriedade adjustedTerms.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdjustedTerms(String value) {
        this.adjustedTerms = value;
    }

}
