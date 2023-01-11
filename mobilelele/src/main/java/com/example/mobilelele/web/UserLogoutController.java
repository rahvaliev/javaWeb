package com.example.mobilelele.web;

import com.example.mobilelele.service.UserServiceIfc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLogoutController {
    private UserServiceIfc userServiceIfc;

    public UserLogoutController(UserServiceIfc userServiceIfc) {
        this.userServiceIfc = userServiceIfc;
    }

    @GetMapping("/users/logout")
    public String logout(){
        userServiceIfc.logout();

        return "redirect:/";
    }
}
