package com.aggregator.ambulanceservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

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

    @ElementCollection
    @CollectionTable(name = "phone", joinColumns = @JoinColumn(name = "id"))  //You cannot create Table/class for String
    @Column(name = "phones")
    private List<String> phones;

    @Setter
    private double longitude;

    @Setter
    private double latitude;

    @Setter
    @Column(name = "is_available")
    private boolean isAvailable;

    @Column(name = "created_on")
    private LocalDate createdOn;

    @OneToOne(cascade = CascadeType.ALL)  //Cascade to if the Ambulance is deleted, address is also deleted
    @JoinColumn(name = "fk_address_id")
    private  Address address;


    public Ambulance(String name, double longitude, double latitude, boolean isAvailable, LocalDate createdOn,Address address,List<String> phones) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.isAvailable = isAvailable;
        this.createdOn = createdOn;
        this.address=address;
        this.phones=phones;
    }

}
