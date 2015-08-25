package br.com.cds.connecta.framework.connector.soap.service;

/**
 *
 * @author diego
 */
public class Parameters {

    private String params;
    private String attributes;
    private String value;

    public Parameters(String params, String attributes, String value) {
        this.params = params;
        this.attributes = attributes;
        this.value = value;
    }

    public Parameters(){}

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
    
    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
