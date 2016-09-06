package br.com.cds.connecta.framework.core.context;

public class LdapConfiguration {
	
	private String ldapUrl;
	private String ldapBase;
	private String authMode;
	private String user;
	private String password;
	
	public static final String LDAP_URL_PROPERTY = "ldap.url";
	public static final String LDAP_BASE_PROPERTY = "ldap.base";
	public static final String LDAP_AUTHMODE_PROPERTY = "ldap.authmode";
	public static final String LDAP_USER_PROPERTY = "ldap.user";
	public static final String LDAP_PASSWORD_PROPERTY = "ldap.password";
	
	public String getLdapUrl() {
		return ldapUrl;
	}
	public void setLdapUrl(String ldapUrl) {
		this.ldapUrl = ldapUrl;
	}
	public String getLdapBase() {
		return ldapBase;
	}
	public void setLdapBase(String ldapBase) {
		this.ldapBase = ldapBase;
	}
	public String getAuthMode() {
		return authMode;
	}
	public void setAuthMode(String authMode) {
		this.authMode = authMode;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
