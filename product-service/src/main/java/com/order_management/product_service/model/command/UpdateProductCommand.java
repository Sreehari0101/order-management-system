package com.order_management.product_service.model.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductCommand {
    private String name;
    private String category;
    private BigDecimal price;
    private int quantity;
    private List<ReviewDTO> reviews;
}