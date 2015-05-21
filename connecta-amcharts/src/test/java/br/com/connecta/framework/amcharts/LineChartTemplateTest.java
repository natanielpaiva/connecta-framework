package br.com.connecta.framework.amcharts;

import br.com.cds.connecta.framework.amcharts.model.AmSerialChart;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;

@JsonSubFolder("line")
public class LineChartTemplateTest extends BaseChartTemplateTest {

    @Test
    public void line() throws IOException {
        AmSerialChart chart = mapper.readValue(json("line"), AmSerialChart.class);
        testLineGeneral(chart, null, true);
        testBalloon(chart);
    }

    @Test
    public void lineStacked() throws IOException {
        AmSerialChart chart = mapper.readValue(json("line-stacked"), AmSerialChart.class);
        testLineGeneral(chart, "regular", true);
        testBalloon(chart);
    }

    @Test
    public void lineOneHundredPercentStacked() throws IOException {
        AmSerialChart chart = mapper.readValue(json("line-one-hundred-percent-stacked"), AmSerialChart.class);
        testLineGeneral(chart, "100%", true);
        testBalloon(chart);
    }

    @Test
    public void lineRotate() throws IOException {
        AmSerialChart chart = mapper.readValue(json("line-rotate"), AmSerialChart.class);
        testLineGeneral(chart, null, true);
        assertThat(chart.getRotate(), is(true));
    }

    @Test
    public void lineDateSeriesDaily() throws IOException {
        AmSerialChart chart = mapper.readValue(json("line-date-series-daily"), AmSerialChart.class);
        testLineDateGeneral(chart, null);
        assertThat(chart.getDataDateFormat(), is("YYYY-MM-DD"));

        testProvidersData(chart,  "2014-03-01", "2014-03-02", "2014-03-03", 
                "2014-03-04", "2014-03-05", "2014-03-06", "2014-03-07");

    }

    @Test
    public void lineDateSeriesMonthly() throws IOException {
        AmSerialChart chart = mapper.readValue(json("line-date-series-monthly"), AmSerialChart.class);
        testLineDateGeneral(chart, null);
        testPeriod(chart, "YYYY-MM", "MM", "MMM YYYY");
        assertThat(chart.getTheme(), is("default"));
        
        testProvidersData(chart,  "2014-01", "2014-02", "2014-03", 
                "2014-04", "2014-05", "2014-06", "2014-07");

    }

    @Test
    public void lineDateSeriesYearly() throws IOException {
        AmSerialChart chart = mapper.readValue(json("line-date-series-yearly"), AmSerialChart.class);
        testLineDateGeneral(chart, null);
        testPeriod(chart, "YYYY", "YYYY", "YYYY");
        assertThat(chart.getChartCursor().getAnimationDuration(), is(0d));
        
        testProvidersData(chart,  "2001", "2002", "2003", 
                "2004", "2005", "2006", "2007");
    }

    @Test
    public void lineTimeSeriesHourly() throws IOException {
        AmSerialChart chart = mapper.readValue(json("line-time-series-hourly"), AmSerialChart.class);
        testLineDateGeneral(chart, null);
        testPeriod(chart, "YYYY-MM-DD HH", "hh", "JJ:NN");
        
        testProvidersData(chart,  "2014-03-01 08", "2014-03-01 09", "2014-03-01 10", 
                "2014-03-01 11", "2014-03-01 12", "2014-03-01 13", "2014-03-01 14");
    }

    @Test
    public void lineTimeSeriesMinutes() throws IOException {
        AmSerialChart chart = mapper.readValue(json("line-time-series-minutes"), AmSerialChart.class);
        testLineDateGeneral(chart, null);
        testPeriod(chart, "YYYY-MM-DD HH:NN", "mm", "JJ:NN");
        
        testProvidersData(chart,  "2014-03-01 07:57", "2014-03-01 07:58", "2014-03-01 07:59", 
                "2014-03-01 08:00", "2014-03-01 08:01", "2014-03-01 08:02", "2014-03-01 08:03");
    }

    @Test
    public void lineTimeSeriesSeconds() throws IOException {
        AmSerialChart chart = mapper.readValue(json("line-time-series-seconds"), AmSerialChart.class);
        testLineDateGeneral(chart, null);
        testPeriod(chart, "YYYY-MM-DD HH:NN:SS", "ss", "JJ:NN:SS");
        
        testProvidersData(chart,  "2014-03-01 07:57:57", "2014-03-01 07:57:58", "2014-03-01 07:57:59", 
                "2014-03-01 07:58:00", "2014-03-01 07:58:01", "2014-03-01 07:58:02", "2014-03-01 07:58:03");
    }

    @Test
    public void lineSmoothed() throws IOException {
        AmSerialChart chart = mapper.readValue(json("line-smoothed"), AmSerialChart.class);
        testLineGeneral(chart, null, true);
        assertThat(chart.getGraphs().get(0).getType(), is("smoothedLine"));
        assertThat(chart.getGraphs().get(1).getType(), is("smoothedLine"));
    }

