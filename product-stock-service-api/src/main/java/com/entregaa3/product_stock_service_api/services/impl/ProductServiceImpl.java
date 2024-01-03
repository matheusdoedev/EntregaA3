package com.entregaa3.product_stock_service_api.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.entregaa3.product_stock_service_api.dtos.ProductDto;
import com.entregaa3.product_stock_service_api.exceptions.ResourceNotFoundException;
import com.entregaa3.product_stock_service_api.mappers.ProductMapper;
import com.entregaa3.product_stock_service_api.models.Product;
import com.entregaa3.product_stock_service_api.repositories.ProductRepository;
import com.entregaa3.product_stock_service_api.services.ProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	private static final String RESOURCE_NAME = "Product";
	private static final String FIELD_NAME = "productId";

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		productDto.setId(UUID.randomUUID());

		Product product = ProductMapper.parseToEntity(productDto);

		this.productRepository.save(product);

		return productDto;
	}

	@Override
	public ProductDto updateProduct(UUID productId, ProductDto productDto) {
		Optional<Product> product = this.productRepository.findById(productId);

		if (!product.isPresent()) {
			throw new ResourceNotFoundException(RESOURCE_NAME, FIELD_NAME, productId.toString());
		}

		Product productToBeSaved = product.get();

		if (productDto.getDescription() != null) {
			productToBeSaved.setDescription(productDto.getDescription());
		}

		if (productDto.getName() != null) {
			productToBeSaved.setName(productDto.getName());
		}

		if (!Float.valueOf(productDto.getPrice()).isNaN()) {
			productToBeSaved.setPrice(productDto.getPrice());
		}

		this.productRepository.save(productToBeSaved);

		return ProductMapper.parseToDto(productToBeSaved);
	}

	@Override
	public ProductDto showProduct(UUID productId) {
		Optional<Product> product = this.productRepository.findById(productId);

		if (!product.isPresent()) {
			throw new ResourceNotFoundException(RESOURCE_NAME, FIELD_NAME, productId.toString());
		}

		Product foundProduct = product.get();

		return ProductMapper.parseToDto(foundProduct);
	}

	@Override
	public List<ProductDto> listProducts() {
		List<Product> products = this.productRepository.findAll();
		List<ProductDto> productsDto = new ArrayList<>();

		for (Product product : products) {
			productsDto.add(ProductMapper.parseToDto(product));
		}

		return productsDto;
	}

	@Override
	public void deleteProduct(UUID productId) {
		Optional<Product> product = this.productRepository.findById(productId);

		if (!product.isPresent()) {
			throw new ResourceNotFoundException(RESOURCE_NAME, FIELD_NAME, productId.toString());
		}

		Product productToBeDeleted = product.get();

		this.productRepository.delete(productToBeDeleted);
	}
}
