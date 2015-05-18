
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="entityAdditionInformation" type="{http://www.endeca.com/endeca-server/sconfig/3/0}entityAdditionInformation"/>
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
    "entityAdditionInformation"
})
@XmlRootElement(name = "putEntitiesResponse")
public class PutEntitiesResponse {

    @XmlElement(required = true)
    protected EntityAdditionInformation entityAdditionInformation;

    /**
     * Obt\u00e9m o valor da propriedade entityAdditionInformation.
     * 
     * @return
     *     possible object is
     *     {@link EntityAdditionInformation }
     *     
     */
    public EntityAdditionInformation getEntityAdditionInformation() {
        return entityAdditionInformation;
    }

    /**
     * Define o valor da propriedade entityAdditionInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityAdditionInformation }
     *     
     */
    public void setEntityAdditionInformation(EntityAdditionInformation value) {
        this.entityAdditionInformation = value;
    }

}
