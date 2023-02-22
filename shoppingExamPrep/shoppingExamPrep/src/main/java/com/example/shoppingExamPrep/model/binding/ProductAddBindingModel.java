package com.example.shoppingExamPrep.model.binding;

import com.example.shoppingExamPrep.model.entities.Category;
import com.example.shoppingExamPrep.model.entities.CategoryName;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime neededBefore;
    private CategoryName category;

    @Size(min = 3,max = 20,message = "my custom message ,name must be between 3 and 20 !")
    @NotBlank
    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }
    @Size(min = 5,message = "my custom message ,description must be more than 5 !")
    @NotBlank
    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
    @Positive
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    @FutureOrPresent
    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }
    @NotNull
    public CategoryName getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }
}
