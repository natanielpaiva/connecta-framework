
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;FilterIdentifier&lt;/code&gt;
 * </pre>
 * 
 * identifies a particular filter from a named                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;State&lt;/code&gt;
 * </pre>
 * 
 * .  If a filter is implicitly created via a filter rule,
 * 						the                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;StateName&lt;/code&gt;
 * </pre>
 * 
 * and                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;FilterId&lt;/code&gt;
 * </pre>
 * 
 * indicate its origin.                    
 * 
 * <p>Classe Java de FilterIdentifier complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="FilterIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StateName" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString"/>
 *       &lt;/sequence>
 *       &lt;attribute name="FilterId" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilterIdentifier", propOrder = {
    "stateName"
})
public class FilterIdentifier {

    @XmlElement(name = "StateName", required = true)
    protected String stateName;
    @XmlAttribute(name = "FilterId", required = true)
    protected String filterId;

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
     * Obt\u00e9m o valor da propriedade filterId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterId() {
        return filterId;
    }

    /**
     * Define o valor da propriedade filterId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterId(String value) {
        this.filterId = value;
    }

}
