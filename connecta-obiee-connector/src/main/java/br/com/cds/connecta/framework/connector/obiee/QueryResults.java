
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de QueryResults complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="QueryResults">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rowset" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="queryID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="finished" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryResults", propOrder = {
    "rowset",
    "queryID",
    "finished"
})
public class QueryResults {

    @XmlElement(required = true)
    protected String rowset;
    @XmlElement(required = true)
    protected String queryID;
    protected boolean finished;

    /**
     * Obtém o valor da propriedade rowset.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRowset() {
        return rowset;
    }

    /**
     * Define o valor da propriedade rowset.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRowset(String value) {
        this.rowset = value;
    }

    /**
     * Obtém o valor da propriedade queryID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryID() {
        return queryID;
    }

    /**
     * Define o valor da propriedade queryID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryID(String value) {
        this.queryID = value;
    }

    /**
     * Obtém o valor da propriedade finished.
     * 
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * Define o valor da propriedade finished.
     * 
     */
    public void setFinished(boolean value) {
        this.finished = value;
    }

}
