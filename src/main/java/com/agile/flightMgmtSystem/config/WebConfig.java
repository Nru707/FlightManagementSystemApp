package com.agile.flightMgmtSystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/airport").setViewName("airport");
        registry.addViewController("/addAirport").setViewName("addAirport");
        registry.addViewController("/airportlist").setViewName("airportlist");
        registry.addViewController("/airportview").setViewName("airportview");
    }
}
