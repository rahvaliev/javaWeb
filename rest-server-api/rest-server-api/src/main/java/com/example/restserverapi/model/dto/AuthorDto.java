package com.example.restserverapi.model.dto;

import com.example.restserverapi.model.entity.BookEntity;

import java.util.List;

public class AuthorDto {

    private String name;




    public String getName() {
        return name;
    }

    public AuthorDto setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
