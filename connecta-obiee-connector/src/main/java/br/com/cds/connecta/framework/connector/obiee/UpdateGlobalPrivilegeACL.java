
package br.com.cds.connecta.framework.connector.obiee;

import br.com.cds.connecta.framework.connector.obiee.ACL;
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
 *         &lt;element name="privilegeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="acl" type="{urn://oracle.bi.webservices/v6}ACL"/>
 *         &lt;element name="updateACLParams" type="{urn://oracle.bi.webservices/v6}UpdateACLParams"/>
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
    "privilegeName",
    "acl",
    "updateACLParams",
    "sessionID"
})
@XmlRootElement(name = "updateGlobalPrivilegeACL")
public class UpdateGlobalPrivilegeACL {

    @XmlElement(required = true)
    protected String privilegeName;
    @XmlElement(required = true)
    protected ACL acl;
    @XmlElement(required = true, nillable = true)
    protected UpdateACLParams updateACLParams;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Obtém o valor da propriedade privilegeName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrivilegeName() {
        return privilegeName;
    }

    /**
     * Define o valor da propriedade privilegeName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrivilegeName(String value) {
        this.privilegeName = value;
    }

    /**
     * Obtém o valor da propriedade acl.
     * 
     * @return
     *     possible object is
     *     {@link ACL }
     *     
     */
    public ACL getAcl() {
        return acl;
    }

    /**
     * Define o valor da propriedade acl.
     * 
     * @param value
     *     allowed object is
     *     {@link ACL }
     *     
     */
    public void setAcl(ACL value) {
        this.acl = value;
    }

    /**
     * Obtém o valor da propriedade updateACLParams.
     * 
     * @return
     *     possible object is
     *     {@link UpdateACLParams }
     *     
     */
    public UpdateACLParams getUpdateACLParams() {
        return updateACLParams;
    }

    /**
     * Define o valor da propriedade updateACLParams.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateACLParams }
     *     
     */
    public void setUpdateACLParams(UpdateACLParams value) {
        this.updateACLParams = value;
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
