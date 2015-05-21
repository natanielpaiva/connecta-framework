package br.com.connecta.framework.amcharts;

import br.com.cds.connecta.framework.amcharts.model.AmAngularGauge;
import br.com.cds.connecta.framework.amcharts.model.AmFunnelChart;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

@JsonSubFolder("other")
public class OtherChartTemplateTest extends BaseChartTemplateTest {

    @Test
    public void otherAngularGauge() throws IOException {
        AmAngularGauge chart = mapper.readValue(json("other-angular-gauge"), AmAngularGauge.class);
        
        assertThat(chart.getType(), is("gauge"));
        assertThat(chart.getPath(), is("https://www.amcharts.com/lib/3/"));
        assertThat(chart.getArrows().get(0).getId(), is("GaugeArrow-1"));
        assertThat(chart.getAxes().get(0).getBottomText(), is("0 km/h"));
        assertThat(chart.getAxes().get(0).getBottomTextYOffset(), is(-20d));
        assertThat(chart.getAxes().get(0).getEndValue(), is(220d));
        assertThat(chart.getAxes().get(0).getId(), is("GaugeAxis-1"));
        assertThat(chart.getAxes().get(0).getValueInterval(), is(10d));
        
        testBands(chart, 0, "#00CC00", 90d, "GaugeBand-1", 0d);
        testBands(chart, 1, "#ffac29", 130d, "GaugeBand-2", 90d);
        testBands(chart, 2, "#ea3838", 220d, "GaugeBand-3", 130d);
        assertThat(chart.getAxes().get(0).getBands().get(2).getInnerRadius(), is("95%"));
        
        assertThat(chart.getTitles().get(0).getId(), is("Title-1"));
        assertThat(chart.getTitles().get(0).getSize(), is(15d));
        assertThat(chart.getTitles().get(0).getText(), is("Speedometer"));

    }
    
    @Test
    public void otherFunnel() throws IOException {
        AmFunnelChart chart = mapper.readValue(json("other-funnel"), AmFunnelChart.class);
        
        assertThat(chart.getType(), is("funnel"));
        assertThat(chart.getPath(), is("https://www.amcharts.com/lib/3/"));
        assertThat(chart.getBalloonText(), is("[[title]]:<b>[[value]]</b>"));
        assertThat(chart.getLabelPosition(), is("right"));
        assertThat(chart.getNeckHeight(), is("30%"));
        assertThat(chart.getNeckWidth(), is("40%"));
        assertThat(chart.getMarginLeft(), is(15d));
        assertThat(chart.getMarginRight(), is(160d));
        assertThat(chart.getTitleField(), is("title"));
        assertThat(chart.getValueField(), is("value"));
        
        String[] categories;
        categories = new String[]{
            "Website visits",
            "Downloads",
            "Requested prices",
            "Contaced",
            "Purchased",
            "Asked for support",
            "Purchased more"
        };
        int[] columns;
        columns = new int[]{
            300,
            123,
            98,
            72,
            35,
            25,
            18
        };
        
        testDataProviders(chart.getDataProvider(), categories, columns);

    }

    private void testBands(AmAngularGauge chart, int i, String color, Double endValue,
                            String id, Double startValue) {
        assertThat(chart.getAxes().get(0).getBands().get(i).getColor().toString(), is(color));
        assertThat(chart.getAxes().get(0).getBands().get(i).getEndValue(), is(endValue));
        assertThat(chart.getAxes().get(0).getBands().get(i).getId(), is(id));
        assertThat(chart.getAxes().get(0).getBands().get(i).getStartValue(), is(startValue));
    }
    
     private void testDataProviders(List<Object> dataProvider, String[] categories, int[] columns) {
        for (int i = 0; i < dataProvider.size(); i++) {
            Map provider = (Map<String, Object>) dataProvider.get(i);
            assertThat((String) provider.get("title"), equalTo(categories[i]));
            assertThat((Integer) provider.get("value"), equalTo(columns[i]));
        }
    }

}
