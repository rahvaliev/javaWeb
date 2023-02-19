package com.example.examPrepCoco.model.view;

import com.example.examPrepCoco.model.entities.Order;

import java.util.Set;

public class UserViewModel {
    private Long id;
    private String username;
    private Integer countOfOrders;

    public Long getId() {
        return id;
    }

    public UserViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getCountOfOrders() {
        return countOfOrders;
    }

    public UserViewModel setCountOfOrders(Integer countOfOrders) {
        this.countOfOrders = countOfOrders;
        return this;
    }
}
