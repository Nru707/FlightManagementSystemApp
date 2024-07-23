package com.FlightManagementSystemDemo.exception;

public class RouteException extends RuntimeException  {
	   private static final long serialVersionUID = 1L;
	    public RouteException(String message) {
	        super(message);
	    }

	    public static long getSerialversionuid() {
	        return serialVersionUID;
	    }

}
