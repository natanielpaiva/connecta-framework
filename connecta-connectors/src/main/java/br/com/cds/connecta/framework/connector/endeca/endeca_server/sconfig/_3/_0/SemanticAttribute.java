
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * An element representing one Semantic Attribute of a Semantic Entity. Valid datatypes are
 * 						listed in mdex.xsd. "isDimension" should be set on attributes that are useful to do
 * 						a                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:sconfig_v3="http://www.endeca.com/endeca-server/sconfig/3" xmlns:sconfig_v3_0="http://www.endeca.com/endeca-server/sconfig/3/0" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;GROUP BY&lt;/code&gt;
 * </pre>
 * 
 * on (e.g. "Size", "Region", "Category").                    
 * 
 * <p>Classe Java de semanticAttribute complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="semanticAttribute">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="property" type="{http://www.endeca.com/endeca-server/sconfig/3/0}property" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" />
 *       &lt;attribute name="displayName" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" />
 *       &lt;attribute name="datatype" use="required" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" />
 *       &lt;attribute name="isDimension" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="isKeyColumn" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "semanticAttribute", propOrder = {
    "property"
})
public class SemanticAttribute {

    protected List<Property> property;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "displayName")
    protected String displayName;
    @XmlAttribute(name = "datatype", required = true)
    protected String datatype;
    @XmlAttribute(name = "isDimension", required = true)
    protected boolean isDimension;
    @XmlAttribute(name = "isKeyColumn", required = true)
    protected boolean isKeyColumn;
    @XmlAttribute(name = "description")
    protected String description;

    /**
     * Gets the value of the property property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Property }
     * 
     * 
     */
    public List<Property> getProperty() {
        if (property == null) {
            property = new ArrayList<Property>();
        }
        return this.property;
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
     * Obt\u00e9m o valor da propriedade datatype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatatype() {
        return datatype;
    }

    /**
     * Define o valor da propriedade datatype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatatype(String value) {
        this.datatype = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade isDimension.
     * 
     */
    public boolean isIsDimension() {
        return isDimension;
    }

    /**
     * Define o valor da propriedade isDimension.
     * 
     */
    public void setIsDimension(boolean value) {
        this.isDimension = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade isKeyColumn.
     * 
     */
    public boolean isIsKeyColumn() {
        return isKeyColumn;
    }

    /**
     * Define o valor da propriedade isKeyColumn.
     * 
     */
    public void setIsKeyColumn(boolean value) {
        this.isKeyColumn = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade description.
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

}
