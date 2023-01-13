package com.example.mobilelele.web;

import com.example.mobilelele.model.binding.UserRegistrationBindingModel;
import com.example.mobilelele.model.service.UserRegistrationServiceModel;
import com.example.mobilelele.service.UserServiceIfc;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserRegistrationController {

    private UserServiceIfc userServiceIfc;
    private ModelMapper modelMapper;

    public UserRegistrationController(UserServiceIfc userServiceIfc, ModelMapper modelMapper) {
        this.userServiceIfc = userServiceIfc;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("userModel")
    public UserRegistrationBindingModel userModel(){
        return new UserRegistrationBindingModel();
    }

    @GetMapping("/users/register")
    public String registerUser(){
        return "auth-register";
    }

    @PostMapping("/users/register")
    public String register(@Valid UserRegistrationBindingModel userModel, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes, Model model ){
        //todo validation
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userModel",userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",bindingResult);
            return "redirect:/users/register";
        }



        UserRegistrationServiceModel serviceModel=modelMapper.map(userModel,UserRegistrationServiceModel.class);
        if(userServiceIfc.isUsernameFree(serviceModel.getUsername())){
            userServiceIfc.registerAndLoginUser(serviceModel);
            return "redirect:/";
        }else {
            model.addAttribute("usernameOccupied",true);
            return "redirect:/users/register";
        }


    }
}
