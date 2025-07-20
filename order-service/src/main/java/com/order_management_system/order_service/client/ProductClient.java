package com.order_management_system.order_service.client;


import com.order_management_system.order_service.model.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url= "${product.service.url}")
public interface ProductClient {
    @GetMapping("/products/{productId}")
    ProductDTO getProductById(@PathVariable String productId);
}
