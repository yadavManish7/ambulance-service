package com.aggregator.ambulanceservice.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter                 // This applies to the whole class
//@ToString
//@EqualsAndHashCode
public class Ambulance {

    private String id;

    private String name;

    private List<String> phone;     // @Getter  to add getter/setter for specific state

    private double longitude;      // @Setter to add getter/setter for specific variable

    private  double latitude;

    private boolean available;

    private LocalDate createdOn;

    private  Address address;

}
