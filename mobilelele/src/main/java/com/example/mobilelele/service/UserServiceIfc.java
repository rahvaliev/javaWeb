package com.example.mobilelele.service;

import com.example.mobilelele.model.service.UserLoginServiceModel;
import com.example.mobilelele.model.service.UserRegistrationServiceModel;

public interface UserServiceIfc {


    boolean login(UserLoginServiceModel userLoginServiceModel);

    void logout();

    boolean isUsernameFree(String username);
    void registerAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);
}
