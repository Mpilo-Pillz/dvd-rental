package com.dvdrental.springbootdvdrentalapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.dvdrental.springbootdvdrentalapi")
public class SpringbootDvdRentalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDvdRentalApiApplication.class, args);
	}

}
