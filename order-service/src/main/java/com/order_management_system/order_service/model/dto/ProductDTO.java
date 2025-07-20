package com.order_management_system.order_service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private String productId;
    private String name;
    private String category;
    private double price;
    private int quantity;
    private List<ReviewDTO> reviews;

}