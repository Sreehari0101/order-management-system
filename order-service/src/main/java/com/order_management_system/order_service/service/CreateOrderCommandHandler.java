package com.order_management_system.order_service.service;
import com.order_management_system.order_service.model.command.CreateOrderCommand;
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
    public Order handle(CreateOrderCommand command){
        List<OrderItem> orderItems = null;

        if(command.getItems() != null){
            orderItems = command.getItems().stream().map(this::mapToOrderItem).collect(Collectors.toList());
        }
        Order order = Order.builder()
                .customerId(command.getCustomerId())
                .items(orderItems)
                .totalAmount(command.getTotalAmount())
                .build();
        return orderRepository.save(order);
    }

    private OrderItem mapToOrderItem(OrderItem item){
        return OrderItem.builder()
                .productId(item.getProductId())
                .productName(item.getProductName())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .build();

    }
}
