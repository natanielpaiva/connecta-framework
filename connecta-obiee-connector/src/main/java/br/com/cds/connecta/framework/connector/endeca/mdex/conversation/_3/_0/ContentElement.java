
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * The ContentElement type is the base class of all content elements. Types that extend
 * 						ContentElement are the results that correspond to a ContentElementConfig from a
 * 						request. A ContentElement contains a "projection" of data.
 * 
 * <p>Classe Java de ContentElement complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ContentElement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StateName" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContentElement", propOrder = {
    "stateName"
})
@XmlSeeAlso({
    AvailableSearchKeys.class,
    ValueSearch.class,
    PropertyList.class,
    RecordDetails.class,
    RecordList.class,
    SearchAdjustments.class,
    RecordCount.class,
    NavigationMenu.class,
    Breadcrumbs.class,
    EQL.class,
    AttributeGroupList.class
})
public class ContentElement {

    @XmlElement(name = "StateName")
    protected String stateName;
    @XmlAttribute(name = "Id")
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
