package com.example.examPrepCoco.service;

import com.example.examPrepCoco.model.entities.Category;
import com.example.examPrepCoco.model.entities.CategoryEnum;
import com.example.examPrepCoco.model.entities.User;

public interface CategoryService {
    void init();

    Category findByCategoryEnum(CategoryEnum categoryEnum);


}
