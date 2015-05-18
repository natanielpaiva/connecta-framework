
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SAColumn complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SAColumn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="displayName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nullable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="aggregatable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="aggrRule" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SAColumn", propOrder = {
    "name",
    "displayName",
    "description",
    "nullable",
    "dataType",
    "aggregatable",
    "aggrRule"
})
public class SAColumn {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String displayName;
    @XmlElement(required = true)
    protected String description;
    protected boolean nullable;
    @XmlElement(required = true)
    protected String dataType;
    protected boolean aggregatable;
    @XmlElement(required = true)
    protected String aggrRule;

    /**
     * Obtém o valor da propriedade name.
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
     * Obtém o valor da propriedade displayName.
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
     * Obtém o valor da propriedade description.
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
     * Obtém o valor da propriedade nullable.
     * 
     */
    public boolean isNullable() {
        return nullable;
    }

    /**
     * Define o valor da propriedade nullable.
     * 
     */
    public void setNullable(boolean value) {
        this.nullable = value;
    }

    /**
     * Obtém o valor da propriedade dataType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * Define o valor da propriedade dataType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataType(String value) {
        this.dataType = value;
    }

    /**
     * Obtém o valor da propriedade aggregatable.
     * 
     */
    public boolean isAggregatable() {
        return aggregatable;
    }

    /**
     * Define o valor da propriedade aggregatable.
     * 
     */
    public void setAggregatable(boolean value) {
        this.aggregatable = value;
    }

    /**
     * Obtém o valor da propriedade aggrRule.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAggrRule() {
        return aggrRule;
    }

    /**
     * Define o valor da propriedade aggrRule.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAggrRule(String value) {
        this.aggrRule = value;
    }

}
