
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="validatedSemanticEntity" type="{http://www.endeca.com/endeca-server/sconfig/3/0}validatedSemanticEntity" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlRootElement(name = "listEntitiesResponse")
public class ListEntitiesResponse {

    protected List<ValidatedSemanticEntity> validatedSemanticEntity;

    /**
     * Gets the value of the validatedSemanticEntity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the validatedSemanticEntity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValidatedSemanticEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValidatedSemanticEntity }
     * 
     * 
     */
    public List<ValidatedSemanticEntity> getValidatedSemanticEntity() {
        if (validatedSemanticEntity == null) {
            validatedSemanticEntity = new ArrayList<ValidatedSemanticEntity>();
        }
        return this.validatedSemanticEntity;
    }

}
