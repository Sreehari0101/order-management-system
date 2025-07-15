package com.order_management.product_service.service;

import com.order_management.product_service.model.entity.Product;
import com.order_management.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductCommandHandler {
    private final ProductRepository productRepository;
    public Product handle(String productId){
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID:" + productId));
    }
}
