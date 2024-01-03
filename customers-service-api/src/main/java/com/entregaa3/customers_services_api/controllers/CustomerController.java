package com.entregaa3.customers_services_api.controllers;

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

import com.entregaa3.customers_services_api.dto.CustomerDto;
import com.entregaa3.customers_services_api.services.impl.CustomerServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/customers")
@Tag(name = "customers")
@AllArgsConstructor
public class CustomerController {

	private final CustomerServiceImpl customerService;

	@PostMapping("/create")
	@Operation(summary = "Create a new customer.")
	@ApiResponse(responseCode = "200", description = "Customer created.")
	public ResponseEntity<CustomerDto> postCreateCustomer(@RequestBody CustomerDto customerDto) {
		CustomerDto savedCustomer = this.customerService.createCustomer(customerDto);

		return ResponseEntity.ok(savedCustomer);
	}

	@PutMapping("/update/{customerId}")
	@Operation(summary = "Update a customer.")
	@ApiResponse(responseCode = "200", description = "Customer updated.")
	@ApiResponse(responseCode = "404", description = "Customer not found.")
	public ResponseEntity<CustomerDto> putUpdateCustomer(@PathVariable("customerId") UUID customerId,
			@RequestBody CustomerDto customerDto) {
		CustomerDto savedCustomer = this.customerService.updateCustomer(customerId, customerDto);

		return ResponseEntity.ok(savedCustomer);
	}

	@GetMapping("")
	@Operation(summary = "List all customers.")
	@ApiResponse(responseCode = "200", description = "Customers listed.")
	public ResponseEntity<List<CustomerDto>> getAllCustomers() {
		List<CustomerDto> customers = this.customerService.listCustomers();

		return ResponseEntity.ok(customers);
	}

	@GetMapping("{customerId}")
	@Operation(summary = "Show a specific customer.")
	@ApiResponse(responseCode = "200", description = "Customer found.")
	@ApiResponse(responseCode = "404", description = "Customer not found.")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
		CustomerDto customer = this.customerService.showCustomer(customerId);

		return ResponseEntity.ok(customer);
	}

	@DeleteMapping("/delete/{customerId}")
	@Operation(summary = "Delete a customer.")
	@ApiResponse(responseCode = "200", description = "Customer deleted.")
	@ApiResponse(responseCode = "404", description = "Customer not found.")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") UUID customerId) {
		this.customerService.deleteCustomer(customerId);

		return ResponseEntity.ok("Customer deleted successfully.");
	}
}
