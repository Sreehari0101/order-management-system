package com.order_management_system.order_service.repository;

import com.order_management_system.order_service.model.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {

}
