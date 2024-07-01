package com.agile.flightMgmtSystem.repository;

import com.agile.flightMgmtSystem.bean.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    boolean existsByCarrierNameAndFlightNumber(String carrierName, Long flightNumber);

    List<Flight> findByRouteId(Long routeId);

    List<Flight> findByDepartureAndArrival(String departure, String arrival);
    
    @Query("SELECT f FROM Flight f JOIN Route r ON f.routeId = r.routeId WHERE r.sourceAirport = :fromCity AND r.destinationAirport = :toCity")
    List<Flight> findByRoute(String fromCity, String toCity);
    
    
    
}
