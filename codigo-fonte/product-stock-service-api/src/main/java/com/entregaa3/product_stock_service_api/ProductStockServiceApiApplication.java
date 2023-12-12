package com.entregaa3.product_stock_service_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Product Stock Service API", version = "v0.0.1", description = "Product Stock Service API"))
public class ProductStockServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductStockServiceApiApplication.class, args);
	}

}
