package br.com.cds.connecta.framework.amcharts;

import br.com.cds.connecta.framework.amcharts.ChartTemplate;
import java.util.Set;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
public class ChartTemplateType {
    
    private String id;
    private Set<ChartTemplate> templates;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<ChartTemplate> getTemplates() {
        return templates;
    }

    public void setTemplates(Set<ChartTemplate> templates) {
        this.templates = templates;
    }
}
