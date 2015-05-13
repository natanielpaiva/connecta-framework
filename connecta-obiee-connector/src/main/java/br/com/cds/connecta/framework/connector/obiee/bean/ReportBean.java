package br.com.cds.connecta.framework.connector.obiee.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jhonatas
 */
public class ReportBean {

    private String id;
    private String path;
    private List<ReportAttr> header;
    private List<List<ReportAttr>> body;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<ReportAttr> getHeader() {
        return header;
    }

    public void setHeader(List<ReportAttr> header) {
        this.header = header;
    }

    public List<List<ReportAttr>> getBody() {
        return body;
    }

    public void setBody(List<List<ReportAttr>> body) {
        this.body = body;
        this.verificaFiltros();
    }

    public List<String> getHeaderArray() {

        List<String> names = new ArrayList<String>();

        if (header != null && !header.isEmpty()) {
            for (ReportAttr report : header) {
                names.add(report.getValue());
            }
        }
        return names;
    }

    public List<List<String>> getBodyArray() {

        List<List<String>> arr = new ArrayList<List<String>>();

        if (body != null && !body.isEmpty()) {

            for (List<ReportAttr> rep : body) {
                List<String> lista = new ArrayList<String>();
                for (ReportAttr attr : rep) {
                    lista.add(attr.getValue());
                }
                arr.add(lista);
            }

        }

        return arr;
    }

    public List<FilterBean> getAllFilters() {

        List<FilterBean> filters = new ArrayList<FilterBean>();

        if (header != null && !header.isEmpty()) {
            for (ReportAttr rep : header) {
                if (rep.getFilter() != null) {
                    if (rep.getFilter() instanceof FilterBean) {
                        filters.add((FilterBean) rep.getFilter());
                    }
                }
            }
        }

        return filters;
    }

    private void verificaFiltros() {
        Set<String> valores = new HashSet<String>();
        if (header != null && !header.isEmpty()) {
            for (ReportAttr rep : header) {
                if (rep.getFilter() != null) {
                    if (rep.getFilter() instanceof FilterBean) {
                        for (List<ReportAttr> lista : body) {
                            for (ReportAttr attr : lista) {
                                if (rep.getName().equals(attr.getName())) {
                                    valores.add(attr.getValue());
                                }
                            }
                        }
                        ((FilterBean) rep.getFilter()).setValues(valores);
                    }
                }
            }
        }

    }

}
