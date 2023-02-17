package com.example.AndrewsExamPrep.service.impl;

import com.example.AndrewsExamPrep.model.entity.User;
import com.example.AndrewsExamPrep.model.service.UserServiceModel;
import com.example.AndrewsExamPrep.repository.UserRepository;
import com.example.AndrewsExamPrep.service.UserService;
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
    public boolean save(UserServiceModel userServiceModel) {
        try {
            userRepository.save(modelMapper.map(userServiceModel, User.class));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public UserServiceModel findByUsername(String username) {

        return userRepository.findByUsername(username)
                .map(user -> modelMapper.map(user,UserServiceModel.class))
                .orElse(null);
    }
}
