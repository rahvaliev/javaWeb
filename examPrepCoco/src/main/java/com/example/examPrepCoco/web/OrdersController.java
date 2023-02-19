package com.example.examPrepCoco.web;

import com.example.examPrepCoco.model.bindingModel.OrderAddBindingModel;
import com.example.examPrepCoco.model.service.OrderServiceModel;
import com.example.examPrepCoco.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrdersController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addOrder(){
        return "order-add";
    }

    @PostMapping("/add")
    public String addOrderConfirm(@Validated OrderAddBindingModel orderAddBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("orderAddBindingModel",orderAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel",
                            bindingResult);

            return  "redirect:add";
        }

        orderService.addOrder(modelMapper.map(orderAddBindingModel, OrderServiceModel.class));
        return "redirect:/home";
    }

    @GetMapping("/ready/{id}")
    public String ready(@PathVariable Long id){

        orderService.delete(id);
        return "redirect:/";
    }

    @ModelAttribute
    public OrderAddBindingModel orderAddBindingModel(){
        return new OrderAddBindingModel();
    }
}
