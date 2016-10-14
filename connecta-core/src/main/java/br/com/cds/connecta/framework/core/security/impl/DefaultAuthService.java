package br.com.cds.connecta.framework.core.security.impl;

import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.cds.connecta.framework.core.context.ConnectaConfigurationService;
import br.com.cds.connecta.framework.core.security.IAuthService;

@Service("defaultAuthService")
public class DefaultAuthService implements IAuthService, Observer {

    private ConnectaConfigurationService connectaConfigurationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAuthService.class);
    private static final String ENDPOINT_URL_TOKEN = "/user/token/validate";
    private static final String ENDPOINT_URL_PUBLIC_KEY = "/dashboard/public/publicKey/validate?key={key}&viewerId={id}";
    private static final String ENDPOINT_URL_PUBLIC_KEY_DASH = "/dashboard/public/publicKey/validateDash?key={key}&dashId={id}";


    private String connectaPortalUrl = "";

    @Override
    public boolean validateToken(String token) {
        connectaPortalUrl = connectaConfigurationService.getConfiguration().getConnectaPortalBackend();

        try {
        	HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", token);
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            
        	RestTemplate restTemplate = new RestTemplate();
        	ResponseEntity<String> response =
        			restTemplate.exchange(connectaPortalUrl + ENDPOINT_URL_TOKEN, HttpMethod.GET, entity, String.class);
        	
        	if(response.getStatusCode() != HttpStatus.OK){
        		LOGGER.error("Validação não foi bem sucedida. Resposta:", response);
        		return false;
        	}
        } catch (HttpClientErrorException e) {
            LOGGER.error("Não foi possível se conectar ao Portal", e);
            return false;
        }

        return true;
    }
    
    @Override
    public boolean validatePublicKey(String publicKey, String viewerId) {
        connectaPortalUrl = connectaConfigurationService.getConfiguration().getConnectaPortalBackend();

        try {
        	RestTemplate restTemplate = new RestTemplate();
        	ResponseEntity<String> response = 
        			restTemplate.getForEntity(connectaPortalUrl + ENDPOINT_URL_PUBLIC_KEY, String.class, publicKey, viewerId);
        	
        	if(response.getStatusCode() != HttpStatus.OK){
        		LOGGER.error("Validação não foi bem sucedida. Resposta:", response);
        		return false;
        	}
        } catch (HttpClientErrorException e) {
            LOGGER.error("Não foi possível se conectar ao Portal", e);
            return false;
        }

        return true;
    }
    
	@Override
	public boolean validatePublicKeyDash(String publicKey, String dashId) {
        connectaPortalUrl = connectaConfigurationService.getConfiguration().getConnectaPortalBackend();

        try {
        	RestTemplate restTemplate = new RestTemplate();
        	ResponseEntity<String> response = 
        			restTemplate.getForEntity(connectaPortalUrl + ENDPOINT_URL_PUBLIC_KEY_DASH, String.class, publicKey, dashId);
        	
        	if(response.getStatusCode() != HttpStatus.OK){
        		LOGGER.error("Validação não foi bem sucedida. Resposta:", response);
        		return false;
        	}
        } catch (HttpClientErrorException e) {
            LOGGER.error("Não foi possível se conectar ao Portal", e);
            return false;
        }

        return true;
	}

    @Autowired
    public void setConnectaConfigurationService(ConnectaConfigurationService connectaConfigurationService) {
        this.connectaConfigurationService = connectaConfigurationService;

        this.connectaConfigurationService.addObserver(this);
    }

    @Override
    public void update(Observable o, Object o1) {
        connectaPortalUrl = connectaConfigurationService.getConfiguration().getConnectaPortalBackend();
    }

}
