package br.com.connecta.framework.amcharts;

import br.com.cds.connecta.framework.amcharts.AmSerialChart;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;

@JsonSubFolder("column")
public class ColumnChartTemplateTest extends BaseChartTemplateTest {

    @Test
    public void columnClustered() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-clustered"), AmSerialChart.class);
        testColumnGeneral(chart, null);
        assertThat(chart.getLegend().getUseGraphSettings(), is(true));

    }

    @Test
    public void columnStacked() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-stacked"), AmSerialChart.class);
        testColumnGeneral(chart, "regular");
        testAlphaAndColumn(chart);
        assertThat(chart.getLegend().getUseGraphSettings(), is(true));

    }

    @Test
    public void columnCemPorCentoStacked() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-cem-por-cento-stacked"), AmSerialChart.class);
        testColumnGeneral(chart, "100%");
        testAlphaAndColumn(chart);
        assertThat(chart.getLegend().getUseGraphSettings(), is(true));

    }

    @Test
    public void columnClusteredAndStacked() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-clustered-and-stacked"), AmSerialChart.class);
        testColumnGeneral(chart, "regular");
        testGraph(chart, 2);
        testAlphaAndColumn(chart);
        assertThat(chart.getLegend().getUseGraphSettings(), is(true));

    }

    @Test
    public void columnClustered3D() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-clustered-3d"), AmSerialChart.class);
        testAll3D(chart, null);
    }

    @Test
    public void columnStacked3D() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-stacked-3d"), AmSerialChart.class);
        testAll3D(chart, "regular");
    }

    @Test
    public void column3DCemPorCentoStacked() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-3d-cem-por-cento-stacked"), AmSerialChart.class);
        testAll3D(chart, "100%");
    }

    @Test
    public void column3DColumn() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-3d-column"), AmSerialChart.class);
        testAll3D(chart, "3d");

    }

    @Test
    public void columnAndLine() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-and-line"), AmSerialChart.class);
        baseAssertTest(chart);
        testGraph(chart, 1);
        testBalloon(chart);
        assertThat(chart.getLegend().getUseGraphSettings(), is(true));
    }

    @Test
    public void columnDateBasedData() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-date-based-data"), AmSerialChart.class);
        baseAssertTest(chart);
        assertThat(chart.getDataDateFormat(), is("YYYY-MM-DD"));
        assertThat(chart.getCategoryAxis().getParseDates(), is(true));
    }

    @Test
    public void columnWithScroll() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-width-scroll"), AmSerialChart.class);
        baseAssertTest(chart);
        assertThat(chart.getChartScrollbar().getGridCount(), is(1d));
    }

    @Test
    public void columnFloatingColumns() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-floating-columns"), AmSerialChart.class);
        baseAssertTest(chart);
        assertThat(chart.getGraphs().get(0).getCloseField(), is("close"));
        assertThat(chart.getGraphs().get(0).getOpenField(), is("open"));
        assertThat(chart.getGraphs().get(0).getFillAlphas(), is(1d));
        assertThat(chart.getGraphs().get(0).getType(), is("column"));
    }

    @Test
    public void columnTwoValueAxes() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-two-value-axes"), AmSerialChart.class);
        baseAssertTest(chart);
        assertThat(chart.getValueAxes().get(1).getId(), is("ValueAxis-2"));
        assertThat(chart.getValueAxes().get(1).getTitle(), is("Axis title"));
        assertThat(chart.getValueAxes().get(1).getPosition(), is("right"));
        assertThat(chart.getValueAxes().get(1).getGridAlpha(), is(0d));
        testGraph(chart, 0);
    }

    @Test
    public void columnUsingCustomColors() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-using-custom-colors"), AmSerialChart.class);
        baseAssertTest(chart);
        assertThat(chart.getGraphs().get(0).getLineColorField(), is("color"));
        testGraph(chart, 0);
    }

    @Test
    public void columnLogarithmicScale() throws IOException {
        AmSerialChart chart = mapper.readValue(json("column-logarithmic-scale"), AmSerialChart.class);
        baseAssertTest(chart);
        assertThat(chart.getValueAxes().get(0).getLogarithmic(), is(true));
        assertThat(chart.getGraphs().get(0).getId(), is("AmGraph-1"));
        assertThat(chart.getGraphs().get(0).getTitle(), is("graph 1"));
        assertThat(chart.getGraphs().get(0).getType(), is("column"));
        assertThat(chart.getGraphs().get(0).getValueField(), is("graph 1"));
    }

    private void baseAssertTest(AmSerialChart chart) {
        assertThat(chart.getType(), is("serial"));
        assertThat(chart.getPath(), is("https://www.amcharts.com/lib/3/"));
        assertThat(chart.getCategoryField(), is("category"));
        assertThat(chart.getStartDuration(), is(1d));
        assertThat(chart.getCategoryAxis().getGridPosition(), is("start"));
        assertThat(chart.getValueAxes().get(0).getId(), is("ValueAxis-1"));
        assertThat(chart.getValueAxes().get(0).getTitle(), is("Axis title"));
        assertThat(chart.getTitles().get(0).getId(), is("Title-1"));
        assertThat(chart.getTitles().get(0).getSize(), is(15d));
        assertThat(chart.getTitles().get(0).getText(), is("Chart Title"));

    }

    private void testGraph(AmSerialChart chart, int countList) {

        int column = countList + 1;

        assertThat(chart.getGraphs().get(countList).getId(), is("AmGraph-" + column));
        assertThat(chart.getGraphs().get(countList).getTitle(), is("graph " + column));
        assertThat(chart.getGraphs().get(countList).getValueField(), is("column-" + column));
    }

    private void testAlphaAndColumn(AmSerialChart chart) {
        assertThat(chart.getGraphs().get(0).getFillAlphas(), is(1d));
        assertThat(chart.getGraphs().get(1).getFillAlphas(), is(1d));
        assertThat(chart.getGraphs().get(0).getType(), is("column"));
        assertThat(chart.getGraphs().get(1).getType(), is("column"));
    }

    private void testAll3D(AmSerialChart chart, String stakeType) {

        baseAssertTest(chart);
        testGraph(chart, 1);
        testBalloon(chart);
        test3D(chart);
        assertThat(chart.getValueAxes().get(0).getStackType(), is(stakeType));
        testAlphaAndColumn(chart);
        assertThat(chart.getLegend().getUseGraphSettings(), is(true));
        testDataProviders(chart.getDataProvider(), new String[]{
            "category 1", "category 2", "category 3", "category 4", "category 5", "category 6", "category 7"
        }, new int[]{
            8, 6, 2, 1, 2, 3, 6
        }, new int[]{
            5, 7, 3, 3, 1, 2, 8
        });

    }

    private void testColumnGeneral(AmSerialChart chart, String stakeType) {
        baseAssertTest(chart);
        testGraph(chart, 1);
        testBalloon(chart);
        assertThat(chart.getValueAxes().get(0).getStackType(), is(stakeType));
        testGraph(chart, 0);
        testDataProviders(chart.getDataProvider(), new String[]{
            "category 1", "category 2", "category 3", "category 4", "category 5", "category 6", "category 7"
        }, new int[]{
            8, 6, 2, 1, 2, 3, 6
        }, new int[]{
            5, 7, 3, 3, 1, 2, 8
        });
    }

    private void test3D(AmSerialChart chart) {
        assertThat(chart.getAngle(), is(30d));
        assertThat(chart.getDepth3D(), is(30d));
        assertThat(chart.getStartDuration(), is(1d));
    }

    private void testBalloon(AmSerialChart chart) {
        assertThat(chart.getGraphs().get(0).getBalloonText(), is("[[title]] of [[category]]:[[value]]"));
        assertThat(chart.getGraphs().get(1).getBalloonText(), is("[[title]] of [[category]]:[[value]]"));
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
