package com.example.mobilelele.service.impl;

import com.example.mobilelele.model.entity.UserEntity;
import com.example.mobilelele.model.entity.UserRoleEntity;
import com.example.mobilelele.model.enums.UserRoleEnum;
import com.example.mobilelele.model.service.UserLoginServiceModel;
import com.example.mobilelele.repository.UserRepository;
import com.example.mobilelele.repository.UserRoleRepository;
import com.example.mobilelele.service.UserServiceIfc;
import com.example.mobilelele.userSession.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIfcImpl implements UserServiceIfc {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;


    public UserServiceIfcImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;

    }




    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {
        Optional<UserEntity> userEntityOpt = userRepository.findByUsername(userLoginServiceModel.getUsername());
        if(userEntityOpt.isEmpty()){
            logout();
            return false;
        }else {
           boolean success= passwordEncoder.matches(userLoginServiceModel.getPassword(), userEntityOpt.get().getPassword());
           if(success){
               UserEntity loggedInUser=userEntityOpt.get();
               currentUser
                       .setLoggedIn(true)
                       .setUsername(loggedInUser.getUsername())
                       .setFirstName(loggedInUser.getFirstName())
                       .setLastName(loggedInUser.getLastName());

               loggedInUser.getRoles().forEach(r->currentUser.addRole(r.getRole()));
           }
           return success;
        }

    }

    @Override
    public void logout() {
        currentUser.clear();
    }


}
