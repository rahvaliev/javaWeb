package com.example.mobilelele.service.impl;

import com.example.mobilelele.model.service.UserLoginServiceModel;
import com.example.mobilelele.service.UserServiceIfc;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIfcImpl implements UserServiceIfc {
    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        //todo login
        throw new UnsupportedOperationException("Not yet implemented");

    }
}
