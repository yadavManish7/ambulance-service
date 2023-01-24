package com.aggregator.ambulanceservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter                 // This applies to the whole class
@Entity()
@Table(name = "ambulance_tbl")
public class Ambulance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Setter
    private String name;

    //private List<String> phone;     // @Getter  to add getter/setter for specific state

    @Setter
    private double longitude;
    // @Setter to add getter/setter for specific variable
    @Setter
    private double latitude;

    @Setter
    @Column(name = "is_available")
    private boolean available;

    @Column(name = "created_on")
    private LocalDate createdOn;

    //private  Address address;


    public Ambulance(String name, double longitude, double latitude, boolean available, LocalDate createdOn) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.available = available;
        this.createdOn = createdOn;
    }

}
