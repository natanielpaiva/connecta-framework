package br.com.connecta.framework.amcharts;

import br.com.cds.connecta.framework.amcharts.model.AmGraph;
import br.com.cds.connecta.framework.amcharts.model.AmSerialChart;
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

        testBasicAreaFields(chart, "category", 1.0, "start");
        testGraphList(chart.getGraphs(), 2, new Boolean[]{
            null, null
        }, new String[]{
            "[[title]] of [[category]]:[[value]]",
            "[[title]] of [[category]]:[[value]]"
        }, new Double[]{
            0.7, 0.7
        }, new Double[]{
            0d, 0d
        }, new String[]{
            null, null
        });
        testValueAxes(chart, null);
        testDataProviders(chart.getDataProvider(), new String[]{
            "category 1", "category 2", "category 3", "category 4", "category 5", "category 6", "category 7"
        }, new int[]{
            8, 6, 2, 1, 2, 3, 6
        }, new int[]{
            5, 7, 3, 3, 1, 2, 8
        }, "category");
    }

    @Test
    public void stackedArea() throws IOException {
        AmSerialChart chart = mapper.readValue(json("area-stacked"), AmSerialChart.class);

        testBasicAreaFields(chart, "category", 1.0, "start");
        testGraphList(chart.getGraphs(), 2, new Boolean[]{
            null, null
        }, new String[]{
            "[[title]] of [[category]]:[[value]]",
            "[[title]] of [[category]]:[[value]]"
        }, new Double[]{
            0.7, 0.7
        }, new Double[]{
            0d, 0d
        }, new String[]{
            null, null
        });
        testValueAxes(chart, "regular");
        testDataProviders(chart.getDataProvider(), new String[]{
            "category 1", "category 2", "category 3", "category 4", "category 5", "category 6", "category 7"
        }, new int[]{
            8, 6, 2, 1, 2, 3, 6
        }, new int[]{
            5, 7, 3, 3, 1, 2, 8
        }, "category");
    }

    @Test
    public void percent100stackedArea() throws IOException {
        AmSerialChart chart = mapper.readValue(json("area-100-stacked"), AmSerialChart.class);

        testBasicAreaFields(chart, "category", 1.0, "start");
        testGraphList(chart.getGraphs(), 2, new Boolean[]{
            null, null
        }, new String[]{
            "[[title]] of [[category]]:[[value]]",
            "[[title]] of [[category]]:[[value]]"
        }, new Double[]{
            0.7, 0.7
        }, new Double[]{
            0d, 0d
        }, new String[]{
            null, null
        });
        testValueAxes(chart, "100%");
        testDataProviders(chart.getDataProvider(), new String[]{
            "category 1", "category 2", "category 3", "category 4", "category 5", "category 6", "category 7"
        }, new int[]{
            8, 6, 2, 1, 2, 3, 6
        }, new int[]{
            5, 7, 3, 3, 1, 2, 8
        }, "category");
    }

    @Test
    public void rotatedArea() throws IOException {
        AmSerialChart chart = mapper.readValue(json("area-rotated"), AmSerialChart.class);
        
        assertThat(chart.getRotate(), is(true));

        testBasicAreaFields(chart, "category", 1.0, "start");
        testGraphList(chart.getGraphs(), 2, new Boolean[]{
            null, null
        }, new String[]{
            "[[title]] of [[category]]:[[value]]",
            "[[title]] of [[category]]:[[value]]"
        }, new Double[]{
            0.7, 0.7
        }, new Double[]{
            0d, 0d
        }, new String[]{
            null, null
        });
        testValueAxes(chart, null);
        testDataProviders(chart.getDataProvider(), new String[]{
            "category 1", "category 2", "category 3", "category 4", "category 5", "category 6", "category 7"
        }, new int[]{
            8, 6, 4, 5, 2, 3, 6
        }, new int[]{
            5, 7, 3, 1, 3, 2, 8
        }, "category");
    }
    
    @Test
    public void dateSeriesDaily() throws IOException {
        AmSerialChart chart = mapper.readValue(json("area-date-series-daily"), AmSerialChart.class);
        
        assertThat(chart.getDataDateFormat(), is("YYYY-MM-DD"));
        assertThat(chart.getCategoryAxis().getParseDates(), is(true));
        assertThat(chart.getChartCursor(), notNullValue());
        assertThat(chart.getChartScrollbar(), notNullValue());

        testBasicAreaFields(chart, "date", null, null);
        testGraphList(chart.getGraphs(), 2, new Boolean[]{
            null, null
        }, new String[]{
            null, null
        }, new Double[]{
            0.7, 0.7
        }, new Double[]{
            0d, 0d
        }, new String[]{
            null, null
        });
        testValueAxes(chart, null);
        testDataProviders(chart.getDataProvider(), new String[]{
            "2014-03-01", "2014-03-02", "2014-03-03", "2014-03-04", "2014-03-05", "2014-03-06", "2014-03-07"
        }, new int[]{
            8, 6, 2, 1, 2, 3, 6
        }, new int[]{
            5, 7, 3, 3, 1, 2, 8
        }, "date");
    }
    
    @Test
    public void dateSeriesMonthly() throws IOException {
        AmSerialChart chart = mapper.readValue(json("area-date-series-monthly"), AmSerialChart.class);
        
        assertThat(chart.getDataDateFormat(), is("YYYY-MM"));
        assertThat(chart.getCategoryAxis().getParseDates(), is(true));
        assertThat(chart.getCategoryAxis().getMinPeriod(), is("MM"));
        assertThat(chart.getTheme(), is("default"));
        assertThat(chart.getChartCursor().getCategoryBalloonDateFormat(), is("MMM YYYY"));
        assertThat(chart.getChartScrollbar(), notNullValue());

        testBasicAreaFields(chart, "date", null, null);
        testGraphList(chart.getGraphs(), 2, new Boolean[]{
            null, null
        }, new String[]{
            null, null
        }, new Double[]{
            0.7, 0.7
        }, new Double[]{
            0d, 0d
        }, new String[]{
            null, null
        });
        testValueAxes(chart, null);
        testDataProviders(chart.getDataProvider(), new String[]{
            "2014-01", "2014-02", "2014-03", "2014-04", "2014-05", "2014-06", "2014-07"
        }, new int[]{
            8, 6, 2, 1, 2, 3, 6
        }, new int[]{
            5, 7, 3, 3, 1, 2, 8
        }, "date");
    }
    
    @Test
    public void dateSeriesYearly() throws IOException {
        AmSerialChart chart = mapper.readValue(json("area-date-series-yearly"), AmSerialChart.class);
        
        assertThat(chart.getDataDateFormat(), is("YYYY"));
        assertThat(chart.getTheme(), is("default"));
        assertThat(chart.getCategoryAxis().getParseDates(), is(true));
        assertThat(chart.getCategoryAxis().getMinPeriod(), is("YYYY"));
        assertThat(chart.getChartCursor().getCategoryBalloonDateFormat(), is("YYYY"));
        assertThat(chart.getChartCursor().getAnimationDuration(), is(0d));
        assertThat(chart.getChartScrollbar(), notNullValue());

        testBasicAreaFields(chart, "date", null, null);
        testGraphList(chart.getGraphs(), 2, new Boolean[]{
            null, null
        }, new String[]{
            null, null
        }, new Double[]{
            0.7, 0.7
        }, new Double[]{
            0d, 0d
        }, new String[]{
            null, null
        });
        testValueAxes(chart, null);
        testDataProviders(chart.getDataProvider(), new String[]{
            "2001", "2002", "2003", "2004", "2005", "2006", "2007"
        }, new int[]{
            8, 6, 2, 4, 2, 3, 4
        }, new int[]{
            5, 7, 3, 3, 1, 2, 8
        }, "date");
    }
    
    @Test
    public void timeSeriesHourly() throws IOException {
        AmSerialChart chart = mapper.readValue(json("area-time-series-hourly"), AmSerialChart.class);
        
        assertThat(chart.getDataDateFormat(), is("YYYY-MM-DD HH"));
        assertThat(chart.getCategoryAxis().getParseDates(), is(true));
        assertThat(chart.getCategoryAxis().getMinPeriod(), is("hh"));
        assertThat(chart.getChartCursor().getCategoryBalloonDateFormat(), is("JJ:NN"));
        assertThat(chart.getChartScrollbar(), notNullValue());

        testBasicAreaFields(chart, "date", null, null);
        testGraphList(chart.getGraphs(), 2, new Boolean[]{
            null, null
        }, new String[]{
            null, null
        }, new Double[]{
            0.7, 0.7
        }, new Double[]{
            0d, 0d
        }, new String[]{
            null, null
        });
        testValueAxes(chart, null);
        testDataProviders(chart.getDataProvider(), new String[]{
            "2014-03-01 08", "2014-03-01 09", "2014-03-01 10", "2014-03-01 11",
            "2014-03-01 12", "2014-03-01 13", "2014-03-01 14"
        }, new int[]{
            8, 6, 2, 1, 2, 3, 6
        }, new int[]{
            5, 7, 3, 3, 1, 2, 8
        }, "date");
    }
    
    @Test
    public void timeSeriesMinutes() throws IOException {
        AmSerialChart chart = mapper.readValue(json("area-time-series-minutes"), AmSerialChart.class);
        
        assertThat(chart.getDataDateFormat(), is("YYYY-MM-DD HH:NN"));
        assertThat(chart.getCategoryAxis().getMinPeriod(), is("mm"));
        assertThat(chart.getCategoryAxis().getParseDates(), is(true));
        assertThat(chart.getChartCursor().getCategoryBalloonDateFormat(), is("JJ:NN"));
        assertThat(chart.getChartScrollbar(), notNullValue());

        testBasicAreaFields(chart, "date", null, null);
        testGraphList(chart.getGraphs(), 2, new Boolean[]{
            null, null
        }, new String[]{
            null, null
        }, new Double[]{
            0.7, 0.7
        }, new Double[]{
            0d, 0d
        }, new String[]{
            null, null
        });
        testValueAxes(chart, null);
        testDataProviders(chart.getDataProvider(), new String[]{
            "2014-03-01 07:57", "2014-03-01 07:58", "2014-03-01 07:59", "2014-03-01 08:00",
            "2014-03-01 08:01", "2014-03-01 08:02", "2014-03-01 08:03"
        }, new int[]{
            8, 6, 2, 1, 2, 3, 6
        }, new int[]{
            5, 7, 3, 3, 1, 2, 8
        }, "date");
    }
    
    @Test
    public void timeSeriesSeconds() throws IOException {
        AmSerialChart chart = mapper.readValue(json("area-time-series-seconds"), AmSerialChart.class);
        
        assertThat(chart.getDataDateFormat(), is("YYYY-MM-DD HH:NN:SS"));
        assertThat(chart.getCategoryAxis().getMinPeriod(), is("ss"));
        assertThat(chart.getCategoryAxis().getParseDates(), is(true));
        assertThat(chart.getChartCursor().getCategoryBalloonDateFormat(), is("JJ:NN:SS"));
        assertThat(chart.getChartScrollbar(), notNullValue());

        testBasicAreaFields(chart, "date", null, null);
        testGraphList(chart.getGraphs(), 2, new Boolean[]{
            null, null
        }, new String[]{
            null, null
        }, new Double[]{
            0.7, 0.7
        }, new Double[]{
            0d, 0d
        }, new String[]{
            null, null
        });
        testValueAxes(chart, null);
        testDataProviders(chart.getDataProvider(), new String[]{
            "2014-03-01 07:57:57", "2014-03-01 07:57:58", "2014-03-01 07:57:59",
            "2014-03-01 07:58:00", "2014-03-01 07:58:01", "2014-03-01 07:58:02",
            "2014-03-01 07:58:03"
        }, new int[]{
            8, 6, 2, 1, 2, 3, 6
        }, new int[]{
            5, 7, 3, 3, 1, 2, 8
        }, "date");
    }
    
    // HELPERS
    private void testBasicAreaFields(AmSerialChart chart, final String categoryField, Double startDuration, String gridPosition) {
        assertThat(chart.getType(), is("serial"));
        assertThat(chart.getPath(), is("http://www.amcharts.com/lib/3/"));
        assertThat(chart.getCategoryField(), is(categoryField));
        assertThat(chart.getStartDuration(), is(startDuration));
        assertThat(chart.getCategoryAxis().getGridPosition(), is(gridPosition));
        assertThat(chart.getTrendLines().size(), is(0));

        assertThat(chart.getGuides().size(), is(0));

        assertThat(chart.getAllLabels().size(), is(0));
        assertThat(chart.getBalloon(), notNullValue());
        assertThat(chart.getLegend(), notNullValue());

        assertThat(chart.getTitles().size(), is(1));
        assertThat(chart.getTitles().get(0).getId(), is("Title-1"));
        assertThat(chart.getTitles().get(0).getSize(), is(15d));
        assertThat(chart.getTitles().get(0).getText(), is("Chart Title"));
    }
    
    private void testGraphList(List<AmGraph> graphs, int size,
            Boolean[] newStacks, String[] balloonTexts, Double[] fillAlphas,
            Double[] lineAlphas, String[] types) {
        
        assertThat(graphs.size(), is(size));
        
        for (int i=0; i<graphs.size(); i++) {
            assertThat(graphs.get(i).getId(), is("AmGraph-" + (i + 1)));
            assertThat(graphs.get(i).getTitle(), is("graph " + (i + 1)));
            assertThat(graphs.get(i).getValueField(), is("column-" + (i + 1)));
            
            assertThat(graphs.get(i).getNewStack(), is(newStacks[i]));
            assertThat(graphs.get(i).getBalloonText(), is(balloonTexts[i]));
            assertThat(graphs.get(i).getFillAlphas(), is(fillAlphas[i]));
            assertThat(graphs.get(i).getLineAlpha(), is(lineAlphas[i]));
            assertThat(graphs.get(i).getType(), is(types[i]));
        }
    }

    private void testValueAxes(AmSerialChart chart, String stackType) {
        assertThat(chart.getValueAxes().size(), is(1));
        assertThat(chart.getValueAxes().get(0).getId(), is("ValueAxis-1"));
        assertThat(chart.getValueAxes().get(0).getTitle(), is("Axis title"));
        assertThat(chart.getValueAxes().get(0).getStackType(), is(stackType));
    }

    private void testDataProviders(List<Object> dataProvider, String[] categories, int[] columns1, int[] columns2, String field) {
        for (int i = 0; i < dataProvider.size(); i++) {
            Map provider = (Map<String, Object>) dataProvider.get(i);
            assertThat((String) provider.get(field), equalTo(categories[i]));
            assertThat((Integer) provider.get("column-1"), equalTo(columns1[i]));
            assertThat((Integer) provider.get("column-2"), equalTo(columns2[i]));
        }
    }

}
