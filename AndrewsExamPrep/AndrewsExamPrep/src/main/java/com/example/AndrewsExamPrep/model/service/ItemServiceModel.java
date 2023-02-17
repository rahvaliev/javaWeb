package com.example.AndrewsExamPrep.model.service;

import com.example.AndrewsExamPrep.model.entity.Category;
import com.example.AndrewsExamPrep.model.entity.CategoryNameEnum;

import java.math.BigDecimal;

public class ItemServiceModel {
    private Long id;
    private String name;
    private String description;
    private Category category;
    private String gender;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public ItemServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ItemServiceModel setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public ItemServiceModel setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
