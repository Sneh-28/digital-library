package com.miniproject.digital_library.repository.impl;

import com.miniproject.digital_library.entity.BookEntity;
import com.miniproject.digital_library.repository.jpa.BookJpaRepo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepo {
    private final BookJpaRepo bookJpaRepo;

    public BookRepo(BookJpaRepo bookJpaRepo) {
        this.bookJpaRepo = bookJpaRepo;
    }

    public BookEntity addBook(BookEntity bookEntity){
        return this.bookJpaRepo.save(bookEntity);
    }

    public Optional<BookEntity> getExistingBook(String isbn){
        return this.bookJpaRepo.findByIsbn(isbn);
    }

    public List<BookEntity> getAllBooks(){
        return this.bookJpaRepo.findAll();
    }

    public BookEntity findBookById(int id){
        return this.bookJpaRepo.findById(id).orElseThrow(()->
                new RuntimeException("Book not found"));
    }

    public Optional<BookEntity> findBookByTitle(String title){
        return this.bookJpaRepo.findByTitle(title);
    }

    public Optional<BookEntity> findBookByAuthor(String author){
        return this.bookJpaRepo.findByAuthor(author);
    }

    public void deleteBookByIsbn(String isbn){
        this.bookJpaRepo.deleteByIsbn(isbn);
    }
}
