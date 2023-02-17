package com.example.AndrewsExamPrep.model.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {
    private String username;
    private String password;

    @Size(min=2,message = "username must be more than 2 characters!")
    @NotBlank
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }
    @Size(min = 2,message = "password must be more than 2 characters!")
    @NotBlank
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
