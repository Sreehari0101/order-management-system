package com.order_management.product_service.service;

import com.order_management.product_service.model.command.CreateProductCommand;
import com.order_management.product_service.model.command.ReviewDTO;
import com.order_management.product_service.repository.ProductRepository;
import com.order_management.product_service.model.entity.Product;
import com.order_management.product_service.model.entity.Review;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
public class CreateProductCommandHandler {
    private final ProductRepository productRepository;

    public Product handle(CreateProductCommand command){
        log.info("Reached Create handler: {}", command);
        List<Review> reviews = null;
        if(command.getReviews() != null){
            reviews = command.getReviews().stream().map(this::mapToReview).collect(Collectors.toList());
        }

        Product product = Product.builder()
                .name(command.getName())
                .category(command.getCategory())
                .price(command.getPrice())
                .quantity(command.getQuantity())
                .reviews(reviews)
                .build();
        return productRepository.save(product);

    }

    private Review mapToReview(ReviewDTO r) {
        return Review.builder()
                .reviewerId(r.getReviewerId())
                .reviewerName(r.getReviewerName())
                .rating(r.getRating())
                .comment(r.getComment())
                .build();
    }

}
