package br.com.cds.connecta.framework.core.http;

import br.com.cds.connecta.framework.core.util.Util;
import java.util.Arrays;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Julio Lemes
 * @date Jul 24, 2015
 */
@Component
public class RestClient {
    
    
    public static <T> T getForObject(String url, Class<T> responseObj, Object... urlVariables){
        return getRestClient().getForObject(url, responseObj, urlVariables);
    }
    
    public static <T> T postForObject(String url, Object request, Class<T> responseObj, Object... urlVariables){
        return getRestClient().postForObject(url, request, responseObj, urlVariables);
    }
    
    public static <T> T request(String url, HttpMethod method, Class<T> responseObj, 
            MultiValueMap<String, String> params, Map<String, String> headerMap, Object... urlVariables){
        
        HttpEntity<MultiValueMap<String, String>> entity = getAcceptJsonEntity(params, headerMap);
        RestTemplate restClient = getFormPostRestClient();
        
        ResponseEntity<T> response = restClient.exchange(url, method, entity, responseObj, urlVariables);
        
        return response.getBody();
    }

    private static HttpEntity<MultiValueMap<String, String>> getAcceptJsonEntity(
            MultiValueMap<String, String> params, Map<String, String> headerMap) {
        HttpHeaders headers = createHttpHeader(headerMap, MediaType.APPLICATION_JSON);
        return new HttpEntity<>(params, headers);
    }

    private static HttpHeaders createHttpHeader(Map<String, String> headerMap, MediaType... accept) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(accept));
        
        if(!Util.isEmpty(headerMap)){
            headers.setAll(headerMap);
        }
        
        return headers;
    }
    
    
    
    private static RestTemplate getFormPostRestClient(){
        return getRestClient(
                new FormHttpMessageConverter(), 
                new MappingJackson2HttpMessageConverter()
        );
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
