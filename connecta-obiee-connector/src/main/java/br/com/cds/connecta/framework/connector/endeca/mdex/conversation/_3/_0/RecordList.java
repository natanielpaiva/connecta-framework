
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * The result data corresponding to a RecordListConfig request. It contains information about the overall 
 * 						set of result records submitted to this summarization (                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;NumRecords&lt;/code&gt;
 * </pre>
 * 
 * and                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;TotalPages&lt;/code&gt;
 * </pre>
 * 
 * ),
 * 						the page of records presented (                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;Record&lt;/code&gt;
 * </pre>
 * 
 * and                        
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;code xmlns="http://www.w3.org/2001/XMLSchema" xmlns:cs="http://www.endeca.com/MDEX/conversation/3" xmlns:cs_v3_0="http://www.endeca.com/MDEX/conversation/3/0" xmlns:eql_parser_types="http://www.endeca.com/MDEX/eql_parser/types" xmlns:mdex="http://www.endeca.com/MDEX/XQuery/2009/09" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"&gt;RecordRange&lt;/code&gt;
 * </pre>
 * 
 * ) and 
 * 						controls for sorting and pagination. Note that the total number of records is NOT informed by the 
 * 						attributes presented, so a record will be counted even if it appears empty in the results because it has no
 * 						assignments for the attributes in question.                    
 * 
 * <p>Classe Java de RecordList complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RecordList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElement">
 *       &lt;sequence>
 *         &lt;element name="NumRecords" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="TotalPages" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="Column" type="{http://www.endeca.com/MDEX/conversation/3/0}ColumnMetadata" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RecordRange" type="{http://www.endeca.com/MDEX/conversation/3/0}RecordRange" minOccurs="0"/>
 *         &lt;element name="DimensionHierarchy" type="{http://www.endeca.com/MDEX/conversation/3/0}DimensionHierarchy"/>
 *         &lt;element name="RecordListEntry" type="{http://www.endeca.com/MDEX/conversation/3/0}RecordListEntry" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PaginationControl" type="{http://www.endeca.com/MDEX/conversation/3/0}Control" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordList", propOrder = {
    "numRecords",
    "totalPages",
    "column",
    "recordRange",
    "dimensionHierarchy",
    "recordListEntry",
    "paginationControl"
})
public class RecordList
    extends ContentElement
{

    @XmlElement(name = "NumRecords")
    @XmlSchemaType(name = "unsignedInt")
    protected long numRecords;
    @XmlElement(name = "TotalPages")
    @XmlSchemaType(name = "unsignedInt")
    protected long totalPages;
    @XmlElement(name = "Column")
    protected List<ColumnMetadata> column;
    @XmlElement(name = "RecordRange")
    protected RecordRange recordRange;
    @XmlElement(name = "DimensionHierarchy", required = true)
    protected DimensionHierarchy dimensionHierarchy;
    @XmlElement(name = "RecordListEntry")
    protected List<RecordListEntry> recordListEntry;
    @XmlElement(name = "PaginationControl")
    protected List<Control> paginationControl;

    /**
     * Obt\u00e9m o valor da propriedade numRecords.
     * 
     */
    public long getNumRecords() {
        return numRecords;
    }

    /**
     * Define o valor da propriedade numRecords.
     * 
     */
    public void setNumRecords(long value) {
        this.numRecords = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade totalPages.
     * 
     */
    public long getTotalPages() {
        return totalPages;
    }

    /**
     * Define o valor da propriedade totalPages.
     * 
     */
    public void setTotalPages(long value) {
        this.totalPages = value;
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
     * {@link ColumnMetadata }
     * 
     * 
     */
    public List<ColumnMetadata> getColumn() {
        if (column == null) {
            column = new ArrayList<ColumnMetadata>();
        }
        return this.column;
    }

    /**
     * Obt\u00e9m o valor da propriedade recordRange.
     * 
     * @return
     *     possible object is
     *     {@link RecordRange }
     *     
     */
    public RecordRange getRecordRange() {
        return recordRange;
    }

    /**
     * Define o valor da propriedade recordRange.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordRange }
     *     
     */
    public void setRecordRange(RecordRange value) {
        this.recordRange = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade dimensionHierarchy.
     * 
     * @return
     *     possible object is
     *     {@link DimensionHierarchy }
     *     
     */
    public DimensionHierarchy getDimensionHierarchy() {
        return dimensionHierarchy;
    }

    /**
     * Define o valor da propriedade dimensionHierarchy.
     * 
     * @param value
     *     allowed object is
     *     {@link DimensionHierarchy }
     *     
     */
    public void setDimensionHierarchy(DimensionHierarchy value) {
        this.dimensionHierarchy = value;
    }

    /**
     * Gets the value of the recordListEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recordListEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecordListEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecordListEntry }
     * 
     * 
     */
    public List<RecordListEntry> getRecordListEntry() {
        if (recordListEntry == null) {
            recordListEntry = new ArrayList<RecordListEntry>();
        }
        return this.recordListEntry;
    }

    /**
     * Gets the value of the paginationControl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paginationControl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaginationControl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Control }
     * 
     * 
     */
    public List<Control> getPaginationControl() {
        if (paginationControl == null) {
            paginationControl = new ArrayList<Control>();
        }
        return this.paginationControl;
    }

}
