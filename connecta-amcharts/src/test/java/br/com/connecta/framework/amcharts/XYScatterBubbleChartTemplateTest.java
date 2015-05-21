package br.com.connecta.framework.amcharts;

import br.com.cds.connecta.framework.amcharts.model.AmXYChart;
import java.io.IOException;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
@JsonSubFolder("xy-scatter-bubble")
public class XYScatterBubbleChartTemplateTest extends BaseChartTemplateTest {

    @Test
    public void markers() throws IOException {
        AmXYChart chart = mapper.readValue(json("xy-markers"), AmXYChart.class);

        testBasicFields(chart, 0, 0);
        
        testGraphs(chart, 2, "x:<b>[[x]]</b> y:<b>[[y]]</b><br>value:<b>[[value]]</b>", new String[]{
            "diamond", "round"
        }, new Double[]{
            0.0, 0.0
        }, new String[]{
            "#b0de09", "#fcd202"
        }, new String[]{
            "value", "value2"
        }, new String[]{
            "x", "x2"
        }, new String[]{
            "y", "y2"
        });
        
        testValueAxis(chart, new String[]{
            null, "bottom"
        });
        
        testDataProviderX2Y2Value2(chart, 7, new int[]{
            14, 3, -3, 5, -4, 1, 6 // X
        }, new int[]{
            10, 5, -10, -6, 15, 13, 1 // Y
        }, new int[]{
            59, 50, 19, 65, 92, 8, 35 // VALUES
        }, new int[]{
            -3, -8, 6, -6, -8, -3, -3 // X2
        }, new int[]{
            -5, -15, -4, -5, -10, -2, 0 // Y2
        }, new int[]{
            44, 12, 35, 168, 102, 41, 16 // VALUES2
        });
    }

    @Test
    public void markersAndLines() throws IOException {
        AmXYChart chart = mapper.readValue(json("xy-markers-lines"), AmXYChart.class);

        testBasicFields(chart, 0, 0);
        
        testGraphs(chart, 2, "x:<b>[[x]]</b> y:<b>[[y]]</b><br>value:<b>[[value]]</b>", new String[]{
            "diamond", "round"
        }, new Double[]{
            null, null
        }, new String[]{
            "#b0de09", "#fcd202"
        }, new String[]{
            "value", "value2"
        }, new String[]{
            "x", "x2"
        }, new String[]{
            "y", "y2"
        });
        
        testValueAxis(chart, new String[]{
            null, "bottom"
        });
        
        testDataProviderX2Y2Value2(chart, 7, new int[]{
            14, 3, -3, 5, -4, 1, 6 // X
        }, new int[]{
            10, 5, -10, -6, 15, 13, 1 // Y
        }, new int[]{
            59, 50, 19, 65, 92, 8, 35 // VALUES
        }, new int[]{
            -3, -8, 6, -6, -8, -3, -3 // X2
        }, new int[]{
            -5, -15, -4, -5, -10, -2, 0 // Y2
        }, new int[]{
            44, 12, 35, 168, 102, 41, 16 // VALUES2
        });
    }

    @Test
    public void lines() throws IOException {
        AmXYChart chart = mapper.readValue(json("xy-lines"), AmXYChart.class);

        testBasicFields(chart, 0, 0);
        
        testGraphs(chart, 2, "x:<b>[[x]]</b> y:<b>[[y]]</b>", new String[]{
            "round", "round"
        }, new Double[]{
            null, null
        }, new String[]{
            "#b0de09", "#fcd202"
        }, new String[]{
            null, null
        }, new String[]{
            "x", "x2"
        }, new String[]{
            "y", "y2"
        });
        
        testValueAxis(chart, new String[]{
            null, "bottom"
        });
        
        testDataProviderX2Y2(chart, 7, new int[]{
            14, 3, -3, 5, -4, 1, 6 // X
        }, new int[]{
            10, 5, -10, -6, 15, 13, 1 // Y
        }, new int[]{
            -3, -8, 6, -6, -8, -3, -3 // X2
        }, new int[]{
            -5, -15, -4, -5, -10, -2, 0 // Y2
        });
    }

