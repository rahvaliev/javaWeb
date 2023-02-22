package com.softuni.lastExamPrep.model.binding;

import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {
    private String username;
    private String password;
    @Size(min =5,max = 20,message = "Custom username length must be between 5 and 20. ")
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }
    @Size(min =3,message = "Custom password length must be more than 3 ")
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
