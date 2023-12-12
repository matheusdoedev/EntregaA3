package com.entregaa3.customers_services_api.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Customer DTO Schema.")
public class CustomerDto {

	@Schema(description = "Customer ID.")
	private UUID id;

	@Schema(description = "Customer first name.")
	private String firstName;

	@Schema(description = "Customer last name.")
	private String lastName;

	@Schema(description = "Customer e-mail.")
	private String email;
}