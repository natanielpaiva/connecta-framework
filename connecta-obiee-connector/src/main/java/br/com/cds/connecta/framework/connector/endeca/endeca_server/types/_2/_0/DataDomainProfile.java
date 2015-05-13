
package br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0;
//package com.endeca.endeca_server.types._2._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A dataDomainProfile specifies the resources available to a data domain.
 * 			It provides a mechanism to offer different levels of service.
 * 
 * <p>Classe Java de dataDomainProfile complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dataDomainProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.endeca.com/endeca-server/types/2/0}nonEmptyString"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="allowQueriesOnLeader" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="numFollowers" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt" minOccurs="0"/>
 *         &lt;element name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="allowOversubscribe" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="numComputeThreads" type="{http://www.endeca.com/endeca-server/types/2/0}positiveIntGreaterThanOne" minOccurs="0"/>
 *         &lt;element name="computeCacheSizeMB" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt" minOccurs="0"/>
 *         &lt;element name="startupTimeoutSeconds" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt" minOccurs="0"/>
 *         &lt;element name="shutdownTimeoutSeconds" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt" minOccurs="0"/>
 *         &lt;element name="sessionIdType" type="{http://www.endeca.com/endeca-server/types/2/0}sessionIdTypes" minOccurs="0"/>
 *         &lt;element name="sessionIdKey" type="{http://www.endeca.com/endeca-server/types/2/0}nonEmptyString" minOccurs="0"/>
 *         &lt;element name="enableAncestorCounts" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="backlogTimeout" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt" minOccurs="0"/>
 *         &lt;element name="minRefinementSamples" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt" minOccurs="0"/>
 *         &lt;element name="enableExactImplicits" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="numImplicitSamples" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt" minOccurs="0"/>
 *         &lt;element name="netTimeoutSeconds" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt" minOccurs="0"/>
 *         &lt;element name="maxSearchTerms" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt" minOccurs="0"/>
 *         &lt;element name="snippetCutoff" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt" minOccurs="0"/>
 *         &lt;element name="disableSnippets" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="enableAllDynamicMAs" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="enableDynamicRelRankBins" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="disableContraction" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="maxWildcards" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt" minOccurs="0"/>
 *         &lt;element name="searchCharLimit" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt" minOccurs="0"/>
 *         &lt;element name="autoIdle" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="idleTimeoutMinutes" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt" minOccurs="0"/>
 *         &lt;element name="args" type="{http://www.endeca.com/endeca-server/types/2/0}nonEmptyString" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataDomainProfile", propOrder = {
    "name",
    "description",
    "allowQueriesOnLeader",
    "numFollowers",
    "readOnly",
    "allowOversubscribe",
    "numComputeThreads",
    "computeCacheSizeMB",
    "startupTimeoutSeconds",
    "shutdownTimeoutSeconds",
    "sessionIdType",
    "sessionIdKey",
    "enableAncestorCounts",
    "backlogTimeout",
    "minRefinementSamples",
    "enableExactImplicits",
    "numImplicitSamples",
    "netTimeoutSeconds",
    "maxSearchTerms",
    "snippetCutoff",
    "disableSnippets",
    "enableAllDynamicMAs",
    "enableDynamicRelRankBins",
    "disableContraction",
    "maxWildcards",
    "searchCharLimit",
    "autoIdle",
    "idleTimeoutMinutes",
    "args"
})
public class DataDomainProfile {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(defaultValue = "")
    protected String description;
    @XmlElement(defaultValue = "true")
    protected Boolean allowQueriesOnLeader;
    @XmlElement(defaultValue = "0")
    protected Integer numFollowers;
    @XmlElement(defaultValue = "false")
    protected Boolean readOnly;
    @XmlElement(defaultValue = "true")
    protected Boolean allowOversubscribe;
    @XmlElement(defaultValue = "2")
    protected Integer numComputeThreads;
    protected Integer computeCacheSizeMB;
    @XmlElement(defaultValue = "600")
    protected Integer startupTimeoutSeconds;
    @XmlElement(defaultValue = "30")
    protected Integer shutdownTimeoutSeconds;
    @XmlElement(defaultValue = "header")
    protected SessionIdTypes sessionIdType;
    @XmlElement(defaultValue = "X-Endeca-Session-ID")
    protected String sessionIdKey;
    @XmlElement(defaultValue = "false")
    protected Boolean enableAncestorCounts;
    @XmlElement(defaultValue = "0")
    protected Integer backlogTimeout;
    @XmlElement(defaultValue = "0")
    protected Integer minRefinementSamples;
    @XmlElement(defaultValue = "false")
    protected Boolean enableExactImplicits;
    @XmlElement(defaultValue = "1024")
    protected Integer numImplicitSamples;
    @XmlElement(defaultValue = "30")
    protected Integer netTimeoutSeconds;
    @XmlElement(defaultValue = "10")
    protected Integer maxSearchTerms;
    @XmlElement(defaultValue = "500")
    protected Integer snippetCutoff;
    @XmlElement(defaultValue = "false")
    protected Boolean disableSnippets;
    @XmlElement(defaultValue = "false")
    protected Boolean enableAllDynamicMAs;
    @XmlElement(defaultValue = "false")
    protected Boolean enableDynamicRelRankBins;
    @XmlElement(defaultValue = "false")
    protected Boolean disableContraction;
    @XmlElement(defaultValue = "100")
    protected Integer maxWildcards;
    protected Integer searchCharLimit;
    @XmlElement(defaultValue = "false")
    protected Boolean autoIdle;
    @XmlElement(defaultValue = "10")
    protected Integer idleTimeoutMinutes;
    protected List<String> args;

