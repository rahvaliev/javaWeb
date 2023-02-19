package com.example.examPrepCoco.web;

import com.example.examPrepCoco.sec.CurrentUser;
import com.example.examPrepCoco.service.OrderService;
import com.example.examPrepCoco.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final OrderService orderService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public HomeController(OrderService orderService, UserService userService, CurrentUser currentUser) {
        this.orderService = orderService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping()
    public String index(Model model){

        if(currentUser.getId()==null){
            return "index";
        }

        model.addAttribute("orders",orderService.findAllByPrice());
        model.addAttribute("total",orderService.total());
        model.addAttribute("users",userService.findAllByCountOfOrders());

        return "home";
    }

    @GetMapping("/home")
    public String home(Model model){

        return "home";
    }
}
