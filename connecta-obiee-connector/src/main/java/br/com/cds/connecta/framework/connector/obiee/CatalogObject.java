
package br.com.cds.connecta.framework.connector.obiee;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de CatalogObject complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CatalogObject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="catalogObject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="catalogObjectBytes" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="itemInfo" type="{urn://oracle.bi.webservices/v6}ItemInfo" minOccurs="0"/>
 *         &lt;element name="errorInfo" type="{urn://oracle.bi.webservices/v6}ErrorInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CatalogObject", propOrder = {
    "catalogObject",
    "catalogObjectBytes",
    "itemInfo",
    "errorInfo"
})
public class CatalogObject {

    protected String catalogObject;
    @XmlMimeType("application/obipscatalogobject")
    protected DataHandler catalogObjectBytes;
    protected ItemInfo itemInfo;
    protected ErrorInfo errorInfo;

    /**
     * Obtém o valor da propriedade catalogObject.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogObject() {
        return catalogObject;
    }

    /**
     * Define o valor da propriedade catalogObject.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogObject(String value) {
        this.catalogObject = value;
    }

    /**
     * Obtém o valor da propriedade catalogObjectBytes.
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getCatalogObjectBytes() {
        return catalogObjectBytes;
    }

    /**
     * Define o valor da propriedade catalogObjectBytes.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setCatalogObjectBytes(DataHandler value) {
        this.catalogObjectBytes = value;
    }

    /**
     * Obtém o valor da propriedade itemInfo.
     * 
     * @return
     *     possible object is
     *     {@link ItemInfo }
     *     
     */
    public ItemInfo getItemInfo() {
        return itemInfo;
    }

    /**
     * Define o valor da propriedade itemInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemInfo }
     *     
     */
    public void setItemInfo(ItemInfo value) {
        this.itemInfo = value;
    }

    /**
     * Obtém o valor da propriedade errorInfo.
     * 
     * @return
     *     possible object is
     *     {@link ErrorInfo }
     *     
     */
    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    /**
     * Define o valor da propriedade errorInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorInfo }
     *     
     */
    public void setErrorInfo(ErrorInfo value) {
        this.errorInfo = value;
    }

}
