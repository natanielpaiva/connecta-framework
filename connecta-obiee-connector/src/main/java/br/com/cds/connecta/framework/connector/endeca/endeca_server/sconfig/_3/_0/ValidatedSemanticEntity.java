
package br.com.cds.connecta.framework.connector.endeca.endeca_server.sconfig._3._0;

import br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types.Query;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
//import com.endeca.mdex.eql_parser.types.Query;


/**
 * <p>Classe Java de validatedSemanticEntity complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="validatedSemanticEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/endeca-server/sconfig/3/0}semanticEntity">
 *       &lt;sequence>
 *         &lt;element name="parsedDefinition" type="{http://www.endeca.com/MDEX/eql_parser/types}Query"/>
 *         &lt;element name="dependentSources" type="{http://www.endeca.com/endeca-server/sconfig/3/0}NonEmptyString" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="isValid" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validatedSemanticEntity", propOrder = {
    "parsedDefinition",
    "dependentSources"
})
public class ValidatedSemanticEntity
    extends SemanticEntity
{

    @XmlElement(required = true)
    protected Query parsedDefinition;
    protected List<String> dependentSources;
    @XmlAttribute(name = "isValid", required = true)
    protected boolean isValid;

    /**
     * Obt\u00e9m o valor da propriedade parsedDefinition.
     * 
     * @return
     *     possible object is
     *     {@link Query }
     *     
     */
    public Query getParsedDefinition() {
        return parsedDefinition;
    }

    /**
     * Define o valor da propriedade parsedDefinition.
     * 
     * @param value
     *     allowed object is
     *     {@link Query }
     *     
     */
    public void setParsedDefinition(Query value) {
        this.parsedDefinition = value;
    }

    /**
     * Gets the value of the dependentSources property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dependentSources property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDependentSources().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDependentSources() {
        if (dependentSources == null) {
            dependentSources = new ArrayList<String>();
        }
        return this.dependentSources;
    }

    /**
     * Obt\u00e9m o valor da propriedade isValid.
     * 
     */
    public boolean isIsValid() {
        return isValid;
    }

    /**
     * Define o valor da propriedade isValid.
     * 
     */
    public void setIsValid(boolean value) {
        this.isValid = value;
    }

}
