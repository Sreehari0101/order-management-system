package com.order_management.product_service.repository;

import com.order_management.product_service.model.entity.Product;

import java.util.List;

public interface ProductCustomRepository {
    List<Product> findByCategory(String category);
}
