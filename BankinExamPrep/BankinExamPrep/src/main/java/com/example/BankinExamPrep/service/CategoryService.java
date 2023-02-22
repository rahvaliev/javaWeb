package com.example.BankinExamPrep.service;

import com.example.BankinExamPrep.model.entity.Category;
import com.example.BankinExamPrep.model.entity.CategoryNameEnum;

public interface CategoryService {
    void init();

    Category findByCategoryName(CategoryNameEnum category);
}
