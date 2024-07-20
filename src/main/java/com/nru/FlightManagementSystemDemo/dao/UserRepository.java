package com.nru.FlightManagementSystemDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nru.FlightManagementSystemDemo.bean.FlightUser;


public interface UserRepository extends JpaRepository<FlightUser, Long> {
	
    FlightUser findByEmail(String email);
}
