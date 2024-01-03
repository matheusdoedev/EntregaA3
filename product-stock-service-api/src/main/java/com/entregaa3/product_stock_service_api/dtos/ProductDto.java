package com.entregaa3.product_stock_service_api.dtos;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Product DTO Schema.")
public class ProductDto {

	@Schema(description = "Product ID.")
	private UUID id;

	@Schema(description = "Product name.")
	private String name;

	@Schema(description = "Product description.")
	private String description;

	@Schema(description = "Product price in BRL .")
	private float price;
}
