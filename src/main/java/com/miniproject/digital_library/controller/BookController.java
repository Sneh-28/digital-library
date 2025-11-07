package com.miniproject.digital_library.controller;
import com.miniproject.digital_library.entity.BookEntity;
import com.miniproject.digital_library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity bookEntity,@PathVariable int userId) {
        BookEntity addedBook = this.bookService.addBook(bookEntity,userId);
        return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
    }


    @GetMapping
    public List<BookEntity> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<BookEntity> findBookByTitle(@PathVariable String title) {
        BookEntity foundBook = this.bookService.findBookByTitle(title);
        return new ResponseEntity<>(foundBook, HttpStatus.FOUND);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<BookEntity> findBookByAuthor(@PathVariable String author) {
        BookEntity foundBook = this.bookService.findBookByAuthor(author);
        return new ResponseEntity<>(foundBook, HttpStatus.FOUND);
    }

    @DeleteMapping("/{isbn}/{userId}")
    public ResponseEntity<Void> deleteBookByIsbn(@PathVariable String isbn,@PathVariable int userId){
        this.bookService.deleteBookByIsbn(isbn,userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
