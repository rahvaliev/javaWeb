package com.example.shoppingExamPrep.service.impl;

import com.example.shoppingExamPrep.model.entities.Category;
import com.example.shoppingExamPrep.model.entities.CategoryName;
import com.example.shoppingExamPrep.repository.CategoryRepository;
import com.example.shoppingExamPrep.service.CategoryService;
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
        if(categoryRepository.count()!=0){
            return;
        }
        Arrays.stream(CategoryName.values())
                .forEach(categoryName -> {
                    Category category=new Category();
                    category.setName(categoryName);
                    category.setDescription("Some description "+categoryName);
                    categoryRepository.save(category);
                });

    }

    @Override
    public Category findByCategoryEnumName(CategoryName categoryName) {

        return categoryRepository.findByName(categoryName);
    }
}
