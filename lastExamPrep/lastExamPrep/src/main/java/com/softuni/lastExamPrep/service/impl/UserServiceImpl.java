package com.softuni.lastExamPrep.service.impl;

import com.softuni.lastExamPrep.model.entity.User;
import com.softuni.lastExamPrep.model.service.UserServiceModel;
import com.softuni.lastExamPrep.model.view.UserViewModel;
import com.softuni.lastExamPrep.repository.UserRepository;
import com.softuni.lastExamPrep.sec.CurrentUser;
import com.softuni.lastExamPrep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
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
    public boolean loggedOut() {
        if(currentUser.getId()==null){
            return true;
        }
        return false;
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
    public void logout() {
        currentUser.setId(null).setUsername(null);
    }

    @Override
    public User findById() {

       return userRepository.findById(currentUser.getId()).orElse(null);
    }

    @Override
    public List<UserViewModel> allOrders() {
        return userRepository.findAllOrdersByUsername()
                .stream()
                .map(user ->{
                    UserViewModel userViewModel=modelMapper.map(user, UserViewModel.class);
                    userViewModel.setOrderCount(user.getOrders().size());
                    return userViewModel;
                })
                .collect(Collectors.toList());

    }
}
