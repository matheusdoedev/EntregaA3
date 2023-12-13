package com.entregaa3.product_stock_service_api.mappers;

import com.entregaa3.product_stock_service_api.dtos.ProductDto;
import com.entregaa3.product_stock_service_api.models.Product;

public class ProductMapper {

	private ProductMapper() {
	}

	public static Product parseToEntity(ProductDto productDto) {
		return new Product(
				productDto.getId(),
				productDto.getName(),
				productDto.getDescription(),
				productDto.getPrice());
	}

	public static ProductDto parseToDto(Product product) {
		return new ProductDto(
				product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}
}
