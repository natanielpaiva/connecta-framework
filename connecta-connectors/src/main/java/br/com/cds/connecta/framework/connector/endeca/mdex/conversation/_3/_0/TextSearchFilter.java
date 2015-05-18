
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * A TextSearchFilter type that parallels the structure of a MAX Search element. Key is the search
 * 						interface to use and the text contents of the element is the search term(s).
 * 
 * <p>Classe Java de TextSearchFilter complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TextSearchFilter">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.endeca.com/MDEX/conversation/3/0>NonEmptyString">
 *       &lt;attribute name="Key" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="RelevanceRankingStrategy" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="Mode" type="{http://www.endeca.com/MDEX/conversation/3/0}SearchMode" />
 *       &lt;attribute name="EnableSnippeting" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="SnippetLength" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
 *       &lt;attribute name="Language" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextSearchFilter", propOrder = {
    "value"
})
public class TextSearchFilter {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "Key", required = true)
    protected String key;
    @XmlAttribute(name = "RelevanceRankingStrategy")
    protected String relevanceRankingStrategy;
    @XmlAttribute(name = "Mode")
    protected SearchMode mode;
    @XmlAttribute(name = "EnableSnippeting")
    protected Boolean enableSnippeting;
    @XmlAttribute(name = "SnippetLength")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger snippetLength;
    @XmlAttribute(name = "Language")
    protected String language;

    /**
     * Used to force string inputs to be non-empty.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Define o valor da propriedade value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
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

    /**
     * Obt\u00e9m o valor da propriedade relevanceRankingStrategy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelevanceRankingStrategy() {
        return relevanceRankingStrategy;
    }

    /**
     * Define o valor da propriedade relevanceRankingStrategy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelevanceRankingStrategy(String value) {
        this.relevanceRankingStrategy = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade mode.
     * 
     * @return
     *     possible object is
     *     {@link SearchMode }
     *     
     */
    public SearchMode getMode() {
        return mode;
    }

    /**
     * Define o valor da propriedade mode.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchMode }
     *     
     */
    public void setMode(SearchMode value) {
        this.mode = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade enableSnippeting.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnableSnippeting() {
        return enableSnippeting;
    }

    /**
     * Define o valor da propriedade enableSnippeting.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnableSnippeting(Boolean value) {
        this.enableSnippeting = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade snippetLength.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSnippetLength() {
        return snippetLength;
    }

    /**
     * Define o valor da propriedade snippetLength.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSnippetLength(BigInteger value) {
        this.snippetLength = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade language.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Define o valor da propriedade language.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

}
