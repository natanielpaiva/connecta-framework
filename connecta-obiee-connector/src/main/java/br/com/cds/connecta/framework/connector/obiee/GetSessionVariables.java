
package br.com.cds.connecta.framework.connector.obiee;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                    Predefined variable names:
 *                    NQ_SESSION.USER,
 *                    NQ_SESSION.USERGUID,
 *                    NQ_SESSION.GROUP,
 *                    NQ_SESSION.GROUPGUIDS,
 *                    NQ_SESSION.WEBGROUPS, 
 *                    NQ_SESSION.REALM,
 *                    NQ_SESSION.REALMGUID,
 *                    NQ_SESSION.TOKENS,
 *                    NQ_SESSION.REQUESTKEY,
 *                    NQ_SESSION.PORTALPATH,
 *                    NQ_SESSION.DISPLAYNAME,
 *                    NQ_SESSION.SKIN,
 *                    NQ_SESSION.STYLE,
 *                    NQ_SESSION.EMAIL,
 *                    NQ_SESSION.CURRENCYTAG,
 *                    NQ_SESSION.ACTUATEUSERID,
 *                    NQ_SESSION.TIMEZONE,
 *                    NQ_SESSION.DATA_TZ,
 *                    NQ_SESSION.DATA_DISPLAY_TZ,
 *                    NQ_SESSION.PROXYLEVEL,
 *                    NQ_SESSION.USERLOCALE,
 *                    NQ_SESSION.USERLANG,
 *                    NQ_SESSION.PREFERRED_CURRENCY
 *                 
 * 
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="names" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
    "names",
    "sessionID"
})
@XmlRootElement(name = "getSessionVariables")
public class GetSessionVariables {

    @XmlElement(nillable = true)
    protected List<String> names;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Gets the value of the names property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the names property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNames() {
        if (names == null) {
            names = new ArrayList<String>();
        }
        return this.names;
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
