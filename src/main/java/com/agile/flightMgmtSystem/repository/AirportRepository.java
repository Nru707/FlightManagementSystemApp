package com.agile.flightMgmtSystem.repository;

import com.agile.flightMgmtSystem.bean.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, String> {
    Optional<Airport> findByAirportLocation(String airportLocation);
    
    @Query("SELECT a.airportLocation FROM Airport a")
    List<String> findAllAirportLocations();
    
 
   
}
