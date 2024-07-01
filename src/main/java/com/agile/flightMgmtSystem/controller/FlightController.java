package com.agile.flightMgmtSystem.controller;


import com.agile.flightMgmtSystem.bean.Flight;
import com.agile.flightMgmtSystem.service.AirportService;
import com.agile.flightMgmtSystem.service.FlightService;
import com.agile.flightMgmtSystem.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private RouteService routeService;
    
    @Autowired
    private AirportService airportService;

    @GetMapping("/addFlight")
    public String showAddFlightForm(Model model) {
        model.addAttribute("flight", new Flight());
        model.addAttribute("routes", routeService.getAllRoutes());
        return "addFlight";
    }

    @PostMapping("/addFlight")
    public String addFlight(@ModelAttribute("flight") Flight flight,
                            @RequestParam("returnDeparture") String returnDeparture,
                            @RequestParam("returnArrival") String returnArrival,
                            Model model) {
        try {
            flightService.addFlight(flight, returnDeparture, returnArrival);
            model.addAttribute("successMessage", "Flight added successfully.");
            model.addAttribute("flight", new Flight()); // Reset the form
            model.addAttribute("routes", routeService.getAllRoutes());
            return "addFlight";
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("routes", routeService.getAllRoutes());
            return "addFlight";
        }
    }

    @GetMapping("/flights")
    public String getAllFlights(Model model) {
        model.addAttribute("flights", flightService.getAllFlights());
        return "flightList";
    }
    @GetMapping("/viewFlight")
    public String viewFlights(Model model) {
        List<Flight> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "viewFlight";
    }
    
    @GetMapping("/searchFlight")
    public String searchFlight(Model model) {
        model.addAttribute("airports", airportService.getAllAirports());
        return "searchFlight";
    }
    
   

    @PostMapping("/searchFlight")
    public String searchFlightResult(@RequestParam("fromCity") String fromCity,
                                     @RequestParam("toCity") String toCity,
                                     Model model) {
        List<Flight> flights = flightService.findFlightsByRoute(fromCity, toCity);
        Double airFare = routeService.getFareByRoute(fromCity, toCity);
        model.addAttribute("flights", flights);
        model.addAttribute("airFare", airFare);
        model.addAttribute("fromCity", fromCity);
        model.addAttribute("toCity", toCity);
        return "searchFlightResult";
    }
    
   

    
}
