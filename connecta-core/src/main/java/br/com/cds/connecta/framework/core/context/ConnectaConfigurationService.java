package br.com.cds.connecta.framework.core.context;

import java.io.IOException;
import java.util.Observable;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * Observable Singleton that gives access to constants in Connecta and
 * warns Observers of changes
 * 
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
public class ConnectaConfigurationService extends Observable {

    private static final String SOLR_INDEX_ROOT_PROP = "connecta.search.solrbackend";
    private static final String PORTAL_INDEX_ROOT_PROP = "connecta.portal.backend.url";
    private final Logger logger = Logger.getLogger(ConnectaConfigurationService.class);
    private static ConnectaConfigurationService instance;
    private ConnectaConfiguration configuration = new ConnectaConfiguration();

    private ConnectaConfigurationService() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
            configuration.setSolrBackend(props.getProperty(SOLR_INDEX_ROOT_PROP));
            configuration.setConnectaPortalBackend(props.getProperty(PORTAL_INDEX_ROOT_PROP));
            LdapConfiguration ldapConfig = initializeLdapConfigs(props);
            configuration.setLdapConfiguration(ldapConfig);
        } catch (IOException ex) {
            logger.error("Could not read application.properties", ex);
        }
    }
    
    private LdapConfiguration initializeLdapConfigs(Properties props) {
		LdapConfiguration ldapConfig = new LdapConfiguration();
		ldapConfig.setLdapUrl(props.getProperty(LdapConfiguration.LDAP_URL_PROPERTY));
		ldapConfig.setLdapBase(props.getProperty(LdapConfiguration.LDAP_BASE_PROPERTY));
		ldapConfig.setAuthMode(props.getProperty(LdapConfiguration.LDAP_AUTHMODE_PROPERTY));
		ldapConfig.setUser(props.getProperty(LdapConfiguration.LDAP_USER_PROPERTY));
		ldapConfig.setPassword(props.getProperty(LdapConfiguration.LDAP_PASSWORD_PROPERTY));
		
		return ldapConfig;
	}

	public static ConnectaConfigurationService getInstance() {
        if (instance == null) {
            instance = new ConnectaConfigurationService();
        }
        return instance;
    }

    public ConnectaConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ConnectaConfiguration configuration) {
        this.configuration = configuration;
        
        setChanged();
        notifyObservers(this);
    }
}
