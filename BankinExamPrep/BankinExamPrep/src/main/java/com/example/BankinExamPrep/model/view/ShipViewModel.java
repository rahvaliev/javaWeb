package com.example.BankinExamPrep.model.view;

import com.example.BankinExamPrep.model.entity.Category;
import com.example.BankinExamPrep.model.entity.CategoryNameEnum;
import com.example.BankinExamPrep.model.entity.User;

public class ShipViewModel {
    private Long id;
    private String name;
    private Long health;
    private Long power;
    private Category category;
    private User user;

    public Long getId() {
        return id;
    }

    public ShipViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public java.lang.Long getHealth() {
        return health;
    }

    public ShipViewModel setHealth(java.lang.Long health) {
        this.health = health;
        return this;
    }

    public java.lang.Long getPower() {
        return power;
    }

    public ShipViewModel setPower(java.lang.Long power) {
        this.power = power;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ShipViewModel setCategory(Category category) {
        this.category = category;
        return this;
    }


    public User getUser() {
        return user;
    }

    public ShipViewModel setUser(User user) {
        this.user = user;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipViewModel setName(String name) {
        this.name = name;
        return this;
    }
}
