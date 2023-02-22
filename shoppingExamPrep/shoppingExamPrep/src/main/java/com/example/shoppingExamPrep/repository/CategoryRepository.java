package com.example.shoppingExamPrep.repository;

import com.example.shoppingExamPrep.model.entities.Category;
import com.example.shoppingExamPrep.model.entities.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(CategoryName name);
}
