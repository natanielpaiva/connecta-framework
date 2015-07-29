package br.com.cds.connecta.framework.core.security;

import br.com.cds.connecta.framework.core.domain.security.AuthenticationDTO;
import br.com.cds.connecta.framework.core.util.Util;
import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Julio Lemes
 * @date Jul 27, 2015
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {
    
    @Autowired SecurityConnector connector;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse resp = (HttpServletResponse) response;
        
        String userToken = req.getHeader("Authorization");
        Boolean hasToken = userToken != null && !userToken.isEmpty();

        if (!hasToken) {
            for (Cookie cookie : request.getCookies()) {
                if(cookie.getName().equals("Authorization")){
                    userToken = cookie.getValue();
                    hasToken = true;
                    break;
                }
            }
        }
        
        if(hasToken){
            AuthenticationDTO auth = connector.verifyAuthentication(userToken);
            if(Util.isNotNull(auth)){
                return true;
            }
        }

        sendUnauthorized(req, resp);
        return false;
    }
    
    protected void sendUnauthorized(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendError(401);
    }

}
