package br.com.cds.connecta.framework.core.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import br.com.cds.connecta.framework.core.util.Util;

public class AuthFilter extends GenericFilterBean {

    private static final String AUTH_COOKIE_NAME = "portal.auth.access_token";
    
    private IAuthService authService;

    /**
     * Preenchida no application-context.xml
     */
    private List<String> exceptions;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        Boolean publicDashValidated = false;
        
        //validação do src da diretiva de viewer
        PublicDash pd = new PublicDash(request.getParameter("key"), 
        		request.getParameter("viewerId"));
        
        //após validar os viewers, é a validação de cada requisição executada após o carregamento
        //dos viewers
        if(!pd.validate()){
        	String publicDashboardValidated = request.getHeader("publicDashboardValidated");
            publicDashValidated = Boolean.parseBoolean(publicDashboardValidated);
            
            pd = new PublicDash(request.getHeader("publicDashboardKey"), 
            		request.getHeader("publicDashboardId"));
        }
        
        //caso nao seja publico, valida o token do oauth
        if (!request.getMethod().equalsIgnoreCase("OPTIONS")
                && !isPublic(request.getServletPath(), pd, publicDashValidated)) {
        	
            String headerToken = request.getHeader("Authorization");

            String token = headerToken == null ? getTokenFromCookie(request) : headerToken;

            if (Util.isNull(token) || !authService.validateToken(token)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        chain.doFilter(req, res);
    }

    private String getTokenFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (Util.isNotEmpty(cookies)) {
            for (Cookie cookie : request.getCookies()) {
                if (AUTH_COOKIE_NAME.equals(cookie.getName())) {
                    String cookieValue = cookie.getValue();
                    if (cookieValue != null
                            && cookieValue.startsWith("%22")
                            && cookieValue.endsWith("%22")) {
                        return "Bearer "
                                + cookieValue.substring(3, cookieValue.length() - 3);
                    }
                }
            }
        }

        return null;
    }

    public boolean isPublic(String uri, PublicDash pd, Boolean publicDashboardValidated) {
    	boolean isPublic = false;
    	
    	if(publicDashboardValidated && pd.validate()){
    		isPublic = authService.validatePublicKeyDash(pd.publicKey, pd.resourceId);
    	}else if(pd.validate()){
    		isPublic = authService.validatePublicKey(pd.publicKey, pd.resourceId);
    	}
        if (Util.isNotNull(uri)) {
            // adicionar uris de exceptions
            for (String ex : exceptions) {
                if (uri.equals(ex)) {
                	isPublic = true;
                }
            }
        }
        return isPublic;
    }

    public List<String> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<String> exceptions) {
        this.exceptions = exceptions;
    }
    
    public IAuthService getAuthService() {
        return authService;
    }

    public void setAuthService(IAuthService authService) {
        this.authService = authService;
    }
    
    private class PublicDash{
    	String publicKey;
    	String resourceId;
    	
    	public PublicDash(String publicKey, String viewerId){
    		this.publicKey = publicKey;
    		this.resourceId = viewerId;
    	}
    	
    	public boolean validate(){
    		return Util.isNotNull(publicKey)
    				&& Util.isNotNull(resourceId);
    	}
    }
}
