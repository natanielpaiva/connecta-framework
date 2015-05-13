
package br.com.cds.connecta.framework.connector.obiee;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de JobStats complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="JobStats">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="jobID" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="jobType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jobUser" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jobState">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Running"/>
 *               &lt;enumeration value="Finished"/>
 *               &lt;enumeration value="Error"/>
 *               &lt;enumeration value="Queued"/>
 *               &lt;enumeration value="Cancelled"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="jobTotalMilliSec" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="jobStartedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="jobFinishedTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="jobIsCancelling" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="exception" type="{urn://oracle.bi.webservices/v6}SAWException" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JobStats", propOrder = {
    "jobID",
    "jobType",
    "jobUser",
    "jobState",
    "jobTotalMilliSec",
    "jobStartedTime",
    "jobFinishedTime",
    "jobIsCancelling",
    "exception"
})
public class JobStats {

    @XmlElement(required = true)
    protected BigInteger jobID;
    @XmlElement(required = true)
    protected String jobType;
    @XmlElement(required = true)
    protected String jobUser;
    @XmlElement(required = true)
    protected String jobState;
    @XmlElement(required = true)
    protected String jobTotalMilliSec;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar jobStartedTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar jobFinishedTime;
    @XmlElement(required = true)
    protected String jobIsCancelling;
    protected SAWException exception;

    /**
     * Obtém o valor da propriedade jobID.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getJobID() {
        return jobID;
    }

    /**
     * Define o valor da propriedade jobID.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setJobID(BigInteger value) {
        this.jobID = value;
    }

    /**
     * Obtém o valor da propriedade jobType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * Define o valor da propriedade jobType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobType(String value) {
        this.jobType = value;
    }

    /**
     * Obtém o valor da propriedade jobUser.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobUser() {
        return jobUser;
    }

    /**
     * Define o valor da propriedade jobUser.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobUser(String value) {
        this.jobUser = value;
    }

    /**
     * Obtém o valor da propriedade jobState.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobState() {
        return jobState;
    }

    /**
     * Define o valor da propriedade jobState.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobState(String value) {
        this.jobState = value;
    }

    /**
     * Obtém o valor da propriedade jobTotalMilliSec.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobTotalMilliSec() {
        return jobTotalMilliSec;
    }

    /**
     * Define o valor da propriedade jobTotalMilliSec.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobTotalMilliSec(String value) {
        this.jobTotalMilliSec = value;
    }

    /**
     * Obtém o valor da propriedade jobStartedTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getJobStartedTime() {
        return jobStartedTime;
    }

    /**
     * Define o valor da propriedade jobStartedTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setJobStartedTime(XMLGregorianCalendar value) {
        this.jobStartedTime = value;
    }

    /**
     * Obtém o valor da propriedade jobFinishedTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getJobFinishedTime() {
        return jobFinishedTime;
    }

    /**
     * Define o valor da propriedade jobFinishedTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setJobFinishedTime(XMLGregorianCalendar value) {
        this.jobFinishedTime = value;
    }

    /**
     * Obtém o valor da propriedade jobIsCancelling.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobIsCancelling() {
        return jobIsCancelling;
    }

    /**
     * Define o valor da propriedade jobIsCancelling.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobIsCancelling(String value) {
        this.jobIsCancelling = value;
    }

    /**
     * Obtém o valor da propriedade exception.
     * 
     * @return
     *     possible object is
     *     {@link SAWException }
     *     
     */
    public SAWException getException() {
        return exception;
    }

    /**
     * Define o valor da propriedade exception.
     * 
     * @param value
     *     allowed object is
     *     {@link SAWException }
     *     
     */
    public void setException(SAWException value) {
        this.exception = value;
    }

}
