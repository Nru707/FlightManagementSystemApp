package com.agile.flightMgmtSystem.controller;

import com.agile.flightMgmtSystem.service.RouteService;

import java.util.List;

import com.agile.flightMgmtSystem.exception.RouteAlreadyExistsException;
import com.agile.flightMgmtSystem.bean.Route;
import com.agile.flightMgmtSystem.exception.AirportNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("/addRoute")
    public String showAddRouteForm() {
        return "addRoute";
    }
    
    @GetMapping("/viewRoute")
    public String viewRoutes(Model model) {
        Iterable<Route> routes = routeService.getAllRoutes();
        model.addAttribute("routes", routes);
        return "viewRoute";
    }

    @PostMapping("/addRoute")
    public String addRoute(@RequestParam("sourceAirport") String sourceAirport,
                           @RequestParam("destinationAirport") String destinationAirport,
                           @RequestParam("fare") double fare,
                           Model model) {
        try {
            routeService.addRoute(sourceAirport, destinationAirport, fare);
            model.addAttribute("successMessage", "Route added successfully!");
        } catch (RouteAlreadyExistsException e) {
            model.addAttribute("errorMessage", e.getMessage());
        } catch (AirportNotFoundException e) {
            model.addAttribute("errorMessage", e.getMessage());
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Route Already Exists!");
        }
        return "addRoute";
    }
}
