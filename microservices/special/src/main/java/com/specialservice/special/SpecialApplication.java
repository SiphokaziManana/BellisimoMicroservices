package com.specialservice.special;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EnableDiscoveryClient
//@SpringBootApplication
@ComponentScan("com.specialservice")
public class SpecialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpecialApplication.class, args);
	}
}
