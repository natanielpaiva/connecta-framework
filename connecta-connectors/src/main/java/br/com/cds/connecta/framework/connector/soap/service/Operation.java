package br.com.cds.connecta.framework.connector.soap.service;

import java.util.ArrayList;
/**
 *
 * @author diego
 */
public class Operation {
    
    private String operation;
   // private String soapAction;
    private ArrayList<Param> params;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

//    public String getSoapAction() {
//        return soapAction;
//    }
//
//    public void setSoapAction(String soapAction) {
//        this.soapAction = soapAction;
//    }
    
    public ArrayList<Param> getParams() {
        return params;
    }

    public void setParams(ArrayList<Param> params) {
        this.params = params;
    }

    
    
}
