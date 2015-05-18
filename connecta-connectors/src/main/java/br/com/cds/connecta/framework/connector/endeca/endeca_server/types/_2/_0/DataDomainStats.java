
package br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Runtime statistics about a data domain.
 * 
 * <p>Classe Java de dataDomainStats complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dataDomainStats">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="indexSizeMB" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt"/>
 *         &lt;element name="numRecords" type="{http://www.endeca.com/endeca-server/types/2/0}nonNegativeInt"/>
 *         &lt;element name="nodeStats" type="{http://www.endeca.com/endeca-server/types/2/0}dataDomainNodeStats" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataDomainStats", propOrder = {
    "indexSizeMB",
    "numRecords",
    "nodeStats"
})
public class DataDomainStats {

    protected int indexSizeMB;
    protected int numRecords;
    @XmlElement(required = true)
    protected List<DataDomainNodeStats> nodeStats;

    /**
     * Obt\u00e9m o valor da propriedade indexSizeMB.
     * 
     */
    public int getIndexSizeMB() {
        return indexSizeMB;
    }

    /**
     * Define o valor da propriedade indexSizeMB.
     * 
     */
    public void setIndexSizeMB(int value) {
        this.indexSizeMB = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade numRecords.
     * 
     */
    public int getNumRecords() {
        return numRecords;
    }

    /**
     * Define o valor da propriedade numRecords.
     * 
     */
    public void setNumRecords(int value) {
        this.numRecords = value;
    }

    /**
     * Gets the value of the nodeStats property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nodeStats property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNodeStats().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataDomainNodeStats }
     * 
     * 
     */
    public List<DataDomainNodeStats> getNodeStats() {
        if (nodeStats == null) {
            nodeStats = new ArrayList<DataDomainNodeStats>();
        }
        return this.nodeStats;
    }

}
