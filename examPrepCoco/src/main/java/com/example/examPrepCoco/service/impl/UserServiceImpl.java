package com.example.examPrepCoco.service.impl;

import com.example.examPrepCoco.model.bindingModel.UserLoginBindingModel;
import com.example.examPrepCoco.model.entities.User;
import com.example.examPrepCoco.model.service.UserServiceModel;
import com.example.examPrepCoco.model.view.UserViewModel;
import com.example.examPrepCoco.service.UserService;
import com.example.examPrepCoco.repository.UserRepository;
import com.example.examPrepCoco.sec.CurrentUser;
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
    public void register(UserServiceModel userServiceModel) {
        User user =modelMapper.map(userServiceModel,User.class);
        userRepository.save(user);

    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

       return userRepository.findByUsernameAndPassword(username, password)
               .map(user -> modelMapper.map(user,UserServiceModel.class))
               .orElse(null);

    }

    @Override
    public void login(UserLoginBindingModel userLoginBindingModel) {
        User user=userRepository.findByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword()).orElse(null);
        currentUser.setId(user.getId())
                .setUsername(user.getUsername());
    }

    @Override
    public User findById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserViewModel> findAllByCountOfOrders() {

       return userRepository.findAllByOrdersCountDescending()
                .stream()
                .map(user -> {
                    UserViewModel userViewModel=new UserViewModel();
                    userViewModel.setUsername(user.getUsername())
                            .setCountOfOrders(user.getOrders().size());
                    return userViewModel;
                })
               .collect(Collectors.toList());
    }
}
