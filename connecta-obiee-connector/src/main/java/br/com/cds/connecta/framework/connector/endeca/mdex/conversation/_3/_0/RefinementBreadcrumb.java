
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A list of refinements, used to represent paths, for a breadcrumb.
 * 
 * <p>Classe Java de RefinementBreadcrumb complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RefinementBreadcrumb">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DimensionValue" type="{http://www.endeca.com/MDEX/conversation/3/0}DimensionValueWithName" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Name" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="DisplayName" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="Spec" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefinementBreadcrumb", propOrder = {
    "dimensionValue"
})
public class RefinementBreadcrumb {

    @XmlElement(name = "DimensionValue")
    protected List<DimensionValueWithName> dimensionValue;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "DisplayName", required = true)
    protected String displayName;
    @XmlAttribute(name = "Spec")
    protected String spec;

    /**
     * Gets the value of the dimensionValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dimensionValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDimensionValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DimensionValueWithName }
     * 
     * 
     */
    public List<DimensionValueWithName> getDimensionValue() {
        if (dimensionValue == null) {
            dimensionValue = new ArrayList<DimensionValueWithName>();
        }
        return this.dimensionValue;
    }

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
     * Obt\u00e9m o valor da propriedade spec.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpec() {
        return spec;
    }

    /**
     * Define o valor da propriedade spec.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpec(String value) {
        this.spec = value;
    }

}
