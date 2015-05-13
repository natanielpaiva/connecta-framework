
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
 *         &lt;element name="collectionAdditionInformation" type="{http://www.endeca.com/endeca-server/sconfig/3/0}collectionAdditionInformation"/>
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
    "collectionAdditionInformation"
})
@XmlRootElement(name = "putCollectionsResponse")
public class PutCollectionsResponse {

    @XmlElement(required = true)
    protected CollectionAdditionInformation collectionAdditionInformation;

    /**
     * Obt\u00e9m o valor da propriedade collectionAdditionInformation.
     * 
     * @return
     *     possible object is
     *     {@link CollectionAdditionInformation }
     *     
     */
    public CollectionAdditionInformation getCollectionAdditionInformation() {
        return collectionAdditionInformation;
    }

    /**
     * Define o valor da propriedade collectionAdditionInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link CollectionAdditionInformation }
     *     
     */
    public void setCollectionAdditionInformation(CollectionAdditionInformation value) {
        this.collectionAdditionInformation = value;
    }

}
