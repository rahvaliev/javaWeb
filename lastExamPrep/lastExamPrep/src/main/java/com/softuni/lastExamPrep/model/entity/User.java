package com.softuni.lastExamPrep.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private  String password;
    private Set<Order> orders;
    @Column(nullable = false,unique = true)
    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    @Column(nullable = false)
    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    @Column(nullable = false)
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
    @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER)
    public Set<Order> getOrders() {
        return orders;
    }

    public User setOrders(Set<Order> orders) {
        this.orders = orders;
        return this;
    }
}
