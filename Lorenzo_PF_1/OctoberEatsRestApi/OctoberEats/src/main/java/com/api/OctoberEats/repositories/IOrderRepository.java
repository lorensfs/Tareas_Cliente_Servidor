package com.api.OctoberEats.repositories;

import com.api.OctoberEats.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderModel, Long> {
}