    @Test
    public void trendLines() throws IOException {
        AmXYChart chart = mapper.readValue(json("xy-trend-lines"), AmXYChart.class);

        testBasicFields(chart, 2, 0);
        
        testGraphs(chart, 2, "x:<b>[[x]]</b> y:<b>[[y]]</b>", new String[]{
            "diamond", "round"
        }, new Double[]{
            0.0, 0.0
        }, new String[]{
            "#b0de09", "#fcd202"
        }, new String[]{
            null, null
        }, new String[]{
            "ax", "bx"
        }, new String[]{
            "ay", "by"
        });
        
        testValueAxis(chart, new String[]{
            null, "bottom"
        });
        
        testDataProviderABXABY(chart, 12, new Number[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 // AX
        }, new Number[]{
            0.5, 1.3, 2.3, 2.8, 3.5, 5.1, 6.7, 8, 8.9, 9.7, 10.4, 11.7 // AY
        }, new Number[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 // BX
        }, new Number[]{
            2.2, 4.9, 5.1, 5.3, 6.1, 8.3, 10.5, 12.3, 14.5, 15, 18.8, 19 // BY
        });
        
        testTrendLines(chart);
    }

    @Test
    public void guides() throws IOException {
        AmXYChart chart = mapper.readValue(json("xy-guides"), AmXYChart.class);

        testBasicFields(chart, 0, 1);
        
        testGraphs(chart, 2, "x:<b>[[x]]</b> y:<b>[[y]]</b><br>value:<b>[[value]]</b>", new String[]{
            "diamond", "round"
        }, new Double[]{
            0.0, 0.0
        }, new String[]{
            "#b0de09", "#fcd202"
        }, new String[]{
            "value", "value2"
        }, new String[]{
            "x", "x2"
        }, new String[]{
            "y", "y2"
        });
        
        testValueAxis(chart, new String[]{
            null, "bottom"
        });
        
        testDataProviderX2Y2Value2(chart, 7, new int[]{
            14, 3, -3, 5, -4, 1, 6 // X
        }, new int[]{
            10, 5, -10, -6, 15, 13, 1 // Y
        }, new int[]{
            59, 50, 19, 65, 92, 8, 35 // VALUES
        }, new int[]{
            -3, -8, 6, -6, -8, -3, -3 // X2
        }, new int[]{
            -5, -15, -4, -5, -10, -2, 0 // Y2
        }, new int[]{
            44, 12, 35, 168, 102, 41, 16 // VALUES2
        });
        
        testGuides(chart);
    }

    @Test
    public void zoomAndScroll() throws IOException {
        AmXYChart chart = mapper.readValue(json("xy-zoom-scroll"), AmXYChart.class);

        testBasicFields(chart, 0, 0);
        
        testGraphs(chart, 2, "x:<b>[[x]]</b> y:<b>[[y]]</b><br>value:<b>[[value]]</b>", new String[]{
            "diamond", "round"
        }, new Double[]{
            0.0, 0.0
        }, new String[]{
            "#b0de09", "#fcd202"
        }, new String[]{
            "value", "value2"
        }, new String[]{
            "x", "x2"
        }, new String[]{
            "y", "y2"
        });
        
        testValueAxis(chart, new String[]{
            null, "bottom"
        });
        
        testDataProviderX2Y2Value2(chart, 7, new int[]{
            14, 3, -3, 5, -4, 1, 6 // X
        }, new int[]{
            10, 5, -10, -6, 15, 13, 1 // Y
        }, new int[]{
            59, 50, 19, 65, 92, 8, 35 // VALUES
        }, new int[]{
            -3, -8, 6, -6, -8, -3, -3 // X2
        }, new int[]{
            -5, -15, -4, -5, -10, -2, 0 // Y2
        }, new int[]{
            44, 12, 35, 168, 102, 41, 16 // VALUES2
        });
        
        testCursorAndScrollbar(chart);
    }
        
