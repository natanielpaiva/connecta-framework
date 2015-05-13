
package br.com.cds.connecta.framework.connector.obiee;

import java.math.BigInteger;

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
 *         &lt;element name="report" type="{urn://oracle.bi.webservices/v6}ReportRef" minOccurs="0"/>
 *         &lt;element name="reportParams" type="{urn://oracle.bi.webservices/v6}ReportParams" minOccurs="0"/>
 *         &lt;element name="segmentPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="treeNodePath" type="{urn://oracle.bi.webservices/v6}TreeNodePath" minOccurs="0"/>
 *         &lt;element name="segmentationOptions" type="{urn://oracle.bi.webservices/v6}SegmentationOptions" minOccurs="0"/>
 *         &lt;element name="filesystem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timeout" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
    "report",
    "reportParams",
    "segmentPath",
    "treeNodePath",
    "segmentationOptions",
    "filesystem",
    "timeout",
    "sessionID"
})
@XmlRootElement(name = "writeListFiles")
public class WriteListFiles {

    protected ReportRef report;
    protected ReportParams reportParams;
    protected String segmentPath;
    protected TreeNodePath treeNodePath;
    protected SegmentationOptions segmentationOptions;
    @XmlElement(required = true)
    protected String filesystem;
    @XmlElement(required = true)
    protected BigInteger timeout;
    protected String sessionID;

    /**
     * Obtém o valor da propriedade report.
     * 
     * @return
     *     possible object is
     *     {@link ReportRef }
     *     
     */
    public ReportRef getReport() {
        return report;
    }

    /**
     * Define o valor da propriedade report.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportRef }
     *     
     */
    public void setReport(ReportRef value) {
        this.report = value;
    }

    /**
     * Obtém o valor da propriedade reportParams.
     * 
     * @return
     *     possible object is
     *     {@link ReportParams }
     *     
     */
    public ReportParams getReportParams() {
        return reportParams;
    }

    /**
     * Define o valor da propriedade reportParams.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportParams }
     *     
     */
    public void setReportParams(ReportParams value) {
        this.reportParams = value;
    }

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
     * Obtém o valor da propriedade filesystem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilesystem() {
        return filesystem;
    }

    /**
     * Define o valor da propriedade filesystem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilesystem(String value) {
        this.filesystem = value;
    }

    /**
     * Obtém o valor da propriedade timeout.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimeout() {
        return timeout;
    }

    /**
     * Define o valor da propriedade timeout.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimeout(BigInteger value) {
        this.timeout = value;
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
