
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * The RecordListConfig type contains inputs needed to define
 * 						what is returned in the record list.  A RecordList will be
 * 						returned for each RecordListConfig provided.                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;Column&lt;/code&gt;
 * </pre>
 * 
 * - defines a field to be returned in
 * 						the RecordList of the Results.                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;RecordsPerPage&lt;/code&gt;
 * </pre>
 * 
 * - defines the maximum number
 * 						of Record elements to return in the ContentElement of the
 * 						result; default is 10.                    
 * 
 * <p>Classe Java de RecordListConfig complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RecordListConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElementConfig">
 *       &lt;sequence>
 *         &lt;element name="Column" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" maxOccurs="unbounded"/>
 *         &lt;element name="RecordsPerPage" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="Page" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="Sort" type="{http://www.endeca.com/MDEX/conversation/3/0}Sort" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="MaxPages" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="20" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordListConfig", propOrder = {
    "column",
    "recordsPerPage",
    "page",
    "sort"
})
public class RecordListConfig
    extends ContentElementConfig
{

    @XmlElement(name = "Column", required = true)
    protected List<String> column;
    @XmlElement(name = "RecordsPerPage")
    @XmlSchemaType(name = "unsignedInt")
    protected Long recordsPerPage;
    @XmlElement(name = "Page")
    @XmlSchemaType(name = "unsignedInt")
    protected Long page;
    @XmlElement(name = "Sort")
    protected List<Sort> sort;
    @XmlAttribute(name = "MaxPages")
    @XmlSchemaType(name = "unsignedInt")
    protected Long maxPages;

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

    /**
     * Obt\u00e9m o valor da propriedade recordsPerPage.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRecordsPerPage() {
        return recordsPerPage;
    }

    /**
     * Define o valor da propriedade recordsPerPage.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRecordsPerPage(Long value) {
        this.recordsPerPage = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade page.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPage() {
        return page;
    }

    /**
     * Define o valor da propriedade page.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPage(Long value) {
        this.page = value;
    }

    /**
     * Gets the value of the sort property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sort property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSort().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Sort }
     * 
     * 
     */
    public List<Sort> getSort() {
        if (sort == null) {
            sort = new ArrayList<Sort>();
        }
        return this.sort;
    }

    /**
     * Obt\u00e9m o valor da propriedade maxPages.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getMaxPages() {
        if (maxPages == null) {
            return  20L;
        } else {
            return maxPages;
        }
    }

    /**
     * Define o valor da propriedade maxPages.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxPages(Long value) {
        this.maxPages = value;
    }

}
