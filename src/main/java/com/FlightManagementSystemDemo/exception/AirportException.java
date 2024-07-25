package com.FlightManagementSystemDemo.exception;

public class AirportException extends RuntimeException {
    private static final long serialVersionUID = 1L;

   
    public AirportException(String message) {
        super(message);
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
