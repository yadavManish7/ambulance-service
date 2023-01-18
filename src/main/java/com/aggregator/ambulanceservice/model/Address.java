package com.aggregator.ambulanceservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Address {

    private String streetName;
    private String state;
    private String city;
    private String zipCode;

}
