package com.entregaa3.customers_services_api.services;

import java.util.List;
import java.util.UUID;

import com.entregaa3.customers_services_api.dto.CustomerDto;

public interface CustomerService {
	public CustomerDto createCustomer(CustomerDto customerDto);

	public CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto);

	public void deleteCustomer(UUID customerId);

	public CustomerDto showCustomer(UUID customerId);

	public List<CustomerDto> listCustomers();
}
