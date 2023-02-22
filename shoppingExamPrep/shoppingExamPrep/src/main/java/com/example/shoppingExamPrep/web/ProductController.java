package com.example.shoppingExamPrep.web;

import com.example.shoppingExamPrep.model.binding.ProductAddBindingModel;
import com.example.shoppingExamPrep.model.service.ProductServiceModel;
import com.example.shoppingExamPrep.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model){
        if(!model.containsAttribute("productAddBindingModel")){
            model.addAttribute("productAddBindingModel",new ProductAddBindingModel());
        }
        if(!model.containsAttribute("isExists")){
            model.addAttribute("isExists",false);
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String addPost(@Validated ProductAddBindingModel productAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel",
                            bindingResult);

            return "redirect:add";
        }

        boolean productSaved=productService.saveProduct(modelMapper.map(productAddBindingModel, ProductServiceModel.class));
        if(!productSaved){
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel)
                    .addFlashAttribute("isExists",true);
            return "redirect:add";
        }


        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable Long id){
        productService.buy(id);

        return "redirect:/";
    }

    @GetMapping("/buyAll")
    public String buyAll(){
        productService.buyAll();
        return "redirect:/";
    }


}
