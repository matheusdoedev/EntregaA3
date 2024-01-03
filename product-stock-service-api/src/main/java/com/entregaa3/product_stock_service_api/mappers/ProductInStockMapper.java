package com.entregaa3.product_stock_service_api.mappers;

import com.entregaa3.product_stock_service_api.dtos.ProductInStockDto;
import com.entregaa3.product_stock_service_api.models.Product;
import com.entregaa3.product_stock_service_api.models.ProductInStock;

public class ProductInStockMapper {

	private ProductInStockMapper() {
	}

	public static ProductInStock parseToEntity(ProductInStockDto productInStockDto, Product product) {
		return new ProductInStock(
				productInStockDto.getId(),
				product, productInStockDto.getStatus());
	}

	public static ProductInStockDto parseToDto(ProductInStock productInStock) {
		return new ProductInStockDto(
				productInStock.getId(),
				productInStock.getProduct().getId(),
				productInStock.getStatus());
	}
}