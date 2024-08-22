package com.api.OctoberEats.dto;

import com.api.OctoberEats.models.OrderItemModel;
import com.api.OctoberEats.models.OrderStatus;

import java.util.List;

public class OrderModelDTO {
    private Long orderId;
    private OrderStatus status;
    private double totalAmount;
    private List<OrderItemModel> items;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItemModel> getItems() {
        return items;
    }

    public void setItems(List<OrderItemModel> items) {
        this.items = items;
    }
}
