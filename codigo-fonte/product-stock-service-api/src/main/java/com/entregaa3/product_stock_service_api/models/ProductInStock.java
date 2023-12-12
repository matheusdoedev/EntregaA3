package com.entregaa3.product_stock_service_api.models;

import java.util.UUID;

import com.entregaa3.product_stock_service_api.enums.ProductInStockStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products_in_stock")
public class ProductInStock {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@ManyToOne
	private Product product;

	@Column(nullable = false)
	private ProductInStockStatus status;
}
