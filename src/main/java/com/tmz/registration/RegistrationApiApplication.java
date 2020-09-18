package com.tmz.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.tmz.registration","com.tmz.registration.model.*"})
@EnableAutoConfiguration
public class RegistrationApiApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(RegistrationApiApplication.class, args);
	}
	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(RegistrationApiApplication.class);
		
	}
}
