package com.example.BankinExamPrep.web;

import com.example.BankinExamPrep.model.binding.BattleBindingModel;
import com.example.BankinExamPrep.model.binding.ShipAddBindingModel;
import com.example.BankinExamPrep.model.service.ShipServiceModel;
import com.example.BankinExamPrep.service.ShipService;
import com.example.BankinExamPrep.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("ships")
public class ShipController {
    private final ShipService shipService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public ShipController(ShipService shipService, ModelMapper modelMapper, UserService userService) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @PostMapping("/battle")
    public String battle(@Valid BattleBindingModel battleBindingModel,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        if(userService.loggedOut()){
            return "redirect:/";
        }
        System.out.println(battleBindingModel.getAttackerId() + "   "+ battleBindingModel.getDefenderId());

        shipService.battle(battleBindingModel.getAttackerId(),battleBindingModel.getDefenderId());

        return "redirect:/";
    }

    @GetMapping("/add")
    public String add(){
        if(userService.loggedOut()){
            return "redirect:/";
        }

        return "ship-add";
    }
    @PostMapping("/add")
    public String addConfirm(@Valid ShipAddBindingModel shipAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()  ){
            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel",
                            bindingResult);

            return "redirect:add";
        }
        shipService.add(modelMapper.map(shipAddBindingModel, ShipServiceModel.class));

        return "redirect:/";
    }
    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel(){
        return new ShipAddBindingModel();
    }
}
