package com.example.shoppingExamPrep.repository;

import com.example.shoppingExamPrep.model.entities.CategoryName;
import com.example.shoppingExamPrep.model.entities.Product;
import com.example.shoppingExamPrep.model.view.ProductViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select sum(p.price) from Product p ")
    BigDecimal totalAmountOfAllProduct();

    List<Product>findAllByCategory_Name(CategoryName categoryName);
}
