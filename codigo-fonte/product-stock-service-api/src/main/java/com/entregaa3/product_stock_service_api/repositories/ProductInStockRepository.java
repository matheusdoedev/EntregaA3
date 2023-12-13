package com.entregaa3.product_stock_service_api.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entregaa3.product_stock_service_api.enums.ProductInStockStatus;
import com.entregaa3.product_stock_service_api.models.ProductInStock;

public interface ProductInStockRepository extends JpaRepository<ProductInStock, UUID> {

	// @Query("SELECT * FROM products_in_stock p WHERE p.status = 'PENDING' AND
	// p.productId = ?1")
	List<ProductInStock> findByProductIdAndStatus(UUID productId, ProductInStockStatus status);
}
