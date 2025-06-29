package com.nru.FlightManagementSystemDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*@SpringBootApplication
public class FlightManagementSystemDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(FlightManagementSystemDemo1Application.class, args);
	}

}*/

@SpringBootApplication
public class FlightManagementSystemDemo1Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FlightManagementSystemDemo1Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FlightManagementSystemDemo1Application.class);
    }
}

