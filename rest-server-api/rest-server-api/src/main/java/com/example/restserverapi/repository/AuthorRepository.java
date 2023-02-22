package com.example.restserverapi.repository;

import com.example.restserverapi.model.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {

    Optional<AuthorEntity> findByName(String name);
}
