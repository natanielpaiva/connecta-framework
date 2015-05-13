
package br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2._0;

import br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0.DataDomainStats;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
//import com.endeca.endeca_server.types._2._0.DataDomainStats;


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
 *         &lt;element name="dataDomainStats" type="{http://www.endeca.com/endeca-server/types/2/0}dataDomainStats"/>
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
    "dataDomainStats"
})
@XmlRootElement(name = "getDataDomainStatsResponse")
public class GetDataDomainStatsResponse {

    @XmlElement(required = true)
    protected DataDomainStats dataDomainStats;

    /**
     * Obt\u00e9m o valor da propriedade dataDomainStats.
     * 
     * @return
     *     possible object is
     *     {@link DataDomainStats }
     *     
     */
    public DataDomainStats getDataDomainStats() {
        return dataDomainStats;
    }

    /**
     * Define o valor da propriedade dataDomainStats.
     * 
     * @param value
     *     allowed object is
     *     {@link DataDomainStats }
     *     
     */
    public void setDataDomainStats(DataDomainStats value) {
        this.dataDomainStats = value;
    }

}
