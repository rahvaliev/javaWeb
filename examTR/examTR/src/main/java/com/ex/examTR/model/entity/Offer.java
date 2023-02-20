package com.ex.examTR.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{
    private String description;
    private BigDecimal price;
    private Condition condition;
    private User user;
    private Long boughtBy;

    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }
    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public Offer setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    @ManyToOne
    public Condition getCondition() {
        return condition;
    }

    public Offer setCondition(Condition condition) {
        this.condition = condition;
        return this;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    public User getUser() {
        return user;
    }

    public Offer setUser(User user) {
        this.user = user;
        return this;
    }

    public Long getBoughtBy() {
        return boughtBy;
    }

    public Offer setBoughtBy(Long boughtBy) {
        this.boughtBy = boughtBy;
        return this;
    }
}
