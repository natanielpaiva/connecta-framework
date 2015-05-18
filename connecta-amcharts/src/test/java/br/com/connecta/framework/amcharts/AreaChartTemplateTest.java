package br.com.connecta.framework.amcharts;

import br.com.cds.connecta.framework.amcharts.AmSerialChart;
import java.io.IOException;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;

@JsonSubFolder("area")
public class AreaChartTemplateTest extends BaseChartTemplateTest {
    
    @Test
    public void area() throws IOException {
        AmSerialChart chart = mapper.readValue(json("area-area"), AmSerialChart.class);
        
        assertThat(chart.getType(), is("serial"));
        assertThat(chart.getPath(), is("http://www.amcharts.com/lib/3/"));
        assertThat(chart.getCategoryField(), is("category"));
        assertThat(chart.getStartDuration(), is(1d));
        assertThat(chart.getCategoryAxis().getGridPosition(), is("start"));
        assertThat(chart.getTrendLines().size(), is(0));
        assertThat(chart.getGraphs().size(), is(2));
        
        assertThat(chart.getGraphs().get(0).getBalloonText(), is("[[title]] of [[category]]:[[value]]"));
        assertThat(chart.getGraphs().get(0).getFillAlphas(), is(0.7));
        assertThat(chart.getGraphs().get(0).getId(), is("AmGraph-1"));
        assertThat(chart.getGraphs().get(0).getLineAlpha(), is(0d));
        assertThat(chart.getGraphs().get(0).getTitle(), is("graph 1"));
        assertThat(chart.getGraphs().get(0).getValueField(), is("column-1"));
        
        assertThat(chart.getGraphs().get(1).getBalloonText(), is("[[title]] of [[category]]:[[value]]"));
        assertThat(chart.getGraphs().get(1).getFillAlphas(), is(0.7));
        assertThat(chart.getGraphs().get(1).getId(), is("AmGraph-2"));
        assertThat(chart.getGraphs().get(1).getLineAlpha(), is(0d));
        assertThat(chart.getGraphs().get(1).getTitle(), is("graph 2"));
        assertThat(chart.getGraphs().get(1).getValueField(), is("column-2"));
        
        assertThat(chart.getGuides().size(), is(0));
        assertThat(chart.getGuides().size(), is(0));
    }
    
}
