package com.example.BankinExamPrep.web;

import com.example.BankinExamPrep.model.binding.UserLoginBindingModel;
import com.example.BankinExamPrep.model.binding.UserRegisterBindingModel;
import com.example.BankinExamPrep.model.service.UserServiceModel;
import com.example.BankinExamPrep.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(){
        if(!userService.loggedOut()){
            return "redirect:/";
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()  ){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);

            return "redirect:login";
        }
        UserServiceModel userServiceModel=userService.findByUsername(userLoginBindingModel.getUsername());
        if(userServiceModel==null){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("isNotExist",true);
            return "redirect:login";
        }
        boolean isNotExist=!userServiceModel.getPassword().equals(userLoginBindingModel.getPassword());
        if(isNotExist){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("isNotExist",true);
            return "redirect:login";

        }
        userService.login(userServiceModel);


        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model){
        if(!userService.loggedOut()){
            return "redirect:/";
        }
        if(!model.containsAttribute("isExist")){
            model.addAttribute("isExist",false);
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){
        boolean isEqual=userRegisterBindingModel.getConfirmPassword().equals(userRegisterBindingModel.getPassword());

        if(bindingResult.hasErrors() || !isEqual ){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                            bindingResult);

            return "redirect:register";
        }
       boolean isSaved= userService.register(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        if(!isSaved){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("isExist",true);
            return "redirect:register";
        }

        return "redirect:/users/login";
    }

    @GetMapping("/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }

    @ModelAttribute(value = "userRegisterBindingModel")
    public UserRegisterBindingModel userRegisterBindingModel(){
        return new UserRegisterBindingModel();
    }
    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel(){
        return new UserLoginBindingModel();
    }
}
