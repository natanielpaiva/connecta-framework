package br.com.cds.connecta.framework.core.security;

import br.com.cds.connecta.framework.core.domain.annotation.PublicResource;
import br.com.cds.connecta.framework.core.domain.security.AuthenticationDTO;
import br.com.cds.connecta.framework.core.util.Util;
import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Julio Lemes
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    private SecurityConnector connector;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse resp = (HttpServletResponse) response;
        
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
        
            PublicResource pub = handlerMethod.getMethodAnnotation(PublicResource.class);
            if(Util.isNotNull(pub)){
                return true;
            }
            
            pub = handlerMethod.getBean().getClass().getAnnotation(PublicResource.class);
            if(Util.isNotNull(pub)){
                return true;
            }
        }
        
        

        String userToken = req.getHeader("X-Authorization-Token");
        Boolean hasToken = userToken != null && !userToken.isEmpty();

        if (!hasToken && Util.isNotEmpty(request.getCookies())) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("X-Authorization-Token")) {
                    userToken = cookie.getValue();
                    hasToken = true;
                    break;
                }
            }
        }

        if (hasToken) {
            AuthenticationDTO auth = connector.getAuthenticatedUser(userToken);
            if (Util.isNotNull(auth)) {
                SecurityContextUtil.setCurrentUser(auth);
                return true;
            }
        }
        
        SecurityContextUtil.setCurrentUser(null);
        sendUnauthorized(req, resp);
        return false;
    }

    protected void sendUnauthorized(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(401);
    }

    public SecurityConnector getConnector() {
        return connector;
    }

    public void setConnector(SecurityConnector connector) {
        this.connector = connector;
    }
    
}
