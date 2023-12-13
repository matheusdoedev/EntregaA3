package com.entregaa3.product_stock_service_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entregaa3.product_stock_service_api.models.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
