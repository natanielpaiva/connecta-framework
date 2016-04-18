package br.com.cds.connecta.framework.connector.obiee.bean;

public class AnalysisColumnBean {

    private Integer id;
    private String columnName;
    private String columnFormula;
    private String label;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnFormula() {
        return columnFormula;
    }

    public void setColumnFormula(String columnFormula) {
        this.columnFormula = columnFormula;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
