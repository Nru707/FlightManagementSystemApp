package com.nru.FlightManagementSystemDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.FlightManagementSystemDemo.exception.AirportException;
import com.nru.FlightManagementSystemDemo.bean.Airport;
import com.nru.FlightManagementSystemDemo.dao.AirportDao;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AirportDao airportDao;

	@GetMapping("/")
	public String Home() {
		return "Home";
	}

	@GetMapping("/login")
	public ModelAndView adminIndexPage() {
		return new ModelAndView("adminLoginPage");
	}

	@GetMapping("/index")
	public ModelAndView showIndexPage() {
		return new ModelAndView("index");
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

			if (airport.getAirportLocation().length() < 3) {
				throw new AirportException("Airport location must be at least 3 characters long.");
			}
			airportDao.addAirport(airport);
			return new ModelAndView("index");
		} catch (Exception e) {
			throw new AirportException("Error saving airport: " + e.getMessage());
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

	@ExceptionHandler(value = AirportException.class)
	public ModelAndView handlingRouteException(AirportException exception) {
		String message = "Airport Exception: " + exception.getMessage();
		ModelAndView mv = new ModelAndView("airportErrorPage");
		mv.addObject("errorMessage", message);
		return mv;
	}
}
