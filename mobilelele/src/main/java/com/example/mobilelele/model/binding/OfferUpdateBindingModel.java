package com.example.mobilelele.model.binding;

import com.example.mobilelele.model.entity.ModelEntity;
import com.example.mobilelele.model.entity.UserEntity;
import com.example.mobilelele.model.enums.EngineEnum;
import com.example.mobilelele.model.enums.TransmissionEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class OfferUpdateBindingModel {
    private Long id;
    private String description;

    private EngineEnum engine;
    private String imageUrl;
    private int mileage;
    private int price;

    private TransmissionEnum transmission;

    private int year;
    private String model;

    public Long getId() {
        return id;
    }

    public OfferUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferUpdateBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferUpdateBindingModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferUpdateBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferUpdateBindingModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public OfferUpdateBindingModel setPrice(int price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferUpdateBindingModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferUpdateBindingModel setYear(int year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferUpdateBindingModel setModel(String model) {
        this.model = model;
        return this;
    }
}
