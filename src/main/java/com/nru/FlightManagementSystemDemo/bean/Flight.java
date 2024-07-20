package com.nru.FlightManagementSystemDemo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {
	
	@Id
	private Long flightNumber;
	private String carrierName;
	private Integer seatCapacity;
	private Long RouteId;
	private String departure;
	private String arrival;
	private Integer seatBooked;
	
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flight(Long flightNumber, String carrierName, Integer seatCapacity, Long routeId, String departure,
			String arrival) {
		super();
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
		this.RouteId = routeId;
		this.departure = departure;
		this.arrival = arrival;
		this.seatBooked =0;
	}

	
	public Long getRouteId() {
		return RouteId;
	}
	public void setRouteId(Long routeId) {
		RouteId = routeId;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
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
	public Integer getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(Integer seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	
	public Integer getSeatBooked() {
		return seatBooked;
	}
	public void setSeatBooked(Integer seatBooked) {
		this.seatBooked = seatBooked;
	}


}
