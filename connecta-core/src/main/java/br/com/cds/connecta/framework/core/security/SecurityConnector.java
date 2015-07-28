package br.com.cds.connecta.framework.core.security;

import br.com.cds.connecta.framework.core.domain.security.AuthenticationDTO;
import br.com.cds.connecta.framework.core.http.RestClient;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

/**
 *
 * @author Julio Lemes
 * @date Jul 27, 2015
 */
@Component
public class SecurityConnector {
    
    @Value("${auth.provider.url}")
    private String AUTH_PROVIDER_URL;
    
    private String AUTH_ENDPOINT;
    private String GET_AUTH_USER_ENDPOINT;
    
    @PostConstruct
    public void initializeURIs(){
        AUTH_ENDPOINT = AUTH_PROVIDER_URL + "/auth";
        GET_AUTH_USER_ENDPOINT = AUTH_ENDPOINT + "/{token}";
    }

    public AuthenticationDTO verifyAuthentication(String token) {
        try {
            return RestClient.request(GET_AUTH_USER_ENDPOINT, HttpMethod.GET, AuthenticationDTO.class, null, null, token);
        } catch (RestClientException e) {
            Logger.getLogger(SecurityConnector.class.getSimpleName()).severe(e.getMessage());
        }
        
        return null;
    }
}
