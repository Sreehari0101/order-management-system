package com.order_management.product_service.controller;

import com.order_management.product_service.model.command.CreateProductCommand;
import com.order_management.product_service.model.entity.Product;
import com.order_management.product_service.service.CreateProductCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final CreateProductCommandHandler createProductCommandHandler;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductCommand command){
        Product created = createProductCommandHandler.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

}
