package com.entregaa3.product_stock_service_api.services;

import java.util.UUID;
import java.util.List;

import com.entregaa3.product_stock_service_api.dtos.ProductDto;

public interface ProductService {

	public ProductDto createProduct(ProductDto productDto);

	public ProductDto updateProduct(UUID productId, ProductDto productDto);

	public ProductDto showProduct(UUID productId);

	public List<ProductDto> listProducts();

	public void deleteProduct(UUID productId);
}
