
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de entityAdditionInformation complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="entityAdditionInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="numEntitiesAdded" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="numEntitiesReplaced" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entityAdditionInformation")
public class EntityAdditionInformation {

    @XmlAttribute(name = "numEntitiesAdded")
    protected Integer numEntitiesAdded;
    @XmlAttribute(name = "numEntitiesReplaced")
    protected Integer numEntitiesReplaced;

    /**
     * Obt\u00e9m o valor da propriedade numEntitiesAdded.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumEntitiesAdded() {
        return numEntitiesAdded;
    }

    /**
     * Define o valor da propriedade numEntitiesAdded.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumEntitiesAdded(Integer value) {
        this.numEntitiesAdded = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade numEntitiesReplaced.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumEntitiesReplaced() {
        return numEntitiesReplaced;
    }

    /**
     * Define o valor da propriedade numEntitiesReplaced.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumEntitiesReplaced(Integer value) {
        this.numEntitiesReplaced = value;
    }

}
