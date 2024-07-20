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
	private  AirportRepository repository;

	@Override
	public void addAirport(Airport airport) {
		repository.save(airport);
	}


	@Override
	public List<Airport> findAllAirports() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Airport findAirportById(String id) {
		// TODO Auto-generated method stub
		return  repository.findById(id).get();
	}

	/*@Override
	public List<String> findAllAirportCodes() {
		// TODO Auto-generated method stub
		return repository.findAllAirportCodes();
	}
*/

	@Override
	public String findAirportCodeByLocation(String airportLocation) {
		// TODO Auto-generated method stub
		return repository.findAirportCodeByLocation(airportLocation);
	}


	@Override
	public List<String> findAllAirportLocations() {
		
		return repository.findAllAirportLocations();
	}


	/*@Override
	public List<String> findAllRoutes() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<String> findAllAirportCodes() {
		// TODO Auto-generated method stub
		return null;
	}
*/
}

