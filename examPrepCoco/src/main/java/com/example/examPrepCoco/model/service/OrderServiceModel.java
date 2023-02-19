package com.example.examPrepCoco.model.service;

import com.example.examPrepCoco.model.entities.Category;
import com.example.examPrepCoco.model.entities.CategoryEnum;
import com.example.examPrepCoco.model.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderServiceModel {
    private Long id;
    private String description;
    private String name;
    private LocalDateTime orderTime;
    private BigDecimal price;
    private User employee;
    private CategoryEnum category;

    public Long getId() {
        return id;
    }

    public OrderServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderServiceModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public User getEmployee() {
        return employee;
    }

    public OrderServiceModel setEmployee(User employee) {
        this.employee = employee;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public OrderServiceModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }
}
