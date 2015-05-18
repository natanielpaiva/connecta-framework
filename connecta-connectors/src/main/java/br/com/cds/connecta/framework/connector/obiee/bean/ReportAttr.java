package br.com.cds.connecta.framework.connector.obiee.bean;

/**
 *
 * @author jhonatas
 */
public class ReportAttr {

    private String name;
    private String value = "";
    private Object filter = "";
    private String formula = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Object getFilter() {

        if (filter instanceof FilterBean) {
            return (FilterBean) filter;
        }

        return filter;
    }

    public void setFilter(FilterBean filter) {
        this.filter = filter;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

}
