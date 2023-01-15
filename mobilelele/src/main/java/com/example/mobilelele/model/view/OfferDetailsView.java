package com.example.mobilelele.model.view;

import com.example.mobilelele.model.enums.EngineEnum;
import com.example.mobilelele.model.enums.TransmissionEnum;

import java.time.LocalDateTime;

public class OfferDetailsView {
    private Long id;
    private String description;

    private EngineEnum engine;
    private String imageUrl;
    private int mileage;
    private int price;

    private TransmissionEnum transmission;

    private int year;
    private String model;
    private String seller;
    private LocalDateTime created;
    private LocalDateTime modified;

    public Long getId() {
        return id;
    }

    public OfferDetailsView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferDetailsView setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferDetailsView setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferDetailsView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferDetailsView setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public OfferDetailsView setPrice(int price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferDetailsView setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferDetailsView setYear(int year) {
        this.year = year;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferDetailsView setModel(String model) {
        this.model = model;
        return this;
    }

    public String getSeller() {
        return seller;
    }

    public OfferDetailsView setSeller(String seller) {
        this.seller = seller;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public OfferDetailsView setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public OfferDetailsView setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }
}
