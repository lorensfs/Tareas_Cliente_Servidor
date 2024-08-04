package com.api.OctoberEats.repositories;

import com.api.OctoberEats.models.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRestaurantRepository extends JpaRepository<RestaurantModel, Long> {
    List<RestaurantModel> findByNameOrLocationContaining(String name, String location);
    RestaurantModel findByRestaurantId(Long restaurantId);
}
