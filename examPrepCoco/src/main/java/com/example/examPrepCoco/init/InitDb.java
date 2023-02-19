package com.example.examPrepCoco.init;

import com.example.examPrepCoco.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDb implements CommandLineRunner {
    private final CategoryService categoryService;

    public InitDb(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.init();
    }
}
