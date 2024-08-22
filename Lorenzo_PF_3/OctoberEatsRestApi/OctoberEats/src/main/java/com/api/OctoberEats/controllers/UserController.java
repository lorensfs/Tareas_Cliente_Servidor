package com.api.OctoberEats.controllers;

import com.api.OctoberEats.dto.MenuItemDTO;
import com.api.OctoberEats.dto.OrderModelDTO;
import com.api.OctoberEats.dto.RestaurantDTO;
import com.api.OctoberEats.models.*;
import com.api.OctoberEats.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public boolean register(@RequestBody UserModel user) {
        return userService.register(user);
    }

    @GetMapping("/login")
    public boolean login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }

    @GetMapping("/getUserId")
    public long getUserId(@RequestParam String email, @RequestParam String password){
        return userService.getUserID(email, password);
    }

    @GetMapping("/searchRestaurants")
    public List<RestaurantDTO> searchRestaurants(@RequestParam String keyword) {
        return userService.searchRestaurants(keyword);
    }

    @GetMapping("/listRestaurants")
    public List<RestaurantDTO> listRestaurants() {
        return userService.listRestaurants();
    }

    @GetMapping("/restaurant/{restaurantId}/menu")
    public List<MenuItemDTO> getRestaurantMenu(@PathVariable Long restaurantId) {
        return userService.getRestaurantMenu(restaurantId);
    }

    @PostMapping("/placeOrder")
    public OrderModel placeOrder(@RequestBody List<OrderItemModel> items, @RequestParam Long userId, @RequestParam Long restaurantId) {
        return userService.placeOrder(items, userId, restaurantId);
    }

    @GetMapping("/trackOrder")
    public OrderStatus trackOrder(@RequestParam Long orderId) {
        return userService.trackOrder(orderId);
    }

    @GetMapping("/{userId}/orders")
    public List<OrderModelDTO> getOrdersById(@PathVariable Long userId) {
        return userService.getOrdersById(userId);
    }
}
