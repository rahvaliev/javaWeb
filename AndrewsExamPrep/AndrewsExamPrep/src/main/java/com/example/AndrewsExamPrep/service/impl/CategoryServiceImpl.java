package com.example.AndrewsExamPrep.service.impl;

import com.example.AndrewsExamPrep.model.entity.Category;
import com.example.AndrewsExamPrep.model.entity.CategoryNameEnum;
import com.example.AndrewsExamPrep.repository.CategoryRepository;
import com.example.AndrewsExamPrep.service.CategoryService;
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
                        category.setDescription(String.format("Some description of %s",categoryNameEnum));
                        categoryRepository.save(category);
                        });
        }
    }

    @Override
    public Category findByCategoryName(CategoryNameEnum categoryNameEnum) {

      return   categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
