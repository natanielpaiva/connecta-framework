
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * An indication of where the current page of a record list falls in the ordinal enumeration of 
 * 						the records returned by the filter.
 * 
 * <p>Classe Java de RecordRange complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="RecordRange">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="First" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       &lt;attribute name="Last" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordRange")
public class RecordRange {

    @XmlAttribute(name = "First", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long first;
    @XmlAttribute(name = "Last", required = true)
    @XmlSchemaType(name = "unsignedInt")
    protected long last;

    /**
     * Obt\u00e9m o valor da propriedade first.
     * 
     */
    public long getFirst() {
        return first;
    }

    /**
     * Define o valor da propriedade first.
     * 
     */
    public void setFirst(long value) {
        this.first = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade last.
     * 
     */
    public long getLast() {
        return last;
    }

    /**
     * Define o valor da propriedade last.
     * 
     */
    public void setLast(long value) {
        this.last = value;
    }

}
