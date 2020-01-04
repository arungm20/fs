package com.infosys.fs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableCircuitBreaker
@ComponentScan(basePackages = { "com.infosys.fs" })
public class Application {
	
	/**
	 * Main Method to start the application.
	 *
	 * @param args
	 *            Arguments.
	 */
	public static void main(String[] args) {
		
		new SpringApplication(Application.class).run(args);
	}
	
}
