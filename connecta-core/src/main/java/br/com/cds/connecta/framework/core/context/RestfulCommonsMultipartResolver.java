package br.com.cds.connecta.framework.core.context;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Classe que faz exatamente a mesma coisa que o CommonsMultipartResolver do
 * Spring, apenas muda o método isMultipart pra não usar o ServletFileUpload do
 * Apache Commons FileUpload por conta desse bug que a ASF não considera como um
 * bug por provavelmente terem nascido com alguns parafusos a menos:
 * https://issues.apache.org/jira/browse/FILEUPLOAD-197
 *
 * @author Vinicius Pires
 */
public class RestfulCommonsMultipartResolver extends CommonsMultipartResolver {
    /**
     * Método que apenas retira o if estúpido do "isMultipartContent" da
     * {@link ServletFileUpload}, que quer ser o espertão e fazer mais do que o
     * esperado e restringir a funcionalidade de upload só para os métodos POST
     * (linha 68). Pra melhorar ele é final, pra fazer necessário criar outra
     * classe se não quiser que um if idiota domine sua vida pra sempre.
     *
     * @param request request
     * @return return
     */
    @Override
    public boolean isMultipart(HttpServletRequest request) {
        return (request != null && FileUploadBase.isMultipartContent(new ServletRequestContext(request)));
    }

}
