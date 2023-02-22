package com.example.restserverapi.service;

import com.example.restserverapi.model.entity.AuthorEntity;
import com.example.restserverapi.model.entity.BookEntity;
import com.example.restserverapi.repository.AuthorRepository;
import com.example.restserverapi.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorServiceImpl {
    private final AuthorRepository authorRepository;
    private final BooksRepository booksRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, BooksRepository booksRepository) {
        this.authorRepository = authorRepository;
        this.booksRepository = booksRepository;
    }

    public void initAuthor(String authorName,String...books) {
        AuthorEntity authorEntity=new AuthorEntity().setName(authorName);
        AuthorEntity author = authorRepository.save(authorEntity);
        List<BookEntity> allBooks=new ArrayList<>();


        for (String book:books){
            BookEntity bookEntity=new BookEntity();
            bookEntity.setAuthor(author)
                    .setIsbn(UUID.randomUUID().toString())
                    .setTitle(book);
            allBooks.add(bookEntity);
        }
        author.setBooks(allBooks);
        authorRepository.save(author);

        booksRepository.saveAll(allBooks);


    }
    public Long countOfRepository(){
        return authorRepository.count();
    }
}
