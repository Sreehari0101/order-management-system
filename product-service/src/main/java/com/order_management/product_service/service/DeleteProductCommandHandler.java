package com.order_management.product_service.service;

import com.order_management.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductCommandHandler {
    private final ProductRepository productRepository;

    public void hande(String productId){
        if(!productRepository.existsById(productId)){
            throw new RuntimeException("Product not found with ID: " + productId);
        }
        productRepository.deleteById(productId);
    }

}
