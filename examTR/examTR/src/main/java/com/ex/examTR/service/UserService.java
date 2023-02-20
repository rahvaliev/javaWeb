package com.ex.examTR.service;

import com.ex.examTR.model.entity.User;
import com.ex.examTR.model.service.UserServiceModel;

public interface UserService {
    void logout();
    boolean loggedOut();

    boolean register(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);

    void login(UserServiceModel userServiceModel);

    User findById();

    Long findCurrentUserId();

    String currentUsername();

    User findByAdminId();
}
