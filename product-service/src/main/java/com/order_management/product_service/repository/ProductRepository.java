package com.order_management.product_service.repository;

import com.order_management.product_service.model.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
    public List<Product> findByCategory(String category);

}

