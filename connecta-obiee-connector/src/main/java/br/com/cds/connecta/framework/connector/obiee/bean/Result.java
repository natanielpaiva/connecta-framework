/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.connector.obiee.bean;

import java.util.Map;

/**
 *
 * @author diego
 */
public class Result {
    
    Map<String, Object> map;
    
    public void put(String key, Object value ){
        map.put(key, value);
    }
    
}
