
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SASubjectAreaDetails.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="SASubjectAreaDetails">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Minimum"/>
 *     &lt;enumeration value="IncludeTables"/>
 *     &lt;enumeration value="IncludeTablesAndColumns"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SASubjectAreaDetails")
@XmlEnum
public enum SASubjectAreaDetails {

    @XmlEnumValue("Minimum")
    MINIMUM("Minimum"),
    @XmlEnumValue("IncludeTables")
    INCLUDE_TABLES("IncludeTables"),
    @XmlEnumValue("IncludeTablesAndColumns")
    INCLUDE_TABLES_AND_COLUMNS("IncludeTablesAndColumns");
    private final String value;

    SASubjectAreaDetails(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SASubjectAreaDetails fromValue(String v) {
        for (SASubjectAreaDetails c: SASubjectAreaDetails.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
