package com.nru.FlightManagementSystemDemo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket {
    @Id
    private Long ticketNumber;
    private String carrierName;
    private Long flightNumber;
   private Double totalAmount;
    
    
    public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(Long ticketNumber,  Long flightNumber, String carrierName, Double totalAmount) {
		super();
		this.ticketNumber = ticketNumber;
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.totalAmount = totalAmount;
	}
	

	public Long getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(Long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	
	public Long getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String toString() {
		return "Ticket [ ticketNumber=" + ticketNumber  +",flightNumber =" +flightNumber+", carrierName="+ carrierName + ", totalAmount=" + totalAmount + "] ";
	}

}
