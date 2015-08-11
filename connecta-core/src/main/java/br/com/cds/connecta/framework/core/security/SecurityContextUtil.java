package br.com.cds.connecta.framework.core.security;

import br.com.cds.connecta.framework.core.domain.security.AuthenticationDTO;

/**
 *
 * @author Julio Lemes
 * @date Aug 7, 2015
 */
public class SecurityContextUtil {

    private static AuthenticationDTO currentUser;

    public static AuthenticationDTO getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(AuthenticationDTO currentUser) {
        SecurityContextUtil.currentUser = currentUser;
    }

}
