package com.softuni.lastExamPrep.service.impl;

import com.softuni.lastExamPrep.model.entity.Category;
import com.softuni.lastExamPrep.model.entity.enums.CategoryNameEnum;
import com.softuni.lastExamPrep.repository.CategoryRepository;
import com.softuni.lastExamPrep.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void init() {
        if(categoryRepository.count()==0){
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        Category category=new Category();
                        category.setName(categoryNameEnum);
                        switch (categoryNameEnum){
                            case CAKE -> category.setNeededTime(10);
                            case DRINK -> category.setNeededTime(1);
                            case OTHER -> category.setNeededTime(5);
                            case COFFEE -> category.setNeededTime(2);
                        }
                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public Category findByCategoryName(CategoryNameEnum categoryName) {

        return categoryRepository.findByName(categoryName).orElse(null);
    }
}
