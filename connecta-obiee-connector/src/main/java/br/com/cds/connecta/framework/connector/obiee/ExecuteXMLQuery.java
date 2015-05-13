
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
 *         &lt;element name="report" type="{urn://oracle.bi.webservices/v6}ReportRef"/>
 *         &lt;element name="outputFormat" type="{urn://oracle.bi.webservices/v6}XMLQueryOutputFormat"/>
 *         &lt;element name="executionOptions" type="{urn://oracle.bi.webservices/v6}XMLQueryExecutionOptions"/>
 *         &lt;element name="reportParams" type="{urn://oracle.bi.webservices/v6}ReportParams"/>
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
    "report",
    "outputFormat",
    "executionOptions",
    "reportParams",
    "sessionID"
})
@XmlRootElement(name = "executeXMLQuery")
public class ExecuteXMLQuery {

    @XmlElement(required = true)
    protected ReportRef report;
    @XmlElement(required = true)
    protected XMLQueryOutputFormat outputFormat;
    @XmlElement(required = true, nillable = true)
    protected XMLQueryExecutionOptions executionOptions;
    @XmlElement(required = true, nillable = true)
    protected ReportParams reportParams;
    @XmlElement(required = true, nillable = true)
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
     * Obtém o valor da propriedade outputFormat.
     * 
     * @return
     *     possible object is
     *     {@link XMLQueryOutputFormat }
     *     
     */
    public XMLQueryOutputFormat getOutputFormat() {
        return outputFormat;
    }

    /**
     * Define o valor da propriedade outputFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLQueryOutputFormat }
     *     
     */
    public void setOutputFormat(XMLQueryOutputFormat value) {
        this.outputFormat = value;
    }

    /**
     * Obtém o valor da propriedade executionOptions.
     * 
     * @return
     *     possible object is
     *     {@link XMLQueryExecutionOptions }
     *     
     */
    public XMLQueryExecutionOptions getExecutionOptions() {
        return executionOptions;
    }

    /**
     * Define o valor da propriedade executionOptions.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLQueryExecutionOptions }
     *     
     */
    public void setExecutionOptions(XMLQueryExecutionOptions value) {
        this.executionOptions = value;
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
