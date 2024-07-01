package com.agile.flightMgmtSystem.service;

import com.agile.flightMgmtSystem.bean.Flight;
import com.agile.flightMgmtSystem.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(Flight flight, String returnDeparture, String returnArrival) {
        if (flightRepository.existsByCarrierNameAndFlightNumber(flight.getCarrierName(), flight.getFlightNumber())) {
            throw new IllegalArgumentException("Flight ID already exists for this carrier.");
        }
        Flight savedFlight = flightRepository.save(flight);
        addReturnFlight(savedFlight, returnDeparture, returnArrival);
        return savedFlight;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
    
   

    public List<Flight> getFlightsByCities(String departure, String arrival) {
        return flightRepository.findByDepartureAndArrival(departure, arrival);
    }
   
    private void addReturnFlight(Flight originalFlight, String returnDeparture, String returnArrival) {
        Flight returnFlight = new Flight();
        returnFlight.setFlightNumber(originalFlight.getFlightNumber() + 1);
        returnFlight.setCarrierName(originalFlight.getCarrierName());
        returnFlight.setSeatCapacity(originalFlight.getSeatCapacity());
        returnFlight.setRouteId(originalFlight.getRouteId() + 1);
        returnFlight.setDeparture(returnDeparture);
        returnFlight.setArrival(returnArrival);

        flightRepository.save(returnFlight);
    }
    
    public List<Flight> findFlightsByRoute(String fromCity, String toCity) {
        return flightRepository.findByRoute(fromCity, toCity);
    }
    
    public List<Flight> getFlightsByRouteId(Long routeId) {
        return flightRepository.findByRouteId(routeId);
    }


}
