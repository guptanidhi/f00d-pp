package com.stackroute.foodapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.stackroute.foodapp.config.JwtFilter;

@SpringBootApplication
public class App {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/secureService/*", "/restaurantService/*");

		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}