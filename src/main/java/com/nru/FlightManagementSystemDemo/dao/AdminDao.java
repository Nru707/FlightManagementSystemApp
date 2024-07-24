package com.nru.FlightManagementSystemDemo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nru.FlightManagementSystemDemo.bean.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
	
	Optional<Admin> findByUsername(String username);

}
