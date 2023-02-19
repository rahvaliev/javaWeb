package com.example.examPrepCoco.model.view;

import com.example.examPrepCoco.model.entities.Category;

import java.math.BigDecimal;

public class OrderViewModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer neededTime;
    private Category category;

    public Long getId() {
        return id;
    }

    public OrderViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getNeededTime() {
        return neededTime;
    }

    public OrderViewModel setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public OrderViewModel setCategory(Category category) {
        this.category = category;
        return this;
    }
}
