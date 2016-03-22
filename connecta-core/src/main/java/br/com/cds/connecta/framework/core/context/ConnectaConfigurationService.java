package br.com.cds.connecta.framework.core.context;

import java.io.IOException;
import java.util.Observable;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Observable Singleton that gives access to constants in Connecta and
 * warns Observers of changes
 * 
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
@Component
public class ConnectaConfigurationService extends Observable {

    private static final String SOLR_INDEX_ROOT_PROP = "connecta.search.solrbackend";
    private final Logger logger = Logger.getLogger(ConnectaConfigurationService.class);

    private ConnectaConfiguration configuration = new ConnectaConfiguration();

    public ConnectaConfigurationService() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
            configuration.setSolrBackend(props.getProperty(SOLR_INDEX_ROOT_PROP));
        } catch (IOException ex) {
            logger.error("Could not read application.properties", ex);
        }
    }

    public ConnectaConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ConnectaConfiguration configuration) {
        this.configuration = configuration;

        setChanged();
        notifyObservers(this);
    }

    /**
     * The Actual Configuration of Connecta
     */
    public class ConnectaConfiguration {
        private String solrBackend;

        public String getSolrBackend() {
            return solrBackend;
        }
        
        public void setSolrBackend(String solrBackend) {
            this.solrBackend = solrBackend;
        }
    }
}
