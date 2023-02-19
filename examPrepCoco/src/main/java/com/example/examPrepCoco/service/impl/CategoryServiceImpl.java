package com.example.examPrepCoco.service.impl;

import com.example.examPrepCoco.model.entities.Category;
import com.example.examPrepCoco.model.entities.CategoryEnum;
import com.example.examPrepCoco.model.entities.User;
import com.example.examPrepCoco.service.CategoryService;
import com.example.examPrepCoco.repository.CategoryRepository;
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
            Arrays.stream(CategoryEnum.values())
                    .forEach(categoryEnum -> {
                        Category category=new Category();
                        category.setName(categoryEnum);
                        switch (categoryEnum){
                            case CAKE -> category.setNeededTime(10);
                            case DRINK -> category.setNeededTime(1);
                            case OTHER -> category.setNeededTime(5);
                            case COFFEE-> category.setNeededTime(2);

                        }
                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public Category findByCategoryEnum(CategoryEnum categoryEnum) {

       return categoryRepository.findByName(categoryEnum).orElse(null);
    }



}
