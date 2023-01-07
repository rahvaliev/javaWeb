package com.example.mobilelele.web;

import com.example.mobilelele.model.binding.UserLoginBindingModel;
import com.example.mobilelele.model.service.UserLoginServiceModel;
import com.example.mobilelele.service.UserServiceIfc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {
    private final UserServiceIfc userServiceIfc;

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
        // TODO login
        return "redirect:/index";
    }
}
