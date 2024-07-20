package com.nru.FlightManagementSystemDemo.dao;

import com.nru.FlightManagementSystemDemo.bean.Ticket;

public interface TicketDao {
	public void save(Ticket ticket);

    public Long findLastTicketNumber();


}
