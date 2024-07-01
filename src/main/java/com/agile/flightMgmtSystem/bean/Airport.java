package com.agile.flightMgmtSystem.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airport {

    @Id
    private String airportCode; // Unique identifier for the Airport entity
    private String airportLocation;

    // Getters and Setters
    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }
}
