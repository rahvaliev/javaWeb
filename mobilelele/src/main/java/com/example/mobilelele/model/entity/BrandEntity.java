package com.example.mobilelele.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity{
    private String name;
    @OneToMany(mappedBy = "brand",cascade = CascadeType.PERSIST)
    private List<ModelEntity> models;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public void setModels(List<ModelEntity> models) {
        this.models = models;
    }
}
