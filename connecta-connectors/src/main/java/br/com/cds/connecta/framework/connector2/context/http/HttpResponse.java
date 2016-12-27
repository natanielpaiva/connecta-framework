package br.com.cds.connecta.framework.connector2.context.http;

import java.util.List;

/**
 *
 * @author diego
 */
public class HttpResponse {
    
    private List<Header> headers;
    private String body;
    private String statusCode;

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    
}
