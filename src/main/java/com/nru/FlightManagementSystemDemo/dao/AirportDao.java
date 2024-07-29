package com.nru.FlightManagementSystemDemo.dao;

import java.util.List;

import com.nru.FlightManagementSystemDemo.bean.Airport;

public interface AirportDao {
	public void addAirport(Airport airport);

	public List<Airport> findAllAirports();

	public Airport findAirportById(String id);

	public String findAirportCodeByLocation(String AirportLocation);

	public List<String> findAllAirportLocations();

	public void updateAirport(Airport airport);

	public void deleteAirport(Airport airport);

}
