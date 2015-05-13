
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de GetSubItemsParams complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="GetSubItemsParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="filter" type="{urn://oracle.bi.webservices/v6}GetSubItemsFilter"/>
 *         &lt;element name="includeACL" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="withPermission" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="withPermissionMask" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="withAttributes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="withAttributesMask" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetSubItemsParams", propOrder = {
    "filter",
    "includeACL",
    "withPermission",
    "withPermissionMask",
    "withAttributes",
    "withAttributesMask"
})
public class GetSubItemsParams {

    @XmlElement(required = true, nillable = true)
    protected GetSubItemsFilter filter;
    protected boolean includeACL;
    protected int withPermission;
    protected int withPermissionMask;
    protected int withAttributes;
    protected int withAttributesMask;

    /**
     * Obtém o valor da propriedade filter.
     * 
     * @return
     *     possible object is
     *     {@link GetSubItemsFilter }
     *     
     */
    public GetSubItemsFilter getFilter() {
        return filter;
    }

    /**
     * Define o valor da propriedade filter.
     * 
     * @param value
     *     allowed object is
     *     {@link GetSubItemsFilter }
     *     
     */
    public void setFilter(GetSubItemsFilter value) {
        this.filter = value;
    }

    /**
     * Obtém o valor da propriedade includeACL.
     * 
     */
    public boolean isIncludeACL() {
        return includeACL;
    }

    /**
     * Define o valor da propriedade includeACL.
     * 
     */
    public void setIncludeACL(boolean value) {
        this.includeACL = value;
    }

    /**
     * Obtém o valor da propriedade withPermission.
     * 
     */
    public int getWithPermission() {
        return withPermission;
    }

    /**
     * Define o valor da propriedade withPermission.
     * 
     */
    public void setWithPermission(int value) {
        this.withPermission = value;
    }

    /**
     * Obtém o valor da propriedade withPermissionMask.
     * 
     */
    public int getWithPermissionMask() {
        return withPermissionMask;
    }

    /**
     * Define o valor da propriedade withPermissionMask.
     * 
     */
    public void setWithPermissionMask(int value) {
        this.withPermissionMask = value;
    }

    /**
     * Obtém o valor da propriedade withAttributes.
     * 
     */
    public int getWithAttributes() {
        return withAttributes;
    }

    /**
     * Define o valor da propriedade withAttributes.
     * 
     */
    public void setWithAttributes(int value) {
        this.withAttributes = value;
    }

    /**
     * Obtém o valor da propriedade withAttributesMask.
     * 
     */
    public int getWithAttributesMask() {
        return withAttributesMask;
    }

    /**
     * Define o valor da propriedade withAttributesMask.
     * 
     */
    public void setWithAttributesMask(int value) {
        this.withAttributesMask = value;
    }

}
