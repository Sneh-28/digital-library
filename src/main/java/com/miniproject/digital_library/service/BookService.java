package com.miniproject.digital_library.service;

import com.miniproject.digital_library.entity.BookEntity;
import com.miniproject.digital_library.entity.UserEntity;
import com.miniproject.digital_library.repository.impl.BookRepo;
import com.miniproject.digital_library.repository.impl.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepo bookRepo;
    private final UserRepo userRepo;

    public BookService(BookRepo bookRepo,UserRepo userRepo) {
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    public BookEntity addBook(BookEntity bookEntity,int userId){
        UserEntity user = userRepo.getUser(userId);
        if (user.getRole() != "admin"){
            throw new RuntimeException("Only admin can add the book");
        }
        bookRepo.getExistingBook(bookEntity.getIsbn()).ifPresent(existingBook -> {
            throw new RuntimeException("Book with ISBN already exists!");
        });

       return bookRepo.addBook(bookEntity);
    }

    public List<BookEntity> getAllBooks(){
        return this.bookRepo.getAllBooks();
    }

    public BookEntity findBookByTitle(String title){
        return this.bookRepo.findBookByTitle(title).orElseThrow(()-> new RuntimeException("Book not found"));
    }

    public BookEntity findBookByAuthor(String author){
        return this.bookRepo.findBookByAuthor(author).orElseThrow(()-> new RuntimeException("Author not found"));
    }

    @Transactional
    public void deleteBookByIsbn(String isbn,int userId){
        UserEntity user = userRepo.getUser(userId);
        if (user.getRole() != "admin"){
            throw new RuntimeException("Only admin can delete the book");
        }
        this.bookRepo.deleteBookByIsbn(isbn);
    }
}