    @Test
    public void fills() throws IOException {
        AmXYChart chart = mapper.readValue(json("xy-fills"), AmXYChart.class);

        testBasicFields(chart, 0, 0);
        
        testGraphs(chart, 1, "x:<b>[[x]]</b> y:<b>[[y]]</b>", new String[]{
            "round"
        }, new Double[]{
            null
        }, new String[]{
            "#b0de09"
        }, new String[]{
            null
        }, new String[]{
            "x"
        }, new String[]{
            "y"
        });
        
        testValueAxis(chart, new String[]{
            null, "bottom"
        });
        
        testDataProviderXY(chart, 4, new int[]{
            14, 3, 3, 1 // X
        }, new int[]{
            10, 5, 10, 13 // Y
        });
    }
    
    
    // HELPERS
    private void testBasicFields(AmXYChart chart, int trendLinesSize, int guidesSize) {
        assertThat(chart.getType(), is("xy"));
        assertThat(chart.getPath(), is("http://www.amcharts.com/lib/3/"));
        assertThat(chart.getStartDuration(), is(1.5));

        assertThat(chart.getTrendLines(), hasSize(trendLinesSize));
        assertThat(chart.getGuides(), hasSize(guidesSize));
        assertThat(chart.getAllLabels(), hasSize(0));
        assertThat(chart.getTitles(), hasSize(0));
        
        assertThat(chart.getBalloon(), notNullValue());
    }

    private void testTrendLines(AmXYChart chart) {
        double[] initialValues = new double[]{1d, 2d};
        double[] finalValues = new double[]{11d, 19d};
        
        for (int i=0; i<chart.getTrendLines().size(); i++) {
            assertThat(chart.getTrendLines().get(i).getId(), is("TrendLine-"+(i+1)));
            assertThat(chart.getTrendLines().get(i).getLineColor().toString(), is("#FF6600"));
                    
            assertThat(chart.getTrendLines().get(i).getInitialValue(), is(initialValues[i]));
            assertThat(chart.getTrendLines().get(i).getFinalValue(), is(finalValues[i]));
            
            assertThat(chart.getTrendLines().get(i).getInitialXValue(), is(1d));
            assertThat(chart.getTrendLines().get(i).getFinalXValue(), is(12d));
        }
    }

    private void testGraphs(AmXYChart chart, int graphsSize, String balloonText,
            String[] bullets, Double[] lineAlphas, String[] lineColors,
            String[] valueFields, String[] xFields, String[] yFields) {
        
        assertThat(chart.getGraphs(), hasSize(graphsSize));
        
        for(int i=0;i<chart.getGraphs().size(); i++) {
            assertThat(chart.getGraphs().get(i).getBalloonText(), is(balloonText));
            assertThat(chart.getGraphs().get(i).getBullet(), is(bullets[i]));
            assertThat(chart.getGraphs().get(i).getId(), is("AmGraph-"+(i+1)));
            assertThat(chart.getGraphs().get(i).getLineAlpha(), is(lineAlphas[i]));
            assertThat(chart.getGraphs().get(i).getLineColor().toString(), is(lineColors[i]));
            assertThat(chart.getGraphs().get(i).getValueField(), is(valueFields[i]));
            assertThat(chart.getGraphs().get(i).getXField(), is(xFields[i]));
            assertThat(chart.getGraphs().get(i).getYField(), is(yFields[i]));
        }
    }
    
