package br.com.connecta.framework.amcharts;

import br.com.cds.connecta.framework.amcharts.model.AmPieChart;
import java.io.IOException;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
@JsonSubFolder("pie-donut")
public class PieDonutChartTemplateTest extends BaseChartTemplateTest {

    @Test
    public void pie() throws IOException {
        AmPieChart chart = mapper.readValue(json("pie"), AmPieChart.class);

        testBasicFields(chart, null, null, null);
        testLegend(chart);
        testDataProvider(chart, new Number[]{
            8, 6, 2
        });
    }

    @Test
    public void pie3d() throws IOException {
        AmPieChart chart = mapper.readValue(json("pie-3d"), AmPieChart.class);
        
        testBasicFields(chart, 12d, 15d, null);
        testLegend(chart);
        testDataProvider(chart, new Number[]{
            8, 6, 2
        });
    }

    @Test
    public void donut() throws IOException {
        AmPieChart chart = mapper.readValue(json("donut"), AmPieChart.class);
        
        testBasicFields(chart, null, null, "40%");
        testLegend(chart);
        testDataProvider(chart, new Number[]{
            8, 6, 2
        });
    }

    @Test
    public void donut3d() throws IOException {
        AmPieChart chart = mapper.readValue(json("donut-3d"), AmPieChart.class);
        
        testBasicFields(chart, 12d, 15d, "40%");
        testLegend(chart);
        testDataProvider(chart, new Number[]{
            8, 6, 2
        });
    }

    // HELPERS
    private void testBasicFields(AmPieChart chart, Double angle, Double depth, String innerRadius) {
        assertThat(chart.getType(), is("pie"));
        assertThat(chart.getPath(), is("http://www.amcharts.com/lib/3/"));
        assertThat(chart.getBalloonText(), is("[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>"));
        assertThat(chart.getTitleField(), is("category"));
        assertThat(chart.getValueField(), is("column-1"));
        
        // 3D stuff
        assertThat(chart.getAngle(), is(angle));
        assertThat(chart.getDepth3D(), is(depth));
        
        // Donut stuff
        assertThat(chart.getInnerRadius(), is(innerRadius));

        assertThat(chart.getAllLabels().size(), is(0));
        assertThat(chart.getBalloon(), notNullValue());
        assertThat(chart.getTitles().size(), is(0));
    }

    private void testLegend(AmPieChart chart) {
        assertThat(chart.getLegend().getAlign(), is("center"));
        assertThat(chart.getLegend().getMarkerType(), is("circle"));
    }

    private void testDataProvider(AmPieChart chart, Number[] values) {
        for (int i = 0; i < chart.getDataProvider().size(); i++) {
            Map<String, Object> current = (Map<String, Object>) chart.getDataProvider().get(i);
            assertThat((String)current.get(chart.getTitleField()), is("category "+(i+1)));
            assertThat((Number)current.get(chart.getValueField()), is(values[i]));
        }
    }
}
