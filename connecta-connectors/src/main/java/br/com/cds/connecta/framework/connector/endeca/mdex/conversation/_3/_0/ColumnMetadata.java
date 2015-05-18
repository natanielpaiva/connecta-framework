
package br.com.cds.connecta.framework.connector.endeca.mdex.conversation._3._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * This type contains column data that includes the display name and column key.
 * 
 * <p>Classe Java de ColumnMetadata complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte\u00fado esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ColumnMetadata">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="ColumnKey" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="DisplayName" use="required" type="{http://www.endeca.com/MDEX/conversation/3/0}NonEmptyString" />
 *       &lt;attribute name="SpecColumn" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColumnMetadata")
public class ColumnMetadata {

    @XmlAttribute(name = "ColumnKey", required = true)
    protected String columnKey;
    @XmlAttribute(name = "DisplayName", required = true)
    protected String displayName;
    @XmlAttribute(name = "SpecColumn", required = true)
    protected boolean specColumn;

    /**
     * Obt\u00e9m o valor da propriedade columnKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnKey() {
        return columnKey;
    }

    /**
     * Define o valor da propriedade columnKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnKey(String value) {
        this.columnKey = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade displayName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Define o valor da propriedade displayName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * Obt\u00e9m o valor da propriedade specColumn.
     * 
     */
    public boolean isSpecColumn() {
        return specColumn;
    }

    /**
     * Define o valor da propriedade specColumn.
     * 
     */
    public void setSpecColumn(boolean value) {
        this.specColumn = value;
    }

}
