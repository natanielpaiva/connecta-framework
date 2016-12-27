package br.com.cds.connecta.framework.connector2.context.file.json;

import br.com.cds.connecta.framework.connector2.common.FileContextFactory;
import com.jayway.jsonpath.JsonPath;
import java.io.File;
import java.net.URL;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.json.JsonDataContext;
import org.apache.metamodel.util.InMemoryResource;
import org.apache.metamodel.util.Resource;
import org.apache.metamodel.util.UrlResource;

/**
 *
 * @author diego
 */
public class JsonDataContextFactory implements FileContextFactory {

    DataContext dataContext;

    public JsonDataContextFactory(URL jsonUrl) {
        Resource resource = new UrlResource(jsonUrl);
        dataContext = new JsonDataContext(resource);
    }

    public JsonDataContextFactory(File file) {
        dataContext = new JsonDataContext(file);
    }

    public JsonDataContextFactory(String json) {
        Resource resource = new InMemoryResource("json", json.getBytes(), 0);
        dataContext = new JsonDataContext(resource);
    }

    public JsonDataContextFactory(String json, String path) {
        String jsonPathResult = JsonPath.read(json, path).toString();
        Resource resource = new InMemoryResource("json", jsonPathResult.getBytes(), 0);
        dataContext = new JsonDataContext(resource);
    }

    @Override
    public DataContext createDataContext() {
        return dataContext;
    }

}
