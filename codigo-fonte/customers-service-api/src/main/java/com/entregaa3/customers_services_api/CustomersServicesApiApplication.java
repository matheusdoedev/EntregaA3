package com.entregaa3.customers_services_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Customers Service API", version = "v0.0.1", description = "Customers Service API."))
public class CustomersServicesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersServicesApiApplication.class, args);
	}

}
