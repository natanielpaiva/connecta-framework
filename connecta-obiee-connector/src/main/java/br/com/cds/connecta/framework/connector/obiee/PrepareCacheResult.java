
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
 *         &lt;element name="jobInfo" type="{urn://oracle.bi.webservices/v6}JobInfo"/>
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
    "jobInfo"
})
@XmlRootElement(name = "prepareCacheResult")
public class PrepareCacheResult {

    @XmlElement(required = true)
    protected JobInfo jobInfo;

    /**
     * Obtém o valor da propriedade jobInfo.
     * 
     * @return
     *     possible object is
     *     {@link JobInfo }
     *     
     */
    public JobInfo getJobInfo() {
        return jobInfo;
    }

    /**
     * Define o valor da propriedade jobInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link JobInfo }
     *     
     */
    public void setJobInfo(JobInfo value) {
        this.jobInfo = value;
    }

}
