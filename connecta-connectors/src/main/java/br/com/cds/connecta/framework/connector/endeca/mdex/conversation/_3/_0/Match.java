
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Details of a single value within a particular property
 * 						that matched a value search.  The FullPath will be present
 * 						when the matched value is dimension value.
 * 
 * <p>Classe Java de Match complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Match">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MatchingValue" type="{http://www.endeca.com/MDEX/conversation/3/0}ResultValue"/>
 *         &lt;element name="FullPath" type="{http://www.endeca.com/MDEX/conversation/3/0}Path" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Match", propOrder = {
    "matchingValue",
    "fullPath"
})
public class Match {

    @XmlElement(name = "MatchingValue", required = true)
    protected ResultValue matchingValue;
    @XmlElement(name = "FullPath")
    protected Path fullPath;

    /**
     * Obt\u00e9m o valor da propriedade matchingValue.
     * 
     * @return
     *     possible object is
     *     {@link ResultValue }
     *     
     */
    public ResultValue getMatchingValue() {
        return matchingValue;
    }

    /**
     * Define o valor da propriedade matchingValue.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultValue }
     *     
     */
    public void setMatchingValue(ResultValue value) {
        this.matchingValue = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade fullPath.
     * 
     * @return
     *     possible object is
     *     {@link Path }
     *     
     */
    public Path getFullPath() {
        return fullPath;
    }

    /**
     * Define o valor da propriedade fullPath.
     * 
     * @param value
     *     allowed object is
     *     {@link Path }
     *     
     */
    public void setFullPath(Path value) {
        this.fullPath = value;
    }

}
