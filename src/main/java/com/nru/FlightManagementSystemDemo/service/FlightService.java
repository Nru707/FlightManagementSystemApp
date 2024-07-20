package com.nru.FlightManagementSystemDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nru.FlightManagementSystemDemo.bean.Flight;
import com.nru.FlightManagementSystemDemo.bean.Route;
import com.nru.FlightManagementSystemDemo.dao.RouteDao;

@Service
public class FlightService {
	
	    @Autowired
	    private RouteDao routeDao;

	    public Flight createReturnFlight(Flight flight, String dtime, String atime) {
	        Long newId = flight.getFlightNumber() + 1;
	        Route route = routeDao.findRouteById(flight.getRouteId());
	        String sourceCode = route.getDestinationAirportCode();
	        String destinationCode = route.getSourceAirportCode();
	        Route Route2= routeDao.findRouteBySourceAndDestination(sourceCode, destinationCode);
	        return new Flight(newId, flight.getCarrierName(), flight.getSeatCapacity(), Route2.getRouteId(), dtime, atime);
	    }

}
