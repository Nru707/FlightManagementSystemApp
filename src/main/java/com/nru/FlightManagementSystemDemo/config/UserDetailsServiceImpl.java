package com.nru.FlightManagementSystemDemo.config;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.nru.FlightManagementSystemDemo.bean.FlightUser;
import com.nru.FlightManagementSystemDemo.dao.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@PostConstruct
	public void init() {

		long count = repo.count();
		if (count == 0) {
			FlightUser flightUser = new FlightUser();
			flightUser.setUsername("admin");
			flightUser.setEmail("nru707@gmail.com");
			flightUser.setPassword(passwordEncoder.encode("Amra29260@"));
			flightUser.setUserType("ROLE_ADMIN");
			repo.save(flightUser);
		}

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		FlightUser flightUser = repo.getUserByUserName(username);
		if (flightUser != null) {
			CustomUserDetails customUserDetails = new CustomUserDetails(flightUser);
			return customUserDetails;
		}
		throw new UsernameNotFoundException("user not available");

	}

}
