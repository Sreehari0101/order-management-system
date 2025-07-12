package com.order_management.product_service.repository;

import com.order_management.product_service.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<Product> findByCategory(String category){
        Query query = new Query(Criteria.where("category").is(category));
        return mongoTemplate.find(query,Product.class);
    }

}
