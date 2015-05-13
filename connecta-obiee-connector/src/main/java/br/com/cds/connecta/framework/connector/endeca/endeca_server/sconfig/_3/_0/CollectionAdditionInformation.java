
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de collectionAdditionInformation complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="collectionAdditionInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="numCollectionsAdded" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="numCollectionsReplaced" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "collectionAdditionInformation")
public class CollectionAdditionInformation {

    @XmlAttribute(name = "numCollectionsAdded")
    protected Integer numCollectionsAdded;
    @XmlAttribute(name = "numCollectionsReplaced")
    protected Integer numCollectionsReplaced;

    /**
     * Obt\u00e9m o valor da propriedade numCollectionsAdded.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumCollectionsAdded() {
        return numCollectionsAdded;
    }

    /**
     * Define o valor da propriedade numCollectionsAdded.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumCollectionsAdded(Integer value) {
        this.numCollectionsAdded = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade numCollectionsReplaced.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumCollectionsReplaced() {
        return numCollectionsReplaced;
    }

    /**
     * Define o valor da propriedade numCollectionsReplaced.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumCollectionsReplaced(Integer value) {
        this.numCollectionsReplaced = value;
    }

}
