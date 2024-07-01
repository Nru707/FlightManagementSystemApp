package com.agile.flightMgmtSystem.controller;

import com.agile.flightMgmtSystem.bean.Airport;
import com.agile.flightMgmtSystem.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/airportlist")
    public String showAllAirports(Model model) {
        List<Airport> airports = airportService.showAllAirports();
        airports.forEach(airport -> System.out.println(airport.getAirportCode() + " " + airport.getAirportLocation()));
        model.addAttribute("airportlist", airports);
        return "airportlist";
    }


    @GetMapping("/addAirport")
    public String showAddAirportForm(Model model) {
        model.addAttribute("airport", new Airport());
        return "addAirport";
    }

    @PostMapping("/addAirport")
    public String addAirport(@ModelAttribute("airport") Airport airport, Model model) {
        Airport existingAirport = airportService.showAirport(airport.getAirportCode());
        if (existingAirport != null) {
            model.addAttribute("errorMessage", "Airport Code already exists.");
            return "addAirport";
        }
        airportService.addAirport(airport);
        model.addAttribute("success", true); 
        return "addAirport";
    }

    @GetMapping("/airport/{code}")
    public String showAirport(@PathVariable("code") String code, Model model) {
        Airport airport = airportService.showAirport(code);
        if (airport == null) {
            model.addAttribute("errorMessage", "Airport not Exists.");
            return "error";
        }
        model.addAttribute("airportview", airport);
        return "airportview";
    }

    @GetMapping("/searchAirport")
    public String searchAirport(@RequestParam("code") String code, Model model) {
        Airport airport = airportService.showAirport(code);
        if (airport == null) {
            model.addAttribute("errorMessage", "Airport not found.");
            return "airportview";
        }
        model.addAttribute("airportview", airport);
        return "airportview";
    }
}
