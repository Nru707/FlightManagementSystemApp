package com.nru.FlightManagementSystemDemo.dao;



import java.util.List;



import com.nru.FlightManagementSystemDemo.bean.Airport;
public interface AirportDao {
   public void addAirport(Airport airport);

   public List<Airport> findAllAirports();

   public Airport findAirportById(String id);
   
   /*public List<String> findAllAirportCodes();*/


public String findAirportCodeByLocation(String AirportLocation);

/*public List<String> findAllRoutes();*/

public List<String> findAllAirportLocations();




}
