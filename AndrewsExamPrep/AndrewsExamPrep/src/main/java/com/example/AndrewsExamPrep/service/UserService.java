package com.example.AndrewsExamPrep.service;

import com.example.AndrewsExamPrep.model.service.UserServiceModel;

public interface UserService {
    boolean save(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);
}
