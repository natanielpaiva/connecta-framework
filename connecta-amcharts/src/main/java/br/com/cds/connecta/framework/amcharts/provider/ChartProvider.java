package br.com.cds.connecta.framework.amcharts.provider;

import br.com.cds.connecta.framework.amcharts.ChartTemplateType;
import br.com.cds.connecta.framework.amcharts.ChartTemplate;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
public class ChartProvider {

    private static final String CHART_TEMPLATES = "/chart-templates";
    private static final String INVALID_TEMPLATE_ID = "Invalid template ID";
    private static final String JSON_EXT = ".json";

    public Collection<ChartTemplateType> listTemplateTypes() {
        File templateTypeFolder = new File(getClass().getResource(CHART_TEMPLATES).getPath());

        File[] folders = templateTypeFolder.listFiles();

        Set<ChartTemplateType> types = new HashSet<>(folders.length);
        for (File folder : folders) {
            Collection<ChartTemplate> templates = listTemplatesFor(folder.getName());

            types.add(new ChartTemplateType(folder.getName(), templates));
        }

        return types;
    }

    public ChartTemplate getTemplate(String type, String file) {
        File json = getTemplateFile(type, file);
        
        
        
        return new ChartTemplate(json.getName().replace(JSON_EXT, ""));
    }

    private File getTemplateFile(String type, String file) throws RuntimeException {
        File json = new File(getClass()
                .getResource(CHART_TEMPLATES.concat(File.separator)
                        .concat(type)
                        .concat(File.separator)
                        .concat(file)
                        .concat(JSON_EXT)
                ).getPath());
        if (!json.exists()) {
            throw new RuntimeException(INVALID_TEMPLATE_ID);
        }
        return json;
    }

    public Collection<ChartTemplate> listTemplatesFor(String type) {
        File[] jsonFiles = new File(getClass()
                .getResource(CHART_TEMPLATES.concat(File.separator)
                    .concat(type)
                ).getPath())
                .listFiles();
        
        Set<ChartTemplate> templates = new HashSet<>(jsonFiles.length);
        for (File json : jsonFiles) {
            templates.add(new ChartTemplate(json.getName().replace(JSON_EXT, "")));
        }

        return templates;
    }

    public Collection<ChartTemplate> listTemplatesFor(ChartTemplateType type) {
        return listTemplatesFor(type.getId());
    }

    public String getTemplateContent(String type, String templateName) {
        File file = getTemplateFile(type, templateName);
        
        String content = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            content = IOUtils.toString(fis);
        } catch (IOException ex) {
            throw new RuntimeException(INVALID_TEMPLATE_ID, ex);
        }
        
        return content;
    }

}
