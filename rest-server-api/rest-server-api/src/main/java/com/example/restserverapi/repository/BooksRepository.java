package com.example.restserverapi.repository;

import com.example.restserverapi.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BookEntity,Long> {
}