    /**
     * Obt\u00e9m o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define o valor da propriedade description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade allowQueriesOnLeader.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowQueriesOnLeader() {
        return allowQueriesOnLeader;
    }

    /**
     * Define o valor da propriedade allowQueriesOnLeader.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowQueriesOnLeader(Boolean value) {
        this.allowQueriesOnLeader = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade numFollowers.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumFollowers() {
        return numFollowers;
    }

    /**
     * Define o valor da propriedade numFollowers.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumFollowers(Integer value) {
        this.numFollowers = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade readOnly.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReadOnly() {
        return readOnly;
    }

    /**
     * Define o valor da propriedade readOnly.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReadOnly(Boolean value) {
        this.readOnly = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade allowOversubscribe.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowOversubscribe() {
        return allowOversubscribe;
    }

    /**
     * Define o valor da propriedade allowOversubscribe.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowOversubscribe(Boolean value) {
        this.allowOversubscribe = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade numComputeThreads.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumComputeThreads() {
        return numComputeThreads;
    }

    /**
     * Define o valor da propriedade numComputeThreads.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumComputeThreads(Integer value) {
        this.numComputeThreads = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade computeCacheSizeMB.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getComputeCacheSizeMB() {
        return computeCacheSizeMB;
    }

    /**
     * Define o valor da propriedade computeCacheSizeMB.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setComputeCacheSizeMB(Integer value) {
        this.computeCacheSizeMB = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade startupTimeoutSeconds.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStartupTimeoutSeconds() {
        return startupTimeoutSeconds;
    }

    /**
     * Define o valor da propriedade startupTimeoutSeconds.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStartupTimeoutSeconds(Integer value) {
        this.startupTimeoutSeconds = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade shutdownTimeoutSeconds.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getShutdownTimeoutSeconds() {
        return shutdownTimeoutSeconds;
    }

    /**
     * Define o valor da propriedade shutdownTimeoutSeconds.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setShutdownTimeoutSeconds(Integer value) {
        this.shutdownTimeoutSeconds = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade sessionIdType.
     * 
     * @return
     *     possible object is
     *     {@link SessionIdTypes }
     *     
     */
    public SessionIdTypes getSessionIdType() {
        return sessionIdType;
    }

