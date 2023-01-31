package com.aggregator.ambulanceservice.dto;

import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter                 // This applies to the whole class
//@EqualsAndHashCode
public class AmbulanceDTO {   //Data Transfer Object to transfer Json data to Java Object.


    private String name;

    private List<String> phones;

    private double longitude;        // add getter/setter for specific variable

    private  double latitude;

    private boolean available;

    private AddressDTO address;

}
