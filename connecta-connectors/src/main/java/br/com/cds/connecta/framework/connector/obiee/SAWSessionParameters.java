
package br.com.cds.connecta.framework.connector.obiee;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SAWSessionParameters complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SAWSessionParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="locale" type="{urn://oracle.bi.webservices/v6}SAWLocale"/>
 *         &lt;element name="userAgent" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="asyncLogon" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="logonParams" type="{urn://oracle.bi.webservices/v6}LogonParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="syndicate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SAWSessionParameters", propOrder = {
    "locale",
    "userAgent",
    "asyncLogon",
    "logonParams",
    "sessionID",
    "syndicate"
})
public class SAWSessionParameters {

    @XmlElement(required = true, nillable = true)
    protected SAWLocale locale;
    @XmlElement(required = true, nillable = true)
    protected String userAgent;
    protected boolean asyncLogon;
    @XmlElement(nillable = true)
    protected List<LogonParameter> logonParams;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;
    @XmlElement(required = true, nillable = true)
    protected String syndicate;

    /**
     * Obtém o valor da propriedade locale.
     * 
     * @return
     *     possible object is
     *     {@link SAWLocale }
     *     
     */
    public SAWLocale getLocale() {
        return locale;
    }

    /**
     * Define o valor da propriedade locale.
     * 
     * @param value
     *     allowed object is
     *     {@link SAWLocale }
     *     
     */
    public void setLocale(SAWLocale value) {
        this.locale = value;
    }

    /**
     * Obtém o valor da propriedade userAgent.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * Define o valor da propriedade userAgent.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserAgent(String value) {
        this.userAgent = value;
    }

    /**
     * Obtém o valor da propriedade asyncLogon.
     * 
     */
    public boolean isAsyncLogon() {
        return asyncLogon;
    }

    /**
     * Define o valor da propriedade asyncLogon.
     * 
     */
    public void setAsyncLogon(boolean value) {
        this.asyncLogon = value;
    }

    /**
     * Gets the value of the logonParams property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the logonParams property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLogonParams().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LogonParameter }
     * 
     * 
     */
    public List<LogonParameter> getLogonParams() {
        if (logonParams == null) {
            logonParams = new ArrayList<LogonParameter>();
        }
        return this.logonParams;
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

    /**
     * Obtém o valor da propriedade syndicate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSyndicate() {
        return syndicate;
    }

    /**
     * Define o valor da propriedade syndicate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSyndicate(String value) {
        this.syndicate = value;
    }

}
