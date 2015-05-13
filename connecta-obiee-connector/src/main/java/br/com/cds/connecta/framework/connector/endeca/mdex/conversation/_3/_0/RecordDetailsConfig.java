
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The RecordDetailsConfig type contains inputs needed to define
 * 						what is returned for record details.  A RecordDetails will be
 * 						returned for each RecordDetailsConfig provided.                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;Column&lt;/code&gt;
 * </pre>
 * 
 * - defines a field to be returned in
 * 						the RecordDetails of the Results. If none are specified,
 * 						the default set (which may not be all) is returned.                    
 * 
 * <p>Classe Java de RecordDetailsConfig complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RecordDetailsConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElementConfig">
 *       &lt;sequence>
 *         &lt;element name="RecordSelector" type="{http://www.endeca.com/MDEX/conversation/3/0}RecordSelector"/>
 *         &lt;element name="Column" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordDetailsConfig", propOrder = {
    "recordSelector",
    "column"
})
public class RecordDetailsConfig
    extends ContentElementConfig
{

    @XmlElement(name = "RecordSelector", required = true)
    protected RecordSelector recordSelector;
    @XmlElement(name = "Column")
    protected List<String> column;

    /**
     * Obt\u00e9m o valor da propriedade recordSelector.
     * 
     * @return
     *     possible object is
     *     {@link RecordSelector }
     *     
     */
    public RecordSelector getRecordSelector() {
        return recordSelector;
    }

    /**
     * Define o valor da propriedade recordSelector.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordSelector }
     *     
     */
    public void setRecordSelector(RecordSelector value) {
        this.recordSelector = value;
    }

    /**
     * Gets the value of the column property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the column property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getColumn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getColumn() {
        if (column == null) {
            column = new ArrayList<String>();
        }
        return this.column;
    }

}
