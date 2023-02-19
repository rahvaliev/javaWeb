package com.example.examPrepCoco.repository;

import com.example.examPrepCoco.model.entities.Category;
import com.example.examPrepCoco.model.entities.CategoryEnum;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category>findByName(CategoryEnum name);
}
