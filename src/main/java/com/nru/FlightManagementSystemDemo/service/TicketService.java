package com.nru.FlightManagementSystemDemo.service;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nru.FlightManagementSystemDemo.bean.Flight;
import com.nru.FlightManagementSystemDemo.bean.Passenger;
import com.nru.FlightManagementSystemDemo.dao.FlightDao;

@Service
public class TicketService {
    @Autowired
    private FlightDao flightDao;
    
    
    public Double totalBillCalculation(List<Passenger> passengerList) {
    	double totalValue=0.0;
    	for(Passenger passenger:passengerList) {
    		totalValue=totalValue+passenger.getFare();
    	}
    	return totalValue;
    }


	public Double discountedFareCalculation(Passenger passenger) {
		 		int age = ageCalculation(passenger.getPassengerDOB());
		 		Double finalFare=0.0;

		        if (age < 14) {
		            finalFare= passenger.getFare()/2;
		        } else if (age >60) {
		        	finalFare= passenger.getFare()-(passenger.getFare()*0.30);
		        } else {
		        	finalFare= passenger.getFare();
		        }
		        return finalFare;
		    }




	private int ageCalculation(String dob) {
	   LocalDate today= LocalDate.now();
	   String dataArr[]=dob.split("-");
	   LocalDate birthday= LocalDate.of(Integer.parseInt(dataArr[0]),Integer.parseInt(dataArr[1]),Integer.parseInt(dataArr[2]));
	   Period period= Period.between(birthday, today);
	   int age=period.getYears();
	   return age;
	}


	public boolean capacityCalculation(int numberOfSeatBooking, Long flightNumber) {
		Flight flight=flightDao.findFlightById(flightNumber);
		int bookedSeat= flight.getSeatBooked()+numberOfSeatBooking;
		int balance=flight.getSeatCapacity()-bookedSeat;
		if(balance<0) {
			return false;
		}
		else {
			flight.setSeatBooked(bookedSeat);
			flightDao.save(flight);
		}
		return true;
	}
	
	
	
}