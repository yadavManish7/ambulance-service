package com.aggregator.ambulanceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddressDTO {

    private String streetName;
    private String state;
    private String city;
    private String zipCode;

}
