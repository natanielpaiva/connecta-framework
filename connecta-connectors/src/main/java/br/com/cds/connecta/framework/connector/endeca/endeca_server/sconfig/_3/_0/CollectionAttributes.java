
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de collectionAttributes complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="collectionAttributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="collectionAttribute" type="{http://www.endeca.com/endeca-server/sconfig/3/0}collectionAttribute" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "collectionAttributes", propOrder = {
    "collectionAttribute"
})
public class CollectionAttributes {

    protected List<CollectionAttribute> collectionAttribute;

    /**
     * Gets the value of the collectionAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the collectionAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCollectionAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CollectionAttribute }
     * 
     * 
     */
    public List<CollectionAttribute> getCollectionAttribute() {
        if (collectionAttribute == null) {
            collectionAttribute = new ArrayList<CollectionAttribute>();
        }
        return this.collectionAttribute;
    }

}
