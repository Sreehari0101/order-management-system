package com.order_management.product_service.service;


import com.order_management.product_service.model.command.CreateProductCommand;
import com.order_management.product_service.model.command.ReviewDTO;
import com.order_management.product_service.model.entity.Product;
import com.order_management.product_service.model.entity.Review;
import com.order_management.product_service.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class CreateProductCommandHandlerTest {
    private ProductRepository productRepository;
    private CreateProductCommandHandler handler;

    @BeforeEach
    void setUp(){
        productRepository = mock(ProductRepository.class);
        handler = new CreateProductCommandHandler(productRepository);
    }

    @Test
    void testCreateProductSuccess(){
        ReviewDTO reviewDTO = ReviewDTO.builder()
                .reviewerId("user123")
                .reviewerName("John Doe")
                .rating(4)
                .comment("Nice Product")
                .build();
        CreateProductCommand command = CreateProductCommand.builder()
                .name("Test Product")
                .category("Electronics")
                .price(BigDecimal.valueOf(299.99))
                .quantity(10)
                .reviews(List.of(reviewDTO))
                .build();
        Product savedProduct = Product.builder()
                .name(command.getName())
                .category(command.getCategory())
                .price(command.getPrice())
                .quantity(command.getQuantity())
                .reviews(List.of(Review.builder()
                .reviewerId("user123")
                .reviewerName("John Doe")
                .rating(4)
                .comment("Nice Product")
                .build()))
                .build();

        when(productRepository.save(any(Product.class))).thenReturn(savedProduct);
        Product result = handler.handle(command);
        // Assert
        assertEquals("Test Product", result.getName());
        assertEquals("Electronics", result.getCategory());
        assertEquals(BigDecimal.valueOf(299.99), result.getPrice());
        assertEquals(10, result.getQuantity());
        assertEquals(1, result.getReviews().size());
        assertEquals("John Doe", result.getReviews().get(0).getReviewerName());
        verify(productRepository, times(1)).save(any(Product.class));when(productRepository.save(any(Product.class))).thenReturn(savedProduct);
    }

}
