package com.api.OctoberEats.controllers;

import com.api.OctoberEats.dto.OrderModelDTO;
import com.api.OctoberEats.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PatchMapping("/{orderId}/status/confirmed")
    public void acceptOrder(@PathVariable Long orderId) {
        restaurantService.acceptOrder(orderId);
    }

    @PatchMapping("/{orderId}/status/canceled")
    public void rejectOrder(@PathVariable Long orderId) {
        restaurantService.rejectOrder(orderId);
    }

    @PatchMapping("/{orderId}/status/preparing")
    public void preparingOrder(@PathVariable Long orderId) {
        restaurantService.preparingOrder(orderId);
    }

    @PatchMapping("/{orderId}/status/delivered")
    public void deliveredOrder(@PathVariable Long orderId) {
        restaurantService.deliveredOrder(orderId);
    }

    @GetMapping("{restaurantId}/orders")
    public List<OrderModelDTO> getOrdersOfRestaurant(@PathVariable Long restaurantId){
        return restaurantService.getOrdersOfRestaurant(restaurantId);
    }

}