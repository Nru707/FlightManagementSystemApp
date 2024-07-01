package com.agile.flightMgmtSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agile.flightMgmtSystem.bean.FlightUser;

public interface UserRepository extends JpaRepository<FlightUser, Long> {
    FlightUser findByEmail(String email);
}
