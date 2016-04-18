
package br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Runtime statistics about a data domain on a particular node
 * 
 * <p>Classe Java de dataDomainNodeStats complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dataDomainNodeStats">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="node" type="{http://www.endeca.com/endeca-server/types/2/0}nodeInfo"/>
 *         &lt;element name="statsXML" type="{http://www.endeca.com/endeca-server/types/2/0}nonEmptyString"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataDomainNodeStats", propOrder = {
    "node",
    "statsXML"
})
public class DataDomainNodeStats {

    @XmlElement(required = true)
    protected NodeInfo node;
    @XmlElement(required = true)
    protected String statsXML;

    /**
     * Obt\u00e9m o valor da propriedade node.
     * 
     * @return
     *     possible object is
     *     {@link NodeInfo }
     *     
     */
    public NodeInfo getNode() {
        return node;
    }

    /**
     * Define o valor da propriedade node.
     * 
     * @param value
     *     allowed object is
     *     {@link NodeInfo }
     *     
     */
    public void setNode(NodeInfo value) {
        this.node = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade statsXML.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatsXML() {
        return statsXML;
    }

    /**
     * Define o valor da propriedade statsXML.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatsXML(String value) {
        this.statsXML = value;
    }

}
