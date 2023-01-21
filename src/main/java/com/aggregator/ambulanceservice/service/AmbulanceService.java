package com.aggregator.ambulanceservice.service;

import com.aggregator.ambulanceservice.dto.AddressDTO;
import com.aggregator.ambulanceservice.dto.AmbulanceDTO;
import com.aggregator.ambulanceservice.model.Address;
import com.aggregator.ambulanceservice.model.Ambulance;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AmbulanceService {

    public List<Ambulance> getAmbulanceList(){
        return new ArrayList<>();
    }

    public Optional<Ambulance> getAmbulanceDetail(String id){ //Optional because it might contain null value
        Address address = new Address("Bonnie Brae", "TX", "Denton", "76201");//Ambulance is dependent to ADDRESS class
        List<String> phoneNumbers = List.of("123-234-5366", "394-384-0989");
        Ambulance ambulance = new Ambulance(UUID.randomUUID().toString(),"Blue cross blue shield", phoneNumbers, 78.07, 77.79, true, LocalDate.now(), address);
        return Optional.of(ambulance);
    }

    public Ambulance createAmbulance(AmbulanceDTO ambulanceDTO){
        AddressDTO addressDTO = ambulanceDTO.getAddress();
        Address address = new Address(addressDTO.getStreetName(), addressDTO.getState(), addressDTO.getCity(), addressDTO.getZipCode());
        return new Ambulance(UUID.randomUUID().toString(),ambulanceDTO.getName(), ambulanceDTO.getPhone(),ambulanceDTO.getLatitude(), ambulanceDTO.getLongitude(),ambulanceDTO.isAvailable(), LocalDate.now(),address);
    }

    public Ambulance updateAmbulance(String ambulanceId , AmbulanceDTO ambulanceDTO){
        AddressDTO addressDTO = ambulanceDTO.getAddress();
        Address address = new Address(addressDTO.getStreetName(), addressDTO.getState(), addressDTO.getCity(), addressDTO.getZipCode());
        return new Ambulance(UUID.randomUUID().toString(),ambulanceDTO.getName(), ambulanceDTO.getPhone(),ambulanceDTO.getLatitude(), ambulanceDTO.getLongitude(),ambulanceDTO.isAvailable(), LocalDate.now(),address);
    }

    public void deleteAmbulance(String ambulanceId){

    }



}
