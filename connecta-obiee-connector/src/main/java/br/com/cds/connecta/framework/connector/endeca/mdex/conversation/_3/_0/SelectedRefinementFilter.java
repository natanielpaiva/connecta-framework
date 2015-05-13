
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A selected refinement filter selects the refinement with value                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;Spec&lt;/code&gt;
 * </pre>
 * 
 * in the property	or dimension named                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;Name&lt;/code&gt;
 * </pre>
 * 
 * .  The presence of the                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;AppliedFilterRule&lt;/code&gt;
 * </pre>
 * 
 * indicates that the filter was implicitly created
 * 						and supplies relevant information.                    
 * 
 * <p>Classe Java de SelectedRefinementFilter complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SelectedRefinementFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AppliedFilterRule" type="{http://www.endeca.com/MDEX/conversation/3/0}AppliedFilterRule" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Name" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="Spec" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="Id" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SelectedRefinementFilter", propOrder = {
    "appliedFilterRule"
})
public class SelectedRefinementFilter {

    @XmlElement(name = "AppliedFilterRule")
    protected AppliedFilterRule appliedFilterRule;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Spec")
    protected String spec;
    @XmlAttribute(name = "Id")
    protected String id;

    /**
     * Obt\u00e9m o valor da propriedade appliedFilterRule.
     * 
     * @return
     *     possible object is
     *     {@link AppliedFilterRule }
     *     
     */
    public AppliedFilterRule getAppliedFilterRule() {
        return appliedFilterRule;
    }

    /**
     * Define o valor da propriedade appliedFilterRule.
     * 
     * @param value
     *     allowed object is
     *     {@link AppliedFilterRule }
     *     
     */
    public void setAppliedFilterRule(AppliedFilterRule value) {
        this.appliedFilterRule = value;
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
