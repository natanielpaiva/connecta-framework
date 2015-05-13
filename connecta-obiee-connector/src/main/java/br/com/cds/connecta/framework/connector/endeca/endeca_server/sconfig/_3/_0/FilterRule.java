
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * An element representing a Filter Rule and all the attributes it contains.
 * 
 * <p>Classe Java de filterRule complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="filterRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="filterRuleKey" use="required" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" />
 *       &lt;attribute name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sourceCollectionKey" use="required" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" />
 *       &lt;attribute name="sourcePropertyKey" use="required" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" />
 *       &lt;attribute name="targetCollectionKey" use="required" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" />
 *       &lt;attribute name="targetPropertyKey" use="required" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" />
 *       &lt;attribute name="isActive" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filterRule")
public class FilterRule {

    @XmlAttribute(name = "filterRuleKey", required = true)
    protected String filterRuleKey;
    @XmlAttribute(name = "displayName")
    protected String displayName;
    @XmlAttribute(name = "sourceCollectionKey", required = true)
    protected String sourceCollectionKey;
    @XmlAttribute(name = "sourcePropertyKey", required = true)
    protected String sourcePropertyKey;
    @XmlAttribute(name = "targetCollectionKey", required = true)
    protected String targetCollectionKey;
    @XmlAttribute(name = "targetPropertyKey", required = true)
    protected String targetPropertyKey;
    @XmlAttribute(name = "isActive", required = true)
    protected boolean isActive;

    /**
     * Obt\u00e9m o valor da propriedade filterRuleKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterRuleKey() {
        return filterRuleKey;
    }

    /**
     * Define o valor da propriedade filterRuleKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterRuleKey(String value) {
        this.filterRuleKey = value;
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

    /**
     * Obt\u00e9m o valor da propriedade sourceCollectionKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceCollectionKey() {
        return sourceCollectionKey;
    }

    /**
     * Define o valor da propriedade sourceCollectionKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceCollectionKey(String value) {
        this.sourceCollectionKey = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade sourcePropertyKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourcePropertyKey() {
        return sourcePropertyKey;
    }

    /**
     * Define o valor da propriedade sourcePropertyKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourcePropertyKey(String value) {
        this.sourcePropertyKey = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade targetCollectionKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetCollectionKey() {
        return targetCollectionKey;
    }

    /**
     * Define o valor da propriedade targetCollectionKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetCollectionKey(String value) {
        this.targetCollectionKey = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade targetPropertyKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetPropertyKey() {
        return targetPropertyKey;
    }

    /**
     * Define o valor da propriedade targetPropertyKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetPropertyKey(String value) {
        this.targetPropertyKey = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade isActive.
     * 
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * Define o valor da propriedade isActive.
     * 
     */
    public void setIsActive(boolean value) {
        this.isActive = value;
    }

}
