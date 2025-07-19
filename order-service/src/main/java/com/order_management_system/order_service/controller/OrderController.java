package com.order_management_system.order_service.controller;

import com.order_management_system.order_service.model.command.CreateOrderCommand;
import com.order_management_system.order_service.model.entity.Order;
import com.order_management_system.order_service.service.CreateOrderCommandHandler;
import com.order_management_system.order_service.service.GetAllOrdersCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
   private final CreateOrderCommandHandler createOrderCommandHandler;
   private final GetAllOrdersCommandHandler getAllOrdersCommandHandler;
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderCommand command){
        Order order = createOrderCommandHandler.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orders = getAllOrdersCommandHandler.handle();
        return ResponseEntity.ok(orders);
    }


}
