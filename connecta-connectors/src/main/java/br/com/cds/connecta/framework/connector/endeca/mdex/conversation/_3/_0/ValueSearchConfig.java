
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Controls the behavior of a single value search. Searches all properties if                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;RestrictToProperties&lt;/code&gt;
 * </pre>
 * 
 * is not specified, otherwise just searches values within the properties given. 
 * 						If                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;MaxPerProperty&lt;/code&gt;
 * </pre>
 * 
 * is specified it limits the number of matches returned per property. 
 * 						Note that, if record search is used in the filter, that search cannot use Boolean match mode. 
 * 						There is no such restriction on the match mode for the value search.                    
 * 
 * <p>Classe Java de ValueSearchConfig complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ValueSearchConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElementConfig">
 *       &lt;sequence>
 *         &lt;element name="SearchTerm" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString"/>
 *         &lt;element name="RestrictToProperties" type="{http://www.endeca.com/MDEX/conversation/3/0}PropertyRestrictionList" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="MaxPerProperty" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
 *       &lt;attribute name="RelevanceRankingStrategy" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="Mode" type="{http://www.endeca.com/MDEX/conversation/3/0}SearchMode" />
 *       &lt;attribute name="Language" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValueSearchConfig", propOrder = {
    "searchTerm",
    "restrictToProperties"
})
public class ValueSearchConfig
    extends ContentElementConfig
{

    @XmlElement(name = "SearchTerm", required = true)
    protected String searchTerm;
    @XmlElement(name = "RestrictToProperties")
    protected PropertyRestrictionList restrictToProperties;
    @XmlAttribute(name = "MaxPerProperty")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger maxPerProperty;
    @XmlAttribute(name = "RelevanceRankingStrategy")
    protected String relevanceRankingStrategy;
    @XmlAttribute(name = "Mode")
    protected SearchMode mode;
    @XmlAttribute(name = "Language")
    protected String language;

    /**
     * Obt\u00e9m o valor da propriedade searchTerm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     * Define o valor da propriedade searchTerm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchTerm(String value) {
        this.searchTerm = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade restrictToProperties.
     * 
     * @return
     *     possible object is
     *     {@link PropertyRestrictionList }
     *     
     */
    public PropertyRestrictionList getRestrictToProperties() {
        return restrictToProperties;
    }

    /**
     * Define o valor da propriedade restrictToProperties.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyRestrictionList }
     *     
     */
    public void setRestrictToProperties(PropertyRestrictionList value) {
        this.restrictToProperties = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade maxPerProperty.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxPerProperty() {
        return maxPerProperty;
    }

    /**
     * Define o valor da propriedade maxPerProperty.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxPerProperty(BigInteger value) {
        this.maxPerProperty = value;
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
