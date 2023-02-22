package com.softuni.lastExamPrep.web;

import com.softuni.lastExamPrep.service.OrderService;
import com.softuni.lastExamPrep.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UserService userService;
    private final OrderService orderService;

    public HomeController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String index(Model model){
        if(userService.loggedOut()){
            return "index";
        }

        model.addAttribute("totalTime",orderService.totalNeededTime());
        model.addAttribute("allOrders",orderService.allOrders());
        model.addAttribute("byUserAllOrders",userService.allOrders());
        return "home";
    }
}
