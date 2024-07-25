package com.FlightManagementSystemDemo.exception;

public class FlightException extends RuntimeException {
	 private static final long serialVersionUID = 1L;

	    public FlightException(String message) {
	        super(message);
	    }

	    public static long getSerialversionuid() {
	        return serialVersionUID;
	    }

}
