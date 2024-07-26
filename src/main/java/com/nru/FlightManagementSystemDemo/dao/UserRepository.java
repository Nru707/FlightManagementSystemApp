package com.nru.FlightManagementSystemDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nru.FlightManagementSystemDemo.bean.FlightUser;

public interface UserRepository extends JpaRepository<FlightUser, Long> {

	@Query("SELECT u FROM FlightUser u WHERE u.email = :email")
	public FlightUser getUserByUserName(@Param("email") String email);

	public FlightUser findByEmail(String email);

	// Optional<FlightUser> findByUsername(String username);

	// Optional<Admin> findByUsername(String username);

}
