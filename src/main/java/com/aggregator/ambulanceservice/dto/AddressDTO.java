package com.aggregator.ambulanceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class AddressDTO {

    private String streetName;
    private String state;
    private String city;
    private String zipCode;

}
