
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de XMLQueryOutputFormat.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="XMLQueryOutputFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SAWRowsetData"/>
 *     &lt;enumeration value="SAWRowsetSchema"/>
 *     &lt;enumeration value="SAWRowsetSchemaAndData"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "XMLQueryOutputFormat")
@XmlEnum
public enum XMLQueryOutputFormat {

    @XmlEnumValue("SAWRowsetData")
    SAW_ROWSET_DATA("SAWRowsetData"),
    @XmlEnumValue("SAWRowsetSchema")
    SAW_ROWSET_SCHEMA("SAWRowsetSchema"),
    @XmlEnumValue("SAWRowsetSchemaAndData")
    SAW_ROWSET_SCHEMA_AND_DATA("SAWRowsetSchemaAndData");
    private final String value;

    XMLQueryOutputFormat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static XMLQueryOutputFormat fromValue(String v) {
        for (XMLQueryOutputFormat c: XMLQueryOutputFormat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
