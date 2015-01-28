/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.core.bean.message;

import com.fasterxml.jackson.module.hibernate.HibernateModule;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Vinicius
 */
public class HibernateAwareObjectMapper extends ObjectMapper {

    public HibernateAwareObjectMapper() {
        registerModule(new HibernateModule());
    }
    
}
