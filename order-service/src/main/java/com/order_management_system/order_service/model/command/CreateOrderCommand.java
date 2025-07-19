package com.order_management_system.order_service.model.command;

import com.order_management_system.order_service.model.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderCommand {
    private String customerId;
    private List<OrderItem> items;
    private double totalAmount;
}
