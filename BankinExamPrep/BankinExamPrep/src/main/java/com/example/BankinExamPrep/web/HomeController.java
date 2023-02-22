package com.example.BankinExamPrep.web;

import com.example.BankinExamPrep.model.binding.BattleBindingModel;
import com.example.BankinExamPrep.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public  String index(Model model){
        if(userService.loggedOut()){
            return "index";
        }

        model.addAttribute("myShips",userService.myShips());
        model.addAttribute("enemyShips",userService.enemyShips());
        model.addAttribute("allShips",userService.allShipsOrderdByNameHealthPower());


        return "home";

    }
    @ModelAttribute
    public BattleBindingModel battleBindingModel(){
        return new BattleBindingModel();
    }
}
