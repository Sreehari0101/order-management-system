package com.order_management_system.order_service.repository;

import com.order_management_system.order_service.model.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,String> {
    public List<Order> findByCustomerId(String customerId);

}
