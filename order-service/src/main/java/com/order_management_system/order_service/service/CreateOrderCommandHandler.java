package com.order_management_system.order_service.service;
import com.order_management_system.order_service.client.ProductClient;
import com.order_management_system.order_service.client.UserClient;
import com.order_management_system.order_service.exception.UserNotFoundException;
import com.order_management_system.order_service.model.command.CreateOrderCommand;
import com.order_management_system.order_service.model.dto.ProductDTO;
import com.order_management_system.order_service.model.dto.UserDTO;
import com.order_management_system.order_service.model.entity.Order;
import com.order_management_system.order_service.model.entity.OrderItem;
import com.order_management_system.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateOrderCommandHandler {
    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final UserClient userClient;

    public Order handle(CreateOrderCommand command){
        List<OrderItem> orderItems = new ArrayList<>();
        UserDTO user = null;

        if(command.getItems() != null){
            orderItems = command.getItems().stream().map(item ->{
                ProductDTO product = productClient.getProductById(item.getProductId());
                return OrderItem.builder()
                        .productId(item.getProductId())
                        .productName(product.getName())
                        .price(product.getPrice())
                        .quantity(item.getQuantity())
                        .build();
            }).collect(Collectors.toList());
        }
        if (command.getCustomerId() != null) {
            user = userClient.getUserById(command.getCustomerId());
            if (user == null) {
                throw new UserNotFoundException("User not found for customer ID: " + command.getCustomerId());
            }
        } else {
            throw new UserNotFoundException("Customer ID cannot be null.");
        }
        Order order = Order.builder()
                .customerId(command.getCustomerId())
                .customerName(user.getName())
                .customerEmail(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .items(orderItems)
                .totalAmount(calculateTotalAmount(orderItems))
                .orderDate(LocalDateTime.now())
                .build();
        return orderRepository.save(order);
    }


    private BigDecimal calculateTotalAmount(List<OrderItem> items) {
        return items.stream()
                .map(item -> {
                    return item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
