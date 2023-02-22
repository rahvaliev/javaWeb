package com.softuni.lastExamPrep.service;

import com.softuni.lastExamPrep.model.entity.User;
import com.softuni.lastExamPrep.model.service.UserServiceModel;
import com.softuni.lastExamPrep.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    boolean register(UserServiceModel map);

    boolean loggedOut();

    UserServiceModel findByUsername(String username);

    void login(UserServiceModel userServiceModel);


    User findById();
    void logout();

    List<UserViewModel> allOrders();
}
