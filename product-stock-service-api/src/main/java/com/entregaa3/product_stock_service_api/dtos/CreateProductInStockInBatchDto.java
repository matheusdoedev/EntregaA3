package com.entregaa3.product_stock_service_api.dtos;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Create product in batch dto.")
public class CreateProductInStockInBatchDto {

	@Schema(description = "Product id.")
	private UUID productId;

	@Schema(description = "The quantity of produts to be created in stock.")
	private int quantity;
}
