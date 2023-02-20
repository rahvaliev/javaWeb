package com.ex.examTR.model.view;

import com.ex.examTR.model.entity.enums.ConditionNameEnum;

import java.math.BigDecimal;

public class OfferViewModel {
    private Long id;
    private String username;

    private BigDecimal price;
    private ConditionNameEnum condition;
    private String description;

    public Long getId() {
        return id;
    }

    public OfferViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public OfferViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ConditionNameEnum getCondition() {
        return condition;
    }

    public OfferViewModel setCondition(ConditionNameEnum condition) {
        this.condition = condition;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferViewModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
