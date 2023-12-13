package com.entregaa3.product_stock_service_api.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.entregaa3.product_stock_service_api.dtos.ProductInStockDto;
import com.entregaa3.product_stock_service_api.exceptions.ResourceNotFoundException;
import com.entregaa3.product_stock_service_api.mappers.ProductInStockMapper;
import com.entregaa3.product_stock_service_api.models.Product;
import com.entregaa3.product_stock_service_api.models.ProductInStock;
import com.entregaa3.product_stock_service_api.repositories.ProductInStockRepository;
import com.entregaa3.product_stock_service_api.repositories.ProductRepository;
import com.entregaa3.product_stock_service_api.services.ProductInStockService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductInStockServiceImpl implements ProductInStockService {
	private final ProductInStockRepository productInStockRepository;
	private final ProductRepository productRepository;

	private static final String RESOURCE_NAME = "ProductInStock";
	private static final String FIELD_NAME = "productInStockId";

	@Override
	public ProductInStockDto createProductInStock(ProductInStockDto productInStockDto) {
		productInStockDto.setId(UUID.randomUUID());

		Optional<Product> product = this.productRepository.findById(productInStockDto.getProductId());

		if (!product.isPresent()) {
			throw new ResourceNotFoundException(RESOURCE_NAME, FIELD_NAME, productInStockDto.getProductId().toString());
		}

		Product productFound = product.get();

		ProductInStock productInStock = ProductInStockMapper.parseToEntity(productInStockDto, productFound);

		this.productInStockRepository.save(productInStock);

		return productInStockDto;
	}

	@Override
	public ProductInStockDto updateProductInStock(UUID productInStockId, ProductInStockDto productInStockDto) {
		Optional<ProductInStock> productInStock = this.productInStockRepository.findById(productInStockId);

		if (!productInStock.isPresent()) {
			throw new ResourceNotFoundException(RESOURCE_NAME, FIELD_NAME, productInStockId.toString());
		}

		ProductInStock productInStockToBeSaved = productInStock.get();

		if (productInStockDto.getStatus() != null) {
			productInStockToBeSaved.setStatus(productInStockDto.getStatus());
		}

		this.productInStockRepository.save(productInStockToBeSaved);

		return ProductInStockMapper.parseToDto(productInStockToBeSaved);
	}

	@Override
	public void deleteProductInStock(UUID productInStockId) {
		Optional<ProductInStock> productInStock = this.productInStockRepository.findById(productInStockId);

		if (!productInStock.isPresent()) {
			throw new ResourceNotFoundException(RESOURCE_NAME, FIELD_NAME, productInStockId.toString());
		}

		ProductInStock productInStockToBeDeleted = productInStock.get();

		this.productInStockRepository.delete(productInStockToBeDeleted);
	}

	@Override
	public ProductInStockDto showProductInStock(UUID productInStockId) {
		Optional<ProductInStock> productInStock = this.productInStockRepository.findById(productInStockId);

		if (!productInStock.isPresent()) {
			throw new ResourceNotFoundException(RESOURCE_NAME, FIELD_NAME, productInStockId.toString());
		}

		ProductInStock foundProductInStock = productInStock.get();

		return ProductInStockMapper.parseToDto(foundProductInStock);
	}

	@Override
	public List<ProductInStockDto> listProductsInStock() {
		List<ProductInStock> productsInStock = this.productInStockRepository.findAll();
		List<ProductInStockDto> productsInStockDto = new ArrayList<>();

		for (ProductInStock productInStock : productsInStock) {
			productsInStockDto.add(ProductInStockMapper.parseToDto(productInStock));
		}

		return productsInStockDto;
	}
}
