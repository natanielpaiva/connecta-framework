
package br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Hardware profile of nodes in the Endeca Server cluster.
 * 
 * <p>Classe Java de nodeProfile complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="nodeProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numCpuCores" type="{http://www.endeca.com/endeca-server/types/2/0}positiveInt" minOccurs="0"/>
 *         &lt;element name="ramSizeMB" type="{http://www.endeca.com/endeca-server/types/2/0}positiveInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nodeProfile", propOrder = {
    "numCpuCores",
    "ramSizeMB"
})
public class NodeProfile {

    protected Integer numCpuCores;
    @XmlElement(defaultValue = "1024")
    protected Integer ramSizeMB;

    /**
     * Obt\u00e9m o valor da propriedade numCpuCores.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumCpuCores() {
        return numCpuCores;
    }

    /**
     * Define o valor da propriedade numCpuCores.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumCpuCores(Integer value) {
        this.numCpuCores = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade ramSizeMB.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRamSizeMB() {
        return ramSizeMB;
    }

    /**
     * Define o valor da propriedade ramSizeMB.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRamSizeMB(Integer value) {
        this.ramSizeMB = value;
    }

}
