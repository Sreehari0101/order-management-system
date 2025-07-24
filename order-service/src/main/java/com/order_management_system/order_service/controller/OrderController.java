package com.order_management_system.order_service.controller;

import com.order_management_system.order_service.model.command.CreateOrderCommand;
import com.order_management_system.order_service.model.command.UpdateOrderCommand;
import com.order_management_system.order_service.model.entity.Order;
import com.order_management_system.order_service.service.*;
import lombok.RequiredArgsConstructor;
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
   private final GetOrderByIdCommandHandler getOrderByIdCommandHandler;
   private final GetOrderByUserIdCommandHandler getOrderByUserIdCommandHandler;
   private final UpdateOrderCommandHandler updateOrderCommandHandler;
   private final DeleteOrderById deleteOrderById;

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

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable String orderId){
        Order order = getOrderByIdCommandHandler.handle(orderId);
        return ResponseEntity.ok(order);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrderByUserId(@PathVariable String userId){
        List<Order> order = getOrderByUserIdCommandHandler.handle(userId);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrderId(@PathVariable String orderId){
        deleteOrderById.handle(orderId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrderId(@PathVariable String orderId,
                                              @RequestBody UpdateOrderCommand command){
        Order order = updateOrderCommandHandler.handle(orderId, command);
        return ResponseEntity.ok(order);
    }

}
