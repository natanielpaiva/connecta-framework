
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * The result data corresponding to a RecordCountConfig request. 
 * 						It contains the result of counting records.
 * 
 * <p>Classe Java de RecordCount complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RecordCount">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.endeca.com/MDEX/conversation/3/0}ContentElement">
 *       &lt;sequence>
 *         &lt;element name="NumRecords" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordCount", propOrder = {
    "numRecords"
})
public class RecordCount
    extends ContentElement
{

    @XmlElement(name = "NumRecords")
    @XmlSchemaType(name = "unsignedInt")
    protected long numRecords;

    /**
     * Obt\u00e9m o valor da propriedade numRecords.
     * 
     */
    public long getNumRecords() {
        return numRecords;
    }

    /**
     * Define o valor da propriedade numRecords.
     * 
     */
    public void setNumRecords(long value) {
        this.numRecords = value;
    }

}
