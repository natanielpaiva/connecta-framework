package br.com.cds.connecta.framework.connector.obiee.bean;

/**
 *
 * @author jhonatas
 */
public class UserBean {

    private String user;
    private String session;

    public UserBean() {
        this.user = new String();
        this.session = new String();
    }

    public UserBean(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

}
