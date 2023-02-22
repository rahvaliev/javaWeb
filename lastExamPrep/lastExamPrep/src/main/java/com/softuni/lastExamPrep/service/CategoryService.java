package com.softuni.lastExamPrep.service;

import com.softuni.lastExamPrep.model.entity.Category;
import com.softuni.lastExamPrep.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void init();

    Category findByCategoryName(CategoryNameEnum categoryName);
}