    @Test
    public void lineStep() throws IOException {
        AmSerialChart chart = mapper.readValue(json("line-step"), AmSerialChart.class);
        testLineGeneral(chart, null, false);
        testLineStep(chart);
        assertThat(chart.getGraphs().get(0).getType(), is("step"));
        assertThat(chart.getGraphs().get(1).getType(), is("step"));
        assertThat(chart.getGraphs().get(0).getLineThickness(), is(2d));
        assertThat(chart.getGraphs().get(1).getLineThickness(), is(2d));
    }

    @Test
    public void lineStepNoRisers() throws IOException {
        AmSerialChart chart = mapper.readValue(json("line-step-no-risers"), AmSerialChart.class);
        testLineGeneral(chart, null, false);
        assertThat(chart.getGraphs().get(0).getType(), is("step"));
        assertThat(chart.getGraphs().get(1).getType(), is("step"));
        assertThat(chart.getGraphs().get(0).getLineThickness(), is(2d));
        assertThat(chart.getGraphs().get(1).getLineThickness(), is(2d));
        assertThat(chart.getGraphs().get(0).getNoStepRisers(), is(true));
        assertThat(chart.getGraphs().get(1).getNoStepRisers(), is(true));
        testLineStep(chart);
    }

    private void baseAssertTest(AmSerialChart chart) {
        assertThat(chart.getType(), is("serial"));
        assertThat(chart.getPath(), is("https://www.amcharts.com/lib/3/"));
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

    private void testLineGeneral(AmSerialChart chart, String stakeType, boolean bullet) {
        baseAssertTest(chart);
        testGraph(chart, 1);
        testBalloon(chart);
        assertThat(chart.getValueAxes().get(0).getStackType(), is(stakeType));
        assertThat(chart.getCategoryAxis().getGridPosition(), is("start"));
        assertThat(chart.getCategoryField(), is("category"));
        assertThat(chart.getStartDuration(), is(1d));
        testGraph(chart, 0);
        if (bullet == true) {
            assertThat(chart.getGraphs().get(0).getBullet(), is("round"));
            assertThat(chart.getGraphs().get(1).getBullet(), is("square"));
            testDataProviders(chart.getDataProvider(), new String[]{
                "category 1", "category 2", "category 3", "category 4", "category 5", "category 6", "category 7"
            }, new int[]{
                8, 6, 2, 1, 2, 3, 6
            }, new int[]{
                5, 7, 3, 3, 1, 2, 8
            }, "category");
        }

    }

    private void testLineDateGeneral(AmSerialChart chart, String stakeType) {
        baseAssertTest(chart);
        testGraph(chart, 1);
        assertThat(chart.getValueAxes().get(0).getStackType(), is(stakeType));
        assertThat(chart.getCategoryAxis().getParseDates(), is(true));
        assertThat(chart.getCategoryField(), is("date"));
        testGraph(chart, 0);
    }

    private void testPeriod(AmSerialChart chart,
            String dataDateFormat, String minPeriod,
            String balloonDateFormat) {
        assertThat(chart.getDataDateFormat(), is(dataDateFormat));
        assertThat(chart.getCategoryAxis().getMinPeriod(), is(minPeriod));
        assertThat(chart.getChartCursor().getCategoryBalloonDateFormat(), is(balloonDateFormat));
    }

    private void testBalloon(AmSerialChart chart) {
        assertThat(chart.getGraphs().get(0).getBalloonText(), is("[[title]] of [[category]]:[[value]]"));
        assertThat(chart.getGraphs().get(1).getBalloonText(), is("[[title]] of [[category]]:[[value]]"));
    }

    private void testDataProviders(List<Object> dataProvider, String[] categories, int[] columns1, int[] columns2, String field) {
        for (int i = 0; i < dataProvider.size(); i++) {
            Map provider = (Map<String, Object>) dataProvider.get(i);
            assertThat((String) provider.get(field), equalTo(categories[i]));

            assertThat((Integer) provider.get("column-1"), equalTo(columns1[i]));
            assertThat((Integer) provider.get("column-2"), equalTo(columns2[i]));
        }
    }

    private void testLineStep(AmSerialChart chart) {
        testDataProviders(chart.getDataProvider(), new String[]{
            "category 1", "category 2", "category 3", "category 4", "category 5", "category 6", "category 7"
        }, new int[]{
            8, 6, 7, 9, 7, 8, 7
        }, new int[]{
            5, 2, 3, 3, 1, 2, 6
        }, "category");
    }
    
    private void testProvidersData(AmSerialChart chart,
            String d1, String d2, String d3, String d4,
            String d5, String d6, String d7) {
        testDataProviders(chart.getDataProvider(), new String[]{
            d1, d2, d3, d4, d5, d6, d7
        }, new int[]{
            8, 6, 2, 1, 2, 3, 6
        }, new int[]{
            5, 7, 3, 3, 1, 2, 8
        }, "date");
    }

}
