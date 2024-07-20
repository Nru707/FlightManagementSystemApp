package com.nru.FlightManagementSystemDemo.bean;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Passenger {
	
	    private TicketPassengerEmbed embeddedId;
	    
	    private int passengerDOB;
	    private Double fare;
	    private String passengerName; 
	    private String dob;
	    
	    @ManyToOne
	    @JoinColumn(name = "ticket_id", nullable = false)
	    private Ticket ticket;

	 
		public Passenger() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Passenger(TicketPassengerEmbed embeddedId, int passengerDOB, Double fare, String passengerName,
				String dob, Ticket ticket) {
			super();
			this.embeddedId = embeddedId;
			this.passengerDOB = passengerDOB;
			this.fare = fare;
			this.passengerName = passengerName;
			this.dob = dob;
			this.ticket = ticket;
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
		public int getPassengerDOB() {
			return passengerDOB;
		}
		public void setPassengerDOB(int passengerDOB) {
			this.passengerDOB = passengerDOB;
		}
		public Double getFare() {
			return fare;
		}
		public void setFare(Double fare) {
			this.fare = fare;
		}
		   public String getDob() {
				return dob;
			}
			public void setDob(String dob) {
				this.dob = dob;
			}
			public Ticket getTicket() {
		        return ticket;
		    }

		    public void setTicket(Ticket ticket) {
		        this.ticket = ticket;
		    }
		
			
		}
