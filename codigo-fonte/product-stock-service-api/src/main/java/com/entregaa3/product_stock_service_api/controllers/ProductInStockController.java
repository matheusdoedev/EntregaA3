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

import com.entregaa3.product_stock_service_api.dtos.CreateProductInStockInBatchDto;
import com.entregaa3.product_stock_service_api.dtos.ProductInStockDto;
import com.entregaa3.product_stock_service_api.services.impl.ProductInStockServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/product-in-stock")
@Tag(name = "product-in-stock")
@AllArgsConstructor
public class ProductInStockController {
	private final ProductInStockServiceImpl productInStockService;

	@PostMapping("/create")
	@Operation(summary = "Create a new product in stock.")
	@ApiResponse(responseCode = "200", description = "Product in stock created.")
	public ResponseEntity<ProductInStockDto> postCreateProductInStock(
			@RequestBody ProductInStockDto productInStockDto) {
		ProductInStockDto savedProductInStockDto = this.productInStockService.createProductInStock(productInStockDto);

		return ResponseEntity.ok(savedProductInStockDto);
	}

	@PostMapping("/create-in-batch")
	@Operation(summary = "Create a new product in stock in batch.")
	@ApiResponse(responseCode = "200", description = "All products was created succesfully.")
	public ResponseEntity<List<ProductInStockDto>> postCreateProductInStockInBatch(
			@RequestBody CreateProductInStockInBatchDto createProductInStockInBatchDto) {
		List<ProductInStockDto> savedProductInStock = this.productInStockService
				.createProductInStockInBatch(createProductInStockInBatchDto);

		return ResponseEntity.ok(savedProductInStock);
	}

	@PutMapping("/update/{productInStockId}")
	@Operation(summary = "Update a product in stock.")
	@ApiResponse(responseCode = "200", description = "Product in stock updated.")
	@ApiResponse(responseCode = "404", description = "Product in stock not found.")
	public ResponseEntity<ProductInStockDto> putUpdateProductInStock(
			@PathVariable("productInStockId") UUID productInStockId,
			@RequestBody ProductInStockDto productInStockDto) {
		ProductInStockDto savedProductInStock = this.productInStockService.updateProductInStock(productInStockId,
				productInStockDto);

		return ResponseEntity.ok(savedProductInStock);
	}

	@GetMapping("")
	@Operation(summary = "List all products in stock.")
	@ApiResponse(responseCode = "200", description = "Products in stock listed.")
	public ResponseEntity<List<ProductInStockDto>> getAllProductsInStock() {
		List<ProductInStockDto> productsInStock = this.productInStockService.listProductsInStock();

		return ResponseEntity.ok(productsInStock);
	}

	@GetMapping("/available/{productId}")
	@Operation(summary = "It gets all available products from a specific product that can be sold.")
	@ApiResponse(responseCode = "200", description = "Products in stock listed.")
	public ResponseEntity<List<ProductInStockDto>> getAllProductsInStockAvailable(
			@PathVariable("productId") UUID productId) {
		List<ProductInStockDto> productsInStock = this.productInStockService
				.listProductsInStockAvailableToBeSold(productId);

		return ResponseEntity.ok(productsInStock);
	}

	@GetMapping("{productInStockId}")
	@Operation(summary = "Show a specific product in stock.")
	@ApiResponse(responseCode = "200", description = "Product in stock found.")
	@ApiResponse(responseCode = "404", description = "Product in stock not found.")
	public ResponseEntity<ProductInStockDto> getProductInStock(
			@PathVariable("productInStockId") UUID productInStockId) {
		ProductInStockDto productInStockDto = this.productInStockService.showProductInStock(productInStockId);

		return ResponseEntity.ok(productInStockDto);
	}

	@DeleteMapping("/delete/{productInStockId}")
	@Operation(summary = "Delete a product in stock.")
	@ApiResponse(responseCode = "200", description = "Product in stock deleted.")
	@ApiResponse(responseCode = "404", description = "Product in stock not found.")
	public ResponseEntity<String> deleteProductInStock(@PathVariable("productInStockId") UUID productInStockId) {
		this.productInStockService.deleteProductInStock(productInStockId);

		return ResponseEntity.ok("Product in stock deleted successfully.");
	}
}
