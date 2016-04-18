
package br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Overall health of the Endeca Server cluster.
 * 
 * <p>Classe Java de clusterHealth complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="clusterHealth">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clusterCoordinators" type="{http://www.endeca.com/endeca-server/types/2/0}clusterCoordinatorHealth" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nodes" type="{http://www.endeca.com/endeca-server/types/2/0}nodeHealth" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dataDomains" type="{http://www.endeca.com/endeca-server/types/2/0}dataDomainHealth" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "clusterHealth", propOrder = {
    "clusterCoordinators",
    "nodes",
    "dataDomains",
    "detail"
})
public class ClusterHealth {

    protected List<ClusterCoordinatorHealth> clusterCoordinators;
    protected List<NodeHealth> nodes;
    protected List<DataDomainHealth> dataDomains;
    protected List<String> detail;

    /**
     * Gets the value of the clusterCoordinators property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clusterCoordinators property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClusterCoordinators().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterCoordinatorHealth }
     * 
     * 
     */
    public List<ClusterCoordinatorHealth> getClusterCoordinators() {
        if (clusterCoordinators == null) {
            clusterCoordinators = new ArrayList<ClusterCoordinatorHealth>();
        }
        return this.clusterCoordinators;
    }

    /**
     * Gets the value of the nodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NodeHealth }
     * 
     * 
     */
    public List<NodeHealth> getNodes() {
        if (nodes == null) {
            nodes = new ArrayList<NodeHealth>();
        }
        return this.nodes;
    }

    /**
     * Gets the value of the dataDomains property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataDomains property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataDomains().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataDomainHealth }
     * 
     * 
     */
    public List<DataDomainHealth> getDataDomains() {
        if (dataDomains == null) {
            dataDomains = new ArrayList<DataDomainHealth>();
        }
        return this.dataDomains;
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
