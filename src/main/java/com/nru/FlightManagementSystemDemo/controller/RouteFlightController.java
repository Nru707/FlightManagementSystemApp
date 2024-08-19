package com.nru.FlightManagementSystemDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.FlightManagementSystemDemo.exception.RouteException;
import com.nru.FlightManagementSystemDemo.bean.Route;
import com.nru.FlightManagementSystemDemo.dao.AirportDao;
import com.nru.FlightManagementSystemDemo.dao.RouteDao;
import com.nru.FlightManagementSystemDemo.service.RouteService;

@ControllerAdvice
@RestController
@RequestMapping("/Admin")
public class RouteFlightController {

	@Autowired
	private RouteDao routeDao;

	@Autowired
	private RouteService routeService;

	@Autowired
	private AirportDao airportDao;

	@GetMapping("/routeEntryPage")
	public ModelAndView showRouteEntryPage() {
		Long newRouteId = routeDao.generateRouteId();
		Route route = new Route();
		route.setRouteId(newRouteId);
		ModelAndView mv = new ModelAndView("routeEntryPage");
		mv.addObject("routeRecord", route);
		return mv;
	}

	@PostMapping("/route")
	public ModelAndView saveRoutes(@ModelAttribute("routeRecord") Route route1) {
		try{
			String source = route1.getSourceAirportCode().toUpperCase();
		
		String destination = route1.getDestinationAirportCode().toUpperCase();
		 if (source.equals(destination)) {
			throw new RouteException("From-City & To-City cannot be the same......");
		}
		route1.setSourceAirportCode(source);
		route1.setDestinationAirportCode(destination);
		String sourceCode = airportDao.findAirportCodeByLocation(route1.getSourceAirportCode());
		if (sourceCode == null) {
			throw new RouteException("Source airport code not found for location..");
		}
		route1.setSourceAirportCode(sourceCode);
		String destinationCode = airportDao.findAirportCodeByLocation(route1.getDestinationAirportCode());
		if (destinationCode == null) {
			throw new RouteException("Destination airport code not found for location: ");
		}
		route1.setDestinationAirportCode(destinationCode);
		Route route2 = routeService.createReturnRoute(route1);
		routeDao.save(route1);
		routeDao.save(route2);
		return new ModelAndView("index");
		}catch (Exception e){
			throw new RouteException(e.getMessage());
			
		}

	}

	@GetMapping("/routes")
	public ModelAndView showAirportSelectPage() {
		List<Route> routeList = routeDao.findAllRoutes();
		ModelAndView mv = new ModelAndView("routeReportPage");
		mv.addObject("routeList", routeList);
		return mv;
	}
	
	 @GetMapping("/deleteroute/{routeId}")
	    public ModelAndView showDeleteRoute(@PathVariable("routeId") Long routeId) {
	        try {
	            Route route = routeDao.findRouteById(routeId);
	            if (route == null)
	                throw new RouteException("Route not found......");
	            // routeDao.deleteRoute(route);
	            ModelAndView mv = new ModelAndView("deleteRoutePage");
	            mv.addObject("routeRecord", route);
	            mv.addObject("sourceAirport", airportDao.findAirportById(route.getSourceAirportCode()));
	            mv.addObject("destinationAirport", airportDao.findAirportById(route.getDestinationAirportCode()));
	            return mv;
	        } catch (Exception e) {
	            throw new RouteException("Error deleting route: " + e.getMessage());
	        }
	    }
	
	 @GetMapping("/updateroute/{routeId}")
	    public ModelAndView showRouteUpdatePage(@PathVariable("routeId") Long routeId) {
	        try {
	            Route route = routeDao.findRouteById(routeId);
	            if (route == null)
	                throw new RouteException("Route not found......");
	            ModelAndView mv = new ModelAndView("routeUpdatePage");
	            mv.addObject("routeRecord", route);
	            mv.addObject("sourceAirport", airportDao.findAirportById(route.getSourceAirportCode()));
	            mv.addObject("destinationAirport", airportDao.findAirportById(route.getDestinationAirportCode()));
	            airportDao.findAirportById(route.getSourceAirportCode());
	            return mv;
	        } catch (Exception e) {
	            throw new RouteException("Error displaying route update page: " + e.getMessage());
	        }
	    }

