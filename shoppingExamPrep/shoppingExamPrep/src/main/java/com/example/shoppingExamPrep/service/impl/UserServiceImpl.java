package com.example.shoppingExamPrep.service.impl;

import com.example.shoppingExamPrep.model.entities.User;
import com.example.shoppingExamPrep.model.service.UserServiceModel;
import com.example.shoppingExamPrep.repository.UserRepository;
import com.example.shoppingExamPrep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean register(UserServiceModel userServiceModel) {

        User user=modelMapper.map(userServiceModel,User.class);

        try {
            userRepository.save(user);
        }catch (Exception e){
            return false;
        };
        return true;


    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

       return userRepository.findByUsernameAndPassword(username,password)
               .map(user -> modelMapper.map(user,UserServiceModel.class))
               .orElse(null);
    }
}
