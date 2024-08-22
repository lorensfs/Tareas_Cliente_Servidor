package com.api.OctoberEats.controllers;

import com.api.OctoberEats.models.OrderModel;
import com.api.OctoberEats.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderModel> getOrderById(@PathVariable Long id) {
        OrderModel order = orderService.findOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<OrderModel> createOrder(@RequestBody OrderModel order) {
        orderService.saveOrder(order);
        return ResponseEntity.ok(order);
    }
}