    private void testValueAxis(AmXYChart chart, String[] positions) {
        assertThat(chart.getValueAxes(), hasSize(2));
        
        for(int i=0;i<chart.getValueAxes().size();i++) {
            assertThat(chart.getValueAxes().get(i).getId(), is("ValueAxis-"+(i+1)));
            assertThat(chart.getValueAxes().get(i).getAxisAlpha(), is(0d));
            assertThat(chart.getValueAxes().get(i).getPosition(), is(positions[i]));
        }
    }
    
    private void testGuides(AmXYChart chart) {
        assertThat(chart.getGuides().get(0).getFillAlpha(), is(0.21));
        assertThat(chart.getGuides().get(0).getFillColor().toString(), is("#ff8000"));
        assertThat(chart.getGuides().get(0).getId(), is("Guide-1"));
        assertThat(chart.getGuides().get(0).getLineAlpha(), is(0d));
        assertThat(chart.getGuides().get(0).getToValue(), is(-8d));
        assertThat(chart.getGuides().get(0).getValue(), is(-3d));
        assertThat(chart.getGuides().get(0).getValueAxis().getId(), is("ValueAxis-2"));
    }
    
    private void testCursorAndScrollbar(AmXYChart chart) {
        assertThat(chart.getChartCursor(), notNullValue());
        assertThat(chart.getChartScrollbar(), notNullValue());
    }

    private void testDataProviderXY(AmXYChart chart, int dataProviderSize, int[] x, int[] y) {
        assertThat(chart.getDataProvider(), hasSize(dataProviderSize));
        
        for (int i = 0; i < chart.getDataProvider().size(); i++) {
            Map<String, Object> current = (Map<String, Object>) chart.getDataProvider().get(i);
            assertThat((Integer)current.get("x"), is(x[i]));
            assertThat((Integer)current.get("y"), is(y[i]));
        }
    }

    private void testDataProviderX2Y2Value2(AmXYChart chart, int dataProviderSize,
            int[] x, int[] y, int[] values, int[] x2, int[] y2, int[] values2) {
        assertThat(chart.getDataProvider(), hasSize(dataProviderSize));
        for (int i = 0; i < chart.getDataProvider().size(); i++) {
            Map<String, Object> current = (Map<String, Object>) chart.getDataProvider().get(i);
            assertThat((Integer)current.get("x"), is(x[i]));
            assertThat((Integer)current.get("y"), is(y[i]));
            assertThat((Integer)current.get("value"), is(values[i]));
            
            assertThat((Integer)current.get("x2"), is(x2[i]));
            assertThat((Integer)current.get("y2"), is(y2[i]));
            assertThat((Integer)current.get("value2"), is(values2[i]));
        }
    }
    
    private void testDataProviderX2Y2(AmXYChart chart, int dataProviderSize,
            int[] x, int[] y, int[] x2, int[] y2) {
        assertThat(chart.getDataProvider(), hasSize(dataProviderSize));
        for (int i = 0; i < chart.getDataProvider().size(); i++) {
            Map<String, Object> current = (Map<String, Object>) chart.getDataProvider().get(i);
            assertThat((Integer)current.get("x"), is(x[i]));
            assertThat((Integer)current.get("y"), is(y[i]));
            
            assertThat((Integer)current.get("x2"), is(x2[i]));
            assertThat((Integer)current.get("y2"), is(y2[i]));
        }
    }
    
    private void testDataProviderABXABY(AmXYChart chart, int dataProviderSize,
            Number[] ax, Number[] ay, Number[] bx, Number[] by) {
        assertThat(chart.getDataProvider(), hasSize(dataProviderSize));
        for (int i = 0; i < chart.getDataProvider().size(); i++) {
            Map<String, Number> current = (Map<String, Number>) chart.getDataProvider().get(i);
            assertThat(current.get("ax"), is((Number)ax[i]));
            assertThat(current.get("ay"), is((Number)ay[i]));
            
            assertThat(current.get("bx"), is((Number)bx[i]));
            assertThat(current.get("by"), is((Number)by[i]));
        }
    }
}