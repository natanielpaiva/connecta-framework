
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SearchMode.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="SearchMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="All"/>
 *     &lt;enumeration value="AllAny"/>
 *     &lt;enumeration value="AllPartial"/>
 *     &lt;enumeration value="Any"/>
 *     &lt;enumeration value="Boolean"/>
 *     &lt;enumeration value="Partial"/>
 *     &lt;enumeration value="PartialMax"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SearchMode")
@XmlEnum
public enum SearchMode {

    @XmlEnumValue("All")
    ALL("All"),
    @XmlEnumValue("AllAny")
    ALL_ANY("AllAny"),
    @XmlEnumValue("AllPartial")
    ALL_PARTIAL("AllPartial"),
    @XmlEnumValue("Any")
    ANY("Any"),
    @XmlEnumValue("Boolean")
    BOOLEAN("Boolean"),
    @XmlEnumValue("Partial")
    PARTIAL("Partial"),
    @XmlEnumValue("PartialMax")
    PARTIAL_MAX("PartialMax"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    SearchMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SearchMode fromValue(String v) {
        for (SearchMode c: SearchMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
