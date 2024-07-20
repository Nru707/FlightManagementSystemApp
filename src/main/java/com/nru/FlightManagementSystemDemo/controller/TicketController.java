package com.nru.FlightManagementSystemDemo.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nru.FlightManagementSystemDemo.bean.Flight;
import com.nru.FlightManagementSystemDemo.bean.Passenger;
import com.nru.FlightManagementSystemDemo.bean.Route;
import com.nru.FlightManagementSystemDemo.bean.Ticket;
import com.nru.FlightManagementSystemDemo.dao.FlightDao;
import com.nru.FlightManagementSystemDemo.dao.PassengerDao;
import com.nru.FlightManagementSystemDemo.dao.RouteDao;
import com.nru.FlightManagementSystemDemo.dao.TicketDao;
import com.nru.FlightManagementSystemDemo.service.TicketService;


@ControllerAdvice
@RestController
public class TicketController {
	
	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private PassengerDao passengerDao;
	
	@Autowired
	private RouteDao routeDao;
	
	
	@Autowired
	private TicketService ticketService;
	
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
    	 Long ticketNumber = ticketDao.findLastTicketNumber() + 1;
         ticket.setTicketNumber(ticketNumber);
         System.out.println("Ticket Number: " + ticket.getTicketNumber());

         // Save the ticket first
         ticketDao.save(ticket);

         Double totalAmount = 0.0;
         Integer totalSeats = ticketService.getTotalSeats(ticket.getFlightNumber());
         Integer bookedSeats = ticketService.getBookedSeats(ticket.getFlightNumber());
         System.out.println("Total Seats: " + totalSeats);
         System.out.println("Booked Seats: " + bookedSeats);

         ModelAndView mv = new ModelAndView("showTicketPage");
         String fromCity = request.getParameter("fromLocation");
         String toCity = request.getParameter("toLocation");
         Double basePrice = Double.parseDouble(request.getParameter("totalAmount"));
         String passengerName = "";
         String dob = "";
         Long totalPassengers = 0L;
         for (int i = 1; i <= 6; i++) {
             passengerName = request.getParameter("name" + i);
             dob= request.getParameter("dob" + i);
             if (passengerName.equals("--"))
                 continue;
             Passenger passenger = new Passenger();
             passenger.setPassengerName(passengerName);
             passenger.setDob(dob);
             passenger.setTicket(ticket);
             passenger.setFare(ticket.getTotalAmount());
             passenger.setPassengerDOB(LocalDate.now().getYear() - LocalDate.parse(dob).getYear());
             passengerDao.save(passenger);
             totalAmount += ticketService.calculateFinalTicketPrice(LocalDate.parse(dob).getYear(), basePrice,
                     totalSeats, bookedSeats);
             totalPassengers++;
             System.out.println("name " + passengerName + "dob " + passengerName);
         }
        /* if (totalPassengers == 0) {
             ticketDao.delete(ticket);
             throw new TicketException("No passengers added to the ticket");
         }*/
         ticket.setTotalAmount(totalAmount);
         ticketService.updateBookedSeats(ticket.getFlightNumber(), totalPassengers);
         ticketDao.save(ticket);
         List<Passenger> passengerList = passengerDao.findByTicketId(ticketNumber);
         mv.addObject("passengerList", passengerList);
         mv.addObject("ticketRecord", ticket);
         return mv;
     }
    }


