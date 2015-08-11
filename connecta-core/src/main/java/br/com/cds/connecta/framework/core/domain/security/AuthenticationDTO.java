package br.com.cds.connecta.framework.core.domain.security;

import java.util.List;

/**
 * @author Julio Lemes
 */
public class AuthenticationDTO {

    protected String userId;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String token;
    protected String password;
    protected List<String> authorizedApps;

    // getter / setters /////////////////
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAuthorizedApps(List<String> authorizedApps) {
        this.authorizedApps = authorizedApps;
    }

    public List<String> getAuthorizedApps() {
        return authorizedApps;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthenticationDto{" + "userId=" + userId + ", authorizedApps=" + authorizedApps + ", token=" + token + '}';
    }

}
