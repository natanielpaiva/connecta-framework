
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de XMLQueryExecutionOptions complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="XMLQueryExecutionOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="async" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="maxRowsPerPage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="refresh" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="presentationInfo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLQueryExecutionOptions", propOrder = {
    "async",
    "maxRowsPerPage",
    "refresh",
    "presentationInfo",
    "type"
})
public class XMLQueryExecutionOptions {

    protected boolean async;
    protected int maxRowsPerPage;
    protected boolean refresh;
    protected boolean presentationInfo;
    @XmlElement(required = true, nillable = true)
    protected String type;

    /**
     * Obtém o valor da propriedade async.
     * 
     */
    public boolean isAsync() {
        return async;
    }

    /**
     * Define o valor da propriedade async.
     * 
     */
    public void setAsync(boolean value) {
        this.async = value;
    }

    /**
     * Obtém o valor da propriedade maxRowsPerPage.
     * 
     */
    public int getMaxRowsPerPage() {
        return maxRowsPerPage;
    }

    /**
     * Define o valor da propriedade maxRowsPerPage.
     * 
     */
    public void setMaxRowsPerPage(int value) {
        this.maxRowsPerPage = value;
    }

    /**
     * Obtém o valor da propriedade refresh.
     * 
     */
    public boolean isRefresh() {
        return refresh;
    }

    /**
     * Define o valor da propriedade refresh.
     * 
     */
    public void setRefresh(boolean value) {
        this.refresh = value;
    }

    /**
     * Obtém o valor da propriedade presentationInfo.
     * 
     */
    public boolean isPresentationInfo() {
        return presentationInfo;
    }

    /**
     * Define o valor da propriedade presentationInfo.
     * 
     */
    public void setPresentationInfo(boolean value) {
        this.presentationInfo = value;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
