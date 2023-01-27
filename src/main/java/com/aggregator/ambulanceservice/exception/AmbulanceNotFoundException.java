package com.aggregator.ambulanceservice.exception;

import lombok.Getter;

public class AmbulanceNotFoundException extends  RuntimeException{

    private String message;
    @Getter
    private  int responseCode;

    public AmbulanceNotFoundException(String message, int responseCode){
        super(message);  //To show message in console i.e postman "message" : ""
        this.message=message;
        this.responseCode=responseCode;
    }
}
