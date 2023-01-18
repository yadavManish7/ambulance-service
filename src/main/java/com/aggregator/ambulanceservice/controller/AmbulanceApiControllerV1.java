package com.aggregator.ambulanceservice.controller;

import com.aggregator.ambulanceservice.model.Address;
import com.aggregator.ambulanceservice.model.Ambulance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//@Controller   // For Websites
@RestController  //For API
@RequestMapping(value = "/api/v1")  // for request handling methods
public class AmbulanceApiControllerV1 {


    @GetMapping(value = "/ping")
    public String ping() {
        return "Rest Controller executed in V1";
    }

    @GetMapping(value = "/ambulance")
    public ResponseEntity<Ambulance> getAmbulanceDetail() {
        Address address = new Address("Bonnie Brae", "TX", "Denton", "76201");//Ambulance is dependent to ADDRESS class
        List<String> phoneNumbers = List.of("123-234-5366", "394-384-0989"); //List.of() to create small list of element
        Ambulance ambulance = new Ambulance("Blue cross blue shield", phoneNumbers, 78.07, 77.79, true, LocalDate.now(), address);
        return ResponseEntity.status(HttpStatus.OK).body(ambulance); //Returning ambulance OBJECT
    }

    @PostMapping(value = "/ambulance")
    public ResponseEntity<Ambulance> addAmbulance() {
        Address address = new Address("Bonnie Brae", "TX", "Denton", "76201");//Ambulance is dependent to ADDRESS class
        List<String> phoneNumbers = List.of("123-234-5366", "394-384-0989"); //List.of() to create small list of element
        Ambulance ambulance = new Ambulance("Blue cross blue shield", phoneNumbers, 78.07, 77.79, true, LocalDate.now(), address);
        return ResponseEntity.status(HttpStatus.CREATED).body(ambulance);
    }

    @PutMapping(value = "/ambulance")
    public ResponseEntity<Ambulance> editAmbulance() {
        Address address = new Address("Bonnie Brae", "TX", "Denton", "76201");//Ambulance is dependent to ADDRESS class
        List<String> phoneNumbers = List.of("123-234-5366", "394-384-0989"); //List.of() to create small list of element
        Ambulance ambulance = new Ambulance("Blue cross blue shield", phoneNumbers, 78.07, 77.79, true, LocalDate.now(), address);
        return ResponseEntity.status(HttpStatus.OK).body(ambulance); //Returning ambulance OBJECT
    }

    @DeleteMapping(value = "/ambulance")
    public ResponseEntity deleteAmbulance() {
        Address address = new Address("Bonnie Brae", "TX", "Denton", "76201");//Ambulance is dependent to ADDRESS class
        List<String> phoneNumbers = List.of("123-234-5366", "394-384-0989"); //List.of() to create small list of element
        Ambulance ambulance = new Ambulance("Blue cross blue shield", phoneNumbers, 78.07, 77.79, true, LocalDate.now(), address);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ambulance);
    }

    @GetMapping(value = "/ambulanceList")
    public ResponseEntity<List<Ambulance>> ambulanceList() {
        Address address = new Address("Bonnie Brae", "TX", "Denton", "76201");//Ambulance is dependent to ADDRESS class
        List<String> phoneNumbers = List.of("123-234-5366", "394-384-0989");
        Ambulance ambulance1 = new Ambulance("Blue cross blue shield", phoneNumbers, 78.07, 77.79, true, LocalDate.now(), address);
        Ambulance ambulance2 = new Ambulance("Texas Medical center", phoneNumbers, 78.07, 77.79, true, LocalDate.now(), address);
        return ResponseEntity.status(HttpStatus.OK).body(List.of(ambulance1, ambulance2));
    }


    @GetMapping(value = "/soapApiDemo")   //Soap api example
    public String ambulanceSoapApiDemo() {
        return " <ambulances>\n" +
                "        <ambulance>\n" +
                "            <name>Blue cross </name>\n" +
                "            <phone> 293-4958-9889 </phone>\n" +
                "        <ambulance>\n" +
                "         <ambulance>\n" +
                "             <name>Texas MD</name>\n" +
                "             <phone> 490-4958-9889 </phone>\n" +
                "        <ambulance>\n" +
                "    </ambulances>";
    }

/* JSON  notes  Lightweight format

    {}  Empty json object
    []  json array   Java List -> json array

*/


//SOAP Api format  heavyweight format

    /*
    <ambulances>
        <ambulance>
            <name>Blue cross </name>
            <phone> 293-4958-9889 </phone>
        <ambulance>
         <ambulance>
             <name>Texas MD</name>
             <phone> 490-4958-9889 </phone>
        <ambulance>

    </ambulances>
     */


}
