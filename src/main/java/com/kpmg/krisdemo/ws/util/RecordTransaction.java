package com.kpmg.krisdemo.ws.util;

import com.kpmg.krisdemo.ws.model.PostTransactionRequest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordTransaction {

    private static Logger logger = LoggerFactory.getLogger(RecordTransaction.class);

    public static final String SERVICE_URL = "https://api-call-tracker-3scale-apicast-staging.apps.kpmgocp.stotenrhos.com:443/transaction?user_key=263a0141941df8e92d916138837a2ebe";
//    public static final String SERVICE_URL = "http://api-call-tracker-api-call-tracker.apps.kpmgocp.stotenrhos.com/transaction";
//    public static final String SERVICE_URL = "http://localhost:8080/transaction";

    public static void recordTransaction(
            String apiName,
            String apiType,
            String verb,
            String user_key,
            String originationSystemId
    ) {
        PostTransactionRequest postTransactionRequest = new PostTransactionRequest();
        postTransactionRequest.setApiName(apiName);
        postTransactionRequest.setApiType(apiType);
        postTransactionRequest.setVerb(verb);
        postTransactionRequest.setSubscriberId(user_key == null ? "6574c1909fe0da5a8ebf108c7c8fc0f6" : user_key);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowStr = simpleDateFormat.format(now);
        postTransactionRequest.setRequestDateTime(nowStr);
        postTransactionRequest.setOriginatingSystemId(originationSystemId);
        try {
            HttpResponse<JsonNode> response = Unirest.post(SERVICE_URL)
                    .header("Content-Type", "application/json")
                    .body(postTransactionRequest)
                    .asJson();
            logger.info("response status code = {}", response.getStatus());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static void recordTransaction(
            String apiName,
            String apiType,
            String verb,
            String payload,
            String user_key,
            String originationSystemId
    ) {
        PostTransactionRequest postTransactionRequest = new PostTransactionRequest();
        postTransactionRequest.setApiName(apiName);
        postTransactionRequest.setApiType(apiType);
        postTransactionRequest.setVerb(verb);
        postTransactionRequest.setSubscriberId(user_key == null ? "6574c1909fe0da5a8ebf108c7c8fc0f6" : user_key);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowStr = simpleDateFormat.format(now);
        postTransactionRequest.setRequestDateTime(nowStr);
        postTransactionRequest.setPayload(payload);
        postTransactionRequest.setOriginatingSystemId(originationSystemId);
        try {
            HttpResponse<JsonNode> response = Unirest.post(SERVICE_URL)
                    .header("Content-Type", "application/json")
                    .header("user_key", "263a0141941df8e92d916138837a2ebe")
                    .body(postTransactionRequest)
                    .asJson();
            logger.info("response status code = {}", response.getStatus());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

}
