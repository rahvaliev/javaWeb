package com.example.mobilelele.web;

import com.example.mobilelele.model.binding.UserLoginBindingModel;
import com.example.mobilelele.model.service.UserLoginServiceModel;
import com.example.mobilelele.service.UserServiceIfc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {
    private final UserServiceIfc userServiceIfc;
    private static Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);

    public UserLoginController(UserServiceIfc userServiceIfc) {
        this.userServiceIfc = userServiceIfc;
    }

    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginBindingModel userLoginBindingModel){


        //delegate the logic to the service layer

       boolean loginSuccessfully= userServiceIfc.login(new UserLoginServiceModel().setUsername(userLoginBindingModel.getUsername())
                .setPassword(userLoginBindingModel.getPassword()));

        LOGGER.info("User tried to login.User with name {} try to login , success {}",
                userLoginBindingModel.getUsername(),
               loginSuccessfully);

        return "redirect:/users/login";
    }
}
