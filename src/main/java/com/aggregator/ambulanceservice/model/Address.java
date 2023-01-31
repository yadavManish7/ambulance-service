package com.aggregator.ambulanceservice.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Table(name = "address_tbl")
public class Address {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    private String streetName;
    @Getter
    private String state;
    @Getter
    private String city;
    @Getter
    private String zipCode;
//@JsonIgnore
    @OneToOne(mappedBy = "address")  // JoinColumn variable in Address class
    private Ambulance ambulance;    // This is called reverse relationship


    public Address(String streetName, String state, String city, String zipCode) {
        this.streetName = streetName;
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
    }

}
