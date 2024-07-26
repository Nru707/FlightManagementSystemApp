package com.nru.FlightManagementSystemDemo.config;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		System.out.println(roles);
		
		 if (roles.contains("admin")) {
	            response.sendRedirect("/Admin/");
	        } else if (roles.contains("Customer")) {
	            response.sendRedirect("/Customer/");
	        } else {
	            response.sendRedirect("/"); // Default redirect if no specific role
	        }

	}

}
