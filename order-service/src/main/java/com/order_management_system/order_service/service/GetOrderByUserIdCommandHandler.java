package com.order_management_system.order_service.service;

import com.order_management_system.order_service.model.entity.Order;
import com.order_management_system.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetOrderByUserIdCommandHandler {
    private final OrderRepository orderRepository;

    public List<Order> handle(String userId){
        return orderRepository.findByCustomerId(userId);
    }
}
