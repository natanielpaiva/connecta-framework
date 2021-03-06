package br.com.cds.connecta.framework.core.context;

/**
 * The Actual Configuration of Connecta
 *
 * @author Vinicius Pires <vinicius.pires@cds.com.br>
 */
public class ConnectaConfiguration {

    private String solrBackend;

    private String connectaPortalBackend;
    
    private LdapConfiguration ldapConfiguration;

    public String getSolrBackend() {
        return solrBackend;
    }

    public void setSolrBackend(String solrBackend) {
        this.solrBackend = solrBackend;
    }

    public String getConnectaPortalBackend() {
        return connectaPortalBackend;
    }

    public void setConnectaPortalBackend(String connectaPortalBackend) {
        this.connectaPortalBackend = connectaPortalBackend;
    }

	public LdapConfiguration getLdapConfiguration() {
		return ldapConfiguration;
	}

	public void setLdapConfiguration(LdapConfiguration ldapConfiguration) {
		this.ldapConfiguration = ldapConfiguration;
	}

}
