
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="segmentPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="treeNodePath" type="{urn://oracle.bi.webservices/v6}TreeNodePath" minOccurs="0"/>
 *         &lt;element name="savedSegmentPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="segmentationOptions" type="{urn://oracle.bi.webservices/v6}SegmentationOptions" minOccurs="0"/>
 *         &lt;element name="SRCustomLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appendStaticSegment" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "segmentPath",
    "treeNodePath",
    "savedSegmentPath",
    "segmentationOptions",
    "srCustomLabel",
    "appendStaticSegment",
    "sessionID"
})
@XmlRootElement(name = "saveResultSet")
public class SaveResultSet {

    protected String segmentPath;
    protected TreeNodePath treeNodePath;
    protected String savedSegmentPath;
    protected SegmentationOptions segmentationOptions;
    @XmlElement(name = "SRCustomLabel")
    protected String srCustomLabel;
    @XmlElement(defaultValue = "false")
    protected Boolean appendStaticSegment;
    protected String sessionID;

    /**
     * Obtém o valor da propriedade segmentPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegmentPath() {
        return segmentPath;
    }

    /**
     * Define o valor da propriedade segmentPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegmentPath(String value) {
        this.segmentPath = value;
    }

    /**
     * Obtém o valor da propriedade treeNodePath.
     * 
     * @return
     *     possible object is
     *     {@link TreeNodePath }
     *     
     */
    public TreeNodePath getTreeNodePath() {
        return treeNodePath;
    }

    /**
     * Define o valor da propriedade treeNodePath.
     * 
     * @param value
     *     allowed object is
     *     {@link TreeNodePath }
     *     
     */
    public void setTreeNodePath(TreeNodePath value) {
        this.treeNodePath = value;
    }

    /**
     * Obtém o valor da propriedade savedSegmentPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSavedSegmentPath() {
        return savedSegmentPath;
    }

    /**
     * Define o valor da propriedade savedSegmentPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSavedSegmentPath(String value) {
        this.savedSegmentPath = value;
    }

    /**
     * Obtém o valor da propriedade segmentationOptions.
     * 
     * @return
     *     possible object is
     *     {@link SegmentationOptions }
     *     
     */
    public SegmentationOptions getSegmentationOptions() {
        return segmentationOptions;
    }

    /**
     * Define o valor da propriedade segmentationOptions.
     * 
     * @param value
     *     allowed object is
     *     {@link SegmentationOptions }
     *     
     */
    public void setSegmentationOptions(SegmentationOptions value) {
        this.segmentationOptions = value;
    }

    /**
     * Obtém o valor da propriedade srCustomLabel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSRCustomLabel() {
        return srCustomLabel;
    }

    /**
     * Define o valor da propriedade srCustomLabel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSRCustomLabel(String value) {
        this.srCustomLabel = value;
    }

    /**
     * Obtém o valor da propriedade appendStaticSegment.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAppendStaticSegment() {
        return appendStaticSegment;
    }

    /**
     * Define o valor da propriedade appendStaticSegment.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAppendStaticSegment(Boolean value) {
        this.appendStaticSegment = value;
    }

    /**
     * Obtém o valor da propriedade sessionID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionID() {
        return sessionID;
    }

    /**
     * Define o valor da propriedade sessionID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionID(String value) {
        this.sessionID = value;
    }

}
