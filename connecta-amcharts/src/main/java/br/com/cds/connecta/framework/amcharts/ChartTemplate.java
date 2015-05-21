package br.com.cds.connecta.framework.amcharts;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
public class ChartTemplate {
    private String id;

    public ChartTemplate() {}

    public ChartTemplate(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
