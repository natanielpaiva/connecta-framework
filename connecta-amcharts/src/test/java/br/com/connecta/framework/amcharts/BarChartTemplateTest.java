package br.com.connecta.framework.amcharts;

import br.com.cds.connecta.framework.amcharts.AmSerialChart;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;

@JsonSubFolder("bar")
public class BarChartTemplateTest extends BaseChartTemplateTest {

    @Test
    public void barClustered() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-clustered"), AmSerialChart.class);
        testBarGeneral(chart, null);
        assertThat(chart.getLegend().getUseGraphSettings(), is(true));

    }

    @Test
    public void barStacked() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-stacked"), AmSerialChart.class);
        testBarGeneral(chart, "regular");
        testAlphaAndBar(chart);
        assertThat(chart.getLegend().getUseGraphSettings(), is(true));

    }

    @Test
    public void barCemPorCentoStacked() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-cem-por-cento-stacked"), AmSerialChart.class);
        testBarGeneral(chart, "100%");
        testAlphaAndBar(chart);
        assertThat(chart.getLegend().getUseGraphSettings(), is(true));

    }

    @Test
    public void barClusteredAndStacked() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-clustered-and-stacked"), AmSerialChart.class);
        testBarGeneral(chart, "regular");
        testGraph(chart, 2);
        testAlphaAndBar(chart);
        assertThat(chart.getLegend().getUseGraphSettings(), is(true));

    }

    @Test
    public void barClustered3D() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-clustered-3d"), AmSerialChart.class);
        testAll3D(chart, null);
    }

    @Test
    public void barStacked3D() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-stacked-3d"), AmSerialChart.class);
        testAll3D(chart, "regular");
    }

    @Test
    public void bar3DCemPorCentoStacked() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-3d-cem-por-cento-stacked"), AmSerialChart.class);
        testAll3D(chart, "100%");
    }

    @Test
    public void bar3Dbar() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-3d-bar"), AmSerialChart.class);
        testAll3D(chart, "3d");

    }

    @Test
    public void barAndLine() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-and-line"), AmSerialChart.class);
        baseAssertTest(chart);
        testGraph(chart, 1);
        testBalloon(chart);
        assertThat(chart.getLegend().getUseGraphSettings(), is(true));
    }

    @Test
    @Ignore
    public void barDateBasedData() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-date-based-data"), AmSerialChart.class);
        baseAssertTest(chart);
        assertThat(chart.getDataDateFormat(), is("YYYY-MM-DD"));
        assertThat(chart.getCategoryAxis().getParseDates(), is(true));
    }

    @Test
    public void barWithScroll() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-width-scroll"), AmSerialChart.class);
        baseAssertTest(chart);
        assertThat(chart.getChartScrollbar().getGridCount(), is(1d));
    }

    @Test
    public void barFloatingBars() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-floating-bars"), AmSerialChart.class);
        baseAssertTest(chart);
        assertThat(chart.getGraphs().get(0).getCloseField(), is("close"));
        assertThat(chart.getGraphs().get(0).getOpenField(), is("open"));
        assertThat(chart.getGraphs().get(0).getFillAlphas(), is(1d));
        assertThat(chart.getGraphs().get(0).getType(), is("column"));
    }

    @Test
    public void barTwoValueAxes() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-two-value-axes"), AmSerialChart.class);
        baseAssertTest(chart);
        assertThat(chart.getValueAxes().get(1).getId(), is("ValueAxis-2"));
        assertThat(chart.getValueAxes().get(1).getTitle(), is("Axis title"));
        assertThat(chart.getValueAxes().get(1).getPosition(), is("right"));
        assertThat(chart.getValueAxes().get(1).getGridAlpha(), is(0d));
        testGraph(chart, 0);

    }

    @Test
    public void barDashedStroke() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-dashed-stroke"), AmSerialChart.class);
        baseAssertTest(chart);
        testGraph(chart, 0);
        assertThat(chart.getGraphs().get(0).getDashLengthField(), is("dash length"));
        assertThat(chart.getGraphs().get(0).getAlphaField(), is("fill alpha"));

        Map provider = (Map<String, Object>) chart.getDataProvider().get(7);
        assertThat((String) provider.get("category"), equalTo("category 8"));
        assertThat((Integer) provider.get("column-1"), equalTo(15));
        assertThat((Integer) provider.get("dash length"), equalTo(5));
        assertThat((Double) provider.get("fill alpha"), equalTo(0.2));
    }

    @Test
    public void barLogarithmicScale() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-logarithmic-scale"), AmSerialChart.class);
        baseAssertTest(chart);
        assertThat(chart.getValueAxes().get(0).getLogarithmic(), is(true));
        assertThat(chart.getGraphs().get(0).getId(), is("AmGraph-1"));
        assertThat(chart.getGraphs().get(0).getTitle(), is("graph 1"));
        assertThat(chart.getGraphs().get(0).getType(), is("column"));
        assertThat(chart.getGraphs().get(0).getValueField(), is("graph 1"));
    }
    
    @Test
    public void barWithGuide() throws IOException {
        AmSerialChart chart = mapper.readValue(json("bar-width-guide"), AmSerialChart.class);
        baseAssertTest(chart);
        assertThat(chart.getGuides().get(0).getAbove(), is(true));
        assertThat(chart.getGuides().get(0).getDashLength(), is(5d));
        assertThat(chart.getGuides().get(0).getId(), is("Guide-1"));
        assertThat(chart.getGuides().get(0).getInside(), is(true));
        assertThat(chart.getGuides().get(0).getLabel(), is("max allowed value"));
        assertThat(chart.getGuides().get(0).getLabelRotation(), is(90d));
        assertThat(chart.getGuides().get(0).getLineAlpha(), is(1d));
        assertThat(chart.getGuides().get(0).getLineColor().toString(), is("#ff0000"));
        assertThat(chart.getGuides().get(0).getValue(), is(10d));
        
    }

    private void baseAssertTest(AmSerialChart chart) {
        assertThat(chart.getType(), is("serial"));
        assertThat(chart.getPath(), is("https://www.amcharts.com/lib/3/"));
        assertThat(chart.getCategoryField(), is("category"));
        assertThat(chart.getStartDuration(), is(1d));
        assertThat(chart.getCategoryAxis().getGridPosition(), is("start"));
        assertThat(chart.getValueAxes().get(0).getId(), is("ValueAxis-1"));
        assertThat(chart.getValueAxes().get(0).getTitle(), is("Axis title"));
        assertThat(chart.getRotate(), is(true));

    }

    private void testGraph(AmSerialChart chart, int countList) {

        int column = countList + 1;

        assertThat(chart.getGraphs().get(countList).getId(), is("AmGraph-" + column));
        assertThat(chart.getGraphs().get(countList).getTitle(), is("graph " + column));
        assertThat(chart.getGraphs().get(countList).getValueField(), is("column-" + column));
    }

    private void testAlphaAndBar(AmSerialChart chart) {
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
        testAlphaAndBar(chart);
        assertThat(chart.getLegend().getUseGraphSettings(), is(true));
        testDataProviders(chart.getDataProvider(), new String[]{
            "category 1", "category 2", "category 3", "category 4", "category 5", "category 6", "category 7"
        }, new int[]{
            8, 6, 2, 1, 2, 3, 6
        }, new int[]{
            5, 7, 3, 3, 1, 2, 8
        });
        testTitles(chart);
    }

    private void testBarGeneral(AmSerialChart chart, String stakeType) {
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
        testTitles(chart);
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

    private void testTitles(AmSerialChart chart) {
        assertThat(chart.getTitles().get(0).getId(), is("Title-1"));
        assertThat(chart.getTitles().get(0).getSize(), is(15d));
        assertThat(chart.getTitles().get(0).getText(), is("Chart Title"));
    }

}
