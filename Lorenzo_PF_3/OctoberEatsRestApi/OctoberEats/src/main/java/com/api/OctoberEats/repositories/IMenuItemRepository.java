package com.api.OctoberEats.repositories;

import com.api.OctoberEats.models.MenuItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuItemRepository extends JpaRepository<MenuItemModel, Long> {
}
