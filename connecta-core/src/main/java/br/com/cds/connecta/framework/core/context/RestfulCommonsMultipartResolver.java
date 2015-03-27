package br.com.cds.connecta.framework.core.context;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Classe que faz exatamente a mesma coisa que o CommonsMultipartResolver
 * do Spring, apenas muda o método isMultipart pra não usar o ServletFileUpload
 * do Apache Commons FileUpload por conta desse bug que a ASF não considera como
 * um bug por provavelmente terem nascido com alguns parafusos a menos:
 * https://issues.apache.org/jira/browse/FILEUPLOAD-197
 * 
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
public class RestfulCommonsMultipartResolver extends CommonsMultipartResolver {

    @Override
    public boolean isMultipart(HttpServletRequest request) {
        return (request != null && RestfulServletFileUpload.isMultipartContent(request));
    }
    
}
