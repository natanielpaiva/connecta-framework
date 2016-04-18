package br.com.cds.connecta.framework.core.context;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import org.springframework.stereotype.Component;


/**
 *
 * @author Vinicius
 */
@Component
public class HibernateAwareObjectMapper extends ObjectMapper {

    public HibernateAwareObjectMapper() {
        Hibernate4Module hibernate4Module = new Hibernate4Module();
        
        hibernate4Module.configure(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION, false);

        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
       
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        registerModule(hibernate4Module);
    }
    
}
