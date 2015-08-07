package br.com.cds.connecta.framework.core.security;

import br.com.cds.connecta.framework.core.domain.security.UserDTO;
import br.com.cds.connecta.framework.core.util.Util;
import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Julio Lemes
 * @date Jul 27, 2015
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    private SecurityConnector connector;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse resp = (HttpServletResponse) response;

        String userToken = req.getHeader("Authorization");
        Boolean hasToken = userToken != null && !userToken.isEmpty();

        if (!hasToken && Util.isNotEmpty(request.getCookies())) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("Authorization")) {
                    userToken = cookie.getValue();
                    hasToken = true;
                    break;
                }
            }
        }

        if (hasToken) {
            UserDTO auth = connector.getAuthenticatedUser(userToken);
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
