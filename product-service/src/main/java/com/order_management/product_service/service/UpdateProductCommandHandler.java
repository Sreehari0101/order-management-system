package com.order_management.product_service.service;


import com.order_management.product_service.model.command.ReviewDTO;
import com.order_management.product_service.model.command.UpdateProductCommand;
import com.order_management.product_service.model.entity.Product;
import com.order_management.product_service.model.entity.Review;
import com.order_management.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UpdateProductCommandHandler {
    private final ProductRepository productRepository;

    public Product handle(String productId, UpdateProductCommand command){
        Product existing = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with Id: " +productId));
        List<Review> reviews = null;
        if(command.getReviews() != null) {
            reviews = command.getReviews().stream().map(this::mapToReview).collect(Collectors.toList());
            existing.setReviews(reviews);
        }
            existing.setName(command.getName());
            existing.setCategory(command.getCategory());
            existing.setPrice(command.getPrice());
            existing.setQuantity(command.getQuantity());
            return productRepository.save(existing);

    }

    private Review mapToReview(ReviewDTO r){
        return Review.builder()
                .reviewerId(r.getReviewerId())
                .reviewerName(r.getReviewerName())
                .rating(r.getRating())
                .comment(r.getComment())
                .build();

    }
}
