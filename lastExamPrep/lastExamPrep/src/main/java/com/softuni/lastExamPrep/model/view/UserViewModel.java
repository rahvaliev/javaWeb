package com.softuni.lastExamPrep.model.view;

public class UserViewModel {
    private String username;
    private int orderCount;

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public UserViewModel setOrderCount(int orderCount) {
        this.orderCount = orderCount;
        return this;
    }
}
