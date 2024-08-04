package com.api.OctoberEats.dto;

import java.util.List;

public class RestaurantMenuDTO {
    private Long restaurantId;
    private List<MenuItemDTO> menuItems;

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<MenuItemDTO> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItemDTO> menuItems) {
        this.menuItems = menuItems;
    }
}

