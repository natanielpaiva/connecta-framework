package br.com.cds.connecta.framework.connector.obiee.bean;

public class ReportParamBean {

    private String name;
    private String value;
    private String[] values;
    private String columnFormula;
    private String referenceColumnName;
    private Boolean multiValue;

    public ReportParamBean() {
        name = null;
        value = null;
        multiValue = false;
    }

    public ReportParamBean(String name, String value) {
        this.name = name;
        this.value = value;
        multiValue = false;
    }

    public Boolean isMultiValue() {
        return multiValue;
    }

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
        this.multiValue = false;
        this.values = null;
    }

    public String[] getValues() {
        return values;
    }

    public void setValue(String[] values) {
        this.multiValue = true;
        this.value = null;
        this.values = values;
    }

    public String getColumnFormula() {
        return columnFormula;
    }

    public void setColumnFormula(String columnFormula) {
        this.columnFormula = columnFormula;
    }

    public String getReferenceColumnName() {
        return referenceColumnName;
    }

    public void setReferenceColumnName(String referenceColumnName) {
        this.referenceColumnName = referenceColumnName;
    }

}
