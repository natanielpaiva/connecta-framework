
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The State type contains inputs that determine the set of records to operate on.
 * 
 * <p>Classe Java de State complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="State">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" minOccurs="0"/>
 *         &lt;element name="CollectionName" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" minOccurs="0"/>
 *         &lt;element name="SelectedRefinementFilter" type="{http://www.endeca.com/MDEX/conversation/3/0}SelectedRefinementFilter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TextSearchFilter" type="{http://www.endeca.com/MDEX/conversation/3/0}TextSearchFilter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RecordKind" type="{http://www.endeca.com/MDEX/conversation/3/0}RecordKind" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DataSourceFilter" type="{http://www.endeca.com/MDEX/conversation/3/0}EQLFilter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SelectionFilter" type="{http://www.endeca.com/MDEX/conversation/3/0}EQLFilter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "State", propOrder = {
    "name",
    "collectionName",
    "selectedRefinementFilter",
    "textSearchFilter",
    "recordKind",
    "dataSourceFilter",
    "selectionFilter"
})
public class State {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "CollectionName")
    protected String collectionName;
    @XmlElement(name = "SelectedRefinementFilter")
    protected List<SelectedRefinementFilter> selectedRefinementFilter;
    @XmlElement(name = "TextSearchFilter")
    protected List<TextSearchFilter> textSearchFilter;
    @XmlElement(name = "RecordKind")
    protected List<RecordKind> recordKind;
    @XmlElement(name = "DataSourceFilter")
    protected List<EQLFilter> dataSourceFilter;
    @XmlElement(name = "SelectionFilter")
    protected List<EQLFilter> selectionFilter;

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
     * Obt\u00e9m o valor da propriedade collectionName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * Define o valor da propriedade collectionName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionName(String value) {
        this.collectionName = value;
    }

    /**
     * Gets the value of the selectedRefinementFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the selectedRefinementFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSelectedRefinementFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SelectedRefinementFilter }
     * 
     * 
     */
    public List<SelectedRefinementFilter> getSelectedRefinementFilter() {
        if (selectedRefinementFilter == null) {
            selectedRefinementFilter = new ArrayList<SelectedRefinementFilter>();
        }
        return this.selectedRefinementFilter;
    }

    /**
     * Gets the value of the textSearchFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textSearchFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextSearchFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextSearchFilter }
     * 
     * 
     */
    public List<TextSearchFilter> getTextSearchFilter() {
        if (textSearchFilter == null) {
            textSearchFilter = new ArrayList<TextSearchFilter>();
        }
        return this.textSearchFilter;
    }

    /**
     * Gets the value of the recordKind property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recordKind property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecordKind().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecordKind }
     * 
     * 
     */
    public List<RecordKind> getRecordKind() {
        if (recordKind == null) {
            recordKind = new ArrayList<RecordKind>();
        }
        return this.recordKind;
    }

    /**
     * Gets the value of the dataSourceFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataSourceFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataSourceFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EQLFilter }
     * 
     * 
     */
    public List<EQLFilter> getDataSourceFilter() {
        if (dataSourceFilter == null) {
            dataSourceFilter = new ArrayList<EQLFilter>();
        }
        return this.dataSourceFilter;
    }

    /**
     * Gets the value of the selectionFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the selectionFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSelectionFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EQLFilter }
     * 
     * 
     */
    public List<EQLFilter> getSelectionFilter() {
        if (selectionFilter == null) {
            selectionFilter = new ArrayList<EQLFilter>();
        }
        return this.selectionFilter;
    }

}
