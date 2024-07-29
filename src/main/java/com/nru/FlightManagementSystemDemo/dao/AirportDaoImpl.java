package com.nru.FlightManagementSystemDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.nru.FlightManagementSystemDemo.bean.Airport;

@Repository
@Service
public class AirportDaoImpl implements AirportDao {

	@Autowired
	private AirportRepository repository;

	@Override
	public void addAirport(Airport airport) {
		repository.save(airport);
	}

	@Override
	public List<Airport> findAllAirports() {
		return repository.findAll();
	}

	@Override
	public Airport findAirportById(String id) {
		return repository.findById(id).get();
	}

	@Override
	public String findAirportCodeByLocation(String airportLocation) {
		return repository.findAirportCodeByLocation(airportLocation);
	}

	@Override
	public List<String> findAllAirportLocations() {

		return repository.findAllAirportLocations();
	}

	@Override
	public void updateAirport(Airport airport) {
		repository.save(airport);

	}

	@Override
	public void deleteAirport(Airport airport) {
		repository.delete(airport);

	}

}
