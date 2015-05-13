
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * A suggested search adjustment used for DidYouMean. The
 * 						TextSearchFilter associates this suggestion with a
 * 						particular search from the query.
 * 
 * <p>Classe Java de SuggestedSearchAdjustment complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SuggestedSearchAdjustment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TextSearchFilter" type="{http://www.endeca.com/MDEX/conversation/3/0}TextSearchFilter"/>
 *         &lt;element name="SuggestedTerms" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString"/>
 *       &lt;/sequence>
 *       &lt;attribute name="RecordCountIfApplied" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SuggestedSearchAdjustment", propOrder = {
    "textSearchFilter",
    "suggestedTerms"
})
public class SuggestedSearchAdjustment {

    @XmlElement(name = "TextSearchFilter", required = true)
    protected TextSearchFilter textSearchFilter;
    @XmlElement(name = "SuggestedTerms", required = true)
    protected String suggestedTerms;
    @XmlAttribute(name = "RecordCountIfApplied", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long recordCountIfApplied;

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
     * Obt\u00e9m o valor da propriedade suggestedTerms.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuggestedTerms() {
        return suggestedTerms;
    }

    /**
     * Define o valor da propriedade suggestedTerms.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuggestedTerms(String value) {
        this.suggestedTerms = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade recordCountIfApplied.
     * 
     */
    public long getRecordCountIfApplied() {
        return recordCountIfApplied;
    }

    /**
     * Define o valor da propriedade recordCountIfApplied.
     * 
     */
    public void setRecordCountIfApplied(long value) {
        this.recordCountIfApplied = value;
    }

}
