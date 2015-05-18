
package br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2._0;

import br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0.DataDomainDetail;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//import com.endeca.endeca_server.types._2._0.DataDomainDetail;


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
 *         &lt;element name="dataDomainDetail" type="{http://www.endeca.com/endeca-server/types/2/0}dataDomainDetail"/>
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
    "dataDomainDetail"
})
@XmlRootElement(name = "getDataDomainResponse")
public class GetDataDomainResponse {

    @XmlElement(required = true)
    protected DataDomainDetail dataDomainDetail;

    /**
     * Obt\u00e9m o valor da propriedade dataDomainDetail.
     * 
     * @return
     *     possible object is
     *     {@link DataDomainDetail }
     *     
     */
    public DataDomainDetail getDataDomainDetail() {
        return dataDomainDetail;
    }

    /**
     * Define o valor da propriedade dataDomainDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link DataDomainDetail }
     *     
     */
    public void setDataDomainDetail(DataDomainDetail value) {
        this.dataDomainDetail = value;
    }

}
