package br.com.cds.connecta.framework.core.security;

import br.com.cds.connecta.framework.core.domain.security.AuthenticationDTO;
import br.com.cds.connecta.framework.core.http.RestClient;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.web.client.RestClientException;

/**
 *
 * @author Julio Lemes
 */
public class SecurityConnector {

    private String authProviderUrl;
    private String authEndpoint;
    private String getAuthUserEndpoint;

    @PostConstruct
    public void initializeURIs() {
        authEndpoint = authProviderUrl + "/auth";
        getAuthUserEndpoint = authEndpoint + "/{token}";
    }

    public AuthenticationDTO getAuthenticatedUser(String token) {
        try {
            return RestClient.getForObject(getAuthUserEndpoint, AuthenticationDTO.class, token);
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
