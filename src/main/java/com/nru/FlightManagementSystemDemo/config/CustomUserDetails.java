package com.nru.FlightManagementSystemDemo.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nru.FlightManagementSystemDemo.bean.FlightUser;

public class CustomUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private FlightUser flightuser;


	public CustomUserDetails(FlightUser flightuser) {
		super();
		this.flightuser = flightuser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority  = new SimpleGrantedAuthority (flightuser.getUserType());
		System.out.println(simpleGrantedAuthority);
		
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		return flightuser.getPassword();
	}

	@Override
	public String getUsername() {
		return flightuser.getEmail();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	
	@Override
	public boolean isEnabled() {
		return true;
	}

}
