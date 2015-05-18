
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de RefinementGroupConfig complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RefinementGroupConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RefinementConfig" type="{http://www.endeca.com/MDEX/conversation/3/0}RefinementConfig" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Name" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="Expose" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ExposeAllPropertyRefinements" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefinementGroupConfig", propOrder = {
    "refinementConfig"
})
public class RefinementGroupConfig {

    @XmlElement(name = "RefinementConfig")
    protected List<RefinementConfig> refinementConfig;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Expose", required = true)
    protected boolean expose;
    @XmlAttribute(name = "ExposeAllPropertyRefinements")
    protected Boolean exposeAllPropertyRefinements;

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
     * Obt\u00e9m o valor da propriedade expose.
     * 
     */
    public boolean isExpose() {
        return expose;
    }

    /**
     * Define o valor da propriedade expose.
     * 
     */
    public void setExpose(boolean value) {
        this.expose = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade exposeAllPropertyRefinements.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExposeAllPropertyRefinements() {
        return exposeAllPropertyRefinements;
    }

    /**
     * Define o valor da propriedade exposeAllPropertyRefinements.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExposeAllPropertyRefinements(Boolean value) {
        this.exposeAllPropertyRefinements = value;
    }

}
