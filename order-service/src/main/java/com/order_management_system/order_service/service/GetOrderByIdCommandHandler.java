package com.order_management_system.order_service.service;

import com.order_management_system.order_service.model.entity.Order;
import com.order_management_system.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOrderByIdCommandHandler {
    private final OrderRepository orderRepository;

    public Order handle(String orderId){
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID:" + orderId));
    }
}
