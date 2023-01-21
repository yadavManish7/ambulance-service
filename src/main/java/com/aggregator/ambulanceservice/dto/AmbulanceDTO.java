package com.aggregator.ambulanceservice.dto;

import com.aggregator.ambulanceservice.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter                 // This applies to the whole class
@ToString
//@EqualsAndHashCode
public class AmbulanceDTO {   //Data Transfer Object to transfer Json data to Java Object.

    //private int id;   id is auto generated from server

    private String name;

    private List<String> phone;          // @Getter  to add getter/setter for specific state

    private double longitude;        // @Setter to add getter/setter for specific variable

    private  double latitude;

    private boolean available;

    private AddressDTO address;


}
