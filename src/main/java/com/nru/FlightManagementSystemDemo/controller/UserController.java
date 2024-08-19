package com.nru.FlightManagementSystemDemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

import com.FlightManagementSystemDemo.exception.AirportException;
import com.FlightManagementSystemDemo.exception.FlightException;
import com.FlightManagementSystemDemo.exception.RouteException;
import com.nru.FlightManagementSystemDemo.bean.Airport;
import com.nru.FlightManagementSystemDemo.bean.Flight;
import com.nru.FlightManagementSystemDemo.bean.Passenger;
import com.nru.FlightManagementSystemDemo.bean.Route;
import com.nru.FlightManagementSystemDemo.bean.Ticket;
import com.nru.FlightManagementSystemDemo.bean.TicketPassengerEmbed;
import com.nru.FlightManagementSystemDemo.dao.AirportDao;
import com.nru.FlightManagementSystemDemo.dao.FlightDao;
import com.nru.FlightManagementSystemDemo.dao.PassengerDao;
import com.nru.FlightManagementSystemDemo.dao.RouteDao;
import com.nru.FlightManagementSystemDemo.dao.TicketDao;
import com.nru.FlightManagementSystemDemo.service.TicketService;

@ControllerAdvice
@Controller
@RestController
@RequestMapping("/customer")
public class UserController {

	@Autowired
	private FlightDao flightDao;

	@Autowired
	private AirportDao airportDao;

	@Autowired
	private RouteDao routeDao;

	@Autowired
	private TicketDao ticketDao;

	@Autowired
	private PassengerDao passengerDao;

	@Autowired
	private TicketService ticketService;

	@GetMapping("/")
	public ModelAndView showUserIndexPage() {
		return new ModelAndView("userindex");
	}

	@GetMapping("/airport")
	public ModelAndView showIndexPage() {
		return new ModelAndView("CustomerAirportShowPage");
	}

	@GetMapping("/airports")
	public ModelAndView showAirportReportPage() {
		try {
			List<Airport> airportList = airportDao.findAllAirports();
			ModelAndView mv = new ModelAndView("CustomerAirportReportPage");
			mv.addObject("airportList", airportList);
			return mv;
		} catch (Exception e) {
			throw new AirportException("Error displaying airport report page: " + e.getMessage());
		}
	}

	@GetMapping("/airport/{id}")
	public ModelAndView showSingleAirportPage(@PathVariable("id") String id) {
		try {
			Airport airport = airportDao.findAirportById(id);
			if (airport == null) {
				throw new AirportException("Airport with ID " + id + " not found.");
			}
			ModelAndView mv = new ModelAndView("CustomerAirportShowPage");
			mv.addObject("airport", airport);
			return mv;
		} catch (Exception e) {
			throw new AirportException("Error displaying airport: " + e.getMessage());
		}
	}

	@GetMapping("/routes")
	public ModelAndView showAirportSelectPage() {
		List<Route> routeList = routeDao.findAllRoutes();
		ModelAndView mv = new ModelAndView("CustomerRouteReportPage");
		mv.addObject("routeList", routeList);
		return mv;
	}

	@GetMapping("/flight-search")
	public ModelAndView showRouteSelectPage() {
		List<String> airportList = airportDao.findAllAirportLocations();
		ModelAndView mv = new ModelAndView("routeSelectPage");
		mv.addObject("airportList", airportList);
		return mv;
	}

	@PostMapping("/flight-search")
	public ModelAndView showRouteFlightsPage(@RequestParam("fromCity") String fromCity,@RequestParam("toCity") String toCity) {
		try{
			fromCity = fromCity.toUpperCase();
		toCity = toCity.toUpperCase();
		String fromAirport = airportDao.findAirportCodeByLocation(fromCity);
		String toAirport = airportDao.findAirportCodeByLocation(toCity);
		if (fromAirport == null || toAirport == null) {
	        throw new FlightException("One or both of the cities are invalid.");
	    }
		if (fromAirport.equalsIgnoreCase(toAirport)) {
			throw new  FlightException( "The source and destination airports cannot be the same.");
	    }
		Route route = routeDao.findRouteBySourceAndDestination(fromAirport, toAirport);
		 if (route == null) {
			 throw new  FlightException("No route found between the selected airports.");
		    }

		List<Flight> flightList = flightDao.findFlightsByRouteId(route.getRouteId());

		ModelAndView mv = new ModelAndView("routeFlightShowPage");
		mv.addObject("flightList", flightList);
		mv.addObject("fromAirport", fromCity);
		mv.addObject("toAirport", toCity);
		mv.addObject("fare", route.getFare());
		return mv;
	} catch (Exception e) {
		throw new FlightException( e.getMessage());
	}
}
	 @ExceptionHandler(value = FlightException.class)
	    public ModelAndView handlingFlightException(FlightException exception) {
	        ModelAndView mv = new ModelAndView("SearchflightErrorPage");
	        mv.addObject("errorMessage", exception.getMessage());
	        return mv;
	    }

	@GetMapping("/ticket/{id}")
	public ModelAndView showTicketBookingPage(@PathVariable Long id) {
		Flight flight = flightDao.findFlightById(id);
		Route route = routeDao.findRouteById(flight.getRouteId());
		Long newTicketId = ticketDao.findLastTicketNumber();
		Ticket ticket = new Ticket();
		ticket.setTicketNumber(newTicketId);
		ticket.setFlightNumber(flight.getFlightNumber());
		ticket.setCarrierName(flight.getCarrierName());
		ModelAndView mv = new ModelAndView("ticketBookingPage");
		mv.addObject("ticketRecord", ticket);
		mv.addObject("flight", flight);
		mv.addObject("route", route);
		return mv;
	}

	@PostMapping("/ticket")
	public ModelAndView openShowTicketPage(@ModelAttribute("ticketRecord") Ticket ticket, HttpServletRequest request) {
		List<Passenger> passengerList = new ArrayList<>();
		String fromCity = request.getParameter("fromLocation");
		String toCity = request.getParameter("toLocation");
		Double fare = Double.parseDouble(request.getParameter("fare"));
		String pname = "";
		String dob = "";
		for (int i = 1; i <= 6; i++) {
			pname = request.getParameter("name" + i);
			dob = request.getParameter("dob" + i);
			System.out.println(pname);
			System.out.println(dob);
			System.out.println("name" + i);
			System.out.println("dob" + i);
			if (pname != null && !pname.isEmpty() && !pname.equals("--") && dob != null && !dob.isEmpty()) {
				TicketPassengerEmbed embed = new TicketPassengerEmbed(ticket.getTicketNumber(), i);
				Passenger passenger = new Passenger(embed, pname, dob, fare);
				Double pfare = ticketService.discountedFareCalculation(passenger);
				passenger.setFare(pfare);
				passengerList.add(passenger);
			} else {
				break;
			}
		}

		int size = passengerList.size();
		if (ticketService.capacityCalculation(size, ticket.getFlightNumber())) {
			ticketDao.save(ticket);
			for (Passenger passenger : passengerList) {
				passengerDao.save(passenger);
			}
		} else {
			// throw new SeatNotFoundException();
		}
		Double totalAmount = ticketService.totalBillCalculation(passengerList);
		ticket.setTotalAmount(totalAmount);
		ticketDao.save(ticket);

		ModelAndView mv = new ModelAndView("showTicketPage");
		mv.addObject("ticket", ticket);
		mv.addObject("fromCity", fromCity);
		mv.addObject("toCity", toCity);
		mv.addObject("passengerList", passengerList);
		return mv;
	}

}
