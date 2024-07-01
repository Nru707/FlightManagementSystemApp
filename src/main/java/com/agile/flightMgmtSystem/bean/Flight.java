package com.agile.flightMgmtSystem.bean;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @Column(name = "flight_number")
    private Long flightNumber;

    @Column(name = "carrier_name")
    private String carrierName;

    @Column(name = "seat_capacity")
    private int seatCapacity;

    @Column(name = "route_id")
    private Long routeId;

    @Column(name = "departure")
    private String departure;

    @Column(name = "arrival")
    private String arrival;

    // Getters and Setters

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

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
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
}
