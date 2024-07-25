package com.nru.FlightManagementSystemDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.FlightManagementSystemDemo.exception.RouteException;
import com.nru.FlightManagementSystemDemo.bean.Flight;
import com.nru.FlightManagementSystemDemo.bean.Route;
import com.nru.FlightManagementSystemDemo.dao.AirportDao;
import com.nru.FlightManagementSystemDemo.dao.FlightDao;
import com.nru.FlightManagementSystemDemo.dao.RouteDao;

@ControllerAdvice
@RestController
public class UserController {

	@Autowired
	private FlightDao flightDao;

	@Autowired
	private AirportDao airportDao;

	@Autowired
	private RouteDao routeDao;

	@GetMapping("/flight-search")
	public ModelAndView showRouteSelectPage() {
		List<String> airportList = airportDao.findAllAirportLocations();
		ModelAndView mv = new ModelAndView("routeSelectPage");
		mv.addObject("airportList", airportList);
		return mv;
	}

	@PostMapping("/flight-search")
	public ModelAndView showRouteFlightsPage(@RequestParam("fromCity") String fromCity,
			@RequestParam("toCity") String toCity) {
		fromCity = fromCity.toUpperCase();
		toCity = toCity.toUpperCase();
		String fromAirport = airportDao.findAirportCodeByLocation(fromCity);
		String toAirport = airportDao.findAirportCodeByLocation(toCity);
		if (fromAirport.equalsIgnoreCase(toAirport))
			throw new RouteException(toAirport);
		Route route = routeDao.findRouteBySourceAndDestination(fromAirport, toAirport);

		List<Flight> flightList = flightDao.findFlightsByRouteId(route.getRouteId());

		ModelAndView mv = new ModelAndView("routeFlightShowPage");
		mv.addObject("flightList", flightList);
		mv.addObject("fromAirport", fromCity);
		mv.addObject("toAirport", toCity);
		mv.addObject("fare", route.getFare());
		return mv;

	}

	@ExceptionHandler(value = RouteException.class)
	public ModelAndView handlingRouteException(RouteException exception) {
		String message = "From-City & To-City cannot be the same......";
		ModelAndView mv = new ModelAndView("routeErrorPage");
		mv.addObject("errorMessage", message);
		return mv;

	}

}
