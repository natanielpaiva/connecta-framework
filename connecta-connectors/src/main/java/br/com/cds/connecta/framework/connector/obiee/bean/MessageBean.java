package br.com.cds.connecta.framework.connector.obiee.bean;

/**
 * @class Erro
 * @author jhonatas
 */
public class MessageBean {

    private String error;
    private String success;

    public MessageBean() {
        error = null;
        success = null;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

}
