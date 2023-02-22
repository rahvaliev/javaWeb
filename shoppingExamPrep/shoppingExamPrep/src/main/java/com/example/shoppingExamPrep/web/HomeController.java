package com.example.shoppingExamPrep.web;

import com.example.shoppingExamPrep.model.entities.CategoryName;
import com.example.shoppingExamPrep.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
        private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public String index(HttpSession httpSession, Model model){
        if(httpSession.getAttribute("user")==null){
            return "index";
        }
        if(productService.totalAmount()==null){
            model.addAttribute("total",0.00);
        }else{
            model.addAttribute("total", productService.totalAmount());
        }

        model.addAttribute("drinks",productService.findProductsByCategoryName(CategoryName.DRINK));
        model.addAttribute("foods",productService.findProductsByCategoryName(CategoryName.FOOD));
        model.addAttribute("others",productService.findProductsByCategoryName(CategoryName.OTHER));
        model.addAttribute("households",productService.findProductsByCategoryName(CategoryName.HOUSEHOLD));


        return "home";
    }
}
