package br.com.connecta.framework.amcharts;

import br.com.cds.connecta.framework.amcharts.AmBalloon;
import br.com.cds.connecta.framework.amcharts.AmLegend;
import br.com.cds.connecta.framework.amcharts.AmSerialChart;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
@JsonSubFolder("area")
public class AreaChartTemplateTest extends BaseChartTemplateTest {

    @Test
    public void area() throws IOException {
        AmSerialChart chart = mapper.readValue(json("area-area"), AmSerialChart.class);

        testBasicAreaFields(chart);
        testValueAxes(chart, null);
        testGraphList(chart);
    }

    @Test
    public void stackedArea() throws IOException {
        AmSerialChart chart = mapper.readValue(json("stacked-area"), AmSerialChart.class);

        testBasicAreaFields(chart);
        testGraphList(chart);
        testValueAxes(chart, "regular");
    }

    @Test
    public void percent100stackedArea() throws IOException {
        AmSerialChart chart = mapper.readValue(json("100-stacked-area"), AmSerialChart.class);

        testBasicAreaFields(chart);
        testGraphList(chart);
        testValueAxes(chart, "100%");
    }

    @Test
    public void clusteredStackedArea() throws IOException {
        AmSerialChart chart = mapper.readValue(json("clustered-stacked-area"), AmSerialChart.class);

        testBasicAreaFields(chart);
        assertThat(chart.getGraphs().size(), is(3));
        
        Boolean[] newStacks = {
            null,
            null,
            true
        };
        String[] balloonTexts = {
            "[[title]] of [[category]]:[[value]]",
            "[[title]] of [[category]]:[[value]]",
            null
        };

        for (int i=0; i<3; i++) {
            assertThat(chart.getGraphs().get(i).getFillAlphas(), is(1d));
            assertThat(chart.getGraphs().get(i).getId(), is("AmGraph-" + (i + 1)));
            assertThat(chart.getGraphs().get(i).getTitle(), is("graph " + (i + 1)));
            assertThat(chart.getGraphs().get(i).getType(), is("column"));
            assertThat(chart.getGraphs().get(i).getValueField(), is("column-" + (i + 1)));
            assertThat(chart.getGraphs().get(i).getNewStack(), is(newStacks[i]));
            assertThat(chart.getGraphs().get(i).getBalloonText(), is(balloonTexts[i]));
        }

        testValueAxes(chart, "regular");
    }

    private void testBasicAreaFields(AmSerialChart chart) {
        assertThat(chart.getType(), is("serial"));
        assertThat(chart.getPath(), is("http://www.amcharts.com/lib/3/"));
        assertThat(chart.getCategoryField(), is("category"));
        assertThat(chart.getStartDuration(), is(1d));
        assertThat(chart.getCategoryAxis().getGridPosition(), is("start"));
        assertThat(chart.getTrendLines().size(), is(0));

        assertThat(chart.getGuides().size(), is(0));

        assertThat(chart.getAllLabels().size(), is(0));
        assertThat(chart.getBalloon(), isA(AmBalloon.class));
        assertThat(chart.getLegend(), isA(AmLegend.class));

        assertThat(chart.getTitles().size(), is(1));
        assertThat(chart.getTitles().get(0).getId(), is("Title-1"));
        assertThat(chart.getTitles().get(0).getSize(), is(15d));
        assertThat(chart.getTitles().get(0).getText(), is("Chart Title"));

        testDataProviders(chart.getDataProvider(), new String[]{
            "category 1", "category 2", "category 3", "category 4", "category 5", "category 6", "category 7"
        }, new int[]{
            8, 6, 2, 1, 2, 3, 6
        }, new int[]{
            5, 7, 3, 3, 1, 2, 8
        });
    }

    private void testValueAxes(AmSerialChart chart, final String stackType) {
        assertThat(chart.getValueAxes().size(), is(1));
        assertThat(chart.getValueAxes().get(0).getId(), is("ValueAxis-1"));
        assertThat(chart.getValueAxes().get(0).getTitle(), is("Axis title"));
        assertThat(chart.getValueAxes().get(0).getStackType(), is(stackType));
    }

    private void testGraphList(AmSerialChart chart) {
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
    }

    private void testDataProviders(List<Object> dataProvider, String[] categories, int[] columns1, int[] columns2) {
        for (int i = 0; i < dataProvider.size(); i++) {
            Map provider = (Map<String, Object>) dataProvider.get(i);
            assertThat((String) provider.get("category"), equalTo(categories[i]));
            assertThat((Integer) provider.get("column-1"), equalTo(columns1[i]));
            assertThat((Integer) provider.get("column-2"), equalTo(columns2[i]));
        }
    }

}
