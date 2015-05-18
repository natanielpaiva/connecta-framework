package br.com.connecta.framework.amcharts;

import br.com.cds.connecta.framework.amcharts.AmAngularGauge;
import br.com.cds.connecta.framework.amcharts.AmSerialChart;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
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
        
        String [] s = new String[]{"a","b"};
        System.out.println(s[0]);
        
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
    
}
