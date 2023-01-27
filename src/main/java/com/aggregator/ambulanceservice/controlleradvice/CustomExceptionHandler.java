package com.aggregator.ambulanceservice.controlleradvice;

import com.aggregator.ambulanceservice.exception.AmbulanceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(AmbulanceNotFoundException.class)
    public ResponseEntity<HashMap<String,Object>> handleAmbulanceNotFoundException(AmbulanceNotFoundException ex){
        HashMap<String,Object>  errorRespondMap= new HashMap<>();  // Key is always String in Json Object, Vlaue can be anything, String, Int, boolean
        errorRespondMap.put("status","error");
        errorRespondMap.put("message",ex.getMessage());
        errorRespondMap.put("timestamp", new Date());
        return ResponseEntity.status(ex.getResponseCode()).body(errorRespondMap);

    }
}
