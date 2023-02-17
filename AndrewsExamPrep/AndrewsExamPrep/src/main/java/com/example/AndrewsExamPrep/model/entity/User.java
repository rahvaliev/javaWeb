package com.example.AndrewsExamPrep.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    private String username;
    private String email;
    private String password;
    private BigDecimal budget;


    @Column(nullable = false,unique = true)
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public User setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }
    @Column(nullable = false,unique = true)

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }
}
