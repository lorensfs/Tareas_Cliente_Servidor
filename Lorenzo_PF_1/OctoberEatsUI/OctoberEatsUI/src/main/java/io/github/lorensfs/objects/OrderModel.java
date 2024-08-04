package io.github.lorensfs.objects;

import java.util.List;

public class OrderModel {
    private Long orderId;
    private List<OrderItem> items;
    private OrderStatus status;
    private double totalAmount;
    private User user;
    private Restaurant restaurant;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public double calculateTotal() {
        return items.stream()
                .filter(item -> item.getMenuItem() != null) // Only retain True
                .mapToDouble(item -> item.getMenuItem().getPrice()) //Stream to double
                .sum();
    }

    @Override
    public String toString() {
        return "Total amount: " + totalAmount + "$" + "-- Status:" + status;
    }
}
