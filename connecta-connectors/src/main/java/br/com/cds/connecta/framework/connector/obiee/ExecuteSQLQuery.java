
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sql" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="outputFormat" type="{urn://oracle.bi.webservices/v6}XMLQueryOutputFormat"/>
 *         &lt;element name="executionOptions" type="{urn://oracle.bi.webservices/v6}XMLQueryExecutionOptions"/>
 *         &lt;element name="sessionID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "sql",
    "outputFormat",
    "executionOptions",
    "sessionID"
})
@XmlRootElement(name = "executeSQLQuery")
public class ExecuteSQLQuery {

    @XmlElement(required = true)
    protected String sql;
    @XmlElement(required = true)
    protected XMLQueryOutputFormat outputFormat;
    @XmlElement(required = true, nillable = true)
    protected XMLQueryExecutionOptions executionOptions;
    @XmlElement(required = true, nillable = true)
    protected String sessionID;

    /**
     * Obtém o valor da propriedade sql.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSql() {
        return sql;
    }

    /**
     * Define o valor da propriedade sql.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSql(String value) {
        this.sql = value;
    }

    /**
     * Obtém o valor da propriedade outputFormat.
     * 
     * @return
     *     possible object is
     *     {@link XMLQueryOutputFormat }
     *     
     */
    public XMLQueryOutputFormat getOutputFormat() {
        return outputFormat;
    }

    /**
     * Define o valor da propriedade outputFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLQueryOutputFormat }
     *     
     */
    public void setOutputFormat(XMLQueryOutputFormat value) {
        this.outputFormat = value;
    }

    /**
     * Obtém o valor da propriedade executionOptions.
     * 
     * @return
     *     possible object is
     *     {@link XMLQueryExecutionOptions }
     *     
     */
    public XMLQueryExecutionOptions getExecutionOptions() {
        return executionOptions;
    }

    /**
     * Define o valor da propriedade executionOptions.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLQueryExecutionOptions }
     *     
     */
    public void setExecutionOptions(XMLQueryExecutionOptions value) {
        this.executionOptions = value;
    }

    /**
     * Obtém o valor da propriedade sessionID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionID() {
        return sessionID;
    }

    /**
     * Define o valor da propriedade sessionID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionID(String value) {
        this.sessionID = value;
    }

}
