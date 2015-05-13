
package br.com.cds.connecta.framework.connector.endeca.endeca_server.manage._2._0;

import br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0.BulkLoadInfo;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
//import com.endeca.endeca_server.types._2._0.BulkLoadInfo;


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
 *         &lt;element name="bulkLoad" type="{http://www.endeca.com/endeca-server/types/2/0}bulkLoadInfo"/>
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
    "bulkLoad"
})
@XmlRootElement(name = "allocateBulkLoadPortResponse")
public class AllocateBulkLoadPortResponse {

    @XmlElement(required = true)
    protected BulkLoadInfo bulkLoad;

    /**
     * Obt\u00e9m o valor da propriedade bulkLoad.
     * 
     * @return
     *     possible object is
     *     {@link BulkLoadInfo }
     *     
     */
    public BulkLoadInfo getBulkLoad() {
        return bulkLoad;
    }

    /**
     * Define o valor da propriedade bulkLoad.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkLoadInfo }
     *     
     */
    public void setBulkLoad(BulkLoadInfo value) {
        this.bulkLoad = value;
    }

}
