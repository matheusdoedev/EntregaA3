package com.entregaa3.product_stock_service_api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entregaa3.product_stock_service_api.dtos.ProductDto;
import com.entregaa3.product_stock_service_api.services.impl.ProductServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/products")
@Tag(name = "products")
@AllArgsConstructor
public class ProductController {
	private final ProductServiceImpl productService;

	@PostMapping("/create")
	@Operation(summary = "Create a new product.")
	@ApiResponse(responseCode = "200", description = "Product created.")
	public ResponseEntity<ProductDto> postCreateProduct(@RequestBody ProductDto productDto) {
		ProductDto savedProduct = this.productService.createProduct(productDto);

		return ResponseEntity.ok(savedProduct);
	}

	@PutMapping("/update/{productId}")
	@Operation(summary = "Update a product.")
	@ApiResponse(responseCode = "200", description = "Product updated.")
	@ApiResponse(responseCode = "404", description = "Product not found.")
	public ResponseEntity<ProductDto> putUpdateProduct(@PathVariable("productId") UUID productId,
			@RequestBody ProductDto productDto) {
		ProductDto savedProduct = this.productService.updateProduct(productId, productDto);

		return ResponseEntity.ok(savedProduct);
	}

	@GetMapping("")
	@Operation(summary = "List all products.")
	@ApiResponse(responseCode = "200", description = "Products listed.")
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		List<ProductDto> products = this.productService.listProducts();

		return ResponseEntity.ok(products);
	}

	@GetMapping("{productId}")
	@Operation(summary = "Show a specific product.")
	@ApiResponse(responseCode = "200", description = "Product found.")
	@ApiResponse(responseCode = "404", description = "Product not found.")
	public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") UUID productId) {
		ProductDto productDto = this.productService.showProduct(productId);

		return ResponseEntity.ok(productDto);
	}

	@DeleteMapping("/delete/{productId}")
	@Operation(summary = "Delete a product.")
	@ApiResponse(responseCode = "200", description = "Product deleted.")
	@ApiResponse(responseCode = "404", description = "Product not found.")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") UUID productId) {
		this.productService.deleteProduct(productId);

		return ResponseEntity.ok("Product deleted successfully.");
	}
}
