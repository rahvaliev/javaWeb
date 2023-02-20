package com.ex.examTR.web;

import com.ex.examTR.service.OfferService;
import com.ex.examTR.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final OfferService offerService;
    private final UserService userService;

    public HomeController(OfferService offerService, UserService userService) {
        this.offerService = offerService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model){
        if(userService.loggedOut()){
            return "index";
        }
        model.addAttribute("currentUsername",userService.currentUsername());
        model.addAttribute("myOffers",offerService.myOffers());
        model.addAttribute("allOthersOffer",offerService.allOthersOffer());
        model.addAttribute("myBoughtItems",offerService.myBoughtItems());
        System.out.println();


        return "home";
    }
}
