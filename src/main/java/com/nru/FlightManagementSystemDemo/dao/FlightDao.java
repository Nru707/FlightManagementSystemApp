package com.nru.FlightManagementSystemDemo.dao;

import java.util.List;

import com.nru.FlightManagementSystemDemo.bean.Flight;

public interface FlightDao {
	 public List<Flight> findFlightsByRouteId(Long routeId);

	    public List<Flight> findAllFlights();

	    public void save(Flight flight1);

	    public void addFlight(Flight flight);

	    public Flight findFlightById(Long id);

	    public Flight findFlightByFlightNumber(Long flightNumber);


}
