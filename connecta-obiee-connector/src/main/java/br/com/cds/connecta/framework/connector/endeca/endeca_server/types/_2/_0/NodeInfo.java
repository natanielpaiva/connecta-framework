
package br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Information about a node in the Endeca Server cluster.
 * 
 * <p>Classe Java de nodeInfo complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="nodeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="protocol" type="{http://www.endeca.com/endeca-server/types/2/0}protocol" minOccurs="0"/>
 *         &lt;element name="hostname" type="{http://www.endeca.com/endeca-server/types/2/0}nonEmptyString"/>
 *         &lt;element name="nodePort" type="{http://www.endeca.com/endeca-server/types/2/0}positiveInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nodeInfo", propOrder = {
    "protocol",
    "hostname",
    "nodePort"
})
public class NodeInfo {

    protected Protocol protocol;
    @XmlElement(required = true)
    protected String hostname;
    protected Integer nodePort;

    /**
     * Obt\u00e9m o valor da propriedade protocol.
     * 
     * @return
     *     possible object is
     *     {@link Protocol }
     *     
     */
    public Protocol getProtocol() {
        return protocol;
    }

    /**
     * Define o valor da propriedade protocol.
     * 
     * @param value
     *     allowed object is
     *     {@link Protocol }
     *     
     */
    public void setProtocol(Protocol value) {
        this.protocol = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade hostname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Define o valor da propriedade hostname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostname(String value) {
        this.hostname = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade nodePort.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNodePort() {
        return nodePort;
    }

    /**
     * Define o valor da propriedade nodePort.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNodePort(Integer value) {
        this.nodePort = value;
    }

}
