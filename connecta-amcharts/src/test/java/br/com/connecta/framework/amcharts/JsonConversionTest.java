package br.com.connecta.framework.amcharts;

import br.com.cds.connecta.framework.amcharts.AmAngularGauge;
import br.com.cds.connecta.framework.amcharts.AmBalloon;
import br.com.cds.connecta.framework.amcharts.AmFunnelChart;
import br.com.cds.connecta.framework.amcharts.AmGraph;
import br.com.cds.connecta.framework.amcharts.AmLegend;
import br.com.cds.connecta.framework.amcharts.AmPieChart;
import br.com.cds.connecta.framework.amcharts.AmRadarChart;
import br.com.cds.connecta.framework.amcharts.AmSerialChart;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;

public class JsonConversionTest {
    
    ObjectMapper mapper = new ObjectMapper();
    
    private static String json(String json) throws IOException {
        return IOUtils.toString(new FileInputStream("src/test/resources/"+json+".json"));
    }
    
    @Test
    public void serialchart() throws IOException {
        AmSerialChart chart = mapper.readValue(json("serialchart"), AmSerialChart.class);
        
        assertThat(chart.getType(), is("serial"));
        assertThat(chart.getCategoryField(), is("category"));
        assertThat(chart.getGraphs().get(0).getValueField(), is("value"));
        assertThat(chart.getDataProvider().size(), is(2));
    }
    
    @Test
    public void angularChart() throws IOException {
        AmAngularGauge chart = mapper.readValue(json("angularchart"), AmAngularGauge.class);
        
        assertThat(chart.getType(), is("gauge"));
        assertThat(chart.getArrows().size(), is(1));
        assertThat(chart.getArrows().get(0).getValue(), is(130d));
        assertThat(chart.getTitles().size(), is(1));
        assertThat(chart.getTitles().get(0).getText(), is("Speedometer"));
        assertThat(chart.getTitles().get(0).getSize(), is(15d));
        assertThat(chart.getAxes().get(0).getBottomText(), is("0 km/h"));
        assertThat(chart.getAxes().get(0).getEndValue(), is(220d));
        assertThat(chart.getAxes().get(0).getValueInterval(), is(10d));
        assertThat(chart.getAxes().get(0).getBands().get(0).getColor().toString(), is("#00CC00"));
        assertThat(chart.getAxes().get(0).getBands().get(0).getEndValue(), is(90d));
        assertThat(chart.getAxes().get(0).getBands().get(0).getStartValue(), is(0d));
        assertThat(chart.getAxes().get(0).getBands().get(1).getColor().toString(), is("#ffac29"));
        assertThat(chart.getAxes().get(0).getBands().get(1).getEndValue(), is(130d));
        assertThat(chart.getAxes().get(0).getBands().get(1).getStartValue(), is(90d));
        assertThat(chart.getAxes().get(0).getBands().get(2).getColor().toString(), is("#ea3838"));
        assertThat(chart.getAxes().get(0).getBands().get(2).getEndValue(), is(220d));
        assertThat(chart.getAxes().get(0).getBands().get(2).getStartValue(), is(130d));
        assertThat(chart.getAxes().get(0).getBands().get(2).getInnerRadius(), is("95%"));
    }
    
    @Test
    public void balloonChart() throws IOException {
        AmBalloon chart = mapper.readValue(json("balloonchart"), AmBalloon.class);
        
        assertThat(chart.getAdjustBorderColor(), is(true));
        assertThat(chart.getColor().toString(), is("#000000"));
        assertThat(chart.getCornerRadius(), is(5d));
        assertThat(chart.getFillColor().toString(), is("#FFFFFF"));
    }
    
    @Test
    public void funnelChart() throws IOException {
        AmFunnelChart chart = mapper.readValue(json("funnelchart"), AmFunnelChart.class);
        
        assertThat(chart.getType(), is("funnel"));
        assertThat(chart.getNeckHeight(), is("30%"));
        assertThat(chart.getNeckWidth(), is("40%"));
        assertThat(chart.getTitleField(), is("title"));
        assertThat(chart.getValueField(), is("value"));

    }
    
    @Test
    public void graphsChart() throws IOException {
        AmGraph chart = mapper.readValue(json("graphschart"), AmGraph.class);
        
        assertThat(chart.getId(), is("AmGraph-1"));
        assertThat(chart.getTitle(), is("Column graph"));
        assertThat(chart.getType(), is("column"));
        assertThat(chart.getValueField(), is("column-1"));
        assertThat(chart.getFillAlphas(), is(1d));

    }
    
    @Test
    public void legendChart() throws IOException {
        AmLegend chart = mapper.readValue(json("legendchart"), AmLegend.class);
        
        assertThat(chart.getUseGraphSettings(), is(true));

    }
    
    @Test
    public void pieChart() throws IOException {
        AmPieChart chart = mapper.readValue(json("piechart"), AmPieChart.class);
        
        assertThat(chart.getType(), is("pie"));
        assertThat(chart.getTitleField(), is("category"));
        assertThat(chart.getValueField(), is("column-1"));

    }
    
    @Test
    public void radarChart() throws IOException {
        AmRadarChart chart = mapper.readValue(json("radarchart"), AmRadarChart.class);
        
        assertThat(chart.getType(), is("radar"));
        assertThat(chart.getCategoryField(), is("category"));
        assertThat(chart.getGraphs().get(0).getValueField(), is("value"));
        assertThat(chart.getValueAxes().get(0).getAxisTitleOffset(), is(20d));
        assertThat(chart.getValueAxes().get(0).getMinimum(), is(0d));
        assertThat(chart.getValueAxes().get(0).getAxisAlpha(), is(0.15));
        assertThat(chart.getValueAxes().get(0).getDashLength(), is(3d));

    }
    
}
