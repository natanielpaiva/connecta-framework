/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cds.connecta.framework.core.bean.message;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Component;


/**
 *
 * @author Vinicius
 */
@Component
public class HibernateAwareObjectMapper extends ObjectMapper {

    public HibernateAwareObjectMapper() {
        final Hibernate4Module hibernate4Module = new Hibernate4Module();
        
//        hibernate4Module.enable(Hibernate4Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
        
        registerModule(hibernate4Module);
    }

    @Override
    public void writeValue(File resultFile, Object value) throws IOException, JsonGenerationException, JsonMappingException {
        System.out.println("AQUI!!!!!!!!!!!!!!!!!!!!!!!!!!");
        super.writeValue(resultFile, value); //To change body of generated methods, choose Tools | Templates.
    }
    
}
