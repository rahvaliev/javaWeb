package com.example.restserverapi.web;

import com.example.restserverapi.model.dto.BookDto;
import com.example.restserverapi.service.BookServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private final BookServiceImpl bookService;

    public BooksController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBook() {
        return ResponseEntity.
                ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("id") Long bookId){
        Optional<BookDto> bookDto=bookService.findBYId(bookId);
        return bookDto.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build() );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<BookDto> deleteBookById(@PathVariable Long id){
        bookService.deleteBookBYId(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto newBook,
                                              UriComponentsBuilder uriComponentsBuilder){
        Long newBookId = bookService.createNewBook(newBook);
        return ResponseEntity.created(uriComponentsBuilder.path("/api/books/{id}").build(newBookId)).build();

    }
}
