
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de collectionRecord complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="collectionRecord">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/endeca-server/sconfig/3/0}collection">
 *       &lt;sequence>
 *         &lt;element name="collectionAttributes" type="{http://www.endeca.com/endeca-server/sconfig/3/0}collectionAttributes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "collectionRecord", propOrder = {
    "collectionAttributes"
})
public class CollectionRecord
    extends Collection
{

    protected CollectionAttributes collectionAttributes;

    /**
     * Obt\u00e9m o valor da propriedade collectionAttributes.
     * 
     * @return
     *     possible object is
     *     {@link CollectionAttributes }
     *     
     */
    public CollectionAttributes getCollectionAttributes() {
        return collectionAttributes;
    }

    /**
     * Define o valor da propriedade collectionAttributes.
     * 
     * @param value
     *     allowed object is
     *     {@link CollectionAttributes }
     *     
     */
    public void setCollectionAttributes(CollectionAttributes value) {
        this.collectionAttributes = value;
    }

}
