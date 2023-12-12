package com.entregaa3.customers_services_api.controllers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/health-check")
public class HealthCheckController {

	@GetMapping("")
	public String healthCheck() {
		return LocalDateTime.now().toString();
	}
}
