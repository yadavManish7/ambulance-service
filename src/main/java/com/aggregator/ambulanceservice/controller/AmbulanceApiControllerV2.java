package com.aggregator.ambulanceservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller   // For Websites
@RestController  //For API
@RequestMapping(value = "/api/v2")  // for request handling methods
public class AmbulanceApiControllerV2 {

    @GetMapping(value = "/greeting")
    public String greetingMessage(){
        String msg = "Welcome to springboot V2";
        return msg;
    }


    @GetMapping(value = "/ping")
    public String ping (){
        return "Rest Controller executed V2";
    }

    @GetMapping(value = "/ambulance")
    public String listOfAmbulance(){
        return "List of ambulances V2";
    }




}
