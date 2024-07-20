package com.nru.FlightManagementSystemDemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nru.FlightManagementSystemDemo.bean.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	  @Query("SELECT a FROM Flight a WHERE route_Id=?1")
	public List<Flight> findFlightsByRouteId(Long routeId);

	  @Query("SELECT a FROM Flight a WHERE flightNumber=?1")
    public Flight findFlightByFlightNumber(Long flightNumber);
	
}
