package com.order_management.product_service.repository;

import com.order_management.product_service.model.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String>, ProductCustomRepository {

}

