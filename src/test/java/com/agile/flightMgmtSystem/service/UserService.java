package com.agile.flightMgmtSystem.service;



import com.agile.flightMgmtSystem.entity.FlightUser;
import com.agile.flightMgmtSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(FlightUser user) {
        userRepository.save(user);
    }
    
    public boolean validateUser(String Username, String password) {
        FlightUser user = userRepository.findByUsername(Username);
        return user != null && user.getPassword().equals(password);
    }
}

