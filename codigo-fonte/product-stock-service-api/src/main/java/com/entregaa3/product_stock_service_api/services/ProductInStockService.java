package com.entregaa3.product_stock_service_api.services;

import java.util.List;
import java.util.UUID;

import com.entregaa3.product_stock_service_api.dtos.ProductInStockDto;

public interface ProductInStockService {

	public ProductInStockDto createProductInStock(ProductInStockDto productInStockDto);

	public ProductInStockDto updateProductInStock(UUID productInStockId, ProductInStockDto productInStockDto);

	public ProductInStockDto showProductInStock(UUID productInStockId);

	public List<ProductInStockDto> listProductsInStock();

	public void deleteProductInStock(UUID productInStockId);
}
