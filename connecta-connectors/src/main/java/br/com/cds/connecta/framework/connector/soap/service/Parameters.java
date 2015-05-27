
package br.com.cds.connecta.framework.connector.soap.service;

/**
 *
 * @author diego
 */
public class Parameters {

    public Parameters(String attributes, String value) {
        this.attributes = attributes;
        this.value = value;
    }
    
     public Parameters() {
        
    }
    
    private String attributes;
    private String type;
    private String value;

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
     public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
