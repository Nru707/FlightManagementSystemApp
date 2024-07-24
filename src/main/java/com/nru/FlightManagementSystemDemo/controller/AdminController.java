package com.nru.FlightManagementSystemDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nru.FlightManagementSystemDemo.bean.Airport;
import com.nru.FlightManagementSystemDemo.dao.AirportDao;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AirportDao airportDao;
	
	@GetMapping("/")
	public String Home() {
		return"Home";
	}
	
	@GetMapping("/index")
	public ModelAndView showIndexPage() {
		return new ModelAndView("index");
	}

	@GetMapping("/airport")
	public ModelAndView showAirportEntryPage() {
		Airport airport = new Airport();
		ModelAndView mv = new ModelAndView("airportEntryPage");
		mv.addObject("airportRecord", airport);
		return mv;
	}
	
	@PostMapping("/airport")
	public ModelAndView saveAirport(@ModelAttribute("airportRecord") Airport airport) {
		String str = airport.getAirportCode().toUpperCase();
		airport.setAirportCode(str);
	     String stg = airport.getAirportLocation().toUpperCase();
		airport.setAirportLocation(stg);
		airportDao.addAirport(airport);
		return new ModelAndView("index");
	}
	
	@GetMapping("/airport/{id}")
    public ModelAndView showSingleAirportPage(@PathVariable("id") String id) {
	 Airport airport=airportDao.findAirportById(id);
	 ModelAndView mv=new ModelAndView("airportShowPage");
     mv.addObject("airport",airport);
	 return mv;
	}
	
	
	
	
	@GetMapping("/airports")
	public ModelAndView showAirportReportPage() {
		List<Airport> airportList = airportDao.findAllAirports();
		ModelAndView mv = new ModelAndView("airportReportPage");
		mv.addObject("airportList", airportList);
		return mv;
	}
}
