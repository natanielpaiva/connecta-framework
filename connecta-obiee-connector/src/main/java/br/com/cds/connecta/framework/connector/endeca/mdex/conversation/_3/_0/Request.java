
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * The                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;Request&lt;/code&gt;
 * </pre>
 * 
 * type contains one or more states describing the records to be
 * 						selected and one or more content element configurations to describe what summarizations are
 * 						to be performed. A                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;State&lt;/code&gt;
 * </pre>
 * 
 * is associated with a                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;ContentElementConfig&lt;/code&gt;
 * </pre>
 * 
 * via                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;StateName&lt;/code&gt;
 * </pre>
 * 
 * .
 * 
 * 						Typically, a                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;Request&lt;/code&gt;
 * </pre>
 * 
 * is constructed from the                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;Results&lt;/code&gt;
 * </pre>
 * 
 * returned by a
 * 						previous invocation by modifying the                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;State&lt;/code&gt;
 * </pre>
 * 
 * .
 * 
 * 						The                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;Language&lt;/code&gt;
 * </pre>
 * 
 * string indicates a language code for any error messages generated
 * 						during parsing of EQL statements.                    
 * 
 * <p>Classe Java de Request complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OuterTransactionId" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" minOccurs="0"/>
 *         &lt;element name="Language" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.endeca.com/MDEX/conversation/3/0}State" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.endeca.com/MDEX/conversation/3/0}ContentElementConfig" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PinDataVersion" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" minOccurs="0"/>
 *         &lt;element name="DataVersionRequested" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Request", propOrder = {
    "outerTransactionId",
    "language",
    "state",
    "contentElementConfig",
    "pinDataVersion",
    "dataVersionRequested"
})
public class Request {

    @XmlElement(name = "OuterTransactionId")
    protected String outerTransactionId;
    @XmlElement(name = "Language", defaultValue = "en")
    protected String language;
    @XmlElement(name = "State")
    protected List<State> state;
    @XmlElements({
        @XmlElement(name = "RecordListConfig", type = RecordListConfig.class),
        @XmlElement(name = "RecordDetailsConfig", type = RecordDetailsConfig.class),
        @XmlElement(name = "RecordCountConfig", type = RecordCountConfig.class),
        @XmlElement(name = "BreadcrumbConfig", type = BreadcrumbConfig.class),
        @XmlElement(name = "NavigationMenuConfig", type = NavigationMenuConfig.class),
        @XmlElement(name = "PropertyListConfig", type = PropertyListConfig.class),
        @XmlElement(name = "AvailableSearchKeysConfig", type = AvailableSearchKeysConfig.class),
        @XmlElement(name = "ValueSearchConfig", type = ValueSearchConfig.class),
        @XmlElement(name = "SearchAdjustmentConfig", type = SearchAdjustmentConfig.class),
        @XmlElement(name = "EQLConfig", type = EQLConfig.class),
        @XmlElement(name = "AttributeGroupListConfig", type = AttributeGroupListConfig.class)
    })
    protected List<ContentElementConfig> contentElementConfig;
    @XmlElement(name = "PinDataVersion")
    protected String pinDataVersion;
    @XmlElement(name = "DataVersionRequested")
    protected String dataVersionRequested;

    /**
     * Obt\u00e9m o valor da propriedade outerTransactionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOuterTransactionId() {
        return outerTransactionId;
    }

    /**
     * Define o valor da propriedade outerTransactionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOuterTransactionId(String value) {
        this.outerTransactionId = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade language.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Define o valor da propriedade language.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the state property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link State }
     * 
     * 
     */
    public List<State> getState() {
        if (state == null) {
            state = new ArrayList<State>();
        }
        return this.state;
    }

    /**
     * Gets the value of the contentElementConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentElementConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentElementConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecordListConfig }
     * {@link RecordDetailsConfig }
     * {@link RecordCountConfig }
     * {@link BreadcrumbConfig }
     * {@link NavigationMenuConfig }
     * {@link PropertyListConfig }
     * {@link AvailableSearchKeysConfig }
     * {@link ValueSearchConfig }
     * {@link SearchAdjustmentConfig }
     * {@link EQLConfig }
     * {@link AttributeGroupListConfig }
     * 
     * 
     */
    public List<ContentElementConfig> getContentElementConfig() {
        if (contentElementConfig == null) {
            contentElementConfig = new ArrayList<ContentElementConfig>();
        }
        return this.contentElementConfig;
    }

    /**
     * Obt\u00e9m o valor da propriedade pinDataVersion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPinDataVersion() {
        return pinDataVersion;
    }

    /**
     * Define o valor da propriedade pinDataVersion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPinDataVersion(String value) {
        this.pinDataVersion = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade dataVersionRequested.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataVersionRequested() {
        return dataVersionRequested;
    }

    /**
     * Define o valor da propriedade dataVersionRequested.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataVersionRequested(String value) {
        this.dataVersionRequested = value;
    }

}
