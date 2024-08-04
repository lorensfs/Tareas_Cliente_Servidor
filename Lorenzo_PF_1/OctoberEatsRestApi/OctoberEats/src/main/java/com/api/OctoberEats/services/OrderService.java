package com.api.OctoberEats.services;

import com.api.OctoberEats.models.OrderModel;
import com.api.OctoberEats.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private IOrderRepository orderRepository;

    public OrderModel findOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public void saveOrder(OrderModel order) {
        orderRepository.save(order);
    }
}