package com.nru.FlightManagementSystemDemo.bean;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
@Entity
public class Passenger {
	    @EmbeddedId
	    private TicketPassengerEmbed embeddedId;
	    private String passengerDOB;
	    private Double fare;
	    private String passengerName; 
	 
		public Passenger() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Passenger(TicketPassengerEmbed embeddedId , String passengerName, String passengerDOB, Double fare) {
			super();
			this.embeddedId = embeddedId;
			this.passengerDOB = passengerDOB;
			this.fare = fare;
			this.passengerName = passengerName;
		}

		public String getPassengerName() {
			return passengerName;
		}
		public void setPassengerName(String passengerName) {
			this.passengerName = passengerName;
		}
		public TicketPassengerEmbed getEmbeddedId() {
			return embeddedId;
		}
		public void setEmbeddedId(TicketPassengerEmbed embeddedId) {
			this.embeddedId = embeddedId;
		}
		public String getPassengerDOB() {
			return passengerDOB;
		}
		public void setPassengerDOB(String passengerDOB) {
			this.passengerDOB = passengerDOB;
		}
		public Double getFare() {
			return fare;
		}
		public void setFare(Double fare) {
			this.fare = fare;
		}
		
			
		}
