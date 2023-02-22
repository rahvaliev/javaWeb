package com.example.BankinExamPrep.service;

import com.example.BankinExamPrep.model.entity.User;
import com.example.BankinExamPrep.model.service.UserServiceModel;
import com.example.BankinExamPrep.model.view.ShipViewModel;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface UserService {
    boolean register(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);

    void login(UserServiceModel userServiceModel);

    void logout();

    boolean loggedOut();

    List<ShipViewModel> myShips();

    User findById();

    List<ShipViewModel> enemyShips();

    List<ShipViewModel> allShipsOrderdByNameHealthPower();
}
