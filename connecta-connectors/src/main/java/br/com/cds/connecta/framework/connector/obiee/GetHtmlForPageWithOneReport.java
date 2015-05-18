
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
 *         &lt;element name="reportID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="report" type="{urn://oracle.bi.webservices/v6}ReportRef"/>
 *         &lt;element name="reportViewName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reportParams" type="{urn://oracle.bi.webservices/v6}ReportParams"/>
 *         &lt;element name="reportOptions" type="{urn://oracle.bi.webservices/v6}ReportHTMLOptions"/>
 *         &lt;element name="pageParams" type="{urn://oracle.bi.webservices/v6}StartPageParams"/>
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "reportID",
    "report",
    "reportViewName",
    "reportParams",
    "reportOptions",
    "pageParams",
    "sessionID"
})
@XmlRootElement(name = "getHtmlForPageWithOneReport")
public class GetHtmlForPageWithOneReport {

    @XmlElement(required = true)
    protected String reportID;
    @XmlElement(required = true)
    protected ReportRef report;
    @XmlElement(required = true, nillable = true)
    protected String reportViewName;
    @XmlElement(required = true, nillable = true)
    protected ReportParams reportParams;
    @XmlElement(required = true, nillable = true)
    protected ReportHTMLOptions reportOptions;
    @XmlElement(required = true, nillable = true)
    protected StartPageParams pageParams;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Obtém o valor da propriedade reportID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportID() {
        return reportID;
    }

    /**
     * Define o valor da propriedade reportID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportID(String value) {
        this.reportID = value;
    }

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
     * Obtém o valor da propriedade reportViewName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportViewName() {
        return reportViewName;
    }

    /**
     * Define o valor da propriedade reportViewName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportViewName(String value) {
        this.reportViewName = value;
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
     * Obtém o valor da propriedade reportOptions.
     * 
     * @return
     *     possible object is
     *     {@link ReportHTMLOptions }
     *     
     */
    public ReportHTMLOptions getReportOptions() {
        return reportOptions;
    }

    /**
     * Define o valor da propriedade reportOptions.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportHTMLOptions }
     *     
     */
    public void setReportOptions(ReportHTMLOptions value) {
        this.reportOptions = value;
    }

    /**
     * Obtém o valor da propriedade pageParams.
     * 
     * @return
     *     possible object is
     *     {@link StartPageParams }
     *     
     */
    public StartPageParams getPageParams() {
        return pageParams;
    }

    /**
     * Define o valor da propriedade pageParams.
     * 
     * @param value
     *     allowed object is
     *     {@link StartPageParams }
     *     
     */
    public void setPageParams(StartPageParams value) {
        this.pageParams = value;
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
