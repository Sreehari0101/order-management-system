package com.order_management.product_service.model.command;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDTO {
    private String reviewerId;
    private int rating;
    private String comment;
}