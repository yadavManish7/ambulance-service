package com.aggregator.ambulanceservice.dto;

import com.aggregator.ambulanceservice.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter                 // This applies to the whole class
//@ToString
//@EqualsAndHashCode
public class AmbulanceDTO {

    private String name;
    private List<String> phone;
   // @Getter  to add getter/setter for specific state
    private double longitude;
   // @Setter to add getter/setter for specific variable
    private  double latitude;

    private boolean isAvailable;

    private LocalDate createdOn;

    private Address address;


}
