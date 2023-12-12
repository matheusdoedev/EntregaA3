package com.entregaa3.customers_services_api.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.entregaa3.customers_services_api.dto.CustomerDto;
import com.entregaa3.customers_services_api.exceptions.ResourceNotFoundException;
import com.entregaa3.customers_services_api.mappers.CustomerMapper;
import com.entregaa3.customers_services_api.models.Customer;
import com.entregaa3.customers_services_api.repositories.CustomerRepository;
import com.entregaa3.customers_services_api.services.CustomerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	private static final String RESOURCE_NAME = "Customer";
	private static final String FIELD_NAME = "customerId";

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		customerDto.setId(UUID.randomUUID());

		Customer customer = CustomerMapper.parseToEntity(customerDto);

		this.customerRepository.save(customer);

		return customerDto;
	}

	@Override
	public CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto) {
		Optional<Customer> customer = this.customerRepository.findById(customerId);

		if (!customer.isPresent()) {
			throw new ResourceNotFoundException(RESOURCE_NAME, FIELD_NAME, customerId.toString());
		}

		Customer customerToBeSaved = customer.get();

		if (customerDto.getFirstName() != null) {
			customerToBeSaved.setFirstName(customerDto.getFirstName());
		}

		if (customerDto.getLastName() != null) {
			customerToBeSaved.setLastName(customerDto.getLastName());
		}

		if (customerDto.getEmail() != null) {
			customerToBeSaved.setEmail(customerDto.getEmail());
		}

		this.customerRepository.save(customerToBeSaved);

		return CustomerMapper.parseToDto(customerToBeSaved);
	}

	@Override
	public void deleteCustomer(UUID customerId) {
		Optional<Customer> customer = this.customerRepository.findById(customerId);

		if (!customer.isPresent()) {
			throw new ResourceNotFoundException(RESOURCE_NAME, FIELD_NAME, customerId.toString());
		}

		Customer customerToBeDeleted = customer.get();

		this.customerRepository.delete(customerToBeDeleted);
	}

	@Override
	public CustomerDto showCustomer(UUID customerId) {
		Optional<Customer> customer = this.customerRepository.findById(customerId);

		if (!customer.isPresent()) {
			throw new ResourceNotFoundException(RESOURCE_NAME, FIELD_NAME, customerId.toString());
		}

		Customer foundCustomer = customer.get();

		return CustomerMapper.parseToDto(foundCustomer);
	}

	@Override
	public List<CustomerDto> listCustomers() {
		List<Customer> customers = this.customerRepository.findAll();
		List<CustomerDto> customersDto = new ArrayList<>();

		for (Customer customer : customers) {
			customersDto.add(CustomerMapper.parseToDto(customer));
		}

		return customersDto;
	}

}
