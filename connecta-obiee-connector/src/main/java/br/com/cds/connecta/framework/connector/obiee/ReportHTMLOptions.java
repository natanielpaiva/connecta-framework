
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ReportHTMLOptions complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ReportHTMLOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enableDelayLoading" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="linkMode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportHTMLOptions", propOrder = {
    "enableDelayLoading",
    "linkMode"
})
public class ReportHTMLOptions {

    protected boolean enableDelayLoading;
    @XmlElement(required = true)
    protected String linkMode;

    /**
     * Obtém o valor da propriedade enableDelayLoading.
     * 
     */
    public boolean isEnableDelayLoading() {
        return enableDelayLoading;
    }

    /**
     * Define o valor da propriedade enableDelayLoading.
     * 
     */
    public void setEnableDelayLoading(boolean value) {
        this.enableDelayLoading = value;
    }

    /**
     * Obtém o valor da propriedade linkMode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkMode() {
        return linkMode;
    }

    /**
     * Define o valor da propriedade linkMode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkMode(String value) {
        this.linkMode = value;
    }

}
