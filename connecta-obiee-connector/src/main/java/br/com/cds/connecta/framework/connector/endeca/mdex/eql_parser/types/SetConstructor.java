
package br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SetConstructor complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SetConstructor">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase">
 *       &lt;sequence>
 *         &lt;element name="elementValues" type="{http://www.endeca.com/MDEX/eql_parser/types}ExpressionBase" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetConstructor", propOrder = {
    "elementValues"
})
public class SetConstructor
    extends ExpressionBase
{

    protected List<ExpressionBase> elementValues;

    /**
     * Gets the value of the elementValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elementValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElementValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExpressionBase }
     * 
     * 
     */
    public List<ExpressionBase> getElementValues() {
        if (elementValues == null) {
            elementValues = new ArrayList<ExpressionBase>();
        }
        return this.elementValues;
    }

}
