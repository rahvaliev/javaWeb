package com.example.restserverapi.service;

import com.example.restserverapi.model.dto.AuthorDto;
import com.example.restserverapi.model.dto.BookDto;
import com.example.restserverapi.model.entity.AuthorEntity;
import com.example.restserverapi.model.entity.BookEntity;
import com.example.restserverapi.repository.AuthorRepository;
import com.example.restserverapi.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl {
    private final BooksRepository booksRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BooksRepository booksRepository, AuthorRepository authorRepository) {
        this.booksRepository = booksRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookDto> getAllBooks() {

        return booksRepository.findAll().stream()
                .map(this::map)
                .collect(Collectors.toList());

    }
    private BookDto map(BookEntity bookEntity){
        BookDto bookDto=new BookDto();
        AuthorDto authorDto=new AuthorDto().setName(bookEntity.getAuthor().getName());
        bookDto.setAuthor(authorDto);
        bookDto.setId(bookEntity.getId())
                .setIsbn(bookEntity.getIsbn())
                .setTitle(bookEntity.getTitle());


        return bookDto;
    }

    public Optional<BookDto> findBYId(Long bookId) {
    return booksRepository.findById(bookId).map(this::map);
    }

    public void deleteBookBYId(Long bookId) {
        try {
            booksRepository.deleteById(bookId);
        }catch (Exception e){

        }

    }

    public Long createNewBook(BookDto newBook) {
        Optional<AuthorEntity>author=authorRepository.findByName(newBook.getAuthor().getName());


        BookEntity newBookEntity=new BookEntity();
        newBookEntity.setTitle(newBook.getTitle())
                .setAuthor(author.orElseGet(()->createAuthor(newBook.getAuthor().getName())))
                .setIsbn(newBook.getIsbn());
        BookEntity savedBook = booksRepository.save(newBookEntity);
        return savedBook.getId();
    }

    private AuthorEntity createAuthor(String authorName){
      return   authorRepository.save(new AuthorEntity().setName(authorName));
    }
}
