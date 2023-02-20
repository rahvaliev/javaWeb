package com.ex.examTR.model.binding;

import com.ex.examTR.model.entity.enums.ConditionNameEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class OfferAddBindingModel {
    private String description;
    private BigDecimal price;
    private ConditionNameEnum condition;

    @Size(min = 2,max = 50,message = "Description length must be between 2 and 50 characters!")
    @NotBlank(message ="Description length must be between 2 and 50 characters!" )
    public String getDescription() {
        return description;
    }

    public OfferAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
    @Positive(message = "Price must be positive number!")
    public BigDecimal getPrice() {
        return price;
    }

    public OfferAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    @NotNull(message = "You must select a condition")
    public ConditionNameEnum getCondition() {
        return condition;
    }

    public OfferAddBindingModel setCondition(ConditionNameEnum condition) {
        this.condition = condition;
        return this;
    }
}
