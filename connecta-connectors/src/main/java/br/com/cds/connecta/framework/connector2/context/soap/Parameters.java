package br.com.cds.connecta.framework.connector2.context.soap;

/**
 *
 * @author diego
 */
public class Parameters {

    private String type;
    private String attribute;
    private String value;

    public Parameters(String attributes, String value, String type) {
        this.attribute = attribute;
        this.value = value;
        this.type = type;
    }

    public Parameters(String attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

    public Parameters() {
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
