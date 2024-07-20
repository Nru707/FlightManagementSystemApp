package com.nru.FlightManagementSystemDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nru.FlightManagementSystemDemo.bean.Airport;

public interface AirportRepository extends JpaRepository<Airport, String> {
	@Query("select a.airportCode from Airport a")
    public List<String> findAllAirportCodes();
	
	@Query("select a.airportCode from Airport a WHERE a.airportLocation = ?1")
	public String findAirportCodeByLocation(String airportLocation);
	
	 @Query("SELECT a.airportLocation FROM Airport a")
	public List<String> findAllAirportLocations();
}
