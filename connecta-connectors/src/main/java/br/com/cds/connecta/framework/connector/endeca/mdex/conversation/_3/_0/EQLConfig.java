
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import br.com.cds.connecta.framework.connector.endeca.mdex.eql_parser.types.Query;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
//import com.endeca.mdex.eql_parser.types.Query;


/**
 * A content element that allows arbitrary EQL statements to be evaluated. These statements
 * 						are submitted either as string or as XML.
 * 
 * <p>Classe Java de EQLConfig complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="EQLConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElementConfig">
 *       &lt;choice>
 *         &lt;element name="EQLQuery" type="{http://www.endeca.com/MDEX/eql_parser/types}Query"/>
 *         &lt;element name="EQLQueryString" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EQLConfig", propOrder = {
    "eqlQuery",
    "eqlQueryString"
})
public class EQLConfig
    extends ContentElementConfig
{

    @XmlElement(name = "EQLQuery")
    protected Query eqlQuery;
    @XmlElement(name = "EQLQueryString")
    protected String eqlQueryString;

    /**
     * Obt\u00e9m o valor da propriedade eqlQuery.
     * 
     * @return
     *     possible object is
     *     {@link Query }
     *     
     */
    public Query getEQLQuery() {
        return eqlQuery;
    }

    /**
     * Define o valor da propriedade eqlQuery.
     * 
     * @param value
     *     allowed object is
     *     {@link Query }
     *     
     */
    public void setEQLQuery(Query value) {
        this.eqlQuery = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade eqlQueryString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEQLQueryString() {
        return eqlQueryString;
    }

    /**
     * Define o valor da propriedade eqlQueryString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEQLQueryString(String value) {
        this.eqlQueryString = value;
    }

}
