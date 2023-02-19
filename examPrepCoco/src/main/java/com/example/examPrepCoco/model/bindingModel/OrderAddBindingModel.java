package com.example.examPrepCoco.model.bindingModel;

import com.example.examPrepCoco.model.entities.Category;
import com.example.examPrepCoco.model.entities.CategoryEnum;
import com.example.examPrepCoco.model.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddBindingModel {
    @Size(min = 5)
    private String description;
    @Size(min = 3, max = 20)
    private String name;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    private LocalDateTime orderTime;
    @PositiveOrZero
    @NotNull
    private BigDecimal price;
    @NotNull
    private CategoryEnum category;

    public String getDescription() {
        return description;
    }

    public OrderAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderAddBindingModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public OrderAddBindingModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }
}
