package com.agile.flightMgmtSystem.service;

import com.agile.flightMgmtSystem.bean.FlightUser;
import com.agile.flightMgmtSystem.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void saveUser(FlightUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public boolean validateUser(String email, String password) {
        FlightUser user = userRepository.findByEmail(email);
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }
    

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}