package com.nru.FlightManagementSystemDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nru.FlightManagementSystemDemo.bean.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	@Query("select max(ticketNumber) from Ticket")
	public Long findLastTicketNumber();

}
