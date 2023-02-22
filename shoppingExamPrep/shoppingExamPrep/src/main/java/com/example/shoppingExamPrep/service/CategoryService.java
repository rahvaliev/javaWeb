package com.example.shoppingExamPrep.service;

import com.example.shoppingExamPrep.model.entities.Category;
import com.example.shoppingExamPrep.model.entities.CategoryName;

public interface CategoryService {
    void init();

    Category findByCategoryEnumName(CategoryName categoryName);
}
