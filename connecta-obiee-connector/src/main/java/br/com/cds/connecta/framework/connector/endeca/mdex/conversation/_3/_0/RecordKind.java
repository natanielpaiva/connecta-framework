
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de RecordKind.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="RecordKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="data"/>
 *     &lt;enumeration value="nondata"/>
 *     &lt;enumeration value="properties"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RecordKind")
@XmlEnum
public enum RecordKind {

    @XmlEnumValue("data")
    DATA("data"),
    @XmlEnumValue("nondata")
    NONDATA("nondata"),
    @XmlEnumValue("properties")
    PROPERTIES("properties");
    private final String value;

    RecordKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RecordKind fromValue(String v) {
        for (RecordKind c: RecordKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
