
package br.com.cds.connecta.framework.connector.obiee;

import br.com.cds.connecta.framework.connector.obiee.Account;
import br.com.cds.connecta.framework.connector.obiee.ACL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 *                 attributes field value is  a combination of the following flags:
 *                 1 - read only,
 *                 2 - archive,
 *                 4 - hidden,
 *                 8 - system,
 *                 16 - dont index
 *              
 * 
 * <p>Classe Java de ItemInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ItemInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="path" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{urn://oracle.bi.webservices/v6}ItemInfoType"/>
 *         &lt;element name="caption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attributes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="lastModified" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="accessed" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="creator" type="{urn://oracle.bi.webservices/v6}Account" minOccurs="0"/>
 *         &lt;element name="lastModifier" type="{urn://oracle.bi.webservices/v6}Account" minOccurs="0"/>
 *         &lt;element name="signature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="acl" type="{urn://oracle.bi.webservices/v6}ACL" minOccurs="0"/>
 *         &lt;element name="owner" type="{urn://oracle.bi.webservices/v6}Account" minOccurs="0"/>
 *         &lt;element name="itemProperties" type="{urn://oracle.bi.webservices/v6}NameValuePair" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemInfo", propOrder = {
    "path",
    "type",
    "caption",
    "attributes",
    "lastModified",
    "created",
    "accessed",
    "creator",
    "lastModifier",
    "signature",
    "targetPath",
    "acl",
    "owner",
    "itemProperties"
})
public class ItemInfo {

    @XmlElement(required = true)
    protected String path;
    @XmlElement(required = true)
    protected ItemInfoType type;
    protected String caption;
    protected Integer attributes;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastModified;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar accessed;
    protected Account creator;
    protected Account lastModifier;
    protected String signature;
    protected String targetPath;
    protected ACL acl;
    protected Account owner;
    protected List<NameValuePair> itemProperties;

    /**
     * Obtém o valor da propriedade path.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * Define o valor da propriedade path.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link ItemInfoType }
     *     
     */
    public ItemInfoType getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemInfoType }
     *     
     */
    public void setType(ItemInfoType value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade caption.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Define o valor da propriedade caption.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaption(String value) {
        this.caption = value;
    }

    /**
     * Obtém o valor da propriedade attributes.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAttributes() {
        return attributes;
    }

    /**
     * Define o valor da propriedade attributes.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAttributes(Integer value) {
        this.attributes = value;
    }

    /**
     * Obtém o valor da propriedade lastModified.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastModified() {
        return lastModified;
    }

    /**
     * Define o valor da propriedade lastModified.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastModified(XMLGregorianCalendar value) {
        this.lastModified = value;
    }

    /**
     * Obtém o valor da propriedade created.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreated() {
        return created;
    }

    /**
     * Define o valor da propriedade created.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreated(XMLGregorianCalendar value) {
        this.created = value;
    }

    /**
     * Obtém o valor da propriedade accessed.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAccessed() {
        return accessed;
    }

    /**
     * Define o valor da propriedade accessed.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAccessed(XMLGregorianCalendar value) {
        this.accessed = value;
    }

    /**
     * Obtém o valor da propriedade creator.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getCreator() {
        return creator;
    }

    /**
     * Define o valor da propriedade creator.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setCreator(Account value) {
        this.creator = value;
    }

    /**
     * Obtém o valor da propriedade lastModifier.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getLastModifier() {
        return lastModifier;
    }

    /**
     * Define o valor da propriedade lastModifier.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setLastModifier(Account value) {
        this.lastModifier = value;
    }

    /**
     * Obtém o valor da propriedade signature.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Define o valor da propriedade signature.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignature(String value) {
        this.signature = value;
    }

    /**
     * Obtém o valor da propriedade targetPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetPath() {
        return targetPath;
    }

    /**
     * Define o valor da propriedade targetPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetPath(String value) {
        this.targetPath = value;
    }

    /**
     * Obtém o valor da propriedade acl.
     * 
     * @return
     *     possible object is
     *     {@link ACL }
     *     
     */
    public ACL getAcl() {
        return acl;
    }

    /**
     * Define o valor da propriedade acl.
     * 
     * @param value
     *     allowed object is
     *     {@link ACL }
     *     
     */
    public void setAcl(ACL value) {
        this.acl = value;
    }

    /**
     * Obtém o valor da propriedade owner.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getOwner() {
        return owner;
    }

    /**
     * Define o valor da propriedade owner.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setOwner(Account value) {
        this.owner = value;
    }

    /**
     * Gets the value of the itemProperties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemProperties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemProperties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameValuePair }
     * 
     * 
     */
    public List<NameValuePair> getItemProperties() {
        if (itemProperties == null) {
            itemProperties = new ArrayList<NameValuePair>();
        }
        return this.itemProperties;
    }

}
