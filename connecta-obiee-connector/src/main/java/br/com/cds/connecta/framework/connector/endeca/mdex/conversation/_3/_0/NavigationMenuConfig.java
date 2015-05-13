
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The NavigationMenuConfig type contains inputs needed to define what is returned in the navigation
 * 						menu. If ReturnFullPath is set to true, each set of refinements will be accompanied
 * 						with the path to root for that set of refinements. If ExposeAllRefinements is set to true,
 * 						it is equivalent to sending a RefinementConfig with Expose="true" for each property and dimension.
 * 
 * <p>Classe Java de NavigationMenuConfig complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="NavigationMenuConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElementConfig">
 *       &lt;choice>
 *         &lt;element name="RefinementGroupConfig" type="{http://www.endeca.com/MDEX/conversation/3/0}RefinementGroupConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RefinementConfig" type="{http://www.endeca.com/MDEX/conversation/3/0}RefinementConfig" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="ExposeAllRefinements" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ReturnFullPath" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="MaximumRefinementCount" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="IncludeAllExplicitSelections" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="IncludeAllImplicitSelections" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NavigationMenuConfig", propOrder = {
    "refinementGroupConfig",
    "refinementConfig"
})
public class NavigationMenuConfig
    extends ContentElementConfig
{

    @XmlElement(name = "RefinementGroupConfig")
    protected List<RefinementGroupConfig> refinementGroupConfig;
    @XmlElement(name = "RefinementConfig")
    protected List<RefinementConfig> refinementConfig;
    @XmlAttribute(name = "ExposeAllRefinements")
    protected Boolean exposeAllRefinements;
    @XmlAttribute(name = "ReturnFullPath")
    protected Boolean returnFullPath;
    @XmlAttribute(name = "MaximumRefinementCount")
    protected Integer maximumRefinementCount;
    @XmlAttribute(name = "IncludeAllExplicitSelections")
    protected Boolean includeAllExplicitSelections;
    @XmlAttribute(name = "IncludeAllImplicitSelections")
    protected Boolean includeAllImplicitSelections;

    /**
     * Gets the value of the refinementGroupConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refinementGroupConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefinementGroupConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefinementGroupConfig }
     * 
     * 
     */
    public List<RefinementGroupConfig> getRefinementGroupConfig() {
        if (refinementGroupConfig == null) {
            refinementGroupConfig = new ArrayList<RefinementGroupConfig>();
        }
        return this.refinementGroupConfig;
    }

    /**
     * Gets the value of the refinementConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refinementConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefinementConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefinementConfig }
     * 
     * 
     */
    public List<RefinementConfig> getRefinementConfig() {
        if (refinementConfig == null) {
            refinementConfig = new ArrayList<RefinementConfig>();
        }
        return this.refinementConfig;
    }

    /**
     * Obt\u00e9m o valor da propriedade exposeAllRefinements.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExposeAllRefinements() {
        return exposeAllRefinements;
    }

    /**
     * Define o valor da propriedade exposeAllRefinements.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExposeAllRefinements(Boolean value) {
        this.exposeAllRefinements = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade returnFullPath.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReturnFullPath() {
        if (returnFullPath == null) {
            return false;
        } else {
            return returnFullPath;
        }
    }

    /**
     * Define o valor da propriedade returnFullPath.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnFullPath(Boolean value) {
        this.returnFullPath = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade maximumRefinementCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaximumRefinementCount() {
        return maximumRefinementCount;
    }

    /**
     * Define o valor da propriedade maximumRefinementCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaximumRefinementCount(Integer value) {
        this.maximumRefinementCount = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade includeAllExplicitSelections.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIncludeAllExplicitSelections() {
        if (includeAllExplicitSelections == null) {
            return false;
        } else {
            return includeAllExplicitSelections;
        }
    }

    /**
     * Define o valor da propriedade includeAllExplicitSelections.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeAllExplicitSelections(Boolean value) {
        this.includeAllExplicitSelections = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade includeAllImplicitSelections.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIncludeAllImplicitSelections() {
        if (includeAllImplicitSelections == null) {
            return false;
        } else {
            return includeAllImplicitSelections;
        }
    }

    /**
     * Define o valor da propriedade includeAllImplicitSelections.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeAllImplicitSelections(Boolean value) {
        this.includeAllImplicitSelections = value;
    }

}
