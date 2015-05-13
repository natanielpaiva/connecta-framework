
package br.com.cds.connecta.framework.connector.obiee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SegmentationOptions complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SegmentationOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="removeCacheHits" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="countOverride" type="{urn://oracle.bi.webservices/v6}OverrideType" minOccurs="0"/>
 *         &lt;element name="cacheOverride" type="{urn://oracle.bi.webservices/v6}OverrideType" minOccurs="0"/>
 *         &lt;element name="samplingFactor" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="govRules" type="{urn://oracle.bi.webservices/v6}NameValuePair" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="prompts" type="{urn://oracle.bi.webservices/v6}NameValuePair" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SegmentationOptions", propOrder = {
    "removeCacheHits",
    "countOverride",
    "cacheOverride",
    "samplingFactor",
    "govRules",
    "prompts"
})
public class SegmentationOptions {

    @XmlElement(defaultValue = "false")
    protected Boolean removeCacheHits;
    @XmlElement(defaultValue = "Default")
    protected OverrideType countOverride;
    @XmlElement(defaultValue = "Default")
    protected OverrideType cacheOverride;
    @XmlElement(defaultValue = "100")
    protected BigDecimal samplingFactor;
    protected List<NameValuePair> govRules;
    protected List<NameValuePair> prompts;

    /**
     * Obtém o valor da propriedade removeCacheHits.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRemoveCacheHits() {
        return removeCacheHits;
    }

    /**
     * Define o valor da propriedade removeCacheHits.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRemoveCacheHits(Boolean value) {
        this.removeCacheHits = value;
    }

    /**
     * Obtém o valor da propriedade countOverride.
     * 
     * @return
     *     possible object is
     *     {@link OverrideType }
     *     
     */
    public OverrideType getCountOverride() {
        return countOverride;
    }

    /**
     * Define o valor da propriedade countOverride.
     * 
     * @param value
     *     allowed object is
     *     {@link OverrideType }
     *     
     */
    public void setCountOverride(OverrideType value) {
        this.countOverride = value;
    }

    /**
     * Obtém o valor da propriedade cacheOverride.
     * 
     * @return
     *     possible object is
     *     {@link OverrideType }
     *     
     */
    public OverrideType getCacheOverride() {
        return cacheOverride;
    }

    /**
     * Define o valor da propriedade cacheOverride.
     * 
     * @param value
     *     allowed object is
     *     {@link OverrideType }
     *     
     */
    public void setCacheOverride(OverrideType value) {
        this.cacheOverride = value;
    }

    /**
     * Obtém o valor da propriedade samplingFactor.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSamplingFactor() {
        return samplingFactor;
    }

    /**
     * Define o valor da propriedade samplingFactor.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSamplingFactor(BigDecimal value) {
        this.samplingFactor = value;
    }

    /**
     * Gets the value of the govRules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the govRules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGovRules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameValuePair }
     * 
     * 
     */
    public List<NameValuePair> getGovRules() {
        if (govRules == null) {
            govRules = new ArrayList<NameValuePair>();
        }
        return this.govRules;
    }

    /**
     * Gets the value of the prompts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prompts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrompts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameValuePair }
     * 
     * 
     */
    public List<NameValuePair> getPrompts() {
        if (prompts == null) {
            prompts = new ArrayList<NameValuePair>();
        }
        return this.prompts;
    }

}
