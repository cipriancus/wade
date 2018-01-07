package com.wade.cryma.crymapythonprediction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.SERVICE_UNAVAILABLE, reason="Could not provide response for request")
public class RequestNoResponseException  extends RuntimeException{
    public RequestNoResponseException(){
        super();
    }
}
