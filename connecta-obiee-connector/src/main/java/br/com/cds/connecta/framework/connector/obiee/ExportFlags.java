
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ExportFlags.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="ExportFlags">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="processAll_ForMerge"/>
 *     &lt;enumeration value="processAll_ForReplace"/>
 *     &lt;enumeration value="processAll_ForWriteIfNotExists"/>
 *     &lt;enumeration value="processLocalChanges"/>
 *     &lt;enumeration value="processRemoteChanges"/>
 *     &lt;enumeration value="processAllChanges"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExportFlags")
@XmlEnum
public enum ExportFlags {

    @XmlEnumValue("processAll_ForMerge")
    PROCESS_ALL_FOR_MERGE("processAll_ForMerge"),
    @XmlEnumValue("processAll_ForReplace")
    PROCESS_ALL_FOR_REPLACE("processAll_ForReplace"),
    @XmlEnumValue("processAll_ForWriteIfNotExists")
    PROCESS_ALL_FOR_WRITE_IF_NOT_EXISTS("processAll_ForWriteIfNotExists"),
    @XmlEnumValue("processLocalChanges")
    PROCESS_LOCAL_CHANGES("processLocalChanges"),
    @XmlEnumValue("processRemoteChanges")
    PROCESS_REMOTE_CHANGES("processRemoteChanges"),
    @XmlEnumValue("processAllChanges")
    PROCESS_ALL_CHANGES("processAllChanges");
    private final String value;

    ExportFlags(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExportFlags fromValue(String v) {
        for (ExportFlags c: ExportFlags.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
