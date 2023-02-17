package com.example.AndrewsExamPrep.service;

import com.example.AndrewsExamPrep.model.entity.Category;
import com.example.AndrewsExamPrep.model.entity.CategoryNameEnum;

public interface CategoryService {
    void init();

    Category findByCategoryName(CategoryNameEnum categoryNameEnum);
}
