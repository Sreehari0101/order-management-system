package com.order_management_system.order_service.model.command;

import com.order_management_system.order_service.model.dto.OrderItemDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateOrderCommand {
    private String customerId;
    private List<OrderItemDTO> items;
}
