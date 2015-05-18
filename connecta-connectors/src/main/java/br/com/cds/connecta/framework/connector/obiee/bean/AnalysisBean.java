package br.com.cds.connecta.framework.connector.obiee.bean;

import java.util.List;

public class AnalysisBean {

    private int id;
    private String path;
    private String reportid;
    private boolean paginate;
    private int rownumberforpage;
    private List<ReportParamBean> filters;
    private ReportParamBean drillColumn;
    private String session;
    private List<String> columns;
    private List<String> filterColumns;
    private int typeQuery;

    public static final int TYPE_QUERY_XML = 1;
    public static final int TYPE_QUERY_SQL = 2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportid() {
        return reportid;
    }

    public void setReportid(String reportid) {
        this.reportid = reportid;
    }

    public boolean isPaginate() {
        return paginate;
    }

    public void setPaginate(boolean paginate) {
        this.paginate = paginate;
    }

    public int getRownumberforpage() {
        return rownumberforpage;
    }

    public void setRownumberforpage(int rownumberforpage) {
        this.rownumberforpage = rownumberforpage;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public int getTypeQuery() {
        return typeQuery;
    }

    public void setTypeQuery(int typeQuery) {
        this.typeQuery = typeQuery;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<ReportParamBean> getFilters() {
        return filters;
    }

    public void setFilters(List<ReportParamBean> filters) {
        this.filters = filters;
    }

    public ReportParamBean getDrillColumn() {
        return drillColumn;
    }

    public void setDrillColumn(ReportParamBean drillColumn) {
        this.drillColumn = drillColumn;
    }

    public List<String> getFilterColumns() {
        return filterColumns;
    }

    public void setFilterColumns(List<String> filterColumns) {
        this.filterColumns = filterColumns;
    }

}
