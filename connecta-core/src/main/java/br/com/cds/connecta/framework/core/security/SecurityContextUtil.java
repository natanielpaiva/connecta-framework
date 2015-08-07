package br.com.cds.connecta.framework.core.security;

import br.com.cds.connecta.framework.core.domain.security.UserDTO;

/**
 *
 * @author Julio Lemes
 * @date Aug 7, 2015
 */
public class SecurityContextUtil {

    private static UserDTO currentUser;

    public static UserDTO getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(UserDTO currentUser) {
        SecurityContextUtil.currentUser = currentUser;
    }

}
