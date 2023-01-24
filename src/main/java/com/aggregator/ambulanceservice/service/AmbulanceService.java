package com.aggregator.ambulanceservice.service;

import com.aggregator.ambulanceservice.dto.AmbulanceDTO;
import com.aggregator.ambulanceservice.model.Ambulance;
import com.aggregator.ambulanceservice.repository.AmbulanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AmbulanceService {

    @Autowired
    private AmbulanceRepo ambulanceRepo;

    public List<Ambulance> getAmbulanceList(){
        return ambulanceRepo.findAll();
    }

    public Ambulance getAmbulanceDetail(Long ambulanceId){ //Optional because it might contain null value

       Optional<Ambulance> optionalAmbulance= ambulanceRepo.findById(ambulanceId);//getting from DB if exist

        if(optionalAmbulance.isPresent()){
           Ambulance ambulanceToGetDetail =optionalAmbulance.get();
            ambulanceToGetDetail.getName();
            ambulanceToGetDetail.getLatitude();
            ambulanceToGetDetail.getLongitude();
            ambulanceToGetDetail.getCreatedOn();
            ambulanceToGetDetail.isAvailable();
            return ambulanceToGetDetail;
        }else {
            throw new RuntimeException(String.format("The ambulance with id %d does not exist", ambulanceId));
        }
    }

    public Ambulance createAmbulance(AmbulanceDTO ambulanceDTO){
        Ambulance ambulance = new Ambulance(ambulanceDTO.getName(),ambulanceDTO.getLatitude(),ambulanceDTO.getLongitude(),ambulanceDTO.isAvailable(),LocalDate.now());
        return ambulanceRepo.save(ambulance);
    }

    public Ambulance updateAmbulance(Long ambulanceId , AmbulanceDTO ambulanceDTO){
       Optional<Ambulance> optionalAmbulance = ambulanceRepo.findById(ambulanceId);

       if(optionalAmbulance.isPresent()){
           Ambulance ambulanceToUpdate = optionalAmbulance.get();
           ambulanceToUpdate.setName(ambulanceDTO.getName());
           ambulanceToUpdate.setLatitude(ambulanceDTO.getLatitude());
           ambulanceToUpdate.setLongitude(ambulanceDTO.getLongitude());
           ambulanceToUpdate.setAvailable(ambulanceDTO.isAvailable());
           return ambulanceRepo.save(ambulanceToUpdate);
       }else {
           throw new RuntimeException(String.format("The ambulance with id %d does not exist",ambulanceId));
       }
    }

    public void deleteAmbulance(Long ambulanceId){
        ambulanceRepo.deleteById(ambulanceId);
    }



}
