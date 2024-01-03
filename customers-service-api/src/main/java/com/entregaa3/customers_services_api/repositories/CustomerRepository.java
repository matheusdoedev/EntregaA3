package com.entregaa3.customers_services_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entregaa3.customers_services_api.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
