
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Statement complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Statement">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}Node">
 *       &lt;sequence>
 *         &lt;element name="selects" type="{http://www.endeca.com/MDEX/eql_parser/types}Select" maxOccurs="unbounded"/>
 *         &lt;element name="from" type="{http://www.endeca.com/MDEX/eql_parser/types}From" minOccurs="0"/>
 *         &lt;element name="where" type="{http://www.endeca.com/MDEX/eql_parser/types}Where" minOccurs="0"/>
 *         &lt;element name="group" type="{http://www.endeca.com/MDEX/eql_parser/types}Group" minOccurs="0"/>
 *         &lt;element name="having" type="{http://www.endeca.com/MDEX/eql_parser/types}Having" minOccurs="0"/>
 *         &lt;element name="order" type="{http://www.endeca.com/MDEX/eql_parser/types}OrderByList" minOccurs="0"/>
 *         &lt;element name="paging" type="{http://www.endeca.com/MDEX/eql_parser/types}PageBase" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="returnTable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="statementKey" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Statement", propOrder = {
    "selects",
    "from",
    "where",
    "group",
    "having",
    "order",
    "paging"
})
public class Statement
    extends Node
{

    @XmlElement(required = true)
    protected List<Select> selects;
    protected From from;
    protected Where where;
    protected Group group;
    protected Having having;
    protected OrderByList order;
    protected PageBase paging;
    @XmlAttribute(name = "returnTable", required = true)
    protected boolean returnTable;
    @XmlAttribute(name = "statementKey", required = true)
    protected String statementKey;

    /**
     * Gets the value of the selects property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the selects property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSelects().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Select }
     * 
     * 
     */
    public List<Select> getSelects() {
        if (selects == null) {
            selects = new ArrayList<Select>();
        }
        return this.selects;
    }

    /**
     * Obt\u00e9m o valor da propriedade from.
     * 
     * @return
     *     possible object is
     *     {@link From }
     *     
     */
    public From getFrom() {
        return from;
    }

    /**
     * Define o valor da propriedade from.
     * 
     * @param value
     *     allowed object is
     *     {@link From }
     *     
     */
    public void setFrom(From value) {
        this.from = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade where.
     * 
     * @return
     *     possible object is
     *     {@link Where }
     *     
     */
    public Where getWhere() {
        return where;
    }

    /**
     * Define o valor da propriedade where.
     * 
     * @param value
     *     allowed object is
     *     {@link Where }
     *     
     */
    public void setWhere(Where value) {
        this.where = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade group.
     * 
     * @return
     *     possible object is
     *     {@link Group }
     *     
     */
    public Group getGroup() {
        return group;
    }

    /**
     * Define o valor da propriedade group.
     * 
     * @param value
     *     allowed object is
     *     {@link Group }
     *     
     */
    public void setGroup(Group value) {
        this.group = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade having.
     * 
     * @return
     *     possible object is
     *     {@link Having }
     *     
     */
    public Having getHaving() {
        return having;
    }

    /**
     * Define o valor da propriedade having.
     * 
     * @param value
     *     allowed object is
     *     {@link Having }
     *     
     */
    public void setHaving(Having value) {
        this.having = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade order.
     * 
     * @return
     *     possible object is
     *     {@link OrderByList }
     *     
     */
    public OrderByList getOrder() {
        return order;
    }

    /**
     * Define o valor da propriedade order.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderByList }
     *     
     */
    public void setOrder(OrderByList value) {
        this.order = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade paging.
     * 
     * @return
     *     possible object is
     *     {@link PageBase }
     *     
     */
    public PageBase getPaging() {
        return paging;
    }

    /**
     * Define o valor da propriedade paging.
     * 
     * @param value
     *     allowed object is
     *     {@link PageBase }
     *     
     */
    public void setPaging(PageBase value) {
        this.paging = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade returnTable.
     * 
     */
    public boolean isReturnTable() {
        return returnTable;
    }

    /**
     * Define o valor da propriedade returnTable.
     * 
     */
    public void setReturnTable(boolean value) {
        this.returnTable = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade statementKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatementKey() {
        return statementKey;
    }

    /**
     * Define o valor da propriedade statementKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatementKey(String value) {
        this.statementKey = value;
    }

}
