package com.agile.flightMgmtSystem.service;

import com.agile.flightMgmtSystem.bean.Airport;
import com.agile.flightMgmtSystem.bean.Route;
import com.agile.flightMgmtSystem.repository.AirportRepository;
import com.agile.flightMgmtSystem.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Transactional
    public void addRoute(String sourceAirport, String destinationAirport, double fare) throws Exception {
        // Check if the source airport exists
        Optional<Airport> sourceAirportOptional = airportRepository.findByAirportLocation(sourceAirport);
        if (!sourceAirportOptional.isPresent()) {
            throw new Exception("Source airport location does not exist");
        }

        // Check if the destination airport exists
        Optional<Airport> destinationAirportOptional = airportRepository.findByAirportLocation(destinationAirport);
        if (!destinationAirportOptional.isPresent()) {
            throw new Exception("Destination airport location does not exist");
        }

        // Get airport codes
        String sourceAirportCode = sourceAirportOptional.get().getAirportCode();
        String destinationAirportCode = destinationAirportOptional.get().getAirportCode();

        // Check if the route already exists
        Optional<Route> existingRoute = routeRepository.findRouteByAirports(sourceAirportCode, destinationAirportCode);
        if (existingRoute.isPresent()) {
            throw new Exception("Route already exists");
        }

        // Create the first route
        Route route1 = new Route();
        route1.setRouteId(generateRouteId());
        route1.setSourceAirport(sourceAirportCode);
        route1.setDestinationAirport(destinationAirportCode);
        route1.setFare(fare);

        // Save the first route
        routeRepository.save(route1);

        // Create the second route (reverse route)
        Route route2 = new Route();
        route2.setRouteId(generateRouteId());
        route2.setSourceAirport(destinationAirportCode);
        route2.setDestinationAirport(sourceAirportCode);
        route2.setFare(fare);

        // Save the second route
        routeRepository.save(route2);
    }

    public Iterable<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    private Long generateRouteId() {
        // Fetch the current max route ID from the database
        Long maxRouteId = routeRepository.findMaxRouteId();
        if (maxRouteId == null) {
            // If no routes exist, start with 101
            return 101L;
        } else {
            // Otherwise, increment the max route ID by 1
            return maxRouteId + 1;
        }
    }
    
    public Double getFareByRoute(String fromCity, String toCity) {
        Route route = routeRepository.findBySourceAirportAndDestinationAirport(fromCity, toCity);
        return route != null ? route.getFare() : 0.0;
    }
    
    
}
