package com.aggregator.ambulanceservice.controller;

import com.aggregator.ambulanceservice.dto.AmbulanceDTO;
import com.aggregator.ambulanceservice.model.Ambulance;
import com.aggregator.ambulanceservice.service.AmbulanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")  // for request handling methods

public class AmbulanceApiControllerV1 {

@Autowired
private AmbulanceService ambulanceService;

    @Operation(summary = "Get ambulance by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Ambulance",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Ambulance.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Ambulance not found",
                    content = @Content) })
    @GetMapping(value = "/ambulance/{id}")
    public ResponseEntity<Ambulance> getAmbulanceDetail(@PathVariable(value = "id") Long ambulanceId ) {    //UUID generates Unique key
       Ambulance ambulance= ambulanceService.getAmbulanceDetail(ambulanceId);
        return ResponseEntity.status(HttpStatus.OK).body(ambulance);
    }

    @Operation(summary = "Create new ambulance")

    @PostMapping(value = "/ambulance")
    public  ResponseEntity<Ambulance> createAmbulance(@RequestBody AmbulanceDTO ambulanceDTO) {//AmbulanceDto is Object asking from User
        Ambulance  createdAmbulance =ambulanceService.createAmbulance(ambulanceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAmbulance);
    }
    @Operation(summary = "Update ambulance by id")
    @PutMapping(value = "/ambulance/{id}")
    public ResponseEntity<Ambulance> updateAmbulance(@PathVariable(value = "id") Long ambulanceId, @RequestBody AmbulanceDTO ambulanceDTO) {
          Ambulance updatedAmbulance  =ambulanceService.updateAmbulance(ambulanceId,ambulanceDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAmbulance); //Returning updated ambulance OBJECT
    }
    @Operation(summary = "Delete ambulance by id")
    @DeleteMapping(value = "/ambulance/{id}")
    public ResponseEntity<String> deleteAmbulance(@PathVariable(value = "id") Long ambulanceId) {
        ambulanceService.deleteAmbulance(ambulanceId);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deleted");
    }
    @Operation(summary = "Get ambulance list",description = "List of ambulance")
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
