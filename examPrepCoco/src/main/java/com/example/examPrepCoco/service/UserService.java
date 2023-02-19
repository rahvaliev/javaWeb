package com.example.examPrepCoco.service;

import com.example.examPrepCoco.model.bindingModel.UserLoginBindingModel;
import com.example.examPrepCoco.model.entities.User;
import com.example.examPrepCoco.model.service.UserServiceModel;
import com.example.examPrepCoco.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void login(UserLoginBindingModel userLoginBindingModel);

    User findById(Long id);

    List<UserViewModel> findAllByCountOfOrders();
}
