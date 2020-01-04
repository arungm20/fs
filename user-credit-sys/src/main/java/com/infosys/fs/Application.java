package com.infosys.fs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan(basePackages = { "com.infosys.fs" })
@EnableAsync
public class Application {
	
	/**
	 * Main Method to start the application.
	 *
	 * @param args
	 *            Arguments.
	 */
	public static void main(String[] args){
		
		new SpringApplication(Application.class).run(args);
	}
	
}
