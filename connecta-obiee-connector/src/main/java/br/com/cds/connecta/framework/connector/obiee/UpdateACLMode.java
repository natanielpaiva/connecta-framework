
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de UpdateACLMode.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="UpdateACLMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ReplaceAcl"/>
 *     &lt;enumeration value="ReplaceForSpecifiedAccounts"/>
 *     &lt;enumeration value="DeleteAccountsFromAcl"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UpdateACLMode")
@XmlEnum
public enum UpdateACLMode {

    @XmlEnumValue("ReplaceAcl")
    REPLACE_ACL("ReplaceAcl"),
    @XmlEnumValue("ReplaceForSpecifiedAccounts")
    REPLACE_FOR_SPECIFIED_ACCOUNTS("ReplaceForSpecifiedAccounts"),
    @XmlEnumValue("DeleteAccountsFromAcl")
    DELETE_ACCOUNTS_FROM_ACL("DeleteAccountsFromAcl");
    private final String value;

    UpdateACLMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UpdateACLMode fromValue(String v) {
        for (UpdateACLMode c: UpdateACLMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
