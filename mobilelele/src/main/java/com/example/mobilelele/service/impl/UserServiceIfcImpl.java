package com.example.mobilelele.service.impl;

import com.example.mobilelele.model.entity.UserEntity;
import com.example.mobilelele.model.service.UserLoginServiceModel;
import com.example.mobilelele.repository.UserRepository;
import com.example.mobilelele.service.UserServiceIfc;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceIfcImpl implements UserServiceIfc {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceIfcImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        Optional<UserEntity> userEntityOpt = userRepository.findByUsername(userLoginServiceModel.getUsername());
        if(userEntityOpt.isEmpty()){
            return false;
        }else {
           return passwordEncoder.matches(userLoginServiceModel.getPassword(), userEntityOpt.get().getPassword());
        }

    }
}
