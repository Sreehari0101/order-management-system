package com.order_management.product_service.service;

import com.order_management.product_service.model.command.UpdatePriceQuantityCommand;
import com.order_management.product_service.model.entity.Product;
import com.order_management.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePriceQuantityCommandHandler {
    private final ProductRepository productRepository;

    public Product handle(String productId, UpdatePriceQuantityCommand command){
        Product existing = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with Id: " +productId));
        if(command.getQuantity() != existing.getQuantity()){
            existing.setQuantity(command.getQuantity());
        }
        if(command.getPrice() != existing.getPrice()){
            existing.setPrice(command.getPrice());
        }
        return productRepository.save(existing);
    }
}
