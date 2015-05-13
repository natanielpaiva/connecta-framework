
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
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="impersonateID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sessionparams" type="{urn://oracle.bi.webservices/v6}SAWSessionParameters"/>
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
    "name",
    "password",
    "impersonateID",
    "sessionparams"
})
@XmlRootElement(name = "impersonateex")
public class Impersonateex {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected String impersonateID;
    @XmlElement(required = true, nillable = true)
    protected SAWSessionParameters sessionparams;

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define o valor da propriedade password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Obtém o valor da propriedade impersonateID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImpersonateID() {
        return impersonateID;
    }

    /**
     * Define o valor da propriedade impersonateID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImpersonateID(String value) {
        this.impersonateID = value;
    }

    /**
     * Obtém o valor da propriedade sessionparams.
     * 
     * @return
     *     possible object is
     *     {@link SAWSessionParameters }
     *     
     */
    public SAWSessionParameters getSessionparams() {
        return sessionparams;
    }

    /**
     * Define o valor da propriedade sessionparams.
     * 
     * @param value
     *     allowed object is
     *     {@link SAWSessionParameters }
     *     
     */
    public void setSessionparams(SAWSessionParameters value) {
        this.sessionparams = value;
    }

}
