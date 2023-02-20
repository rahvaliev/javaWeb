package com.ex.examTR.model.entity;

import com.ex.examTR.model.entity.enums.ConditionNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity{
    private ConditionNameEnum name;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    public ConditionNameEnum getName() {
        return name;
    }

    public Condition setName(ConditionNameEnum name) {
        this.name = name;
        return this;
    }
    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public Condition setDescription(String description) {
        this.description = description;
        return this;
    }
}
