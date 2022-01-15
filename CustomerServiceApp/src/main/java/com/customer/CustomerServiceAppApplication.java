package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.customer")
public class CustomerServiceAppApplication {

	public static void main(String[] args) {
		System.out.println("Customer service started");
		SpringApplication.run(CustomerServiceAppApplication.class, args);
	}

}
