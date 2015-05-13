
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de UpdateACLParams complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="UpdateACLParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="updateFlag" type="{urn://oracle.bi.webservices/v6}UpdateACLMode"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateACLParams", propOrder = {
    "updateFlag"
})
public class UpdateACLParams {

    @XmlElement(required = true)
    protected UpdateACLMode updateFlag;

    /**
     * Obtém o valor da propriedade updateFlag.
     * 
     * @return
     *     possible object is
     *     {@link UpdateACLMode }
     *     
     */
    public UpdateACLMode getUpdateFlag() {
        return updateFlag;
    }

    /**
     * Define o valor da propriedade updateFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateACLMode }
     *     
     */
    public void setUpdateFlag(UpdateACLMode value) {
        this.updateFlag = value;
    }

}
