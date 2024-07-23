package com.nru.FlightManagementSystemDemo.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import com.nru.FlightManagementSystemDemo.bean.Passenger;
import com.nru.FlightManagementSystemDemo.bean.TicketPassengerEmbed;

public interface PassengerRepository extends JpaRepository<Passenger, TicketPassengerEmbed> {

}
