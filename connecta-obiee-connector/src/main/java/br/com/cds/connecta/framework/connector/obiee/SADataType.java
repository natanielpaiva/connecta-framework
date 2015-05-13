
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SADataType.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="SADataType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Invalid"/>
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="VarBinary"/>
 *     &lt;enumeration value="LongVarBinary"/>
 *     &lt;enumeration value="Binary"/>
 *     &lt;enumeration value="Char"/>
 *     &lt;enumeration value="VarChar"/>
 *     &lt;enumeration value="LongVarChar"/>
 *     &lt;enumeration value="Date"/>
 *     &lt;enumeration value="Time"/>
 *     &lt;enumeration value="TimeStamp"/>
 *     &lt;enumeration value="Numeric"/>
 *     &lt;enumeration value="Decimal"/>
 *     &lt;enumeration value="Integer"/>
 *     &lt;enumeration value="SmallInt"/>
 *     &lt;enumeration value="BigInt"/>
 *     &lt;enumeration value="TinyInt"/>
 *     &lt;enumeration value="Bit"/>
 *     &lt;enumeration value="Float"/>
 *     &lt;enumeration value="Real"/>
 *     &lt;enumeration value="Double"/>
 *     &lt;enumeration value="Coordinate"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SADataType")
@XmlEnum
public enum SADataType {

    @XmlEnumValue("Invalid")
    INVALID("Invalid"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("VarBinary")
    VAR_BINARY("VarBinary"),
    @XmlEnumValue("LongVarBinary")
    LONG_VAR_BINARY("LongVarBinary"),
    @XmlEnumValue("Binary")
    BINARY("Binary"),
    @XmlEnumValue("Char")
    CHAR("Char"),
    @XmlEnumValue("VarChar")
    VAR_CHAR("VarChar"),
    @XmlEnumValue("LongVarChar")
    LONG_VAR_CHAR("LongVarChar"),
    @XmlEnumValue("Date")
    DATE("Date"),
    @XmlEnumValue("Time")
    TIME("Time"),
    @XmlEnumValue("TimeStamp")
    TIME_STAMP("TimeStamp"),
    @XmlEnumValue("Numeric")
    NUMERIC("Numeric"),
    @XmlEnumValue("Decimal")
    DECIMAL("Decimal"),
    @XmlEnumValue("Integer")
    INTEGER("Integer"),
    @XmlEnumValue("SmallInt")
    SMALL_INT("SmallInt"),
    @XmlEnumValue("BigInt")
    BIG_INT("BigInt"),
    @XmlEnumValue("TinyInt")
    TINY_INT("TinyInt"),
    @XmlEnumValue("Bit")
    BIT("Bit"),
    @XmlEnumValue("Float")
    FLOAT("Float"),
    @XmlEnumValue("Real")
    REAL("Real"),
    @XmlEnumValue("Double")
    DOUBLE("Double"),
    @XmlEnumValue("Coordinate")
    COORDINATE("Coordinate");
    private final String value;

    SADataType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SADataType fromValue(String v) {
        for (SADataType c: SADataType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
