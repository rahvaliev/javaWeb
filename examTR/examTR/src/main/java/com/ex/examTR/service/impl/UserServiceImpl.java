package com.ex.examTR.service.impl;

import com.ex.examTR.model.entity.User;
import com.ex.examTR.model.service.UserServiceModel;
import com.ex.examTR.repository.UserRepository;
import com.ex.examTR.service.UserService;
import com.ex.examTR.sec.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(CurrentUser currentUser, ModelMapper modelMapper, UserRepository userRepository) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void logout() {
        currentUser.setId(null).setUsername(null);
    }

    @Override
    public boolean loggedOut() {
        return currentUser.getId() == null;
    }

    @Override
    public boolean register(UserServiceModel userServiceModel) {
        try {
            userRepository.save(modelMapper.map(userServiceModel, User.class));
        }catch (Exception e){
            return false;
        }
        return true;

    }

    @Override
    public UserServiceModel findByUsername(String username) {
       return modelMapper.map(userRepository.findByUsername(username),UserServiceModel.class);

    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser.setId(userServiceModel.getId())
                .setUsername(userServiceModel.getUsername());
    }

    @Override
    public User findById() {

        return userRepository.findById(currentUser.getId()).orElse(null);
    }

    @Override
    public Long findCurrentUserId() {

        return currentUser.getId();
    }

    @Override
    public String currentUsername() {
        return currentUser.getUsername();
    }

    @Override
    public User findByAdminId() {

        return userRepository.findById(7l).orElse(null);
    }
}
