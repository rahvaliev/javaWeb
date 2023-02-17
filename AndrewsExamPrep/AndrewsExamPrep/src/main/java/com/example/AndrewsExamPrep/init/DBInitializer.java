package com.example.AndrewsExamPrep.init;

import com.example.AndrewsExamPrep.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer implements CommandLineRunner {
    private final CategoryService categoryService;

    public DBInitializer(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.init();
    }
}
