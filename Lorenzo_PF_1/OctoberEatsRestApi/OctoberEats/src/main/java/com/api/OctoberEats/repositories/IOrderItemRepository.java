package com.api.OctoberEats.repositories;

import com.api.OctoberEats.models.OrderItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemRepository extends JpaRepository<OrderItemModel, Long> {
}
