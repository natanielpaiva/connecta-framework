
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types.StandaloneFilter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
//import com.endeca.mdex.eql_parser.types.StandaloneFilter;


/**
 * A filter expressed in EQL. The                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;AppliedFilterRule&lt;/code&gt;
 * </pre>
 * 
 * indicates if the filter was implicitly created and provides relevant
 * 						information.  It applies only to SelectionFilters.                    
 * 
 * <p>Classe Java de EQLFilter complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="EQLFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="filterAST" type="{http://www.endeca.com/MDEX/eql_parser/types}StandaloneFilter"/>
 *           &lt;element name="filterString" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString"/>
 *         &lt;/choice>
 *         &lt;sequence>
 *           &lt;element name="AppliedFilterRule" type="{http://www.endeca.com/MDEX/conversation/3/0}AppliedFilterRule" minOccurs="0"/>
 *         &lt;/sequence>
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
@XmlType(name = "EQLFilter", propOrder = {
    "filterAST",
    "filterString",
    "appliedFilterRule"
})
public class EQLFilter {

    protected StandaloneFilter filterAST;
    protected String filterString;
    @XmlElement(name = "AppliedFilterRule")
    protected AppliedFilterRule appliedFilterRule;
    @XmlAttribute(name = "Id")
    protected String id;

    /**
     * Obt\u00e9m o valor da propriedade filterAST.
     * 
     * @return
     *     possible object is
     *     {@link StandaloneFilter }
     *     
     */
    public StandaloneFilter getFilterAST() {
        return filterAST;
    }

    /**
     * Define o valor da propriedade filterAST.
     * 
     * @param value
     *     allowed object is
     *     {@link StandaloneFilter }
     *     
     */
    public void setFilterAST(StandaloneFilter value) {
        this.filterAST = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade filterString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterString() {
        return filterString;
    }

    /**
     * Define o valor da propriedade filterString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterString(String value) {
        this.filterString = value;
    }

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
