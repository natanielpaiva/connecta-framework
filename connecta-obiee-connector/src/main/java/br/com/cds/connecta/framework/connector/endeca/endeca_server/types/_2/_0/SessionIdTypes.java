
package br.com.cds.connecta.framework.connector.endeca.endeca_server.types._2._0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de sessionIdTypes.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="sessionIdTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="header"/>
 *     &lt;enumeration value="parameter"/>
 *     &lt;enumeration value="cookie"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "sessionIdTypes")
@XmlEnum
public enum SessionIdTypes {

    @XmlEnumValue("header")
    HEADER("header"),
    @XmlEnumValue("parameter")
    PARAMETER("parameter"),
    @XmlEnumValue("cookie")
    COOKIE("cookie");
    private final String value;

    SessionIdTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SessionIdTypes fromValue(String v) {
        for (SessionIdTypes c: SessionIdTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
