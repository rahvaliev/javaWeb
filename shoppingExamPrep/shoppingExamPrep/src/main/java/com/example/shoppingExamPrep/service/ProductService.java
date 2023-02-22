package com.example.shoppingExamPrep.service;

import com.example.shoppingExamPrep.model.entities.CategoryName;
import com.example.shoppingExamPrep.model.service.ProductServiceModel;
import com.example.shoppingExamPrep.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    boolean saveProduct(ProductServiceModel map);

    BigDecimal totalAmount();

    List<ProductViewModel> findProductsByCategoryName(CategoryName categoryName);

    void buy(Long id);

    void buyAll();
}
