
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * The ContentElementConfig is the base class for Configs. A Config
 * 						is a logical representation of a chunk of data. A Config
 * 						can provide a "projection" of data that is determined by its State.
 * 
 * <p>Classe Java de ContentElementConfig complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ContentElementConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StateName" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentElementConfig", propOrder = {
    "stateName"
})
@XmlSeeAlso({
    PropertyListConfig.class,
    SearchAdjustmentConfig.class,
    ValueSearchConfig.class,
    RecordCountConfig.class,
    RecordDetailsConfig.class,
    BreadcrumbConfig.class,
    AvailableSearchKeysConfig.class,
    AttributeGroupListConfig.class,
    NavigationMenuConfig.class,
    EQLConfig.class,
    RecordListConfig.class
})
public class ContentElementConfig {

    @XmlElement(name = "StateName")
    protected String stateName;
    @XmlAttribute(name = "Id", required = true)
    protected String id;

    /**
     * Obt\u00e9m o valor da propriedade stateName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * Define o valor da propriedade stateName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateName(String value) {
        this.stateName = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
