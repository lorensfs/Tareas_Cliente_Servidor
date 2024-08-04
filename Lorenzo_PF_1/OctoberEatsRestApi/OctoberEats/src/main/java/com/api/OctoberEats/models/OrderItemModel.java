package com.api.OctoberEats.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
public class OrderItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference("order-items")
    private OrderModel order;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItemModel menuItem;


    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    public MenuItemModel getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItemModel menuItem) {
        this.menuItem = menuItem;
    }

}
