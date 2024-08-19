package com.nru.FlightManagementSystemDemo.controller;

import java.util.List;
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
import com.nru.FlightManagementSystemDemo.bean.Airport;
import com.nru.FlightManagementSystemDemo.bean.Flight;
import com.nru.FlightManagementSystemDemo.bean.Passenger;
import com.nru.FlightManagementSystemDemo.dao.AirportDao;
import com.nru.FlightManagementSystemDemo.dao.FlightDao;
import com.nru.FlightManagementSystemDemo.dao.PassengerDao;
import com.nru.FlightManagementSystemDemo.dao.RouteDao;
import com.nru.FlightManagementSystemDemo.service.FlightService;

@ControllerAdvice
@RestController
@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private AirportDao airportDao;

	@Autowired
	private PassengerDao passengerDao;

	@Autowired
	private RouteDao routeDao;

	@Autowired
	private FlightService flightService;

	@Autowired
	private FlightDao flightDao;

	@GetMapping("/")
	public ModelAndView showIndexPage() {
		return new ModelAndView("index");
	}

	@GetMapping("/Home")
	public String Home() {
		return "Home";
	}

	@GetMapping("/airport")
	public ModelAndView showAirportEntryPage() {
		try {
			Airport airport = new Airport();
			ModelAndView mv = new ModelAndView("airportEntryPage");
			mv.addObject("airportRecord", airport);
			return mv;
		} catch (Exception e) {
			throw new AirportException("Error displaying airport entry page: " + e.getMessage());
		}
	}

	@PostMapping("/airport")
	public ModelAndView saveAirport(@ModelAttribute("airportRecord") Airport airport) {
		try {
			String str = airport.getAirportCode().toUpperCase();
			airport.setAirportCode(str);
			String stg = airport.getAirportLocation().toUpperCase();
			airport.setAirportLocation(stg);

			if (airport.getAirportCode().length() != 3) {
				throw new AirportException("Airport code must be 3 characters long.");
			}

			if (airport.getAirportLocation().length() <= 3) {
				throw new AirportException("Airport City must be at least 3 characters long.");
			}
			airportDao.addAirport(airport);
			return new ModelAndView("redirect:/Admin/");
		} catch (Exception e) {
			throw new AirportException( e.getMessage());
		}
	}

	@GetMapping("/airport/{id}")
	public ModelAndView showSingleAirportPage(@PathVariable("id") String id) {
		try {
			Airport airport = airportDao.findAirportById(id);
			if (airport == null) {
				throw new AirportException("Airport with ID " + id + " not found.");
			}
			ModelAndView mv = new ModelAndView("airportShowPage");
			mv.addObject("airport", airport);
			return mv;
		} catch (Exception e) {
			throw new AirportException("Error displaying airport: " + e.getMessage());
		}
	}

	@GetMapping("/airports")
	public ModelAndView showAirportReportPage() {
		try {
			List<Airport> airportList = airportDao.findAllAirports();
			ModelAndView mv = new ModelAndView("airportReportPage");
			mv.addObject("airportList", airportList);
			return mv;
		} catch (Exception e) {
			throw new AirportException("Error displaying airport report page: " + e.getMessage());
		}
	}

	@GetMapping("/UpdateAirport/{id}")
	public ModelAndView showUpdateAirportPage(@PathVariable("id") String id) {
		try {
			Airport airport = airportDao.findAirportById(id.toUpperCase());
			if (airport == null) {
				throw new AirportException("Airport with ID " + id + " not found.");
			}
			ModelAndView mv = new ModelAndView("UpdateAirportPage");
			mv.addObject("airport", airport);
			return mv;
		} catch (Exception e) {
			throw new AirportException("Error displaying airport: " + e.getMessage());
		}
	}

	@PostMapping("/UpdateAirport")
	public ModelAndView updateAirport(@ModelAttribute("airport") Airport airport) {
		try {
			String str = airport.getAirportCode().toUpperCase();
			airport.setAirportCode(str);

			String stg = airport.getAirportLocation().toUpperCase();
			airport.setAirportLocation(stg);

			if (airport.getAirportCode().length() != 3) {
				throw new AirportException("Airport code must be 3 characters long.");
			}

			if (airport.getAirportLocation().length() <= 3) {
				throw new AirportException("Airport location must be at least 3 characters long.");
			}

			airportDao.updateAirport(airport);
			return new ModelAndView("redirect:/Admin/");
		} catch (Exception e) {
			throw new AirportException("Error updating airport: " + e.getMessage());
		}
	}

	@GetMapping("/DeleteAirport/{id}")
	public ModelAndView showDeleteAirportPage(@PathVariable("id") String id) {
		try {
			// Find the airport by ID
			Airport airport = airportDao.findAirportById(id.toUpperCase());
			if (airport == null) {
				throw new AirportException("Airport with ID " + id + " not found.");
			}
			ModelAndView mv = new ModelAndView("DeleteAirportPage");
			mv.addObject("airport", airport);
			return mv;
		} catch (Exception e) {
			throw new AirportException("Error displaying airport: " + e.getMessage());
		}
	}

	// Delete the airport
	@PostMapping("/DeleteAirport")
	public ModelAndView deleteAirport(@RequestParam("airportCode") String airportCode) {
		try {
			Airport airport = airportDao.findAirportById(airportCode.toUpperCase());
			if (airport == null) {
				throw new AirportException("Airport not found.");
			}
			airportDao.deleteAirport(airport);
			return new ModelAndView("redirect:/Admin/");
		} catch (Exception e) {
			throw new AirportException("Error deleting airport: " + e.getMessage());
		}
	}

	@ExceptionHandler(value = AirportException.class)
	public ModelAndView handlingRouteException(AirportException exception) {
		String message = exception.getMessage();
		ModelAndView mv = new ModelAndView("airportErrorPage");
		mv.addObject("errorMessage", message);
		return mv;
	}

	@GetMapping("/flight")
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
		return new ModelAndView("redirect:/Admin/");
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
	        ModelAndView mv = new ModelAndView("flightErrorPage");
	        mv.addObject("errorMessage", exception.getMessage());
	        return mv;
	    }

	@GetMapping("/Passengers")
	public ModelAndView showPassengerReportPage() {
		List<Passenger> PassengerList = passengerDao.findAllPassengers();
		ModelAndView mv = new ModelAndView("passengerReportPage");
		mv.addObject("PassengerList", PassengerList);
		return mv;
	}

}
