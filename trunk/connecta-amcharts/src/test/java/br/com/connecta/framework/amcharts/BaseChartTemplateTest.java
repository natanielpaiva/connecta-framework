package br.com.connecta.framework.amcharts;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apache.commons.io.IOUtils;

@JsonSubFolder
public abstract class BaseChartTemplateTest {
    private static final String FILE_TEMPLATE = "src/main/resources/chart-templates/%s/%s.json";
    
    protected ObjectMapper mapper = new ObjectMapper();
    
    protected String json(String json) throws IOException {
        final JsonSubFolder annotation = this.getClass().getAnnotation(JsonSubFolder.class);
        return IOUtils.toString(new FileInputStream(
                        String.format(FILE_TEMPLATE,annotation.value(),json)
                )
            );
    }
    
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface JsonSubFolder {
    String value() default "";
}