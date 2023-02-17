package com.example.AndrewsExamPrep.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item extends BaseEntity{
    private String name;
    private BigDecimal price;
    private Category category;
    private String description;
    private String gender;

    public String getGender() {
        return gender;
    }

    public Item setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @Column(nullable = false,unique = true)
    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Item setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public Item setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }
}
