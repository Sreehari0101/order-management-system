package com.order_management.product_service.model.command;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductCommand {
    private String name;
    private String category;
    private double price;
    private int quantity;
    private List<ReviewDTO> reviews;
}