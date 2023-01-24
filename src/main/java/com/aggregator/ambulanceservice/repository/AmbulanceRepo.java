package com.aggregator.ambulanceservice.repository;

import com.aggregator.ambulanceservice.model.Ambulance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbulanceRepo extends JpaRepository<Ambulance, Long> {

}
