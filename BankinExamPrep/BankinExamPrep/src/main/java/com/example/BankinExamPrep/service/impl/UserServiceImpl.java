package com.example.BankinExamPrep.service.impl;

import com.example.BankinExamPrep.model.entity.Ship;
import com.example.BankinExamPrep.model.entity.User;
import com.example.BankinExamPrep.model.service.UserServiceModel;
import com.example.BankinExamPrep.model.view.ShipViewModel;
import com.example.BankinExamPrep.repository.ShipRepository;
import com.example.BankinExamPrep.repository.UserRepository;
import com.example.BankinExamPrep.sec.CurrentUser;
import com.example.BankinExamPrep.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final ShipRepository shipRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser, ShipRepository shipRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.shipRepository = shipRepository;
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

       UserServiceModel userServiceModel=userRepository.findByUsername(username)
               .map(user -> modelMapper.map(user,UserServiceModel.class)).orElse(null);
     return userServiceModel;
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser.setId(userServiceModel.getId())
                .setUsername(userServiceModel.getUsername());
    }


    @Override
    public void logout() {
        currentUser.setId(null)
                .setUsername(null);
    }

    @Override
    public boolean loggedOut() {
        if(currentUser.getId()==null){
            return true;
        }
        return false;
    }

    @Override
    public List<ShipViewModel> myShips() {

        List<ShipViewModel> myShips = shipRepository.findByUser_Id(currentUser.getId())
                .stream().map(ship ->{
                    ShipViewModel shipViewModel=modelMapper.map(ship,ShipViewModel.class);
                    return shipViewModel;
                } )
                .collect(Collectors.toList());
        return myShips;
    }

    @Override
    public User findById() {

        return userRepository.findById(currentUser.getId()).orElse(null);
    }

    @Override
    public List<ShipViewModel> enemyShips() {

        List<ShipViewModel> enemyShips=shipRepository.findByUser_IdNot(currentUser.getId())
                .stream().map(ship -> modelMapper.map(ship,ShipViewModel.class))
                .collect(Collectors.toList());
        return enemyShips;
    }

    @Override
    public List<ShipViewModel> allShipsOrderdByNameHealthPower() {
        List<ShipViewModel> allShipOrdered=shipRepository.findByOrderByNameHealthDescPower()
                .stream().map(ship -> modelMapper.map(ship,ShipViewModel.class))
                .collect(Collectors.toList());
        return allShipOrdered;
    }
}
