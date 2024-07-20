package com.nru.FlightManagementSystemDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.nru.FlightManagementSystemDemo.bean.Flight;


@Service
@Repository
public class FlightDaoImpl implements FlightDao {
	
	
	 @Autowired
	    private FlightRepository repository;

	@Override
	public List<Flight> findFlightsByRouteId(Long routeId) {
		 return repository.findFlightsByRouteId(routeId);
	}

	@Override
	public List<Flight> findAllFlights() {
		  return repository.findAll();
	}

	@Override
	public void save(Flight flight) {
		repository.save(flight);

	}

	@Override
	public void addFlight(Flight flight) {
		

	}

	@Override
	public Flight findFlightById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Flight findFlightByFlightNumber(Long flightNumber) {
		 return repository.findFlightByFlightNumber(flightNumber);
	}

}