	    @PostMapping("/updateroute")
	    public ModelAndView updateRoute(@ModelAttribute("routeRecord") Route route, @RequestParam("routeId") Long routeId) {
	        try {
	            Route route1 = routeDao.findRouteById(routeId);
	            if (route1 == null)
	                throw new RouteException("Route not found......");
	            String source = route.getSourceAirportCode().toUpperCase();
	            String destination = route.getDestinationAirportCode().toUpperCase();
	            if (source.equalsIgnoreCase(destination))
	                throw new RouteException("From-City & To-City cannot be the same......");
	            String sourceCode = airportDao.findAirportCodeByLocation(route.getSourceAirportCode());
	            String destinationCode = airportDao.findAirportCodeByLocation(route.getDestinationAirportCode());
	            if (sourceCode == null || destinationCode == null) {
	                throw new RouteException("Invalid airport codes provided.");
	            }
	            route.setSourceAirportCode(sourceCode);
	            route.setDestinationAirportCode(destinationCode);
	            routeDao.save(route);
	            return new ModelAndView("redirect:/Admin/");
	        } catch (Exception e) {
	            throw new RouteException("Error updating route: " + e.getMessage());
	        }
	    }

	 @PostMapping("/deleteroute")
	    public ModelAndView deleteRoute(@RequestParam("routeId") Long routeId) {
	        try {
	            Route route = routeDao.findRouteById(routeId);
	            if (route == null)
	                throw new RouteException("Route not found......");
	            routeDao.deleteRoute(route);
	            return new ModelAndView("redirect:/Admin/");
	        } catch (Exception e) {
	            throw new RouteException("Error deleting route: " + e.getMessage());
	        }
	    }
	
	@ExceptionHandler(value = RouteException.class)
	public ModelAndView handlingRouteException(RouteException exception) {
		String message = exception.getMessage();
		ModelAndView mv = new ModelAndView("routeErrorPage");
		mv.addObject("errorMessage", message);
		return mv;
	}

	/*@GetMapping("/flight")
	public ModelAndView showFlightEntryPage() {
		List<Long> routeList = routeDao.findAllRoutesId();
		Flight flight = new Flight();
		ModelAndView mv = new ModelAndView("flightEntryPage");
		mv.addObject("flightRecord", flight);
		mv.addObject("routeList", routeList);
		return mv;
	}

	@PostMapping("/flight")
	public ModelAndView saveFlights(@ModelAttribute("flightRecord") Flight flight1, @RequestParam("dtime") String dtime,
			@RequestParam("atime") String atime) {
		Flight flight2 = flightService.createReturnFlight(flight1, dtime, atime);
		flightDao.save(flight1);
		flightDao.save(flight2);
		return new ModelAndView("redirect:/Admin/index");
	}

	@GetMapping("/flights")
	public ModelAndView showFlightReportPage() {
		List<Flight> flightList = flightDao.findAllFlights();
		ModelAndView mv = new ModelAndView("flightReportPage");
		mv.addObject("flightList", flightList);
		return mv;
	}

	@ExceptionHandler(value = FlightException.class)
	    public ModelAndView handlingFlightException(FlightException exception) {
	        String message = "From-City & To-City cannot be the same......";
	        ModelAndView mv = new ModelAndView("flightErrorPage");
	        mv.addObject("flightError", message);
	        return mv;
	    }


 * @GetMapping("/flight-search") public ModelAndView showRouteSelectPage() {
 * List<String> airportList = airportDao.findAllAirportLocations(); ModelAndView
 * mv = new ModelAndView("routeSelectPage"); mv.addObject("airportList",
 * airportList); return mv; }
 * 
 * @PostMapping("/flight-search") public ModelAndView
 * showRouteFlightsPage(@RequestParam("fromCity") String
 * fromCity, @RequestParam("toCity") String toCity) { fromCity =
 * fromCity.toUpperCase(); toCity = toCity.toUpperCase(); String fromAirport =
 * airportDao.findAirportCodeByLocation(fromCity); String toAirport =
 * airportDao.findAirportCodeByLocation(toCity); if
 * (fromAirport.equalsIgnoreCase(toAirport)) throw new
 * RouteException(toAirport); Route route =
 * routeDao.findRouteBySourceAndDestination(fromAirport, toAirport);
 * 
 * List<Flight> flightList = flightDao.findFlightsByRouteId(route.getRouteId());
 * 
 * ModelAndView mv = new ModelAndView("routeFlightShowPage");
 * mv.addObject("flightList", flightList); mv.addObject("fromAirport",
 * fromCity); mv.addObject("toAirport", toCity); mv.addObject("fare",
 * route.getFare()); return mv;
 * 
 * }
 * 
 * @ExceptionHandler(value = RouteException.class) public ModelAndView
 * handlingRouteException(RouteException exception) { String message =
 * "From-City & To-City cannot be the same......"; ModelAndView mv = new
 * ModelAndView("routeErrorPage"); mv.addObject("errorMessage", message); return
 * mv;
 * 
 * }*/


}
