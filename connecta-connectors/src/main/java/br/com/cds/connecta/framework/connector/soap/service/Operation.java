
package br.com.cds.connecta.framework.connector.soap.service;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Operation {
    private String method;
    private ArrayList<Parameters> params;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ArrayList<Parameters> getParams() {
        return params;
    }

    public void setParams(ArrayList<Parameters> params) {
        this.params = params;
    }
    
    
}
