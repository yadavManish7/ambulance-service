package com.aggregator.ambulanceservice.controlleradvice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;

public class HttpExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HashMap<String,Object> errorResponseMap = new HashMap<>();
        errorResponseMap.put("status","error");
        errorResponseMap.put("message", ex.getMessage());
        errorResponseMap.put("timestamp",new Date());
        return ResponseEntity.status(status).body(errorResponseMap);
    }
}
