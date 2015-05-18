
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de StartPageParams complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="StartPageParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idsPrefix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dontUseHttpCookies" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StartPageParams", propOrder = {
    "idsPrefix",
    "dontUseHttpCookies"
})
public class StartPageParams {

    @XmlElement(required = true, nillable = true)
    protected String idsPrefix;
    @XmlElement(defaultValue = "false")
    protected boolean dontUseHttpCookies;

    /**
     * Obtém o valor da propriedade idsPrefix.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdsPrefix() {
        return idsPrefix;
    }

    /**
     * Define o valor da propriedade idsPrefix.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdsPrefix(String value) {
        this.idsPrefix = value;
    }

    /**
     * Obtém o valor da propriedade dontUseHttpCookies.
     * 
     */
    public boolean isDontUseHttpCookies() {
        return dontUseHttpCookies;
    }

    /**
     * Define o valor da propriedade dontUseHttpCookies.
     * 
     */
    public void setDontUseHttpCookies(boolean value) {
        this.dontUseHttpCookies = value;
    }

}
