package br.com.cds.connecta.framework.amcharts.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NONE,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    visible = true
)
@JsonSubTypes({
    @JsonSubTypes.Type(name="serial",   value=AmSerialChart.class),
    @JsonSubTypes.Type(name="pie",      value=AmPieChart.class),
    @JsonSubTypes.Type(name="xy",       value=AmXYChart.class),
    @JsonSubTypes.Type(name="radar",    value=AmRadarChart.class),
    @JsonSubTypes.Type(name="funnel",    value=AmFunnelChart.class),
    @JsonSubTypes.Type(name="gauge",    value=AmAngularGauge.class)
    // Custom
    //@JsonSubTypes.Type(name="gauge",    value=AmAngularGauge.class)
})
public abstract class ChartConfiguration implements Serializable {
    
    protected String type;

    /**
     * Type of a chart. Required when creating chart using JSON. Possible types are: serial,
     * pie, xy, radar, funnel, gauge, map, stock.
     * 
     * @return 
     **/
    public String getType() {
        return type;
    }

    public ChartConfiguration setType(String type) {
        this.type = type;
        return this;
    }

}
