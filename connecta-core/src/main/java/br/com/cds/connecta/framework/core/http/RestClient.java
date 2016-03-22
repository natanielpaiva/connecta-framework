package br.com.cds.connecta.framework.core.http;

import br.com.cds.connecta.framework.core.util.Util;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Julio Lemes
 */
@Component
public class RestClient {
    
    private static final Logger logger = Logger.getLogger(RestClient.class);
    
    public static <T> T getForObject(String url, Class<T> responseObj, Object... urlVariables){
        return getRestClient().getForObject(url, responseObj, urlVariables);
    }
    
    public static <T> T postForObject(String url, Object content, Class<T> responseObj, Object... urlVariables){
        return getRestClient().postForObject(url, content, responseObj, urlVariables);
    }
    
    public static <T> T postForObject(String url, Object content, Map<String, String> headers, 
            Class<T> responseObj, Object... urlVariables){
        
        HttpEntity entity = getJsonContentHttpEntity(content, headers);
        RestTemplate restClient = getJsonRestClient();
        
        ResponseEntity<T> response = restClient.exchange(url, HttpMethod.POST, entity, responseObj, urlVariables);
        
        return response.getBody();
    }
    
    public static <T> T putForObject(String url, Object content, Map<String, String> headers, 
            Class<T> responseObj, Object... urlVariables){

        HttpEntity entity = getJsonContentHttpEntity(content, headers);
        RestTemplate restClient = getJsonRestClient();
        
        ResponseEntity<T> response = restClient.exchange(url, HttpMethod.PUT, entity, responseObj, urlVariables);
        
        return response.getBody();
    }
    
    public static <T> T formRequest(String url, HttpMethod method, Class<T> responseObj, 
            Object content, Map<String, String> headerMap, Object... urlVariables){
        
        HttpEntity entity = getFormContentHttpEntity(content, headerMap);
        RestTemplate restClient = getFormPostRestClient();
        
        ResponseEntity<T> response = restClient.exchange(url, method, entity, responseObj, urlVariables);
        
        logger.debug(response.getBody());
        
        return response.getBody();
    }

    private static HttpHeaders getJsonHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
    
    private static HttpEntity getJsonContentHttpEntity(Object content, Map<String,String> headers){
        HttpHeaders httpHeaders = getJsonHttpHeaders();
        
        if(!Util.isEmpty(headers)){
            httpHeaders.setAll(headers);
        }
        
        return new HttpEntity<>(content, httpHeaders);
    }
    
    private static HttpEntity getFormContentHttpEntity(Object content, Map<String,String> headers){
        HttpHeaders httpHeaders = getFormContentHttpHeaders();
        
        if(!Util.isEmpty(headers)){
            httpHeaders.setAll(headers);
        }
        
        return new HttpEntity<>(content, httpHeaders);
    }
    
    
    private static HttpHeaders getFormContentHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }

    private static RestTemplate getFormPostRestClient(){
        return getRestClient(
                new FormHttpMessageConverter(), 
                new MappingJackson2HttpMessageConverter()
        );
    }

    private static RestTemplate getJsonRestClient(){
        return getRestClient(new MappingJackson2HttpMessageConverter());
    }
   
    
    private static <T> RestTemplate getRestClient(HttpMessageConverter<?>... converters){
        RestTemplate client = getRestClient();
        client.setMessageConverters(Arrays.asList(converters));
        return client;
    }
    
    protected static RestTemplate getRestClient(){
        return new RestTemplate();
    }
}
