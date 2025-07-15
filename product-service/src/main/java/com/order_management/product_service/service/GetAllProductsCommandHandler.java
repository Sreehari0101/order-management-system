package com.order_management.product_service.service;

import com.order_management.product_service.model.entity.Product;
import com.order_management.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GetAllProductsCommandHandler {
    private final ProductRepository productRepository;

    public List<Product> handle(){
        return productRepository.findAll();

    }
}
