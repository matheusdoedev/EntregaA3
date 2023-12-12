package com.entregaa3.product_stock_service_api.dtos;

import java.util.UUID;

import com.entregaa3.product_stock_service_api.enums.ProductInStockStatus;
import com.entregaa3.product_stock_service_api.models.Product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Product In Stock DTO Schema.")
public class ProductInStockDto {

	@Schema(description = "Product unit in stock id.")
	private UUID id;

	@Schema(description = "Product SKU.")
	private Product product;

	@Schema(description = "Product unit status.")
	private ProductInStockStatus status;
}
