package com.ex.examTR.model.service;

import com.ex.examTR.model.entity.Condition;
import com.ex.examTR.model.entity.User;
import com.ex.examTR.model.entity.enums.ConditionNameEnum;

import java.math.BigDecimal;

public class OfferServiceModel {
    private Long id;
    private String description;
    private BigDecimal price;
    private ConditionNameEnum condition;
    private Long user;

    public Long getId() {
        return id;
    }

    public OfferServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ConditionNameEnum getCondition() {
        return condition;
    }

    public OfferServiceModel setCondition(ConditionNameEnum condition) {
        this.condition = condition;
        return this;
    }

    public Long getUser() {
        return user;
    }

    public OfferServiceModel setUser(Long user) {
        this.user = user;
        return this;
    }
}
