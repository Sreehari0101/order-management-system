package com.order_management_system.order_service.service;

import com.order_management_system.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteOrderById {
    private final OrderRepository orderRepository;

    public void handle(String orderId){
        if(orderRepository.existsById(orderId)){
            orderRepository.deleteById(orderId);
        }
    }

}
