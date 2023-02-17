package com.example.AndrewsExamPrep.web;

import com.example.AndrewsExamPrep.model.binding.UserLoginBindingModel;
import com.example.AndrewsExamPrep.model.binding.UserRegisterBindingModel;
import com.example.AndrewsExamPrep.model.service.UserServiceModel;
import com.example.AndrewsExamPrep.sec.CurrentUser;
import com.example.AndrewsExamPrep.service.UserService;
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
    private final CurrentUser currentUser;

    public UserController(UserService userService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel(){
        return new UserLoginBindingModel();
    }

    @GetMapping("/login")
    public String login(Model model){
        if(!model.containsAttribute("isNotExist")){
            model.addAttribute("isNotExist",false);
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel",
                            bindingResult);

            return "redirect:login";
        }
         UserServiceModel userServiceModel=userService.findByUsername(userLoginBindingModel.getUsername());
        if(userServiceModel==null || !userServiceModel.getPassword().equals(userLoginBindingModel.getPassword())){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("isNotExist",true);
            return "redirect:login";
        }

        currentUser.setId(userServiceModel.getId())
                .setUsername(userServiceModel.getUsername());


        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model){
        if(!model.containsAttribute("userRegisterBindingModel")){
            model.addAttribute("userRegisterBindingModel",new UserRegisterBindingModel());
        }
        if(!model.containsAttribute("isExists")){
            model.addAttribute("isExists",false);
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",
                            bindingResult);

            return "redirect:register";
        }
        //TODO validation unique username

        boolean isSaved=userService.save(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        if(!isSaved){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("isExists",true);
            return "redirect:register";
        }


        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }
}
