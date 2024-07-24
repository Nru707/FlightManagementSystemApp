package com.nru.FlightManagementSystemDemo.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AdminPageSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private CustomeLogoutHandler customeLogoutHandler;
	
	@Autowired
	public void setCustomeLogoutHandler(CustomeLogoutHandler customeLogoutHandler) {
		this.customeLogoutHandler = customeLogoutHandler;
	}

	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
        .authorizeRequests(requests -> requests
                .antMatchers("/admin/**").authenticated()
                //.antMatchers("/**").permitAll()
                )
                .formLogin(form -> form
                		.loginPage("/login")
                		.permitAll())
                .logout(logout -> logout
                		.addLogoutHandler(customeLogoutHandler)
                		.logoutUrl("/dologout")
                		); 
        return;
	}
}
