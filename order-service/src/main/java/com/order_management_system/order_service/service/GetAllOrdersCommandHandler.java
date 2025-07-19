package com.order_management_system.order_service.service;

import com.order_management_system.order_service.model.entity.Order;
import com.order_management_system.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class GetAllOrdersCommandHandler {
    private final OrderRepository orderRepository;

    public List<Order> handle(){
        return orderRepository.findAll();
    }
}
