
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The results of a value search. The                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;HasMore&lt;/code&gt;
 * </pre>
 * 
 * attribute specifies whether 
 * 						any results were cut off because of a limit specified in the request. A                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;PropertynMatches&lt;/code&gt;
 * </pre>
 * 
 * element appears only for those properties and dimensions in which matches were found, and contains values 
 * 						for those matches.                    
 * 
 * <p>Classe Java de ValueSearch complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ValueSearch">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElement">
 *       &lt;sequence>
 *         &lt;element name="PropertyMatches" type="{http://www.endeca.com/MDEX/conversation/3/0}PropertyMatches" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValueSearch", propOrder = {
    "propertyMatches"
})
public class ValueSearch
    extends ContentElement
{

    @XmlElement(name = "PropertyMatches")
    protected List<PropertyMatches> propertyMatches;

    /**
     * Gets the value of the propertyMatches property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyMatches property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyMatches().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropertyMatches }
     * 
     * 
     */
    public List<PropertyMatches> getPropertyMatches() {
        if (propertyMatches == null) {
            propertyMatches = new ArrayList<PropertyMatches>();
        }
        return this.propertyMatches;
    }

}
