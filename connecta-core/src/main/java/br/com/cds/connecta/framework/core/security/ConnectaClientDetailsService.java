package br.com.cds.connecta.framework.core.security;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author nataniel
 */
@Service
public class ConnectaClientDetailsService implements ClientDetailsService {
    
    private Map<String, ClientDetails> clients = new HashMap<>();

    public ConnectaClientDetailsService() {
        clients.put("", null);
    }
    
    @Override
    public ClientDetails loadClientByClientId(String string) throws ClientRegistrationException {
        
        
        return null;
    }
    
}
