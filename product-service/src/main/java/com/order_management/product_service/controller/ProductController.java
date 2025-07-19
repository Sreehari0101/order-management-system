package com.order_management.product_service.controller;
import com.order_management.product_service.model.command.CreateProductCommand;
import com.order_management.product_service.model.command.UpdatePriceQuantityCommand;
import com.order_management.product_service.model.command.UpdateProductCommand;
import com.order_management.product_service.model.entity.Product;
import com.order_management.product_service.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final CreateProductCommandHandler createProductCommandHandler;
    private final GetAllProductsCommandHandler getAllProductsCommandHandler;
    private final GetProductCommandHandler getProductCommandHandler;
    private final UpdateProductCommandHandler updateProductCommandHandler;
    private final DeleteProductCommandHandler deleteProductCommandHandler;
    private final UpdatePriceQuantityCommandHandler updatePriceQuantityCommandHandler;
    private final GetProductsByCategoryCommandhandler getProductsByCategoryCommandhandler;


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductCommand command){
        Product created = createProductCommandHandler.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = getAllProductsCommandHandler.handle();
        return ResponseEntity.ok(products);

    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable String productId){
        Product product = getProductCommandHandler.handle(productId);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProductById(@PathVariable String productId,
                                                     @RequestBody UpdateProductCommand command){
        Product product = updateProductCommandHandler.handle(productId, command);
        return ResponseEntity.ok(product);
    }

    @PatchMapping("/{productId}/price-quantity")
    public ResponseEntity<Product> updatePriceQuantityById(@PathVariable String productId,
                                                           @RequestBody UpdatePriceQuantityCommand command){
        Product product = updatePriceQuantityCommandHandler.handle(productId,command);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable String productId){
        deleteProductCommandHandler.hande(productId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>>  getProductBycategory(@PathVariable String category){
        List<Product> products = getProductsByCategoryCommandhandler.handle(category);
        return ResponseEntity.ok(products);
    }


}
