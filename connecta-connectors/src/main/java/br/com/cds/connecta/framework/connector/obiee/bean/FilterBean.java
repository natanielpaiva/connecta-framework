package br.com.cds.connecta.framework.connector.obiee.bean;

import java.util.Set;

/**
 *
 * @author jhonatas
 */
public class FilterBean {

    private String name;
    private Set<String> values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getValues() {
        return values;
    }

    public void setValues(Set<String> values) {
        this.values = values;
    }

}
