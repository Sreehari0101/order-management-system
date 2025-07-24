package com.order_management_system.order_service.service;

import com.order_management_system.order_service.client.ProductClient;
import com.order_management_system.order_service.model.command.UpdateOrderCommand;
import com.order_management_system.order_service.model.dto.ProductDTO;
import com.order_management_system.order_service.model.entity.Order;
import com.order_management_system.order_service.model.entity.OrderItem;
import com.order_management_system.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UpdateOrderCommandHandler {
    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    public Order handle(String orderId, UpdateOrderCommand command) {
        Order existing = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with Id: " + orderId));
        List<OrderItem> orderItems = new ArrayList<>();
        if(command.getItems() != null){
            orderItems = command.getItems().stream().map(item ->{
                ProductDTO product = productClient.getProductById(item.getProductId());
                return OrderItem.builder()
                        .productId(item.getProductId())
                        .productName(product.getName())
                        .quantity(item.getQuantity())
                        .price(product.getPrice())
                        .build();
            }).collect(Collectors.toList());
        }

        existing.setCustomerId(command.getCustomerId());
        existing.setItems(orderItems);
        existing.setTotalAmount(calculateTotalAmount(orderItems));
        existing.setOrderDate(LocalDateTime.now());
        return orderRepository.save(existing);
    }

    private BigDecimal calculateTotalAmount(List<OrderItem> items) {
        return items.stream()
                .map(item -> {
                    return item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
