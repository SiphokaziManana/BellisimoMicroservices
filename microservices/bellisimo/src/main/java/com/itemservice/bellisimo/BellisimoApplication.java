package com.itemservice.bellisimo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EnableDiscoveryClient
//@SpringBootApplication
@ComponentScan("com.itemservice")
public class BellisimoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BellisimoApplication.class, args);
	}
}
