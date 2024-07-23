package com.nru.FlightManagementSystemDemo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nru.FlightManagementSystemDemo.bean.FlightUser;


public interface UserRepository extends JpaRepository<FlightUser, Long> {
	
    FlightUser findByEmail(String email);

	Optional<FlightUser> findById(String username);

	
}
