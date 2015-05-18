package br.com.connecta.framework.amcharts;

import br.com.cds.connecta.framework.amcharts.AmSerialChart;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;

public class ChartTemplateTest {
    
    ObjectMapper mapper = new ObjectMapper();
    
    private static String json(String json) throws IOException {
        return IOUtils.toString(new FileInputStream("src/test/resources/chart-templates/"+json+".json"));
    }
    
    @Test
    @Ignore
    public void columnClustered() throws IOException {
        AmSerialChart chart = mapper.readValue(json("serialchart"), AmSerialChart.class);
        
        assertThat(chart.getType(), is("serial"));
        assertThat(chart.getCategoryField(), is("category"));
        assertThat(chart.getGraphs().get(0).getValueField(), is("value"));
        assertThat(chart.getDataProvider().size(), is(2));
    }
    
}
