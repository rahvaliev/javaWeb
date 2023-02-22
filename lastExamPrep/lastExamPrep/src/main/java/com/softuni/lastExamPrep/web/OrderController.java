package com.softuni.lastExamPrep.web;

import com.softuni.lastExamPrep.model.binding.OrderAddBindingModel;
import com.softuni.lastExamPrep.model.service.OrderServiceModel;
import com.softuni.lastExamPrep.service.OrderService;
import com.softuni.lastExamPrep.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public OrderController(OrderService orderService, ModelMapper modelMapper, UserService userService) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String addOrder(){
        if(userService.loggedOut()){
            return "redirect:/";
        }
        return "order-add";
    }

    @PostMapping("/add")
    public String addOrderPost(@Valid OrderAddBindingModel orderAddBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("orderAddBindingModel",orderAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel",bindingResult);
            return "redirect:add";
        }
        orderService.save(modelMapper.map(orderAddBindingModel, OrderServiceModel.class));



        return "redirect:/";
    }
    @GetMapping("/ready/{id}")
    public String readyOrder(@PathVariable Long id){
        if(userService.loggedOut()){
            return "redirect:/";
        }
        orderService.delete(id);
        return "redirect:/";
    }

    @ModelAttribute
    public OrderAddBindingModel orderAddBindingModel(){
        return new OrderAddBindingModel();
    }
}
