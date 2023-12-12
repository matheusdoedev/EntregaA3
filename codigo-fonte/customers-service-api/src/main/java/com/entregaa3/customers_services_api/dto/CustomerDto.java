package com.entregaa3.customers_services_api.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
}