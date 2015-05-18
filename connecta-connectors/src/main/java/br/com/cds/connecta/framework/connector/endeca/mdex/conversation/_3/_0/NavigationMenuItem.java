
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A collection of refinements of a particular kind. Defaults to hidden.
 * 						Has a name, and an indication of whether there are more refinements than
 * 						are currently shown, and an indication of what kind of multi-select is supported, if any.
 * 
 * <p>Classe Java de NavigationMenuItem complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="NavigationMenuItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExposureControl" type="{http://www.endeca.com/MDEX/conversation/3/0}ExposureControl"/>
 *         &lt;element name="Refinement" type="{http://www.endeca.com/MDEX/conversation/3/0}Refinement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RootDimensionValue" type="{http://www.endeca.com/MDEX/conversation/3/0}DimensionValueWithName" minOccurs="0"/>
 *         &lt;element name="FullPath" type="{http://www.endeca.com/MDEX/conversation/3/0}Path" minOccurs="0"/>
 *         &lt;element name="SelectedRefinement" type="{http://www.endeca.com/MDEX/conversation/3/0}Refinement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ImplicitRefinement" type="{http://www.endeca.com/MDEX/conversation/3/0}Refinement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DisplayName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MultiSelect" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}MultiSelect" />
 *       &lt;attribute name="HasMore" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NavigationMenuItem", propOrder = {
    "exposureControl",
    "refinement",
    "rootDimensionValue",
    "fullPath",
    "selectedRefinement",
    "implicitRefinement"
})
public class NavigationMenuItem {

    @XmlElement(name = "ExposureControl", required = true)
    protected ExposureControl exposureControl;
    @XmlElement(name = "Refinement")
    protected List<Refinement> refinement;
    @XmlElement(name = "RootDimensionValue")
    protected DimensionValueWithName rootDimensionValue;
    @XmlElement(name = "FullPath")
    protected Path fullPath;
    @XmlElement(name = "SelectedRefinement")
    protected List<Refinement> selectedRefinement;
    @XmlElement(name = "ImplicitRefinement")
    protected List<Refinement> implicitRefinement;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "DisplayName", required = true)
    protected String displayName;
    @XmlAttribute(name = "MultiSelect", required = true)
    protected MultiSelect multiSelect;
    @XmlAttribute(name = "HasMore", required = true)
    protected boolean hasMore;

    /**
     * Obt\u00e9m o valor da propriedade exposureControl.
     * 
     * @return
     *     possible object is
     *     {@link ExposureControl }
     *     
     */
    public ExposureControl getExposureControl() {
        return exposureControl;
    }

    /**
     * Define o valor da propriedade exposureControl.
     * 
     * @param value
     *     allowed object is
     *     {@link ExposureControl }
     *     
     */
    public void setExposureControl(ExposureControl value) {
        this.exposureControl = value;
    }

    /**
     * Gets the value of the refinement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refinement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefinement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Refinement }
     * 
     * 
     */
    public List<Refinement> getRefinement() {
        if (refinement == null) {
            refinement = new ArrayList<Refinement>();
        }
        return this.refinement;
    }

    /**
     * Obt\u00e9m o valor da propriedade rootDimensionValue.
     * 
     * @return
     *     possible object is
     *     {@link DimensionValueWithName }
     *     
     */
    public DimensionValueWithName getRootDimensionValue() {
        return rootDimensionValue;
    }

    /**
     * Define o valor da propriedade rootDimensionValue.
     * 
     * @param value
     *     allowed object is
     *     {@link DimensionValueWithName }
     *     
     */
    public void setRootDimensionValue(DimensionValueWithName value) {
        this.rootDimensionValue = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade fullPath.
     * 
     * @return
     *     possible object is
     *     {@link Path }
     *     
     */
    public Path getFullPath() {
        return fullPath;
    }

    /**
     * Define o valor da propriedade fullPath.
     * 
     * @param value
     *     allowed object is
     *     {@link Path }
     *     
     */
    public void setFullPath(Path value) {
        this.fullPath = value;
    }

    /**
     * Gets the value of the selectedRefinement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the selectedRefinement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSelectedRefinement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Refinement }
     * 
     * 
     */
    public List<Refinement> getSelectedRefinement() {
        if (selectedRefinement == null) {
            selectedRefinement = new ArrayList<Refinement>();
        }
        return this.selectedRefinement;
    }

    /**
     * Gets the value of the implicitRefinement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the implicitRefinement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImplicitRefinement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Refinement }
     * 
     * 
     */
    public List<Refinement> getImplicitRefinement() {
        if (implicitRefinement == null) {
            implicitRefinement = new ArrayList<Refinement>();
        }
        return this.implicitRefinement;
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
     * Obt\u00e9m o valor da propriedade multiSelect.
     * 
     * @return
     *     possible object is
     *     {@link MultiSelect }
     *     
     */
    public MultiSelect getMultiSelect() {
        return multiSelect;
    }

    /**
     * Define o valor da propriedade multiSelect.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSelect }
     *     
     */
    public void setMultiSelect(MultiSelect value) {
        this.multiSelect = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade hasMore.
     * 
     */
    public boolean isHasMore() {
        return hasMore;
    }

    /**
     * Define o valor da propriedade hasMore.
     * 
     */
    public void setHasMore(boolean value) {
        this.hasMore = value;
    }

}
