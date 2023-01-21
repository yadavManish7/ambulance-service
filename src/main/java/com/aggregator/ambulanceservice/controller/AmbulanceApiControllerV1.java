package com.aggregator.ambulanceservice.controller;

import com.aggregator.ambulanceservice.dto.AddressDTO;
import com.aggregator.ambulanceservice.dto.AmbulanceDTO;
import com.aggregator.ambulanceservice.model.Address;
import com.aggregator.ambulanceservice.model.Ambulance;
import com.aggregator.ambulanceservice.service.AmbulanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1")  // for request handling methods

public class AmbulanceApiControllerV1 {

@Autowired
private AmbulanceService ambulanceService;

    @GetMapping(value = "/ping")
    public String ping() {
        return "Rest Controller executed in V1";
    }

    @GetMapping(value = "/ambulance/{id}")
    public ResponseEntity<Ambulance> getAmbulanceDetail(@PathVariable(value = "id") String ambulanceId ) {    //UUID generates Unique key
       Optional<Ambulance>  optionalAmbulance = ambulanceService.getAmbulanceDetail(ambulanceId);
        return optionalAmbulance.map(ambulance -> ResponseEntity.status(HttpStatus.OK).body(ambulance)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping(value = "/ambulance")
    public  ResponseEntity<Ambulance> createAmbulance(@RequestBody AmbulanceDTO ambulanceDTO) {//AmbulanceDto is Object asking from User
        Ambulance  createdAmbulance =ambulanceService.createAmbulance(ambulanceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAmbulance);
    }

    @PutMapping(value = "/ambulance/{id}")
    public ResponseEntity<Ambulance> updateAmbulance(@PathVariable(value = "id") String ambulanceId, @RequestBody AmbulanceDTO ambulanceDTO) {
          Ambulance updatedAmbulance  =ambulanceService.updateAmbulance(ambulanceId,ambulanceDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAmbulance); //Returning updated ambulance OBJECT
    }

    @DeleteMapping(value = "/ambulance/{id}")
    public ResponseEntity<String> deleteAmbulance(@PathVariable(value = "id") String ambulanceId) {
        ambulanceService.deleteAmbulance(ambulanceId);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deleted");
    }

    @GetMapping(value = "/ambulance/list")  //@RequestParam used for filtration
    public ResponseEntity<List<Ambulance>> getAmbulanceList(@RequestParam(value = "city",required = false)String cityName,@RequestParam(value = "lat",required = false) Double lat,@RequestParam(value = "lon",required = false) Double lon) {
        List<Ambulance> ambulanceList =ambulanceService.getAmbulanceList();
        return ResponseEntity.status(HttpStatus.OK).body(ambulanceList);
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
