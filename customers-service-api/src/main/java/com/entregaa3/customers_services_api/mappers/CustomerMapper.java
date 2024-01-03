package com.entregaa3.customers_services_api.mappers;

import com.entregaa3.customers_services_api.dto.CustomerDto;
import com.entregaa3.customers_services_api.models.Customer;

public class CustomerMapper {
	private CustomerMapper() {
	}

	public static Customer parseToEntity(CustomerDto customerDto) {
		return new Customer(
				customerDto.getId(),
				customerDto.getFirstName(),
				customerDto.getLastName(),
				customerDto.getEmail());

	}

	public static CustomerDto parseToDto(Customer customer) {
		return new CustomerDto(
				customer.getId(),
				customer.getFirstName(),
				customer.getLastName(),
				customer.getEmail());
	}
}
