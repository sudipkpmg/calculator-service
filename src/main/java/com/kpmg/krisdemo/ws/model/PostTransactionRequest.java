package com.kpmg.krisdemo.ws.model;

public class PostTransactionRequest {

    private String subscriberId;
    private String apiName;
    private String apiType;
    private String verb;
    private String requestDateTime;
    private String payload;
    private String originatingSystemId;

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiType() {
        return apiType;
    }

    public void setApiType(String apiType) {
        this.apiType = apiType;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(String requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getOriginatingSystemId() {
        return originatingSystemId;
    }

    public void setOriginatingSystemId(String originatingSystemId) {
        this.originatingSystemId = originatingSystemId;
    }

}
