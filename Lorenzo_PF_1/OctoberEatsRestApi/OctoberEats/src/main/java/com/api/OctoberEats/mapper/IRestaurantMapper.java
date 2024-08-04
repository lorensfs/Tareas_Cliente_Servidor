package com.api.OctoberEats.mapper;

import com.api.OctoberEats.dto.MenuItemDTO;
import com.api.OctoberEats.dto.OrderModelDTO;
import com.api.OctoberEats.dto.RestaurantDTO;
import com.api.OctoberEats.dto.RestaurantMenuDTO;
import com.api.OctoberEats.models.MenuItemModel;
import com.api.OctoberEats.models.OrderModel;
import com.api.OctoberEats.models.RestaurantModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IRestaurantMapper {
    @Mapping(target = "menuItems", source = "menuItems")
    RestaurantMenuDTO toRestaurantMenuDTO(RestaurantModel restaurantModel);

    RestaurantDTO toRestaurantDTO(RestaurantModel restaurantModel);

    @Mapping(target = "items", source = "items")
    OrderModelDTO toOrderModelDTO(OrderModel orderModel);

    MenuItemDTO toMenuItemDTO(MenuItemModel menuItemModel);
}