package com.api.OctoberEats.services;

import com.api.OctoberEats.dto.OrderModelDTO;
import com.api.OctoberEats.mapper.IRestaurantMapper;
import com.api.OctoberEats.models.OrderModel;
import com.api.OctoberEats.models.OrderStatus;
import com.api.OctoberEats.models.RestaurantModel;
import com.api.OctoberEats.repositories.IOrderRepository;
import com.api.OctoberEats.repositories.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    private IOrderRepository orderRepository;
    @Autowired
    private IRestaurantRepository restaurantRepository;
    @Autowired
    private IRestaurantMapper restaurantMapper;

    public void acceptOrder(Long orderId) {
        OrderModel order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(OrderStatus.CONFIRMED);
            orderRepository.save(order);
        }
    }

    public void preparingOrder(Long orderId) {
        OrderModel order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(OrderStatus.PREPARING);
            orderRepository.save(order);
        }
    }

    public void deliveredOrder(Long orderId) {
        OrderModel order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(OrderStatus.DELIVERED);
            orderRepository.save(order);
        }
    }

    public void rejectOrder(Long orderId) {
        OrderModel order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(OrderStatus.CANCELLED);
            orderRepository.save(order);
        }
    }

    public List<OrderModelDTO> getOrdersOfRestaurant(Long restaurantId){
        RestaurantModel restaurantModel= restaurantRepository.findByRestaurantId(restaurantId);
        return restaurantModel.getOrders().stream()
                .map(restaurantMapper::toOrderModelDTO)
                .collect(Collectors.toList());
    }

}