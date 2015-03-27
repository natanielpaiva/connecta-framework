package br.com.cds.connecta.framework.core.context;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

/**
 * Classe usada pela {@link RestfulMultipartResolver} que apenas retira o if
 * estúpido do método homônimo na {@link ServletFileUpload}, que quer ser o espertão
 * e fazer mais do que o esperado e restringir a funcionalidade de upload só para
 * os métodos POST (linha 68). Pra melhorar ele é final, pra fazer necessário
 * criar outra classe se não quiser que um if idiota domine sua vida pra sempre.
 * 
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
public class RestfulServletFileUpload {

    public static boolean isMultipartContent(HttpServletRequest request) {
        // A única coisa que a ASF deveria ter feito nesse método
        return FileUploadBase.isMultipartContent(new ServletRequestContext(request));
    }
    
}
