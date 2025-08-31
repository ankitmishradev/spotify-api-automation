package models;

import utils.Config;

import java.util.HashMap;
import java.util.Map;

public class RequestModel {
    private String endpoint;
    private Map<String, String> headers;
    private Map<String, ?> params;
    private Map<String, ?> body;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, ?> getBody() {
        return body;
    }

    public void setBody(Map<String, String> body) {
        this.body = body;
    }

    public Map<String, ?> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public void setAuthorization() {
        if (headers == null) headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + Config.ACCESS_TOKEN);
    }
}