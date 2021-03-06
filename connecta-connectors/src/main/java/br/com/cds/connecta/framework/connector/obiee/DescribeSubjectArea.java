
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
 *         &lt;element name="subjectAreaName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="detailsLevel" type="{urn://oracle.bi.webservices/v6}SASubjectAreaDetails"/>
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
    "subjectAreaName",
    "detailsLevel",
    "sessionID"
})
@XmlRootElement(name = "describeSubjectArea")
public class DescribeSubjectArea {

    @XmlElement(required = true)
    protected String subjectAreaName;
    @XmlElement(required = true)
    protected SASubjectAreaDetails detailsLevel;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Obtém o valor da propriedade subjectAreaName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubjectAreaName() {
        return subjectAreaName;
    }

    /**
     * Define o valor da propriedade subjectAreaName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubjectAreaName(String value) {
        this.subjectAreaName = value;
    }

    /**
     * Obtém o valor da propriedade detailsLevel.
     * 
     * @return
     *     possible object is
     *     {@link SASubjectAreaDetails }
     *     
     */
    public SASubjectAreaDetails getDetailsLevel() {
        return detailsLevel;
    }

    /**
     * Define o valor da propriedade detailsLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link SASubjectAreaDetails }
     *     
     */
    public void setDetailsLevel(SASubjectAreaDetails value) {
        this.detailsLevel = value;
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
