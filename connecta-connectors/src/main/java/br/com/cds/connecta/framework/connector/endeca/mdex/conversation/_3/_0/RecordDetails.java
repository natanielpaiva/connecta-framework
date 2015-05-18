
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The result data corresponding to a RecordDetailsConfig request. It contains information about the individual 
 * 						record requested from this summarization.
 * 
 * <p>Classe Java de RecordDetails complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RecordDetails">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElement">
 *       &lt;sequence>
 *         &lt;element name="Column" type="{http://www.endeca.com/MDEX/conversation/3/0}ColumnMetadata" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Record" type="{http://www.endeca.com/MDEX/conversation/3/0}Record"/>
 *         &lt;element name="DimensionHierarchy" type="{http://www.endeca.com/MDEX/conversation/3/0}DimensionHierarchy"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordDetails", propOrder = {
    "column",
    "record",
    "dimensionHierarchy"
})
public class RecordDetails
    extends ContentElement
{

    @XmlElement(name = "Column")
    protected List<ColumnMetadata> column;
    @XmlElement(name = "Record", required = true)
    protected Record record;
    @XmlElement(name = "DimensionHierarchy", required = true)
    protected DimensionHierarchy dimensionHierarchy;

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
     * Obt\u00e9m o valor da propriedade record.
     * 
     * @return
     *     possible object is
     *     {@link Record }
     *     
     */
    public Record getRecord() {
        return record;
    }

    /**
     * Define o valor da propriedade record.
     * 
     * @param value
     *     allowed object is
     *     {@link Record }
     *     
     */
    public void setRecord(Record value) {
        this.record = value;
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

}
