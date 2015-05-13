
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Current exposure status of a dimension.
 * 
 * <p>Classe Java de ExposureControl complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ExposureControl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Exposed" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExposureControl")
public class ExposureControl {

    @XmlAttribute(name = "Exposed", required = true)
    protected boolean exposed;

    /**
     * Obt\u00e9m o valor da propriedade exposed.
     * 
     */
    public boolean isExposed() {
        return exposed;
    }

    /**
     * Define o valor da propriedade exposed.
     * 
     */
    public void setExposed(boolean value) {
        this.exposed = value;
    }

}
