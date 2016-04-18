package br.com.cds.connecta.framework.amcharts;

import java.util.Collection;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
public class ChartTemplateType {
    
    private String id;
    private Collection<ChartTemplate> templates;

    public ChartTemplateType() {}
    
    public ChartTemplateType(String id) {
        this.id = id;
    }

    public ChartTemplateType(String id, Collection<ChartTemplate> templates) {
        this.id = id;
        this.templates = templates;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<ChartTemplate> getTemplates() {
        return templates;
    }

    public void setTemplates(Collection<ChartTemplate> templates) {
        this.templates = templates;
    }
}
