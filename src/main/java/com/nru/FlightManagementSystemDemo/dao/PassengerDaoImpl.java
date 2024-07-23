package com.nru.FlightManagementSystemDemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.nru.FlightManagementSystemDemo.bean.Passenger;

@Service
@Repository
public class PassengerDaoImpl implements PassengerDao {
	
	@Autowired
	private PassengerRepository repository;

	@Override
	public void save(Passenger passenger) {
		repository.save(passenger);
	}

	@Override
	public List<Passenger> findByTicketId(Long ticketNumber) {
		// TODO Auto-generated method stub
		return null;
	}


}
