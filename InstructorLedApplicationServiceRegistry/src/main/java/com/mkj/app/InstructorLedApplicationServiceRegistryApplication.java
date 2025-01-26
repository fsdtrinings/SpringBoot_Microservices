package com.mkj.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/*  it does the Service registry & load balancing*/

@SpringBootApplication
@EnableEurekaServer
public class InstructorLedApplicationServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstructorLedApplicationServiceRegistryApplication.class, args);
	}

}
