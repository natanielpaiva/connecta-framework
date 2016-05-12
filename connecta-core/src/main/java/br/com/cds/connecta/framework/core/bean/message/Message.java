package br.com.cds.connecta.framework.core.bean.message;

/**
 * Classe para transpote de informações de erro ou alerta.
 */
public class Message {

    private String key;
    private String message;
    private Object[] params;

    public Message() {
    }

    public Message(String key, String message, Object[] params) {
        this.key = key;
        this.message = message;
        this.params = params;
    }

    public Message(String key, Object[] params) {
        this.key = key;
        this.params = params;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

}
