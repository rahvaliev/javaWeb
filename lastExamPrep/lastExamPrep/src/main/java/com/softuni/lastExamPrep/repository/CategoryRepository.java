package com.softuni.lastExamPrep.repository;

import com.softuni.lastExamPrep.model.entity.Category;
import com.softuni.lastExamPrep.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(CategoryNameEnum name);
}
