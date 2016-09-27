/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.connector.obiee.service;

import br.com.cds.connecta.framework.connector.obiee.SAWSessionService;
import br.com.cds.connecta.framework.connector.obiee.bean.UserBean;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.xml.ws.soap.SOAPFaultException;

/**
 *
 * @author diego
 */
public class Login {

    private SAWSessionService serviceSession;

    private UserBean user;

    public Login(){}

    public Login(String wsdlLocation) {

        URL url = null;

        try {
            url = new URL(wsdlLocation);
            serviceSession = new SAWSessionService(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public String login(String wsdlLocation, String login, String password) {
        URL url = null;
        try {
            url = new URL(wsdlLocation);
            serviceSession = new SAWSessionService(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return serviceSession.getSAWSessionServiceSoap().logon(login, password);

    }
}
