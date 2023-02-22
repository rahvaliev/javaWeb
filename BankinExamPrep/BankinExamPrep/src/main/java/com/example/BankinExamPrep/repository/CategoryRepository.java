package com.example.BankinExamPrep.repository;

import com.example.BankinExamPrep.model.entity.Category;
import com.example.BankinExamPrep.model.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(CategoryNameEnum name);
}
