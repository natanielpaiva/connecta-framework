
package br.com.cds.connecta.framework.connector.obiee;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de AggregationRule.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="AggregationRule">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Sum"/>
 *     &lt;enumeration value="Count"/>
 *     &lt;enumeration value="Rank"/>
 *     &lt;enumeration value="Avg"/>
 *     &lt;enumeration value="Min"/>
 *     &lt;enumeration value="Max"/>
 *     &lt;enumeration value="Last"/>
 *     &lt;enumeration value="Percentile"/>
 *     &lt;enumeration value="First"/>
 *     &lt;enumeration value="ServerDefault"/>
 *     &lt;enumeration value="CountStar"/>
 *     &lt;enumeration value="Complex"/>
 *     &lt;enumeration value="TopN"/>
 *     &lt;enumeration value="BottomN"/>
 *     &lt;enumeration value="SubTotal"/>
 *     &lt;enumeration value="DimensionAggr"/>
 *     &lt;enumeration value="CountDistinct"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AggregationRule")
@XmlEnum
public enum AggregationRule {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Sum")
    SUM("Sum"),
    @XmlEnumValue("Count")
    COUNT("Count"),
    @XmlEnumValue("Rank")
    RANK("Rank"),
    @XmlEnumValue("Avg")
    AVG("Avg"),
    @XmlEnumValue("Min")
    MIN("Min"),
    @XmlEnumValue("Max")
    MAX("Max"),
    @XmlEnumValue("Last")
    LAST("Last"),
    @XmlEnumValue("Percentile")
    PERCENTILE("Percentile"),
    @XmlEnumValue("First")
    FIRST("First"),
    @XmlEnumValue("ServerDefault")
    SERVER_DEFAULT("ServerDefault"),
    @XmlEnumValue("CountStar")
    COUNT_STAR("CountStar"),
    @XmlEnumValue("Complex")
    COMPLEX("Complex"),
    @XmlEnumValue("TopN")
    TOP_N("TopN"),
    @XmlEnumValue("BottomN")
    BOTTOM_N("BottomN"),
    @XmlEnumValue("SubTotal")
    SUB_TOTAL("SubTotal"),
    @XmlEnumValue("DimensionAggr")
    DIMENSION_AGGR("DimensionAggr"),
    @XmlEnumValue("CountDistinct")
    COUNT_DISTINCT("CountDistinct");
    private final String value;

    AggregationRule(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AggregationRule fromValue(String v) {
        for (AggregationRule c: AggregationRule.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
