
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
 *         &lt;element name="numFilterRulesDeleted" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "numFilterRulesDeleted"
})
@XmlRootElement(name = "deleteFilterRulesResponse")
public class DeleteFilterRulesResponse {

    protected int numFilterRulesDeleted;

    /**
     * Obt\u00e9m o valor da propriedade numFilterRulesDeleted.
     * 
     */
    public int getNumFilterRulesDeleted() {
        return numFilterRulesDeleted;
    }

    /**
     * Define o valor da propriedade numFilterRulesDeleted.
     * 
     */
    public void setNumFilterRulesDeleted(int value) {
        this.numFilterRulesDeleted = value;
    }

}
