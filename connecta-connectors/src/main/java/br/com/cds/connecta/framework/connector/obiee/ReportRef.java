
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ReportRef complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ReportRef">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reportPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reportXml" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportRef", propOrder = {
    "reportPath",
    "reportXml"
})
public class ReportRef {

    @XmlElement(required = true, nillable = true)
    protected String reportPath;
    @XmlElement(required = true, nillable = true)
    protected String reportXml;

    /**
     * Obtém o valor da propriedade reportPath.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportPath() {
        return reportPath;
    }

    /**
     * Define o valor da propriedade reportPath.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportPath(String value) {
        this.reportPath = value;
    }

    /**
     * Obtém o valor da propriedade reportXml.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportXml() {
        return reportXml;
    }

    /**
     * Define o valor da propriedade reportXml.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportXml(String value) {
        this.reportXml = value;
    }

}
