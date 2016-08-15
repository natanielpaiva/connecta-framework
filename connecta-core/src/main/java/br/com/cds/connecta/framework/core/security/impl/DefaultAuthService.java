package br.com.cds.connecta.framework.core.security.impl;

import br.com.cds.connecta.framework.core.context.ConnectaConfigurationService;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Observable;
import java.util.Observer;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.cds.connecta.framework.core.security.IAuthService;

@Service("defaultAuthService")
public class DefaultAuthService implements IAuthService, Observer {

    private ConnectaConfigurationService connectaConfigurationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAuthService.class);
    private static final String ENDPOINT_URL = "/user/validarToken";

    private String connectaPortalUrl = "";

    @Override
    public boolean validateToken(String token) {
        connectaPortalUrl = connectaConfigurationService.getConfiguration().getConnectaPortalBackend();

        try {
            HttpURLConnection urlCon
                    = (HttpURLConnection) new URL(connectaPortalUrl + ENDPOINT_URL).openConnection();
            urlCon.addRequestProperty("Authorization", token);

            int status = urlCon.getResponseCode();

            if (status != HttpStatus.OK.value()) {
                LOGGER.error(urlCon.getResponseMessage());
                return false;
            }
        } catch (IOException e) {
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
