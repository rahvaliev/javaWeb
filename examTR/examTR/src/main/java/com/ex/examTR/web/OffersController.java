package com.ex.examTR.web;

import com.ex.examTR.model.binding.OfferAddBindingModel;
import com.ex.examTR.model.service.OfferServiceModel;
import com.ex.examTR.service.OfferService;
import com.ex.examTR.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OffersController {
    private final OfferService offerService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public OffersController(OfferService offerService, ModelMapper modelMapper, UserService userService) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(){
        if(userService.loggedOut()){
            return "redirect:/";
        }
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOrderPost(@Valid OfferAddBindingModel offerAddBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offerAddBindingModel",offerAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel",bindingResult);
            return "redirect:add";
        }
        offerService.save(modelMapper.map(offerAddBindingModel, OfferServiceModel.class));



        return "redirect:/";
    }
    @ModelAttribute
    public OfferAddBindingModel offerAddBindingModel(){
        return new OfferAddBindingModel();
    }
    @GetMapping("/remove/{id}")
    public String removeOffer(@PathVariable Long id){
        if(userService.loggedOut()){
            return "redirect:/";
        }
        offerService.removeOfferById(id);
        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buyItem(@PathVariable Long id){
        if(userService.loggedOut()){
            return "redirect:/";
        }
        offerService.BuyById(id);

        return "redirect:/";
    }
}
