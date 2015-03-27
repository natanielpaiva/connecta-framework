package br.com.cds.connecta.framework.core.context;

import javax.servlet.http.HttpServletRequest;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
public class RestfulMultipartResolverTest {
    static final String MULTIPART = "multipart/form-data";
    static final String JSON = "application/json";
    static final String POST = "POST";
    static final String PUT = "PUT";
    static final String DELETE = "DELETE";
    static final String ANYTHING = "F*CK_U_ASF";
    
    RestfulCommonsMultipartResolver resolver = new RestfulCommonsMultipartResolver();
    
    @Test
    public void isMultipartNullRequest() {
        HttpServletRequest request = null;
        assertThat(resolver.isMultipart(request), is(false));
    }
    
    @Test
    public void isMultipartAnotherContentType() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        
        when(request.getContentType()).thenReturn(JSON);
        
        assertThat(resolver.isMultipart(request), is(false));
    }
    
    @Test
    public void isMultipart() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        
        when(request.getContentType()).thenReturn(MULTIPART);
        
        assertThat(resolver.isMultipart(request), is(true));
    }
    
    @Test
    public void whyASFProcessSucksAndIHadToRewriteThisShitAtHome() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        
        when(request.getContentType()).thenReturn(MULTIPART);
        
        when(request.getMethod()).thenReturn(POST);
        assertThat(resolver.isMultipart(request), is(true));
        when(request.getMethod()).thenReturn(PUT);
        assertThat(resolver.isMultipart(request), is(true));
        when(request.getMethod()).thenReturn(DELETE);
        assertThat(resolver.isMultipart(request), is(true));
        when(request.getMethod()).thenReturn(ANYTHING);
        assertThat(resolver.isMultipart(request), is(true));
    }
}
