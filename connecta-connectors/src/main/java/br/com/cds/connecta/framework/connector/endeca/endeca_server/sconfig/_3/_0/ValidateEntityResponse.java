
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="validatedSemanticEntity" type="{http://www.endeca.com/endeca-server/sconfig/3/0}validatedSemanticEntity" minOccurs="0"/>
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
    "validatedSemanticEntity"
})
@XmlRootElement(name = "validateEntityResponse")
public class ValidateEntityResponse {

    protected ValidatedSemanticEntity validatedSemanticEntity;

    /**
     * Obt\u00e9m o valor da propriedade validatedSemanticEntity.
     * 
     * @return
     *     possible object is
     *     {@link ValidatedSemanticEntity }
     *     
     */
    public ValidatedSemanticEntity getValidatedSemanticEntity() {
        return validatedSemanticEntity;
    }

    /**
     * Define o valor da propriedade validatedSemanticEntity.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidatedSemanticEntity }
     *     
     */
    public void setValidatedSemanticEntity(ValidatedSemanticEntity value) {
        this.validatedSemanticEntity = value;
    }

}
