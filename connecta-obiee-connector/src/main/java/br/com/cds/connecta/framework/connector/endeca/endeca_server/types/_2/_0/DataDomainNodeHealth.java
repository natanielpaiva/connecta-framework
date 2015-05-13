
package br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The health of one of node of a particular data domain of the Endeca Server cluster.
 * 
 * <p>Classe Java de dataDomainNodeHealth complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dataDomainNodeHealth">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nodeInfo" type="{http://www.endeca.com/endeca-server/types/2/0}nodeInfo"/>
 *         &lt;element name="available" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dgraphRunningOnNode" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dgraphFailureDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "dataDomainNodeHealth", propOrder = {
    "nodeInfo",
    "available",
    "dgraphRunningOnNode",
    "dgraphFailureDescription",
    "detail"
})
public class DataDomainNodeHealth {

    @XmlElement(required = true)
    protected NodeInfo nodeInfo;
    protected boolean available;
    protected boolean dgraphRunningOnNode;
    @XmlElement(required = true)
    protected String dgraphFailureDescription;
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
     * Obt\u00e9m o valor da propriedade dgraphRunningOnNode.
     * 
     */
    public boolean isDgraphRunningOnNode() {
        return dgraphRunningOnNode;
    }

    /**
     * Define o valor da propriedade dgraphRunningOnNode.
     * 
     */
    public void setDgraphRunningOnNode(boolean value) {
        this.dgraphRunningOnNode = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade dgraphFailureDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDgraphFailureDescription() {
        return dgraphFailureDescription;
    }

    /**
     * Define o valor da propriedade dgraphFailureDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDgraphFailureDescription(String value) {
        this.dgraphFailureDescription = value;
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
