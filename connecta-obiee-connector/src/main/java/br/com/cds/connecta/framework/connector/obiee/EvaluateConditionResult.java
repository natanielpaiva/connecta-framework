
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="conditionIsTrue" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "conditionIsTrue"
})
@XmlRootElement(name = "evaluateConditionResult")
public class EvaluateConditionResult {

    protected boolean conditionIsTrue;

    /**
     * Obtém o valor da propriedade conditionIsTrue.
     * 
     */
    public boolean isConditionIsTrue() {
        return conditionIsTrue;
    }

    /**
     * Define o valor da propriedade conditionIsTrue.
     * 
     */
    public void setConditionIsTrue(boolean value) {
        this.conditionIsTrue = value;
    }

}
