package br.com.cds.connecta.framework.core.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author pires
 */
@Component
public class MockMvcProvider {
    
    @Autowired
    private WebApplicationContext wac;
    
    private MockMvc mockMvc;

    public MockMvc getInstance() {
        if ( mockMvc == null ) {
            mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        }
        return mockMvc;
    }
}
