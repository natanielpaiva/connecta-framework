
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
 *         &lt;element name="ColumnInfo" type="{urn://oracle.bi.webservices/v6}PromptedColumnInfo"/>
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
    "columnInfo"
})
@XmlRootElement(name = "getPromptedColumnsResult")
public class GetPromptedColumnsResult {

    @XmlElement(name = "ColumnInfo", required = true)
    protected PromptedColumnInfo columnInfo;

    /**
     * Obtém o valor da propriedade columnInfo.
     * 
     * @return
     *     possible object is
     *     {@link PromptedColumnInfo }
     *     
     */
    public PromptedColumnInfo getColumnInfo() {
        return columnInfo;
    }

    /**
     * Define o valor da propriedade columnInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link PromptedColumnInfo }
     *     
     */
    public void setColumnInfo(PromptedColumnInfo value) {
        this.columnInfo = value;
    }

}
