package com.example.shoppingExamPrep.service;

import com.example.shoppingExamPrep.model.service.UserServiceModel;

public interface UserService {
    boolean register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
