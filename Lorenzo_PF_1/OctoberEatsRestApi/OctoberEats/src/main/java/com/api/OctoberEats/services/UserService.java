package com.api.OctoberEats.services;

import com.api.OctoberEats.dto.MenuItemDTO;
import com.api.OctoberEats.dto.OrderModelDTO;
import com.api.OctoberEats.dto.RestaurantDTO;
import com.api.OctoberEats.dto.RestaurantMenuDTO;
import com.api.OctoberEats.mapper.IRestaurantMapper;
import com.api.OctoberEats.models.*;
import com.api.OctoberEats.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRestaurantRepository restaurantRepository;

    @Autowired
    private IMenuItemRepository menuItemRepository;

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IOrderItemRepository orderItemRepository;

    @Autowired
    private IRestaurantMapper restaurantMapper;

    public boolean register(UserModel user) {
        if (userRepository.findByEmail(user.getEmail()) == null) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean login(String email, String password) {
        UserModel user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

    public Long getUserID(String email, String password) {
        UserModel user = userRepository.findByEmail(email);
        return user.getUserId();
    }

    public List<RestaurantDTO> searchRestaurants(String keyword) {
        List<RestaurantModel> restaurantModel = restaurantRepository.findByNameOrLocationContaining(keyword, keyword);
        return restaurantModel.stream()
                .map(restaurantMapper::toRestaurantDTO)
                .collect(Collectors.toList());
    }

    public List<RestaurantDTO> listRestaurants() {
        List<RestaurantModel> restaurantModels = restaurantRepository.findAll();
        return restaurantModels.stream() // List<RestaurantModel> to stream to use then map and collect
                .map(restaurantMapper::toRestaurantDTO) // Then convert List<RestaurantModel> to List<RestaurantDTO>
                .collect(Collectors.toList()); // Stream to list to return the object
    }

    public OrderModel placeOrder(List<OrderItemModel> items, Long userId, Long restaurantId) {
        UserModel user = userRepository.findById(userId).orElse(null);
        RestaurantModel restaurant = restaurantRepository.findById(restaurantId).orElse(null);

        if (user == null || restaurant == null) {
            throw new RuntimeException("User or Restaurant not found");
        }

        // Fetch and set MenuItemModel for each OrderItemModel
        for (OrderItemModel item : items) {
            MenuItemModel menuItem = menuItemRepository.findById(item.getMenuItem().getItemId()).orElse(null);
            if (menuItem == null) {
                throw new RuntimeException("Order item must have a valid menu item");
            }
            item.setMenuItem(menuItem);
        }

        OrderModel order = new OrderModel();
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setStatus(OrderStatus.CONFIRMED);

        // Save the order to generate the order ID
        orderRepository.save(order);

        // Associate items with the order and save them
        for (OrderItemModel item : items) {
            item.setOrder(order);
            orderItemRepository.save(item);
        }

        // Set the items in the order and calculate the total amount
        order.setItems(items);
        order.setTotalAmount(order.calculateTotal());

        // Update the order with the total amount
        orderRepository.save(order);

        return order;
    }

    public OrderStatus trackOrder(Long orderId) {
        OrderModel order = orderRepository.findById(orderId).orElse(null);
        return (order != null) ? order.getStatus() : null;
    }

    public List<MenuItemDTO> getRestaurantMenu(Long restaurantId) {
        RestaurantModel restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        return (restaurant.getMenuItems() != null) ? restaurant.getMenuItems().stream()
                .map(restaurantMapper::toMenuItemDTO)
                .collect(Collectors.toList()) : null;
    }

    public List<OrderModelDTO> getOrdersById(Long userId) {
        UserModel userModel = userRepository.findByUserId(userId);
        if (userModel == null) {
            System.out.println("User not found with userId: " + userId);
            return Collections.emptyList();
        }

        List<OrderModel> orders = userModel.getOrders();
        if (orders == null || orders.isEmpty()) {
            System.out.println("No orders found for userId: " + userId);
            return Collections.emptyList();
        }

        List<OrderModelDTO> orderModelDTOs = orders.stream()
                .map(order -> {
                    OrderModelDTO dto = restaurantMapper.toOrderModelDTO(order);
                    System.out.println("Mapped order: " + dto);
                    return dto;
                })
                .collect(Collectors.toList());
        return orderModelDTOs;
    }
}
