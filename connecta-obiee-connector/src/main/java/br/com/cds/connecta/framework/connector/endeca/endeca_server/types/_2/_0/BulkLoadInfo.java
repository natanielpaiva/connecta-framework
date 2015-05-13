
package br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Information about a bulkLoad host and port.
 * 
 * <p>Classe Java de bulkLoadInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="bulkLoadInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="host" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bulkLoadInfo", propOrder = {
    "host",
    "port"
})
public class BulkLoadInfo {

    @XmlElement(required = true)
    protected String host;
    protected int port;

    /**
     * Obt\u00e9m o valor da propriedade host.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHost() {
        return host;
    }

    /**
     * Define o valor da propriedade host.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHost(String value) {
        this.host = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade port.
     * 
     */
    public int getPort() {
        return port;
    }

    /**
     * Define o valor da propriedade port.
     * 
     */
    public void setPort(int value) {
        this.port = value;
    }

}
