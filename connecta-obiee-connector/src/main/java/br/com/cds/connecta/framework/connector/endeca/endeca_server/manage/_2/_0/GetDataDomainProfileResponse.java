
package br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0.DataDomainProfile;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataDomainProfile" type="{http://www.endeca.com/endeca-server/types/2/0}dataDomainProfile"/>
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
    "dataDomainProfile"
})
@XmlRootElement(name = "getDataDomainProfileResponse")
public class GetDataDomainProfileResponse {

    @XmlElement(required = true)
    protected DataDomainProfile dataDomainProfile;

    /**
     * Obt\u00e9m o valor da propriedade dataDomainProfile.
     * 
     * @return
     *     possible object is
     *     {@link DataDomainProfile }
     *     
     */
    public DataDomainProfile getDataDomainProfile() {
        return dataDomainProfile;
    }

    /**
     * Define o valor da propriedade dataDomainProfile.
     * 
     * @param value
     *     allowed object is
     *     {@link DataDomainProfile }
     *     
     */
    public void setDataDomainProfile(DataDomainProfile value) {
        this.dataDomainProfile = value;
    }

}