    /**
     * Define o valor da propriedade sessionIdType.
     * 
     * @param value
     *     allowed object is
     *     {@link SessionIdTypes }
     *     
     */
    public void setSessionIdType(SessionIdTypes value) {
        this.sessionIdType = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade sessionIdKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionIdKey() {
        return sessionIdKey;
    }

    /**
     * Define o valor da propriedade sessionIdKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionIdKey(String value) {
        this.sessionIdKey = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade enableAncestorCounts.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnableAncestorCounts() {
        return enableAncestorCounts;
    }

    /**
     * Define o valor da propriedade enableAncestorCounts.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnableAncestorCounts(Boolean value) {
        this.enableAncestorCounts = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade backlogTimeout.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBacklogTimeout() {
        return backlogTimeout;
    }

    /**
     * Define o valor da propriedade backlogTimeout.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBacklogTimeout(Integer value) {
        this.backlogTimeout = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade minRefinementSamples.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinRefinementSamples() {
        return minRefinementSamples;
    }

    /**
     * Define o valor da propriedade minRefinementSamples.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinRefinementSamples(Integer value) {
        this.minRefinementSamples = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade enableExactImplicits.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnableExactImplicits() {
        return enableExactImplicits;
    }

    /**
     * Define o valor da propriedade enableExactImplicits.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnableExactImplicits(Boolean value) {
        this.enableExactImplicits = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade numImplicitSamples.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumImplicitSamples() {
        return numImplicitSamples;
    }

    /**
     * Define o valor da propriedade numImplicitSamples.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumImplicitSamples(Integer value) {
        this.numImplicitSamples = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade netTimeoutSeconds.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNetTimeoutSeconds() {
        return netTimeoutSeconds;
    }

    /**
     * Define o valor da propriedade netTimeoutSeconds.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNetTimeoutSeconds(Integer value) {
        this.netTimeoutSeconds = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade maxSearchTerms.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxSearchTerms() {
        return maxSearchTerms;
    }

    /**
     * Define o valor da propriedade maxSearchTerms.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxSearchTerms(Integer value) {
        this.maxSearchTerms = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade snippetCutoff.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSnippetCutoff() {
        return snippetCutoff;
    }

    /**
     * Define o valor da propriedade snippetCutoff.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSnippetCutoff(Integer value) {
        this.snippetCutoff = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade disableSnippets.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDisableSnippets() {
        return disableSnippets;
    }

    /**
     * Define o valor da propriedade disableSnippets.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisableSnippets(Boolean value) {
        this.disableSnippets = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade enableAllDynamicMAs.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnableAllDynamicMAs() {
        return enableAllDynamicMAs;
    }

    /**
     * Define o valor da propriedade enableAllDynamicMAs.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnableAllDynamicMAs(Boolean value) {
        this.enableAllDynamicMAs = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade enableDynamicRelRankBins.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnableDynamicRelRankBins() {
        return enableDynamicRelRankBins;
    }

    /**
     * Define o valor da propriedade enableDynamicRelRankBins.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnableDynamicRelRankBins(Boolean value) {
        this.enableDynamicRelRankBins = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade disableContraction.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDisableContraction() {
        return disableContraction;
    }

    /**
     * Define o valor da propriedade disableContraction.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisableContraction(Boolean value) {
        this.disableContraction = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade maxWildcards.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxWildcards() {
        return maxWildcards;
    }

    /**
     * Define o valor da propriedade maxWildcards.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxWildcards(Integer value) {
        this.maxWildcards = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade searchCharLimit.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSearchCharLimit() {
        return searchCharLimit;
    }

    /**
     * Define o valor da propriedade searchCharLimit.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSearchCharLimit(Integer value) {
        this.searchCharLimit = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade autoIdle.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoIdle() {
        return autoIdle;
    }

    /**
     * Define o valor da propriedade autoIdle.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoIdle(Boolean value) {
        this.autoIdle = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade idleTimeoutMinutes.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdleTimeoutMinutes() {
        return idleTimeoutMinutes;
    }

    /**
     * Define o valor da propriedade idleTimeoutMinutes.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdleTimeoutMinutes(Integer value) {
        this.idleTimeoutMinutes = value;
    }

    /**
     * Gets the value of the args property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the args property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArgs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getArgs() {
        if (args == null) {
            args = new ArrayList<String>();
        }
        return this.args;
    }

}
