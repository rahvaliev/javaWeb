package com.example.AndrewsExamPrep.model.binding;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class UserRegisterBindingModel {
    private String username;
    private String email;
    private BigDecimal budget;
    private String password;
    private String confirmPassword;

    @Size(min = 2,message = "Username must be more than 2 characters!")
    @NotBlank
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }
    @Email
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }
    @Positive
    @NotNull
    public BigDecimal getBudget() {
        return budget;
    }

    public UserRegisterBindingModel setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }
    @Size(min = 2,message = "Password must be more than 2 characters!")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
    @Size(min = 2,message = "Username must be more than 2 characters!")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
