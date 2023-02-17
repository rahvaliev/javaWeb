package com.example.AndrewsExamPrep.web;

import com.example.AndrewsExamPrep.model.binding.ItemAddBindingModel;
import com.example.AndrewsExamPrep.model.service.ItemServiceModel;
import com.example.AndrewsExamPrep.sec.CurrentUser;
import com.example.AndrewsExamPrep.service.CategoryService;
import com.example.AndrewsExamPrep.service.ItemService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("items")
public class ItemController {
    private final ItemService itemService;
    private  final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public ItemController(ItemService itemService, CategoryService categoryService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.itemService = itemService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }
    @ModelAttribute
    public ItemAddBindingModel itemAddBindingModel(){
        return new ItemAddBindingModel();
    }

    @GetMapping("/add")
    public String add(Model model){
      if(!isAutorized()){
          return "redirect:/";
      }
        if(!model.containsAttribute("isExists")){
            model.addAttribute("isExists",false);
        }

        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ItemAddBindingModel itemAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("itemAddBindingModel", itemAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel",
                            bindingResult);
            return "redirect:add";
        }

        //TODO validation unique item's name
        boolean isExists=itemService.findByName(itemAddBindingModel.getName());
        if(isExists){
            redirectAttributes.addFlashAttribute("itemAddBindingModel", itemAddBindingModel)
                    .addFlashAttribute("isExists",true);
            return "redirect:add";
        }

        ItemServiceModel itemServiceModel=modelMapper.map(itemAddBindingModel,ItemServiceModel.class);
        itemServiceModel.setCategory(categoryService.findByCategoryName(itemAddBindingModel.getCategory()));

        itemService.save(itemServiceModel);



        return "redirect:/";
    }

    @GetMapping("details/{id}")
    public String details(@PathVariable Long id,Model model){
        if(!isAutorized()){
            return "redirect:/";
        }
        model.addAttribute("item",itemService.findById(id));

        return "details-item";
    }

    @GetMapping("/delete/{id}")

    public String deleteItem(@PathVariable Long id){
        if(!isAutorized()){
            return "redirect:/";
        }
        itemService.delete(id);
        return "redirect:/";
    }

    public boolean isAutorized(){
        return currentUser.getId()!=null;
    }

}
