package br.com.cds.connecta.framework.core.security;

import br.com.cds.connecta.framework.core.domain.security.UserDTO;
import br.com.cds.connecta.framework.core.http.RestClient;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientException;

/**
 *
 * @author Julio Lemes
 * @date Jul 27, 2015
 */
public class SecurityConnector {

    private String authProviderUrl;
    private String authEndpoint;
    private String getAuthUserEndpoint;

    @PostConstruct
    public void initializeURIs() {
        authEndpoint = authProviderUrl + "/public/auth";
        getAuthUserEndpoint = authEndpoint + "/{token}";
    }

    public UserDTO getAuthenticatedUser(String token) {
        try {
            return RestClient.request(getAuthUserEndpoint, HttpMethod.GET, UserDTO.class, null, null, token);
        } catch (RestClientException e) {
            Logger.getLogger(SecurityConnector.class.getSimpleName()).severe(e.getMessage());
        }

        return null;
    }
    
    public String getAuthProviderUrl() {
        return authProviderUrl;
    }

    public void setAuthProviderUrl(String authProviderUrl) {
        this.authProviderUrl = authProviderUrl;
    }

}
