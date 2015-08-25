package br.com.cds.connecta.framework.connector.soap.service;

import java.util.ArrayList;
/**
 *
 * @author diego
 */
public class Operation {
    
    private String operation;
    private ArrayList<Parameters> parameters;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    public ArrayList<Parameters> getParams() {
        return parameters;
    }

    public void setParams(ArrayList<Parameters> params) {
        this.parameters = params;
    }

}
