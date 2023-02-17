package com.example.AndrewsExamPrep.repository;

import com.example.AndrewsExamPrep.model.entity.Category;
import com.example.AndrewsExamPrep.model.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category>findByName(CategoryNameEnum name);
}
