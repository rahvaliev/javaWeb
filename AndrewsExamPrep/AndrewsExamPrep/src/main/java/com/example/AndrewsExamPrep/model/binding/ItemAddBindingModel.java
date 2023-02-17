package com.example.AndrewsExamPrep.model.binding;

import com.example.AndrewsExamPrep.model.entity.CategoryNameEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ItemAddBindingModel {
    private String name;
    private String description;
    private CategoryNameEnum category;
    private BigDecimal price;
    @Positive(message = "must be positive")
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public ItemAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    private String gender;
    @Size(min = 2,message = "Name length must be more than 2 characters!")
    public String getName() {
        return name;
    }

    public ItemAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }
    @Size(min = 3,message = "Description length must be more than 2 characters!")
    public String getDescription() {
        return description;
    }

    public ItemAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
    @NotNull
    public CategoryNameEnum getCategory() {
        return category;
    }

    public ItemAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
    @NotNull(message = "must be option between Male and Female")
    public String getGender() {
        return gender;
    }

    public ItemAddBindingModel setGender(String gender) {
        this.gender = gender;
        return this;
    }
}
