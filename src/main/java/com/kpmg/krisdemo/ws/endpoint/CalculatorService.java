package com.kpmg.krisdemo.ws.endpoint;

import com.kpmg.krisdemo.types.calculator.*;
import com.kpmg.krisdemo.ws.util.JsonUtil;
import com.kpmg.krisdemo.ws.util.RecordTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculatorService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ResponsePayload
    @PayloadRoot(namespace = "http://kpmg.com/krisdemo/types/calculator", localPart = "AdditionInput")
    public Output addition(@RequestPayload AdditionInput input) {
        logger.info("Request received for addition with input {} and {} ", input.getNumber1(), input.getNumber2() );
        String payload = JsonUtil.toJson(input);
        logger.info("payload = {}", JsonUtil.toJson(input));
        RecordTransaction.recordTransaction(
                "CALC_API",
                "SOAP",
                "POST",
                payload,
                null,
                ""
        );
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() + input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://kpmg.com/krisdemo/types/calculator", localPart = "SubtractionInput")
    public Output subtraction(@RequestPayload SubtractionInput input){
        logger.info("Request received for subtraction with input {} and {} ", input.getNumber1(), input.getNumber2() );
        String payload = JsonUtil.toJson(input);
        logger.info("payload = {}", JsonUtil.toJson(input));
        RecordTransaction.recordTransaction(
                "CALC_API",
                "SOAP",
                "POST",
                payload,
                null,
                ""
        );
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() - input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://kpmg.com/krisdemo/types/calculator", localPart = "MultiplicationInput")
    public Output multiplication(@RequestPayload MultiplicationInput input){
        logger.info("Request received for multiplication with input {} and {} ", input.getNumber1(), input.getNumber2() );
        String payload = JsonUtil.toJson(input);
        logger.info("payload = {}", JsonUtil.toJson(input));
        RecordTransaction.recordTransaction(
                "CALC_API",
                "SOAP",
                "POST",
                payload,
                null,
                ""
        );
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() * input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://kpmg.com/krisdemo/types/calculator", localPart = "DivisionInput")
    public Output division(@RequestPayload DivisionInput input){
        logger.info("Request received for division with input {} and {} ", input.getNumber1(), input.getNumber2() );
        String payload = JsonUtil.toJson(input);
        logger.info("payload = {}", JsonUtil.toJson(input));
        RecordTransaction.recordTransaction(
                "CALC_API",
                "SOAP",
                "POST",
                payload,
                null,
                ""
        );
        if(input.getNumber2() == 0){
            throw new IllegalArgumentException("Divisor can't be null");
        }
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() / input.getNumber2());
        return output;
    }
}
