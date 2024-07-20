package com.nru.FlightManagementSystemDemo.dao;

import java.util.List;

import com.nru.FlightManagementSystemDemo.bean.Passenger;

public interface PassengerDao {
	public void save(Passenger passenger);

	public List<Passenger> findByTicketId(Long ticketNumber);

}
