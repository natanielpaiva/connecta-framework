
package br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Information about a node's health in the Endeca Server cluster
 * 
 * <p>Classe Java de nodeHealth complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="nodeHealth">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nodeInfo" type="{http://www.endeca.com/endeca-server/types/2/0}nodeInfo"/>
 *         &lt;element name="available" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dataDomainHealth" type="{http://www.endeca.com/endeca-server/types/2/0}nodeDataDomainHealth" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="clusterCoordinatorConnectionStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="detail" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nodeHealth", propOrder = {
    "nodeInfo",
    "available",
    "dataDomainHealth",
    "clusterCoordinatorConnectionStatus",
    "detail"
})
public class NodeHealth {

    @XmlElement(required = true)
    protected NodeInfo nodeInfo;
    protected boolean available;
    protected List<NodeDataDomainHealth> dataDomainHealth;
    @XmlElement(required = true)
    protected String clusterCoordinatorConnectionStatus;
    protected List<String> detail;

    /**
     * Obt\u00e9m o valor da propriedade nodeInfo.
     * 
     * @return
     *     possible object is
     *     {@link NodeInfo }
     *     
     */
    public NodeInfo getNodeInfo() {
        return nodeInfo;
    }

    /**
     * Define o valor da propriedade nodeInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link NodeInfo }
     *     
     */
    public void setNodeInfo(NodeInfo value) {
        this.nodeInfo = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade available.
     * 
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Define o valor da propriedade available.
     * 
     */
    public void setAvailable(boolean value) {
        this.available = value;
    }

    /**
     * Gets the value of the dataDomainHealth property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataDomainHealth property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataDomainHealth().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NodeDataDomainHealth }
     * 
     * 
     */
    public List<NodeDataDomainHealth> getDataDomainHealth() {
        if (dataDomainHealth == null) {
            dataDomainHealth = new ArrayList<NodeDataDomainHealth>();
        }
        return this.dataDomainHealth;
    }

    /**
     * Obt\u00e9m o valor da propriedade clusterCoordinatorConnectionStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClusterCoordinatorConnectionStatus() {
        return clusterCoordinatorConnectionStatus;
    }

    /**
     * Define o valor da propriedade clusterCoordinatorConnectionStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClusterCoordinatorConnectionStatus(String value) {
        this.clusterCoordinatorConnectionStatus = value;
    }

    /**
     * Gets the value of the detail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDetail() {
        if (detail == null) {
            detail = new ArrayList<String>();
        }
        return this.detail;
    }

}
