package com.order_management_system.order_service.service;
import com.order_management_system.order_service.client.ProductClient;
import com.order_management_system.order_service.model.command.CreateOrderCommand;
import com.order_management_system.order_service.model.dto.ProductDTO;
import com.order_management_system.order_service.model.entity.Order;
import com.order_management_system.order_service.model.entity.OrderItem;
import com.order_management_system.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateOrderCommandHandler {
    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    public Order handle(CreateOrderCommand command){
        List<OrderItem> orderItems = null;
        if(command.getItems() != null){
            command.getItems().stream().map(item ->{
                ProductDTO product = productClient.getProductById(item.getProductId());
                return OrderItem.builder()
                        .productId(item.getProductId())
                        .productName(product.getName())
                        .price(product.getPrice())
                        .quantity(item.getQuantity())
                        .build();
            }).collect(Collectors.toList());
        }
         Order order = Order.builder()
                 .customerId(command.getCustomerId())
                 .totalAmount()
        }



}
