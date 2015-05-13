
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ItemInfoType.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="ItemInfoType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Folder"/>
 *     &lt;enumeration value="Link"/>
 *     &lt;enumeration value="Object"/>
 *     &lt;enumeration value="Missing"/>
 *     &lt;enumeration value="NoAccess"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ItemInfoType")
@XmlEnum
public enum ItemInfoType {

    @XmlEnumValue("Folder")
    FOLDER("Folder"),
    @XmlEnumValue("Link")
    LINK("Link"),
    @XmlEnumValue("Object")
    OBJECT("Object"),
    @XmlEnumValue("Missing")
    MISSING("Missing"),
    @XmlEnumValue("NoAccess")
    NO_ACCESS("NoAccess");
    private final String value;

    ItemInfoType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ItemInfoType fromValue(String v) {
        for (ItemInfoType c: ItemInfoType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
