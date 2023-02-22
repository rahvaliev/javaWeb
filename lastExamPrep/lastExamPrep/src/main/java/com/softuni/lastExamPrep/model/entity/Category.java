package com.softuni.lastExamPrep.model.entity;

import com.softuni.lastExamPrep.model.entity.enums.CategoryNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    private CategoryNameEnum name;
    private int neededTime;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }
    @Column(nullable = false)
    public int getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(int neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
