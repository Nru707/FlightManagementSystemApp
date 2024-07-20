package com.nru.FlightManagementSystemDemo.controller;

import java.util.List;

//Remove the unused import statement
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nru.FlightManagementSystemDemo.bean.Airport;
import com.nru.FlightManagementSystemDemo.dao.AirportDao;



@RestController
public class AirportManagementController {

	@Autowired
	private AirportDao airportDao;

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
	
	
	
	/*@GetMapping("/airport-select")
	public ModelAndView showAirportSelectPage() {
	List<String> codeList = airportDao.findAllAirportCodes();
	ModelAndView mv=new ModelAndView("airportSelectPage");
	mv.addObject("codeList",codeList);
	return mv;
	}
	
	*/
	
	/*@PostMapping("/airport-select")
    public ModelAndView showSingleAirportPage1(@RequestParam("airport-code") String id) {
	 Airport airport=airportDao.findAirportById(id);
	 ModelAndView mv=new ModelAndView("airportShowPage");
     mv.addObject("airport",airport);
	 return mv;
	}*/
	
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

	//@GetMapping("/airport/{id}")
	//public ModelAndView showSearchAirportPage(@PathVariable("id") String id) {
    //A/irport airport = airportDao.findAirportById(id.toUpperCase());
	//ModelAndView mv = new ModelAndView("airportShowPage");
	//mv.addObject("airport", airport);
	//r/eturn mv;
	//}

	



	

}