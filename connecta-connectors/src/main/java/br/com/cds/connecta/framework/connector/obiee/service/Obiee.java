/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.connector.obiee.service;

import br.com.cds.connecta.framework.connector.obiee.SAWSessionService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author diego
 */
public final class Obiee {

    private SAWSessionService serviceSession;
    private String wsdlLocation, login, password, path, session;

    public Obiee(String wsdlLocation, String login, String password, String path) {
        this.wsdlLocation = wsdlLocation;
        this.login = login;
        this.password = password;
        this.path = path;
        this.session = serviceSession();
    }

    public Obiee() {
    }

    public List getCatalog() {
        CatalogService catalogService = new CatalogService(this.wsdlLocation);
        return catalogService.listFileBI(this.session, this.path);
    }
    
    
    public HashMap<String, List<String>> getMetadata() {
        ReportService reportService = new ReportService(this.wsdlLocation);
        HashMap metadata = reportService.getMetadata(this.path, this.session);
        return metadata;
    }

    public String serviceSession() {
        String ss = null;
        try {
            URL url = new URL(this.wsdlLocation);
            serviceSession = new SAWSessionService(url);
            ss = serviceSession.getSAWSessionServiceSoap().logon(this.login, this.password);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ss;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
