package br.com.connecta.framework.amcharts;

import br.com.cds.connecta.framework.amcharts.AmSerialChart;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class ColumnChartTemplateTest {
    
    ObjectMapper mapper = new ObjectMapper();
    
    private static String json(String json) throws IOException {
        return IOUtils.toString(new FileInputStream("src/test/resources/chart-templates/column/"+json+".json"));
    }
    
    @Test
    public void columnClustered() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-clustered"), AmSerialChart.class);
        
        assertThat(chart.getType(), is("serial"));
        assertThat(chart.getPath(), is("https://www.amcharts.com/lib/3/"));
    }
    
    
}
