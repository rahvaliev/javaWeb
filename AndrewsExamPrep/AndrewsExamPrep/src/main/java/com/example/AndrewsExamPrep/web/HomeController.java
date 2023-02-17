package com.example.AndrewsExamPrep.web;

import com.example.AndrewsExamPrep.sec.CurrentUser;
import com.example.AndrewsExamPrep.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final ItemService itemService;

    public HomeController(CurrentUser currentUser, ItemService itemService) {
        this.currentUser = currentUser;
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId()==null){
            return "index";
        }
        model.addAttribute("items",itemService.findAll());

        return "home";
    }
}
