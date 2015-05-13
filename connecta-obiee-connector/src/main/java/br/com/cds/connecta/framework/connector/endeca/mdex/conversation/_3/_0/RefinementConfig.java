
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Controls the behavior of an individual group of refinements in a NavigationMenu.
 * 						@Name - the name of the refinement group to control
 * 						@Expose - whether to expose refinements, or just show the head of the group
 * 						@MaximumCount - if specified, limit the number of refinements returned
 * 						@OrderByRecordCount - if true, order by record count, otherwise use natural order
 * 						@IncludeExplicitSelections - whether to return explicitly selected refinements
 * 						@IncludeImplicitSelections - whether to return implicitly selected refinements
 * 
 * <p>Classe Java de RefinementConfig complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RefinementConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Name" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="Spec" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="Expose" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="OrderByRecordCount" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="MaximumCount" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
 *       &lt;attribute name="IncludeExplicitSelections" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="IncludeImplicitSelections" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefinementConfig")
public class RefinementConfig {

    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Spec")
    protected String spec;
    @XmlAttribute(name = "Expose")
    protected Boolean expose;
    @XmlAttribute(name = "OrderByRecordCount")
    protected Boolean orderByRecordCount;
    @XmlAttribute(name = "MaximumCount")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger maximumCount;
    @XmlAttribute(name = "IncludeExplicitSelections")
    protected Boolean includeExplicitSelections;
    @XmlAttribute(name = "IncludeImplicitSelections")
    protected Boolean includeImplicitSelections;

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

    /**
     * Obt\u00e9m o valor da propriedade expose.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isExpose() {
        if (expose == null) {
            return false;
        } else {
            return expose;
        }
    }

    /**
     * Define o valor da propriedade expose.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExpose(Boolean value) {
        this.expose = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade orderByRecordCount.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isOrderByRecordCount() {
        if (orderByRecordCount == null) {
            return false;
        } else {
            return orderByRecordCount;
        }
    }

    /**
     * Define o valor da propriedade orderByRecordCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOrderByRecordCount(Boolean value) {
        this.orderByRecordCount = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade maximumCount.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaximumCount() {
        return maximumCount;
    }

    /**
     * Define o valor da propriedade maximumCount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaximumCount(BigInteger value) {
        this.maximumCount = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade includeExplicitSelections.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIncludeExplicitSelections() {
        if (includeExplicitSelections == null) {
            return false;
        } else {
            return includeExplicitSelections;
        }
    }

    /**
     * Define o valor da propriedade includeExplicitSelections.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeExplicitSelections(Boolean value) {
        this.includeExplicitSelections = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade includeImplicitSelections.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIncludeImplicitSelections() {
        if (includeImplicitSelections == null) {
            return false;
        } else {
            return includeImplicitSelections;
        }
    }

    /**
     * Define o valor da propriedade includeImplicitSelections.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeImplicitSelections(Boolean value) {
        this.includeImplicitSelections = value;
    }

}
