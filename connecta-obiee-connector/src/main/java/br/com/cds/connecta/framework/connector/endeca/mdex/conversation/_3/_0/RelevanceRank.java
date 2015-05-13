
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * @deprecated
 * 						A score reflecting the computed relevance of this record to one of the searches
 * 						in the State. If more than one search is in the State, and arbitrary but consistent
 * 						search will be used to rank results. This score is comparable only within the same
 * 						security filter, filter state, text search, and specific records in the corpus. If
 * 						any of these differs, the scores are not comparable.
 * 
 * <p>Classe Java de RelevanceRank complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RelevanceRank">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>unsignedInt">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelevanceRank", propOrder = {
    "value"
})
public class RelevanceRank {

    @XmlValue
    @XmlSchemaType(name = "unsignedInt")
    protected long value;

    /**
     * Obt\u00e9m o valor da propriedade value.
     * 
     */
    public long getValue() {
        return value;
    }

    /**
     * Define o valor da propriedade value.
     * 
     */
    public void setValue(long value) {
        this.value = value;
    }

}
