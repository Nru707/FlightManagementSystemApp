package com.nru.FlightManagementSystemDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class PageSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private LogOutHandler logOutHandler;
	
	@Autowired
	public void setLogOutHandler(LogOutHandler logOutHandler) {
		this.logOutHandler = logOutHandler;
	}

	private AuthenticationSuccessHandler successHandler;
	
	@Autowired
	public void setSuccessHandler( @Lazy AuthenticationSuccessHandler successHandler) {
		this.successHandler = successHandler;
	}

	@Bean
	UserDetailsService getuserDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.getuserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
		return daoAuthenticationProvider;
	}

	@Bean
	AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new LoginSuccessHandler();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider( authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeRequests(requests -> requests.antMatchers("/Admin/**").hasRole("ADMIN")
                .antMatchers("/customer/**").hasRole("CUSTOMER").antMatchers("/**").permitAll())
                .formLogin(login -> login.loginPage("/Login").loginProcessingUrl("/Login").successHandler(successHandler).permitAll())
                .logout(logout -> logout.addLogoutHandler(logOutHandler).logoutUrl("/Logout"));
	}

}
