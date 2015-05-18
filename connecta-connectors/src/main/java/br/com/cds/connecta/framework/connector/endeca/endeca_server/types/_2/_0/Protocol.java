
package br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de protocol.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="protocol">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="http"/>
 *     &lt;enumeration value="https"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "protocol")
@XmlEnum
public enum Protocol {

    @XmlEnumValue("http")
    HTTP("http"),
    @XmlEnumValue("https")
    HTTPS("https");
    private final String value;

    Protocol(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Protocol fromValue(String v) {
        for (Protocol c: Protocol.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
